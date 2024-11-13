package com.microclimate.platform.u202220528.microclimate.domain.services;

import com.microclimate.platform.u202220528.microclimate.domain.model.aggregates.Microclimate;
import com.microclimate.platform.u202220528.microclimate.domain.model.queries.GetAllMicroclimateQuery;
import com.microclimate.platform.u202220528.microclimate.domain.model.queries.GetMicroclimateByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * The microclimates query service interface
 */
public interface MicroclimatesQueryService {

    Optional<Microclimate> handle(GetMicroclimateByIdQuery query);

    /**
     * Handle a get all microclimates query
     *
     * @param query The get all microclimates query
     * @return The list of microclimates
     * @see GetAllMicroclimateQuery
     */
    List<Microclimate> handle(GetAllMicroclimateQuery query);
}
