package com.microclimate.platform.u202220528.microclimate.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class ClimateId {

    @Column(name = "climate_id", nullable = false)
    private Long climateId;

    protected ClimateId() {
        // Constructor vacío para JPA
    }

    public ClimateId(Long climateId) {
        if (climateId == null || climateId <= 0) {
            throw new IllegalArgumentException("ClimateId must be a positive number.");
        }
        this.climateId = climateId;
    }

    public Long getValue() {
        return climateId;
    }
}
