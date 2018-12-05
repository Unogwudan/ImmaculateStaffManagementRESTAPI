package com.immaculateconsulting.util;

import java.util.HashMap;
import java.util.Map;
import javax.json.bind.JsonbBuilder;

/**
 * This class holds any additional payload we are returning to the client.
 * @author Unogwudan
 */
public class PayLoad {

    private Map<String, Object> data = new HashMap<>();

    public void add(String key, Object value) {
        data.put(key, value);
    }

    public String toJson() {
        return JsonbBuilder.create().toJson(data);
    }

}
