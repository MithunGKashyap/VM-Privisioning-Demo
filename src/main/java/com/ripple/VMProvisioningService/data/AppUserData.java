package com.ripple.VMProvisioningService.data;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AppUserData {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String mobileNo;

    private String role;
}
