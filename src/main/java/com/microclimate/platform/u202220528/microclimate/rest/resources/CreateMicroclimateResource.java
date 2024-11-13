package com.microclimate.platform.u202220528.microclimate.rest.resources;

public record CreateMicroclimateResource(Long climateId, String registerEmailAddress, String climatePlace, String climateCountry, String  climateContinent, Long climateTemperature) {
    public CreateMicroclimateResource {
        if (registerEmailAddress == null || registerEmailAddress.isBlank()) {
            throw new IllegalArgumentException("Register email address is required");
        }
        if (climatePlace == null || climatePlace.isBlank()) {
            throw new IllegalArgumentException("Climate place is required");
        }
        if (climateCountry == null || climateCountry.isBlank()) {
            throw new IllegalArgumentException("Climate country is required");
        }
        if (climateContinent == null || climateContinent.isBlank()) {
            throw new IllegalArgumentException("Climate continent is required");
        }
        if (climateTemperature == null) {
            throw new IllegalArgumentException("Climate temperature is required");
        }
    }
}
