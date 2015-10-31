package com.sheyennevalley.rancher.v1;

/**
 * Created by justin on 10/31/15.
 */
public final class Response<T> {

    private final T value;

    public Response(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
