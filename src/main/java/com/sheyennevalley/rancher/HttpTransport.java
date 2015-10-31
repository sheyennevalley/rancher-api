package com.sheyennevalley.rancher;
/**
 * Created by justin on 10/31/15.
 */
public interface HttpTransport {

    RancherResponse makeGetRequest(String url);

    RancherResponse makePutRequest(String url, String content);

    RancherResponse makePutRequest(String url, byte[] content);

    RancherResponse makeDeleteRequest(String url);
}
