package com.ripple.VMProvisioningService.repository;

import com.ripple.VMProvisioningService.model.HardDisk;
import com.ripple.VMProvisioningService.model.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HardDiskRepository extends JpaRepository<HardDisk, Long> {

    @Override
    Optional<HardDisk> findById(Long id);
}
