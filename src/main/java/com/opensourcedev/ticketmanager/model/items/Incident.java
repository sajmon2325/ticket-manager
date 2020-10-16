package com.opensourcedev.ticketmanager.model.items;

import com.opensourcedev.ticketmanager.model.enums.IncidentType;

import com.opensourcedev.ticketmanager.model.enums.ItemStatus;
import com.opensourcedev.ticketmanager.model.users.IncidentSolver;
import com.opensourcedev.ticketmanager.model.users.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Incident extends BaseItem{

    @Builder
    public Incident(String id, @NotBlank ItemStatus itemStatus, Timestamp createdAt, Timestamp updatedAt,
                    Timestamp closedAt, IncidentSolver incidentSolver, User user, @NotBlank String incidentId,
                    @NotBlank IncidentType incidentType) {
        super(id, itemStatus, createdAt, updatedAt, closedAt, incidentSolver, user);
        this.incidentId = incidentId;
        this.incidentType = incidentType;
    }

    @NotBlank
    private String incidentId; // public ID set by user

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private IncidentType incidentType;


}
