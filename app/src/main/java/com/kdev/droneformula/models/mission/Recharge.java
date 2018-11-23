package com.kdev.droneformula.models.mission;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "rechargerLat ",
        "rechargerLong "
})
public class Recharge {

    @JsonProperty("rechargerLat ")
    private Double rechargerLat;
    @JsonProperty("rechargerLong ")
    private Double rechargerLong;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rechargerLat ")
    public Double getRechargerLat() {
        return rechargerLat;
    }

    @JsonProperty("rechargerLat ")
    public void setRechargerLat(Double rechargerLat) {
        this.rechargerLat = rechargerLat;
    }

    @JsonProperty("rechargerLong ")
    public Double getRechargerLong() {
        return rechargerLong;
    }

    @JsonProperty("rechargerLong ")
    public void setRechargerLong(Double rechargerLong) {
        this.rechargerLong = rechargerLong;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}