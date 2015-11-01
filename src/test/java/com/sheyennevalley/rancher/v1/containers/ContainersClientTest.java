package com.sheyennevalley.rancher.v1.containers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheyennevalley.rancher.RancherResponse;
import com.sheyennevalley.rancher.v1.BaseClient;
import com.sheyennevalley.rancher.v1.Response;
import com.sheyennevalley.rancher.v1.containers.model.Container;
import org.apache.commons.io.IOUtils;
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
public class ContainersClientTest {

    private ContainersClient containersClient;

    @Mock
    private BaseClient baseClient;

    @Before
    public void setUp() {
        ObjectMapper mapper = new ObjectMapper();
        containersClient = new ContainersRancherClient(baseClient, mapper);
        when(baseClient.makeGetRequest("/v1/containers")).thenReturn(buildResponse());
    }

    @Test
    public void shouldReturnContianersResponse(){
        Response<List<Container>> response = containersClient.getContainers();
        assertTrue(response.getValue().get(0).getId().equals("1i7"));
    }

    private RancherResponse buildResponse(){
        try {
            String content = IOUtils.toString(
                    getClass().getResourceAsStream("/containers.json"), "UTF-8");
            return new RancherResponse(200, "Success", content);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
