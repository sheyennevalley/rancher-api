package com.sheyennevalley.rancher.v1.services.model;

import java.util.Map;

/**
 * Created by justin on 10/31/15.
 */
public class LaunchConfig {
    String command;
    String imageUuid;
    Map<String,String> labels;
    Map<String,String> logConfig;
    String networkMode;
}
