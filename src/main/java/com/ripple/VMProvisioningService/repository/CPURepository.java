package com.ripple.VMProvisioningService.repository;

import com.ripple.VMProvisioningService.model.CPU;
import com.ripple.VMProvisioningService.model.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CPURepository extends JpaRepository<CPU, Long> {
    @Override
    Optional<CPU> findById(Long id);
}
