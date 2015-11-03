package com.sheyennevalley.rancher.v1.containers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheyennevalley.rancher.v1.BaseClient;
import com.sheyennevalley.rancher.v1.BaseClientTest;
import com.sheyennevalley.rancher.v1.Response;
import com.sheyennevalley.rancher.v1.containers.model.Container;
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
public class ContainersClientTest extends BaseClientTest{

    private ContainersClient containersClient;

    @Mock
    private BaseClient baseClient;

    @Before
    public void setUp() {
        ObjectMapper mapper = new ObjectMapper();
        containersClient = new ContainersRancherClient(baseClient, mapper, "1a5");
    }

    @Test
    public void shouldReturnContianersResponse(){
        when(baseClient.makeGetRequest("/v1/projects/1a5/containers")).thenReturn(buildResponse("/containers.json"));
        Response<List<Container>> response = containersClient.getContainers();
        assertTrue(response.getValue().get(0).getId().equals("1i7"));
    }

    @Test
    public void shouldReturnRequestedContainer(){
        when(baseClient.makeGetRequest("/v1/projects/1a5/containers/1i7")).thenReturn(buildResponse("/1i7Container.json"));
        Response<Container> response = containersClient.getContainer("1i7");
        assertTrue(response.getValue().getId().equals("1i7"));

    }

}
