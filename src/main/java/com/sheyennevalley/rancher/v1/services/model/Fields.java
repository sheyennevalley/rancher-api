package com.sheyennevalley.rancher.v1.services.model;

import lombok.Data;

import java.util.Map;

/**
 * Created by justin on 10/31/15.
 */
@Data
public class Fields {

    private int scale;

    private Map<String,String> metadata;
}
