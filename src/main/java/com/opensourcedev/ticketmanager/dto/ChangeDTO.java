package com.opensourcedev.ticketmanager.dto;

import com.opensourcedev.ticketmanager.model.enums.ChangeType;
import com.opensourcedev.ticketmanager.model.enums.ItemStatus;
import com.opensourcedev.ticketmanager.model.users.IncidentSolver;
import com.opensourcedev.ticketmanager.model.users.User;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeDTO {

    private String changeId;    // public ID set by user

    private ChangeType changeType;
    private String description;

    private ItemStatus itemStatus;

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp closedAt;

    private IncidentSolver incidentSolver;
    private User user;
}
