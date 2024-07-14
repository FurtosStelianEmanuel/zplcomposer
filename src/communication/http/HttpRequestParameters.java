/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication.http;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author manel
 */
public class HttpRequestParameters {

    public String url;
    public final Map<String, String> headers;

    public HttpRequestParameters(String url, Map<String, String> headers) {
        this.url = url;
        this.headers = headers;
    }

    public HttpRequestParameters(String url) {
        this.url = url;
        headers = new HashMap();
    }
}
