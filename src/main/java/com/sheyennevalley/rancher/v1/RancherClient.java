package com.sheyennevalley.rancher.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheyennevalley.rancher.v1.containers.ContainersClient;
import com.sheyennevalley.rancher.v1.containers.ContainersRancherClient;
import com.sheyennevalley.rancher.v1.containers.model.Container;
import com.sheyennevalley.rancher.v1.services.ServicesClient;
import com.sheyennevalley.rancher.v1.services.ServicesRancherClient;
import com.sheyennevalley.rancher.v1.services.model.Service;

import java.util.List;

/**
 * Created by justin on 11/1/15.
 */
public class RancherClient implements ServicesClient, ContainersClient {

    private final ServicesClient servicesClient;
    private final ContainersClient containersClient;


    public RancherClient(BaseClient baseClient, ObjectMapper objectMapper, String projectId){
        servicesClient = new ServicesRancherClient(baseClient, objectMapper, projectId);
        containersClient = new ContainersRancherClient(baseClient, objectMapper, projectId);
    }

    public RancherClient(String projectId){
        this(new BaseClient(), new ObjectMapper(), projectId);
    }

    public RancherClient(String host, int port, String projectId){
        this(new BaseClient(host, port), new ObjectMapper(), projectId);
    }

    @Override
    public Response<List<Container>> getContainers() {
        return containersClient.getContainers();
    }

    @Override
    public Response<Container> getContainer(String id) {
        return containersClient.getContainer(id);
    }

    @Override
    public Response<List<Container>> getContainersByService(String id) {
        return containersClient.getContainersByService(id);
    }

    @Override
    public Response<List<Service>> getServices() {
        return servicesClient.getServices();
    }

    @Override
    public Response<Service> getService(String id) {
        return servicesClient.getService(id);
    }
}
