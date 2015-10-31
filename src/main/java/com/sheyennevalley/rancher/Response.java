package com.sheyennevalley.rancher;

/**
 * Created by justin on 10/31/15.
 */
public final class Response {

    private final int statusCode;
    private final String statusMessage;

    private final String content;

    public Response(int statusCode, String statusMessage, String content) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.content = content;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public String getContent() {
        return content;
    }
}
