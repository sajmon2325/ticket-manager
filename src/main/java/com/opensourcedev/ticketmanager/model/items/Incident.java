package com.opensourcedev.ticketmanager.model.items;

import com.opensourcedev.ticketmanager.model.enums.IncidentType;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Incident extends BaseItem{

    @NotBlank
    private String incidentId; // public ID set by user

    @Enumerated(value = EnumType.STRING)
    @NotBlank
    private IncidentType incidentType;


}
