/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labelary;

import annotations.Injectable;
import communication.http.CommunicationException;
import communication.http.HttpClient;
import communication.http.HttpClientInterface;
import communication.http.HttpConstants;
import communication.http.HttpPostRequestParameters;
import communication.http.HttpResponse;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import throttling.Throttler;
import layoutlanguage.LabelGenerator;

/**
 *
 * @author manel
 */
@Injectable(ResolveWithNewInstance = false)
public class LabelaryLabelGenerator implements LabelGenerator {

    private final String protocol = "http";
    private final String domain = "api.labelary.com";
    private final String version = "v1";
    private final String printDensity = "8dpmm";
    private final String size = "4x6";

    private final String apiPath;
    private final Throttler throttler;
    private final long throttleTime = 1000;

    public LabelaryLabelGenerator(Throttler throttler) {
        apiPath = String.format("%s://%s/%s/printers/%s/labels/%s/0/",
                protocol, domain, version, printDensity, size);
        this.throttler = throttler;

        throttler.configure(throttleTime, 5);
    }

    @Override
    public LabelGenerationResult getZplView(String zpl, ViewType viewType) {
        throttleRequest();

        HttpClientInterface client = new HttpClient();

        HttpResponse response = null;
        try {
            response = client.post(new HttpPostRequestParameters(apiPath, new HashMap<String, String>() {
                {
                    put(HttpConstants.HttpHeaderTypes.contentType, HttpConstants.HttpContentTypes.formUrlEncoded);
                    put(HttpConstants.HttpHeaderTypes.userAgent, HttpConstants.HttpUserAgents.mozilla);
                    put(HttpConstants.HttpHeaderTypes.accept, getContentTypeFromViewType(viewType));
                }
            }, zpl));
        } catch (CommunicationException ex) {
            Logger.getLogger(LabelaryLabelGenerator.class.getName()).log(Level.SEVERE, null, ex.innerException);
        }

        return response == null || response.statusCode != HttpConstants.HttpResponseCodes.ok
                ? null
                : new LabelGenerationResult(response.bytes, viewType);
    }

    private void throttleRequest() {
        if (throttler.throttle()) {
            return;
        }

        try {
            Thread.sleep(throttleTime);
            Logger.getLogger(LabelaryLabelGenerator.class.getName()).log(Level.INFO, "Throttling mechanism kicked in");
        } catch (InterruptedException ex) {
            Logger.getLogger(LabelaryLabelGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getContentTypeFromViewType(ViewType viewType) {
        switch (viewType) {
            case Image -> {
                return HttpConstants.HttpContentTypes.pngImage;
            }
            case PDF -> {
                return HttpConstants.HttpContentTypes.pdf;
            }
        }

        return null;
    }
}
