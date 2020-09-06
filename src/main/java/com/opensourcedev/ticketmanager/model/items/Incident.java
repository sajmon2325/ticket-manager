package com.opensourcedev.ticketmanager.model.items;

import com.opensourcedev.ticketmanager.model.enums.IncidentType;

import lombok.*;



@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Incident extends BaseItem{

    private String incidentId; // public ID set by user
    private IncidentType incidentType;


}
