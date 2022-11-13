package com.ripple.VMProvisioningService.controller;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.model.AppUser;
import com.ripple.VMProvisioningService.repository.AppUserRepository;
import com.ripple.VMProvisioningService.service.ResponseStatusConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("appUser")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserRepository appUserRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseData retrieveAppUsers(){
        List<AppUser> appUser = this.appUserRepository.findAll();
        return new ResponseData(HttpStatus.OK.value(),"List of all users", appUser);
    }

    @DeleteMapping("{appUserId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseData deleteAppUsers(@PathVariable final Long appUserId){
        //UserDetails s = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       // System.out.println("Logged in user -> "+ s.getUsername());
//        if(appUserId != s()) {
             this.appUserRepository.deleteById(Long.valueOf(appUserId));
//        }else{
//            throw new RuntimeException("Logged in user cannot delete his own account");
//        }
        return new ResponseData(HttpStatus.OK.value(), ResponseStatusConstants.SUCCESS.name(), appUserId);
    }

}
