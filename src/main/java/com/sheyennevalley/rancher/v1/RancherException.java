package com.sheyennevalley.rancher.v1;

/**
 * Created by justin on 10/31/15.
 */
public class RancherException extends RuntimeException {

    public RancherException(){
    }

    public RancherException(Throwable cause){
        super(cause);
    }

    public RancherException(String cause){
        super(cause);
    }
}
