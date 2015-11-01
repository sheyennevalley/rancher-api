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

    public ContainersRancherClient(BaseClient baseClient, ObjectMapper objectMapper) {
        this.baseClient = baseClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public Response<List<Container>> getContainers() {
        RancherResponse response = baseClient.makeGetRequest("/v1/containers");

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
