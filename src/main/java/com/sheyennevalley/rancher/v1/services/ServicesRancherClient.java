package com.sheyennevalley.rancher.v1.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheyennevalley.rancher.RancherResponse;
import com.sheyennevalley.rancher.v1.BaseClient;
import com.sheyennevalley.rancher.v1.RancherException;
import com.sheyennevalley.rancher.v1.Response;
import com.sheyennevalley.rancher.v1.services.model.Service;

import java.util.List;

/**
 * Created by justin on 10/31/15.
 */
public class ServicesRancherClient implements ServicesClient {

    private final BaseClient baseClient;

    private final ObjectMapper objectMapper;

    private final String projectId;

    public ServicesRancherClient(BaseClient baseClient, ObjectMapper objectMapper, String projectId) {
        this.baseClient = baseClient;
        this.objectMapper = objectMapper;
        this.projectId = projectId;
    }

    @Override
    public Response<List<Service>> getServices() {
        RancherResponse response = baseClient.makeGetRequest("/v1/projects/" + projectId + "/services");

        if (response.getStatusCode() == 200) {
            try {
                JsonNode rootNode = objectMapper.readValue(response.getContent(), JsonNode.class);
                JsonNode data = rootNode.get("data");
                List<Service> services = objectMapper.readValue(data.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, Service.class));
                return new Response<List<Service>>(services);
            } catch (Exception e){
                throw new RancherException(e);
            }
        } else {
            throw new RancherException(response.getStatusCode() + " - " + response.getStatusMessage());
        }

    }

    @Override
    public Response<Service> getService(String id) {
        RancherResponse response = baseClient.makeGetRequest("/v1/projects/" + projectId + "/services/" + id);

        if (response.getStatusCode() == 200) {
            try {

                Service service = objectMapper.readValue(response.getContent(), Service.class);
                return new Response<Service>(service);
            } catch (Exception e){
                throw new RancherException(e);
            }
        } else {
            throw new RancherException(response.getStatusCode() + " - " + response.getStatusMessage());
        }
    }
}
