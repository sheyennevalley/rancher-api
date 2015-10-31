package com.sheyennevalley.rancher;
/**
 * Created by justin on 10/31/15.
 */
public interface HttpTransport {

    Response makeGetRequest(String url);

    Response makePutRequest(String url, String content);

    Response makePutRequest(String url, byte[] content);

    Response makeDeleteRequest(String url);
}
