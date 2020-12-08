package com.opensourcedev.ticketmanager.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensourcedev.ticketmanager.dto.ChangeTicketDto;
import com.opensourcedev.ticketmanager.model.enums.ChangeType;
import com.opensourcedev.ticketmanager.model.enums.ItemStatus;
import com.opensourcedev.ticketmanager.model.enums.UserType;
import com.opensourcedev.ticketmanager.model.users.IncidentSolver;
import com.opensourcedev.ticketmanager.model.users.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.Instant;


@ExtendWith(MockitoExtension.class)
class ChangeServiceImplTest {

    ChangeTicketDto changeTicketDto;


    @Test
    public void testConversionOfObjectFromPojoToJson() throws JsonProcessingException {

        changeTicketDto = changeTicketDto.builder()
                .changeId("StringID")
                .changeType(ChangeType.INSTALLATION_OF_OS)
                .description("SOME TEXT")
                .itemStatus(ItemStatus.OPEN)
                .createdAt(Timestamp.from(Instant.now()))
                .updatedAt(Timestamp.from(Instant.now()))
                .closedAt(Timestamp.from(Instant.now()))
                .incidentSolver(IncidentSolver.builder().id("ID").incidentId("SOME ID FOR TEST").userName("DUDEAT").build())
                .user(User.builder().userName("USERNAME").userType(UserType.USER).userId("SOMEID").build())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(changeTicketDto);
        System.out.println(json);
    }

}