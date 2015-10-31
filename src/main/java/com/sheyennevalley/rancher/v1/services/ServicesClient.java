package com.sheyennevalley.rancher.v1.services;

import com.sheyennevalley.rancher.v1.Response;
import com.sheyennevalley.rancher.v1.services.model.Service;

import java.util.List;

/**
 * Created by justin on 10/31/15.
 */
public interface ServicesClient {

    Response<List<Service>> getServices();
}
