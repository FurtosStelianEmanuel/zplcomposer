/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication.http;

/**
 *
 * @author Manel
 */
public interface HttpClientInterface {

    public HttpResponse post(HttpPostRequestParameters parameters) throws CommunicationException;
}
