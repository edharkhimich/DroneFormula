package com.kdev.droneformula.models.drone;

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
        "currentLoadInFlight",
        "forcedLandingCharge"
})
public class Drone {

    @JsonProperty("currentLoadInFlight")
    private List<CurrentLoadInFlight> currentLoadInFlight = null;
    @JsonProperty("forcedLandingCharge")
    private Integer forcedLandingCharge;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("currentLoadInFlight")
    public List<CurrentLoadInFlight> getCurrentLoadInFlight() {
        return currentLoadInFlight;
    }

    @JsonProperty("currentLoadInFlight")
    public void setCurrentLoadInFlight(List<CurrentLoadInFlight> currentLoadInFlight) {
        this.currentLoadInFlight = currentLoadInFlight;
    }

    @JsonProperty("forcedLandingCharge")
    public Integer getForcedLandingCharge() {
        return forcedLandingCharge;
    }

    @JsonProperty("forcedLandingCharge")
    public void setForcedLandingCharge(Integer forcedLandingCharge) {
        this.forcedLandingCharge = forcedLandingCharge;
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
