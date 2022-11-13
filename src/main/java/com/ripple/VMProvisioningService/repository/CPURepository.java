package com.ripple.VMProvisioningService.repository;

import com.ripple.VMProvisioningService.model.CPU;
import com.ripple.VMProvisioningService.model.RAM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CPURepository extends JpaRepository<CPU, Long> {
    @Override
    Optional<CPU> findById(Long id);
}
