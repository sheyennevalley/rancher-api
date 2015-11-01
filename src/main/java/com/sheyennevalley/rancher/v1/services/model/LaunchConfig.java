package com.sheyennevalley.rancher.v1.services.model;

import lombok.Data;

import java.util.Map;

/**
 * Created by justin on 10/31/15.
 */
@Data
public class LaunchConfig {

    private String command;
    private String imageUuid;
    private Map<String,String> labels;
    private Map<String,String> logConfig;
    private String networkMode;
}
