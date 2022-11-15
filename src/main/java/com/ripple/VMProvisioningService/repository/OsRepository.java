package com.ripple.VMProvisioningService.repository;

import com.ripple.VMProvisioningService.model.AppUser;
import com.ripple.VMProvisioningService.model.OS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Repository
public interface OsRepository extends JpaRepository<OS, Long> {

    @Override
    Optional<OS> findById(Long id);
}
