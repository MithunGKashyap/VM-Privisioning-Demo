package com.ripple.VMProvisioningService.repository;

import com.ripple.VMProvisioningService.model.OS;
import com.ripple.VMProvisioningService.model.RAM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RAMRepository extends JpaRepository<RAM, Long> {

    @Override
    Optional<RAM> findById(Long id);
}
