package com.kdev.droneformula.models.configuration;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "verticalSpeeds",
        "energy",
        "payload"
})
public class Config {

    @JsonProperty("verticalSpeeds")
    private List<VerticalSpeed> verticalSpeeds = null;
    @JsonProperty("energy")
    private List<Energy> energy = null;
    @JsonProperty("payload")
    private Integer payload;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("verticalSpeeds")
    public List<VerticalSpeed> getVerticalSpeeds() {
        return verticalSpeeds;
    }

    @JsonProperty("verticalSpeeds")
    public void setVerticalSpeeds(List<VerticalSpeed> verticalSpeeds) {
        this.verticalSpeeds = verticalSpeeds;
    }

    @JsonProperty("energy")
    public List<Energy> getEnergy() {
        return energy;
    }

    @JsonProperty("energy")
    public void setEnergy(List<Energy> energy) {
        this.energy = energy;
    }

    @JsonProperty("payload")
    public Integer getPayload() {
        return payload;
    }

    @JsonProperty("payload")
    public void setPayload(Integer payload) {
        this.payload = payload;
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
