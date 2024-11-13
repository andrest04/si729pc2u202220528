package com.microclimate.platform.u202220528.microclimate.repositories;

import com.microclimate.platform.u202220528.microclimate.domain.model.aggregates.Microclimate;
import com.microclimate.platform.u202220528.microclimate.domain.model.valueobjects.ClimateContinent;
import com.microclimate.platform.u202220528.microclimate.domain.model.valueobjects.ClimateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroclimateRepository extends JpaRepository<Microclimate, Long> {

    boolean existsByClimateIdAndClimatePlaceAndClimateCountryAndClimateContinent(
            ClimateId climateId, String climatePlace, String climateCountry, ClimateContinent climateContinent
    );
}