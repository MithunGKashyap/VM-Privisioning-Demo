package com.ripple.VMProvisioningService.repository;

import com.ripple.VMProvisioningService.model.OS;
import com.ripple.VMProvisioningService.model.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RAMRepository extends JpaRepository<RAM, Long> {

    @Override
    Optional<RAM> findById(Long id);
}
