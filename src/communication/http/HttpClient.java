/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map.Entry;

/**
 *
 * @author Manel
 */
public class HttpClient implements HttpClientInterface {

    @Override
    public HttpResponse post(HttpPostRequestParameters parameters) throws CommunicationException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            HttpURLConnection con = (HttpURLConnection) new URL(parameters.url).openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod(HttpConstants.HttpRequestMethodType.POST.name());
            for (Entry<String, String> en : parameters.headers.entrySet()) {
                con.setRequestProperty(en.getKey(), en.getValue());
            }

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = parameters.body.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int bytesRead;
            byte[] byteChunk = new byte[4096];
            InputStream inputStream = con.getInputStream();

            while ((bytesRead = inputStream.read(byteChunk)) > 0) {
                baos.write(byteChunk, 0, bytesRead);
            }

            baos.close();
            con.disconnect();

            return new HttpResponse(con.getResponseCode(), baos.toByteArray());
        } catch (MalformedURLException | ProtocolException ex) {
            throw buildException(HttpConstants.HttpRequestMethodType.GET, ex);
        } catch (IOException ex) {
            throw buildException(HttpConstants.HttpRequestMethodType.GET, ex);
        }
    }

    private CommunicationException buildException(HttpConstants.HttpRequestMethodType methodType, Exception innerException) {
        return new CommunicationException("err", innerException);
    }
}
