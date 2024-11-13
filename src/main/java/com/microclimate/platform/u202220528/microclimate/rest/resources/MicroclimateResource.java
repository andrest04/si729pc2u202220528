package com.microclimate.platform.u202220528.microclimate.rest.resources;

public record MicroclimateResource(Long id, Long climateId, String registerEmailAddress, String climatePlace, String climateCountry, String  climateContinent, Long climateTemperature ) {
}
