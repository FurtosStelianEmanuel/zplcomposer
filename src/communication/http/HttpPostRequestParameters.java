/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication.http;

import java.util.Map;

/**
 *
 * @author manel
 */
public class HttpPostRequestParameters extends HttpRequestParameters {

    public final String body;

    public HttpPostRequestParameters(String url, Map<String, String> headers, String body) {
        super(url, headers);
        this.body = body;
    }
}
