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
public class HttpConstants {

    public enum HttpRequestMethodType {
        GET,
        POST,
        DELETE
    }

    public class HttpResponseCodes {

        public static int ok = 200;
        public static int created = 201;
        public static int accepted = 202;
    }

    public class HttpHeaderTypes {

        public static String contentType = "Content-Type";
        public static String userAgent = "User-Agent";
        public static String accept = "Accept";
    }

    public class HttpContentTypes {

        public static String formUrlEncoded = "application/x-www-form-urlencoded";
        public static String pngImage = "image/png";
        public static String pdf = "application/pdf";
    }

    public class HttpUserAgents {

        public static String mozilla = "Mozilla/5.0 (Windows NT 6.1; rv:7.0.1) Gecko/20100101 Firefox/7.0.1";
    }

}
