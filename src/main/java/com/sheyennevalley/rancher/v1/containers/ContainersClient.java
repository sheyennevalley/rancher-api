package com.sheyennevalley.rancher.v1.containers;

import com.sheyennevalley.rancher.v1.Response;
import com.sheyennevalley.rancher.v1.containers.model.Container;

import java.util.List;

/**
 * Created by justin on 10/31/15.
 */
public interface ContainersClient {

    Response<List<Container>> getContainers();
    Response<Container> getContainer(String id);
}
