package com.ripple.VMProvisioningService.controller;


import com.ripple.VMProvisioningService.service.VMDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("vm")
@RequiredArgsConstructor
public class VMDetailsController {

    private final VMDetailsService vmDetailsService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity getVMDetails() {
        return vmDetailsService.getVMDetails();
    }
}
