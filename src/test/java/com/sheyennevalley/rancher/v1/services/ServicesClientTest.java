package com.sheyennevalley.rancher.v1.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheyennevalley.rancher.RancherResponse;
import com.sheyennevalley.rancher.v1.BaseClient;
import com.sheyennevalley.rancher.v1.Response;
import com.sheyennevalley.rancher.v1.services.model.Service;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by justin on 11/1/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class ServicesClientTest {

    private ServicesClient servicesClient;

    @Mock
    BaseClient baseClient;

    @Before
    public void setUp(){
        ObjectMapper mapper = new ObjectMapper();
        servicesClient = new ServicesRancherClient(baseClient, mapper);
        when(baseClient.makeGetRequest("/v1/services")).thenReturn(buildResponse());
    }

    @Test
    public void shouldReturnServicesFromRancher(){
        Response<List<Service>> response = servicesClient.getServices();
        assertTrue(response.getValue().get(0).equals(new Service()));

    }

    private RancherResponse buildResponse(){
        try {
            String content = IOUtils.toString(
                    getClass().getResourceAsStream("/services.json"), "UTF-8");
            return new RancherResponse(200, "Success", content);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
