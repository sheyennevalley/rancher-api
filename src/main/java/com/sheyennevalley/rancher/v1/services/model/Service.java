package com.sheyennevalley.rancher.v1.services.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * Created by justin on 10/31/15.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Service {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("links")
    private Map<String,String> links;
    @JsonProperty("actions")
    private Map<String,String> actions;
    @JsonProperty("name")
    private String name;
    @JsonProperty("state")
    private String state;
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("createIndex")
    private String createIndex;
    @JsonProperty("created")
    private Date created;

}
