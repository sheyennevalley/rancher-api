package com.sheyennevalley.rancher.v1.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheyennevalley.rancher.v1.BaseClient;
import com.sheyennevalley.rancher.v1.BaseClientTest;
import com.sheyennevalley.rancher.v1.Response;
import com.sheyennevalley.rancher.v1.services.model.Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by justin on 11/1/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class ServicesClientTest extends BaseClientTest{

    private ServicesClient servicesClient;

    @Mock
    BaseClient baseClient;

    @Before
    public void setUp(){
        ObjectMapper mapper = new ObjectMapper();
        servicesClient = new ServicesRancherClient(baseClient, mapper, "1a5");
    }

    @Test
    public void shouldReturnServicesFromRancher(){
        when(baseClient.makeGetRequest("/v1/projects/1a5/services")).thenReturn(buildResponse("/services.json"));
        Response<List<Service>> response = servicesClient.getServices();
        assertTrue(response.getValue().get(0).getId().equals("1s6"));

    }

    @Test
    public void shouldReturnServiceByIdFromRancher(){
        when(baseClient.makeGetRequest("/v1/projects/1a5/services/1s6")).thenReturn(buildResponse("/1s6service.json"));
        Response<Service> response = servicesClient.getService("1s6");
        assertTrue(response.getValue().getId().equals("1s6"));

    }

}
