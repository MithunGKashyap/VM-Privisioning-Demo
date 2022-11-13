package com.ripple.VMProvisioningService.repository;

import com.ripple.VMProvisioningService.model.HardDisk;
import com.ripple.VMProvisioningService.model.RAM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HardDiskRepository extends JpaRepository<HardDisk, Long> {

    @Override
    Optional<HardDisk> findById(Long id);
}
