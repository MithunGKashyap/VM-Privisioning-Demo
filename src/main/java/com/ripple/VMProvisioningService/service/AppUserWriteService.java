package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.model.AppUser;
import org.springframework.http.ResponseEntity;

public interface AppUserWriteService {
    ResponseEntity saveAppUser(AppUser appUser);
}
