package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.BaseItemDto;
import com.opensourcedev.ticketmanager.dto.ChangeTicketDto;
import com.opensourcedev.ticketmanager.dto.ChangeTicketDto.ChangeTicketDtoBuilder;
import com.opensourcedev.ticketmanager.model.items.BaseItem;
import com.opensourcedev.ticketmanager.model.items.ChangeTicket;
import com.opensourcedev.ticketmanager.model.items.ChangeTicket.ChangeTicketBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-18T18:44:11+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class ChangeTicketMapperImpl implements ChangeTicketMapper {

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
    public ChangeTicketDto changeTicketToChangeTicketDto(ChangeTicket changeTicket) {
        if ( changeTicket == null ) {
            return null;
        }

        ChangeTicketDtoBuilder changeTicketDto = ChangeTicketDto.builder();

        changeTicketDto.changeId( changeTicket.getChangeId() );
        changeTicketDto.changeType( changeTicket.getChangeType() );
        changeTicketDto.description( changeTicket.getDescription() );

        return changeTicketDto.build();
    }

    @Override
    public ChangeTicket changeTicketDtoToChangeTicket(ChangeTicketDto changeTicketDto) {
        if ( changeTicketDto == null ) {
            return null;
        }

        ChangeTicketBuilder changeTicket = ChangeTicket.builder();

        changeTicket.itemStatus( changeTicketDto.getItemStatus() );
        changeTicket.createdAt( changeTicketDto.getCreatedAt() );
        changeTicket.updatedAt( changeTicketDto.getUpdatedAt() );
        changeTicket.closedAt( changeTicketDto.getClosedAt() );
        changeTicket.incidentSolver( changeTicketDto.getIncidentSolver() );
        changeTicket.user( changeTicketDto.getUser() );
        changeTicket.changeId( changeTicketDto.getChangeId() );
        changeTicket.changeType( changeTicketDto.getChangeType() );
        changeTicket.description( changeTicketDto.getDescription() );

        return changeTicket.build();
    }
}
