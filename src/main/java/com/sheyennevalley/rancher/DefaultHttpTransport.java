package com.sheyennevalley.rancher;

import com.sheyennevalley.rancher.v1.RancherException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by justin on 10/31/15.
 */
public class DefaultHttpTransport implements HttpTransport {

    private final HttpClient httpClient;

    public DefaultHttpTransport() {
        PoolingClientConnectionManager connectionManager = new PoolingClientConnectionManager();
        connectionManager.setMaxTotal(1000);
        connectionManager.setDefaultMaxPerRoute(500);

        this.httpClient = new DefaultHttpClient(connectionManager);
    }

    public DefaultHttpTransport(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public RancherResponse makeGetRequest(String url) {
        HttpGet httpGet = new HttpGet(url);
        return executeRequest(httpGet);
    }

    public RancherResponse makePutRequest(String url, String content) {
        HttpPut httpPut = new HttpPut(url);
        httpPut.setEntity(new StringEntity(content, Charset.forName("UTF-8")));
        return executeRequest(httpPut);
    }

    public RancherResponse makePutRequest(String url, byte[] content) {
        HttpPut httpPut = new HttpPut(url);
        httpPut.setEntity(new ByteArrayEntity(content));
        return executeRequest(httpPut);
    }

    public RancherResponse makeDeleteRequest(String url) {
        HttpDelete httpDelete = new HttpDelete(url);
        return executeRequest(httpDelete);
    }

    private RancherResponse executeRequest(HttpUriRequest httpRequest) {
        try {
            return httpClient.execute(httpRequest, new ResponseHandler<RancherResponse>() {
                public RancherResponse handleResponse(HttpResponse response) throws IOException {
                    int statusCode = response.getStatusLine().getStatusCode();
                    String statusMessage = response.getStatusLine().getReasonPhrase();

                    String content = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));


                    return new RancherResponse(statusCode, statusMessage, content);
                }
            });
        } catch (IOException e) {
            throw new RancherException(e);
        }
    }

}
