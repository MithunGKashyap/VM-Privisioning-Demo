package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.data.VmDetailsData;
import com.ripple.VMProvisioningService.model.CPU;
import com.ripple.VMProvisioningService.model.HardDisk;
import com.ripple.VMProvisioningService.model.OS;
import com.ripple.VMProvisioningService.model.RAM;
import com.ripple.VMProvisioningService.repository.CPURepository;
import com.ripple.VMProvisioningService.repository.HardDiskRepository;
import com.ripple.VMProvisioningService.repository.OsRepository;
import com.ripple.VMProvisioningService.repository.RAMRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VMDetailsServiceImpl implements VMDetailsService{

    private final OsRepository osRepository;
    private final RAMRepository ramRepository;
    private final HardDiskRepository hardDiskRepository;
    private final CPURepository cpuRepository;

    @Override
    public ResponseEntity getVMDetails() {
        List<OS> osList = osRepository.findAll();
        List<RAM> ramList = ramRepository.findAll();
        List<HardDisk> hardDiskList = hardDiskRepository.findAll();
        List<CPU> cpuList = cpuRepository.findAll();
        VmDetailsData vmDetailsData = new VmDetailsData(osList, ramList, hardDiskList, cpuList);
        final var responseData = new ResponseData(HttpStatus.OK.value(), ResponseStatusConstants.SUCCESS.name(), vmDetailsData);
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}
