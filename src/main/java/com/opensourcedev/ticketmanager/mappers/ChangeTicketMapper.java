package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.ChangeTicketDto;
import com.opensourcedev.ticketmanager.model.items.ChangeTicket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChangeTicketMapper extends BaseItemMapper{

    ChangeTicketDto changeTicketToChangeTicketDto(final ChangeTicket changeTicket);
    ChangeTicket changeTicketDtoToChangeTicket(final ChangeTicketDto changeTicketDto);
}
