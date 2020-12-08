package com.opensourcedev.ticketmanager.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensourcedev.ticketmanager.dto.IncidentDto;
import com.opensourcedev.ticketmanager.model.enums.IncidentType;
import com.opensourcedev.ticketmanager.model.enums.ItemStatus;
import com.opensourcedev.ticketmanager.model.enums.UserType;
import com.opensourcedev.ticketmanager.model.users.IncidentSolver;
import com.opensourcedev.ticketmanager.model.users.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IncidentServiceImplTest {

    IncidentDto incidentDto;

    @Test
    public void testConversionOfObjectFromPojoToJson() throws JsonProcessingException{

        incidentDto = IncidentDto.builder()
                .incidentId("StringID")
                .incidentType(IncidentType.DATABASE_CONNECTION_DOWN)
                .itemStatus(ItemStatus.IN_PROGRESS)
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                .closedAt(Timestamp.valueOf(LocalDateTime.now()))
                .incidentSolver(IncidentSolver.builder()
                        .userName("USERNAME")
                        .incidentId("INCIDENTID")
                        .build())
                .user(User.builder()
                        .userId("USER_ID")
                        .userType(UserType.CUSTOMER)
                        .userName("USERNAME")
                        .build())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(incidentDto);
        System.out.println(json);

    }

}