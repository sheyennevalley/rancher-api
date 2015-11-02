package com.sheyennevalley.rancher.v1;

import com.sheyennevalley.rancher.RancherResponse;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * Created by justin on 11/1/15.
 */
public class BaseClientTest {

    public RancherResponse buildResponse(String resource) {
        try {
            String content = IOUtils.toString(
                    getClass().getResourceAsStream(resource), "UTF-8");
            return new RancherResponse(200, "Success", content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
