/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication.http;

/**
 *
 * @author manel
 */
public class HttpResponse {

    public final int statusCode;
    public final byte[] bytes;

    public HttpResponse(int statusCode, byte[] responseBytes) {
        this.statusCode = statusCode;
        this.bytes = responseBytes;
    }
}
