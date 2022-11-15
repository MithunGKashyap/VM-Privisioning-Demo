package com.ripple.VMProvisioningService.controller;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.model.UserVm;
import com.ripple.VMProvisioningService.repository.UserVMRepository;
import com.ripple.VMProvisioningService.service.ResponseStatusConstants;
import com.ripple.VMProvisioningService.service.UserVmReadService;
import com.ripple.VMProvisioningService.service.UserVmWriteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("userVm")
@RequiredArgsConstructor
public class VMProvisioningResourceController {

    private final UserVmWriteService userVmWriteService;

    private final UserVmReadService userVmReadService;

    private final UserVMRepository userVMRepository;

    @PostMapping
    public ResponseEntity createUserVM(@RequestBody final UserVm userVm) {
        log.info("CreteUserVM API invoked");
        return this.userVmWriteService.persistUserVm(userVm);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity getAllUserVM() {
        log.info("get ALL UserVM API invoked");
        List<UserVm> userVmList = userVMRepository.findAll();
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), ResponseStatusConstants.SUCCESS.name(), userVmList);
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @GetMapping("{appUserId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity getUserVM(@PathVariable final long appUserId) {
        log.info("getUserVM by User ID invoked");
        return userVmReadService.getVMByUserId(appUserId);
    }

    @GetMapping("/topN")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity getTopVMByEntity(@RequestParam(defaultValue = "1") final Long limit, @RequestParam(defaultValue = "") final Long appUserId) {
        log.info("get top N VMs");
        return this.userVmReadService.getTopNUserVM(limit, appUserId);

    }

}
