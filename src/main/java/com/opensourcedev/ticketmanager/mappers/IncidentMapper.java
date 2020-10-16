package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.IncidentDto;
import com.opensourcedev.ticketmanager.model.items.Incident;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncidentMapper extends BaseItemMapper{

    IncidentDto incidentToIncidentDto(final Incident incident);
    Incident incidentDtoToIncident(final IncidentDto incidentDTO);
}
