package com.ripple.VMProvisioningService.repository;

import com.ripple.VMProvisioningService.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

    @Override
    Optional<AppUser> findById(Long appUserId);
}
