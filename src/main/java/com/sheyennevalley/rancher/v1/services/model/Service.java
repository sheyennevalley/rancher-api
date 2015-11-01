package com.sheyennevalley.rancher.v1.services.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by justin on 10/31/15.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Service {

    private String id;
    private String type;
    private Map<String, String> links;
    private Map<String, String> actions;
    private String name;
    private String state;
    private String accountId;
    private String createIndex;
    private Date created;
    private LaunchConfig launchConfig;
    private String description;
    private String environmentId;
    private String kind;
    private String metadata;
    private String previousLaunchConfig;
    private String previousSecondaryLaunchConfigs;
    private String removeTime;
    private String removed;
    private String scale;
    private List<String> secondaryLaunchConfigs;
    private String selectorContainer;
    private String selectorLink;
    private String transitioning;
    private String transitioningMessage;
    private String transitioningProgress;
    private String upgrade;
    private String uuid;
    private String vip;
}
