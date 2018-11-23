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
        "endLatitude",
        "endLongitude"
})
public class End {

    @JsonProperty("endLatitude")
    private Double endLatitude;
    @JsonProperty("endLongitude")
    private Double endLongitude;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("endLatitude")
    public Double getEndLatitude() {
        return endLatitude;
    }

    @JsonProperty("endLatitude")
    public void setEndLatitude(Double endLatitude) {
        this.endLatitude = endLatitude;
    }

    @JsonProperty("endLongitude")
    public Double getEndLongitude() {
        return endLongitude;
    }

    @JsonProperty("endLongitude")
    public void setEndLongitude(Double endLongitude) {
        this.endLongitude = endLongitude;
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