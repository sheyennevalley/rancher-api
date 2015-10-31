package com.sheyennevalley.rancher.v1;

import com.sheyennevalley.rancher.*;
import org.apache.http.client.HttpClient;

/**
 * Created by justin on 10/31/15.
 */
public class BaseClient {

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 8080;

    // one real HTTP client for all instances
    private static final HttpTransport DEFAULT_HTTP_TRANSPORT = new DefaultHttpTransport();

    private final HttpTransport httpTransport;
    private final String agentAddress;

    public BaseClient() {
        this(DEFAULT_HOST);
    }

    public BaseClient(String agentHost) {
        this(agentHost, DEFAULT_PORT);
    }

    public BaseClient(String agentHost, int agentPort) {
        this(DEFAULT_HTTP_TRANSPORT, agentHost, agentPort);
    }

    public BaseClient(HttpClient httpClient) {
        this(DEFAULT_HOST, httpClient);
    }

    public BaseClient(String agentHost, HttpClient httpClient) {
        this(new DefaultHttpTransport(httpClient), agentHost, DEFAULT_PORT);
    }

    public BaseClient(String agentHost, int agentPort, HttpClient httpClient) {
        this(new DefaultHttpTransport(httpClient), agentHost, agentPort);
    }

    // hidden constructor, for tests
    BaseClient(HttpTransport httpTransport, String agentHost, int agentPort) {
        this.httpTransport = httpTransport;

        // check that agentHost has scheme or not
        String agentHostLowercase = agentHost.toLowerCase();
        if (!agentHostLowercase.startsWith("https://") && !agentHostLowercase.startsWith("http://")) {
            // no scheme in host, use default 'http'
            agentHost = "http://" + agentHost;
        }

        this.agentAddress = agentHost + ":" + agentPort;
    }

    public RancherResponse makeGetRequest(String endpoint, UrlParameters... urlParams) {
        String url = agentAddress + endpoint;
        url = Utils.generateUrl(url, urlParams);

        return httpTransport.makeGetRequest(url);
    }

    public RancherResponse makePutRequest(String endpoint, String content, UrlParameters... urlParams) {
        String url = agentAddress + endpoint;
        url = Utils.generateUrl(url, urlParams);

        return httpTransport.makePutRequest(url, content);
    }

    public RancherResponse makePutRequest(String endpoint, byte[] content, UrlParameters... urlParams) {
        String url = agentAddress + endpoint;
        url = Utils.generateUrl(url, urlParams);

        return httpTransport.makePutRequest(url, content);
    }

    public RancherResponse makeDeleteRequest(String endpoint, UrlParameters... urlParams) {
        String url = agentAddress + endpoint;
        url = Utils.generateUrl(url, urlParams);

        return httpTransport.makeDeleteRequest(url);
    }

}
