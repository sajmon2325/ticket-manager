package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.BaseItemDto;
import com.opensourcedev.ticketmanager.dto.IncidentDto;
import com.opensourcedev.ticketmanager.dto.IncidentDto.IncidentDtoBuilder;
import com.opensourcedev.ticketmanager.model.items.BaseItem;
import com.opensourcedev.ticketmanager.model.items.Incident;
import com.opensourcedev.ticketmanager.model.items.Incident.IncidentBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-28T14:05:32+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class IncidentMapperImpl implements IncidentMapper {

    @Override
    public BaseItemDto baseItemToBaseItemDto(BaseItem baseItem) {
        if ( baseItem == null ) {
            return null;
        }

        BaseItemDto baseItemDto = new BaseItemDto();

        baseItemDto.setItemStatus( baseItem.getItemStatus() );
        baseItemDto.setCreatedAt( baseItem.getCreatedAt() );
        baseItemDto.setUpdatedAt( baseItem.getUpdatedAt() );
        baseItemDto.setClosedAt( baseItem.getClosedAt() );
        baseItemDto.setIncidentSolver( baseItem.getIncidentSolver() );
        baseItemDto.setUser( baseItem.getUser() );

        return baseItemDto;
    }

    @Override
    public BaseItem baseItemDtoToBaseItem(BaseItemDto baseItemDto) {
        if ( baseItemDto == null ) {
            return null;
        }

        BaseItem baseItem = new BaseItem();

        baseItem.setItemStatus( baseItemDto.getItemStatus() );
        baseItem.setCreatedAt( baseItemDto.getCreatedAt() );
        baseItem.setUpdatedAt( baseItemDto.getUpdatedAt() );
        baseItem.setClosedAt( baseItemDto.getClosedAt() );
        baseItem.setIncidentSolver( baseItemDto.getIncidentSolver() );
        baseItem.setUser( baseItemDto.getUser() );

        return baseItem;
    }

    @Override
    public IncidentDto incidentToIncidentDto(Incident incident) {
        if ( incident == null ) {
            return null;
        }

        IncidentDtoBuilder incidentDto = IncidentDto.builder();

        incidentDto.incidentId( incident.getIncidentId() );
        incidentDto.incidentType( incident.getIncidentType() );

        return incidentDto.build();
    }

    @Override
    public Incident incidentDtoToIncident(IncidentDto incidentDTO) {
        if ( incidentDTO == null ) {
            return null;
        }

        IncidentBuilder incident = Incident.builder();

        incident.itemStatus( incidentDTO.getItemStatus() );
        incident.createdAt( incidentDTO.getCreatedAt() );
        incident.updatedAt( incidentDTO.getUpdatedAt() );
        incident.closedAt( incidentDTO.getClosedAt() );
        incident.incidentSolver( incidentDTO.getIncidentSolver() );
        incident.user( incidentDTO.getUser() );
        incident.incidentId( incidentDTO.getIncidentId() );
        incident.incidentType( incidentDTO.getIncidentType() );

        return incident.build();
    }
}
