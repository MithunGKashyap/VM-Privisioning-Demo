package com.ripple.VMProvisioningService.data;

import com.ripple.VMProvisioningService.model.CPU;
import com.ripple.VMProvisioningService.model.HardDisk;
import com.ripple.VMProvisioningService.model.OS;
import com.ripple.VMProvisioningService.model.RAM;
import lombok.Data;

import java.util.List;

@Data
public class VmDetailsData {

    private List<OS> os;

    private List<RAM> ram;

    private List<HardDisk> hardDisk;

    private List<CPU> cpuCores;

    public VmDetailsData(List<OS> os, List<RAM> ram, List<HardDisk> hardDisk, List<CPU> cpuCores) {
        this.os = os;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.cpuCores = cpuCores;
    }
}
