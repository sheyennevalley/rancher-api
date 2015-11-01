package com.sheyennevalley.rancher.v1.services.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by justin on 10/31/15.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class LaunchConfig {

    private String command;
    private Map<String,String> labels;
    private Map<String,String> logConfig;
    private String networkMode;
    private String privileged;
    private String publishAllPorts;
    private String startOnCreate;
    private String stdinOpen;
    private String tty;
    private Map<String, String> restartPolicy;
    private String imageUuid;
    private List<String> dataVolumes;
    private List<String> dataVolumesFrom;
    private List<String> dns;
    private List<String> dnsSearch;
    private List<String> capAdd;
    private List<String> capDrop;
    private List<String> devices;
    private String count;
    private String cpuSet;
    private String cpuShares;
    private String description;
    private String domainName;
    private String hostname;
    private String memory;
    private String memorySwap;
    private String pidMode;
    private String user;
    private String volumeDriver;
    private String workingDir;
    private String networkLaunchConfig;
    private String version;

}
