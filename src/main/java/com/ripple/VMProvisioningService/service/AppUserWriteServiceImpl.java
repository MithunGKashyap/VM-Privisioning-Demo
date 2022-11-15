package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.exception.SQLException;
import com.ripple.VMProvisioningService.model.AppUser;
import com.ripple.VMProvisioningService.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class AppUserWriteServiceImpl implements AppUserWriteService {

    private final AppUserRepository appUserRepository;

    @Override
    public ResponseEntity saveAppUser(AppUser appUser) {
        try {
            AppUser user = this.appUserRepository.save(appUser);
            ResponseData responseData =  new ResponseData(HttpStatus.OK.value(), "User saved successfully", user);
            return ResponseEntity.status(HttpStatus.OK).body(responseData);
        }catch (Exception e){
            throw new SQLException(e.getLocalizedMessage());
        }
    }
}
