package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.ChangeTicketDto;
import com.opensourcedev.ticketmanager.model.items.ChangeTicket;
import org.mapstruct.Mapper;

@Mapper
public interface ChangeTicketMapper {

    ChangeTicketDto changeTicketToChangeDto(final ChangeTicket changeTicket);
    ChangeTicket changeTicketDtoToChangeTicket(final ChangeTicketDto changeTicketDto);
}
