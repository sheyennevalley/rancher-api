package com.sheyennevalley.rancher.v1.containers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheyennevalley.rancher.RancherResponse;
import com.sheyennevalley.rancher.v1.BaseClient;
import com.sheyennevalley.rancher.v1.RancherException;
import com.sheyennevalley.rancher.v1.Response;
import com.sheyennevalley.rancher.v1.containers.model.Container;

import java.util.List;

/**
 * Created by justin on 11/1/15.
 */
public class ContainersRancherClient implements ContainersClient {

    private final BaseClient baseClient;

    private final ObjectMapper objectMapper;

    private final String projectId;

    public ContainersRancherClient(BaseClient baseClient, ObjectMapper objectMapper, String projectId) {
        this.baseClient = baseClient;
        this.objectMapper = objectMapper;
        this.projectId = projectId;
    }

    @Override
    public Response<List<Container>> getContainers() {
        RancherResponse response = baseClient.makeGetRequest("/v1/projects/" + projectId +  "/containers");

        if (response.getStatusCode() == 200) {
            try {
                JsonNode rootNode = objectMapper.readValue(response.getContent(), JsonNode.class);
                JsonNode data = rootNode.get("data");
                List<Container> containers = objectMapper.readValue(data.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, Container.class));
                return new Response<List<Container>>(containers);
            } catch (Exception e){
                throw new RancherException(e);
            }
        } else {
            throw new RancherException(response.getStatusCode() + " - " + response.getStatusMessage());
        }
    }

    @Override
    public Response<Container> getContainer(String id) {
        RancherResponse response = baseClient.makeGetRequest("/v1/projects/" + projectId + "/containers/" + id);

        if (response.getStatusCode() == 200) {
            try {
                Container container = objectMapper.readValue(response.getContent(), Container.class);
                return new Response<Container>(container);
            } catch (Exception e){
                throw new RancherException(e);
            }
        } else {
            throw new RancherException(response.getStatusCode() + " - " + response.getStatusMessage());
        }
    }

    @Override
    public Response<List<Container>> getContainersByService(String id) {
        RancherResponse response = baseClient.makeGetRequest("/v1/projects/" + projectId + "/services/" + id + "/instances");

        if (response.getStatusCode() == 200) {
            try {
                JsonNode rootNode = objectMapper.readValue(response.getContent(), JsonNode.class);
                JsonNode data = rootNode.get("data");
                List<Container> containers = objectMapper.readValue(data.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, Container.class));
                return new Response<List<Container>>(containers);
            } catch (Exception e){
                throw new RancherException(e);
            }
        } else {
            throw new RancherException(response.getStatusCode() + " - " + response.getStatusMessage());
        }
    }
}
