package com.kdev.droneformula.models.mission;

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
        "horizontalSpeed",
        "altitude",
        "points"
})

public class Mission {

        @JsonProperty("horizontalSpeed")
        private Integer horizontalSpeed;
        @JsonProperty("altitude")
        private Integer altitude;
        @JsonProperty("points")
        private List<Points> points = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("horizontalSpeed")
        public Integer getHorizontalSpeed() {
            return horizontalSpeed;
        }

        @JsonProperty("horizontalSpeed")
        public void setHorizontalSpeed(Integer horizontalSpeed) {
            this.horizontalSpeed = horizontalSpeed;
        }

        @JsonProperty("altitude")
        public Integer getAltitude() {
            return altitude;
        }

        @JsonProperty("altitude")
        public void setAltitude(Integer altitude) {
            this.altitude = altitude;
        }

        @JsonProperty("points")
        public List<Points> getPoints() {
            return points;
        }

        @JsonProperty("points")
        public void setPoints(List<Points> points) {
            this.points = points;
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