package com.sheyennevalley.rancher.v1.services.model;

import java.util.Date;
import java.util.Map;

/**
 * Created by justin on 10/31/15.
 */
public class Service {

    String id;
    String type;
    Map<String,String> links;
    Map<String,String> actions;
    String name;
    String state;
    String accountId;
    String createIndex;
    Date created;

}
