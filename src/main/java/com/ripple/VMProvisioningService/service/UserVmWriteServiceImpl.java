package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.exception.ResourceNotFoundException;
import com.ripple.VMProvisioningService.exception.SQLException;
import com.ripple.VMProvisioningService.model.UserVm;
import com.ripple.VMProvisioningService.repository.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserVmWriteServiceImpl implements UserVmWriteService {
    private final UserVMRepository userVMRepository;
    private final AppUserRepository appUserRepository;
    private final OsRepository osRepository;
    private final RAMRepository ramRepository;
    private final HardDiskRepository hardDiskRepository;
    private final CPURepository cpuRepository;

    @Override
    public ResponseEntity persistUserVm(UserVm userVm) {
        userVmValidator(userVm);
        try {
            UserVm user = this.userVMRepository.save(userVm);
        }catch (Exception ex){
            throw new SQLException(ex.getLocalizedMessage());
        }
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), ResponseStatusConstants.SUCCESS.name(), "VM Created for user " + userVm.getAppUser());
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    private void userVmValidator(UserVm request){
        appUserRepository.findById(request.getAppUser()).orElseThrow(() -> new ResourceNotFoundException(request.getAppUser(), "User"));
        osRepository.findById(request.getOs()).orElseThrow(() -> new ResourceNotFoundException(request.getOs(), "OS"));
        ramRepository.findById(request.getRam()).orElseThrow(() -> new ResourceNotFoundException(request.getRam(), "RAM"));
        hardDiskRepository.findById(request.getHardDisk()).orElseThrow(() -> new ResourceNotFoundException(request.getHardDisk(), "Hard Disk"));
        cpuRepository.findById(request.getCpuCores()).orElseThrow(() -> new ResourceNotFoundException(request.getCpuCores(), "CPU"));
    }
}
