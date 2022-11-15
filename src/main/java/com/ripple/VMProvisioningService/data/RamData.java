package com.ripple.VMProvisioningService.data;

import lombok.Data;

import javax.persistence.Column;

@Data
public class RamData {

    private Long id;

    private String ramSize;
}
