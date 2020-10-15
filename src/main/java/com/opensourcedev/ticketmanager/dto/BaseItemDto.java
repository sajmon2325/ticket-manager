package com.opensourcedev.ticketmanager.dto;

import com.opensourcedev.ticketmanager.model.enums.ItemStatus;
import com.opensourcedev.ticketmanager.model.users.IncidentSolver;
import com.opensourcedev.ticketmanager.model.users.User;

import java.sql.Timestamp;

public class BaseItemDto {

    private ItemStatus itemStatus;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp closedAt;
    private IncidentSolver incidentSolver;
    private User user;
}
