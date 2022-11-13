package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.model.UserVm;
import org.springframework.http.ResponseEntity;

public interface UserVmWriteService {
    ResponseEntity persistUserVm(UserVm userVm);
}
