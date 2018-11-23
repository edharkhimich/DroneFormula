package com.kdev.droneformula.models.drone;

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
        "ascension",
        "descent",
        "translation"
})
public class CurrentLoadInFlight {

    @JsonProperty("ascension")
    private Integer ascension;
    @JsonProperty("descent")
    private Integer descent;
    @JsonProperty("translation")
    private Integer translation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ascension")
    public Integer getAscension() {
        return ascension;
    }

    @JsonProperty("ascension")
    public void setAscension(Integer ascension) {
        this.ascension = ascension;
    }

    @JsonProperty("descent")
    public Integer getDescent() {
        return descent;
    }

    @JsonProperty("descent")
    public void setDescent(Integer descent) {
        this.descent = descent;
    }

    @JsonProperty("translation")
    public Integer getTranslation() {
        return translation;
    }

    @JsonProperty("translation")
    public void setTranslation(Integer translation) {
        this.translation = translation;
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
