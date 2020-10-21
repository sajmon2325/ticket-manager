/*
package com.opensourcedev.ticketmanager.bootstrap;

import com.opensourcedev.ticketmanager.model.enums.ChangeType;
import com.opensourcedev.ticketmanager.model.enums.ItemStatus;
import com.opensourcedev.ticketmanager.model.enums.UserType;
import com.opensourcedev.ticketmanager.model.items.ChangeTicket;
import com.opensourcedev.ticketmanager.model.users.IncidentSolver;
import com.opensourcedev.ticketmanager.model.users.User;
import com.opensourcedev.ticketmanager.service.ChangeService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

    private ChangeService changeService;

    @Autowired
    public BootstrapData(ChangeService changeService) {
        this.changeService = changeService;
    }

    private IncidentSolver companyIncidentSolver = IncidentSolver.builder()
            .incidentId("ccba7534-feca-413f-9abe-e5ae7fe9105b")
            .userName("rdude")
            .build();

    private User customerUser = User.builder()
            .userId("d969e5b9-0fc1-4213-b1e7-bee044864f2f")
            .userType(UserType.CUSTOMER)
            .userName("plotor")
            .build();


    private ChangeTicket osInstallTicket = ChangeTicket.builder()
            .changeId("f33ad5c0-70d3-41ce-9cc4-365c714bcb1d")
            .changeType(ChangeType.INSTALLATION_OF_OS)
            .description("Need Installation of new Windows 10 64-Bit OS")
            .itemStatus(ItemStatus.OPEN)
            .createdAt(Timestamp.valueOf("2020-02-01 09:28:56"))
            .updatedAt(Timestamp.valueOf("2020-02-05 12:28:56"))
            .closedAt(Timestamp.valueOf("2020-02-06 08:00:25"))
            .incidentSolver(companyIncidentSolver)
            .user(customerUser)
            .build();



    private void loadBootstrapData(){
        System.out.println("Starting save operation...");
        changeService.save(osInstallTicket);
        System.out.println("Save operation successful...");

    }

    @Override
    public void run(String... args) throws Exception {
        loadBootstrapData();
    }
}
*/
