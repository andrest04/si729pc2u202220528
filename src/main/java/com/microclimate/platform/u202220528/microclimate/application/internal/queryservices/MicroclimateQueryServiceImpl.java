package com.microclimate.platform.u202220528.microclimate.application.internal.queryservices;

import com.microclimate.platform.u202220528.microclimate.domain.model.aggregates.Microclimate;
import com.microclimate.platform.u202220528.microclimate.domain.model.queries.GetAllMicroclimateQuery;
import com.microclimate.platform.u202220528.microclimate.domain.model.queries.GetMicroclimateByIdQuery;
import com.microclimate.platform.u202220528.microclimate.domain.services.MicroclimatesQueryService;
import com.microclimate.platform.u202220528.microclimate.repositories.MicroclimateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The microclimates query service implementation
 */
@Service
public class MicroclimateQueryServiceImpl implements MicroclimatesQueryService {
    private final MicroclimateRepository microclimateRepository;

    public MicroclimateQueryServiceImpl(MicroclimateRepository microclimateRepository) {
        this.microclimateRepository = microclimateRepository;
    }

    /**
     * Handle a get microclimate by id query
     *
     * @param query The get microclimate by id query containing the microclimate id
     * @return The microclimate
     * @see GetMicroclimateByIdQuery
     */
    @Override
    public Optional<Microclimate> handle(GetMicroclimateByIdQuery query) {
        return microclimateRepository.findById(query.microclimateId());
    }

    /**
     * Handle a get all microclimates query
     *
     * @param query The get all microclimates query
     * @return The list of microclimates
     * @see GetAllMicroclimateQuery
     */
    @Override
    public List<Microclimate> handle(GetAllMicroclimateQuery query) {
        return microclimateRepository.findAll();
    }
}
