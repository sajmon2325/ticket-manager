package com.opensourcedev.ticketmanager.model.users;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncidentSolver {   // this user is responsible for solving all items, not only incidents

    private String userName;
    private String password;

}
