package com.sheyennevalley.rancher.v1.containers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by justin on 11/1/15.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Container {

    private String id;
    private String type;
    private Map<String, String> links;
    private Map<String, String> actions;
    private String name;
    private String state;
    private String accountId;
    private String agentId;
    private String allocationState;
    private String build;
    private List<String> capAdd;
    private List<String> capDrop;
    private List<String> command;
    private String cpuSet;
    private String cpuShares;
    private String createIndex;
    private Date created;
    private String dataVolumeMounts;
    private List<String> dataVolumes;
    private List<String> dataVolumesFrom;
    private String deploymentUnitUuid; 
    private String description; 
    private List<String> devices; 
    private List<String> dns; 
    private List<String> dnsSearch; 
    private String domainName; 
    private List<String> entryPoint; 
    private Map<String, String> environment;
    private String expose; 
    private String externalId; 
    private String extraHosts; 
    private String firstRunning; 
    private String healthCheck; 
    private String healthState;
    private String hostname;
    private String imageUuid; 
    private String kind; 
    private Map<String,String> labels; 
    private Map<String,Object> logConfig;
    private Map<String,String> lxcConf; 
    private String memory; 
    private String memorySwap; 
    private String nativeContainer;
    private String networkContainerId; 
    private String networkMode;
    private String pidMode; 
    private List<String> ports;
    private String primaryIpAddress;
    private String privileged; 
    private String publishAllPorts; 
    private String readOnly; 
    private String registryCredentialId; 
    private String removeTime; 
    private String removed; 
    private String requestedHostId;
    private Map<String,String> restartPolicy;
    private String securityOpt; 
    private String startOnCreate; 
    private String stdinOpen; 
    private String systemContainer; 
    private String token;
    private String transitioning;
    private String transitioningMessage; 
    private String transitioningProgress; 
    private String tty; 
    private String user; 
    private String uuid;
    private String version;
    private String volumeDriver; 
    private String workingDir;
}
