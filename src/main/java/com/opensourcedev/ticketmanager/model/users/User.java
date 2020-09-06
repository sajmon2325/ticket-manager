package com.opensourcedev.ticketmanager.model.users;

import com.opensourcedev.ticketmanager.model.enums.UserType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {     // This entity represents user who is reporting an item

    private UserType userType;

    private String userName;
    private String password;

}

