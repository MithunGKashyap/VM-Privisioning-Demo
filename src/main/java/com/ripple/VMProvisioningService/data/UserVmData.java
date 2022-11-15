package com.ripple.VMProvisioningService.data;

import com.ripple.VMProvisioningService.model.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@RequiredArgsConstructor
public class UserVmData {

    private String appUser;

    private String os;

    private String ram;

    private String hardDisk;

    private String cpuCores;

    public UserVmData(String appUser, String os, String ram, String hardDisk, String cpuCores) {
        this.appUser = appUser;
        this.os = os;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.cpuCores  =cpuCores;
    }
}
