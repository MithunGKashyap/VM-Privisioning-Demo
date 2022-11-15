package com.ripple.VMProvisioningService.service;

import org.springframework.http.ResponseEntity;

public interface UserVmReadService {
    ResponseEntity getVMByUserId(final Long appUserId);
    ResponseEntity getTopNUserVM(final Long topN, final Long appUserId);

}
