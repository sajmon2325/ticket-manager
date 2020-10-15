package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.ChangeTicketDto;
import com.opensourcedev.ticketmanager.dto.ChangeTicketDto.ChangeTicketDtoBuilder;
import com.opensourcedev.ticketmanager.model.items.ChangeTicket;
import com.opensourcedev.ticketmanager.model.items.ChangeTicket.ChangeTicketBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-15T21:17:02+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class ChangeTicketMapperImpl implements ChangeTicketMapper {

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

        changeTicket.changeId( changeTicketDto.getChangeId() );
        changeTicket.changeType( changeTicketDto.getChangeType() );
        changeTicket.description( changeTicketDto.getDescription() );

        return changeTicket.build();
    }
}
