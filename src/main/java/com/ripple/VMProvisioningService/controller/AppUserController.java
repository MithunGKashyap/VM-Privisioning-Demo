package com.ripple.VMProvisioningService.controller;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.exception.ResourceNotFoundException;
import com.ripple.VMProvisioningService.model.AppUser;
import com.ripple.VMProvisioningService.repository.AppUserRepository;
import com.ripple.VMProvisioningService.service.ResponseStatusConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appUser")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserRepository appUserRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity retrieveAppUsers() {
        List<AppUser> appUser = this.appUserRepository.findAll();
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), ResponseStatusConstants.SUCCESS.name(), appUser);
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @DeleteMapping("{appUserId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ResponseData> deleteAppUsers(@PathVariable final Long appUserId) {
        try {
            this.appUserRepository.deleteById(appUserId);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(appUserId, "User");
        }
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), ResponseStatusConstants.SUCCESS.name(), appUserId);
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

}
