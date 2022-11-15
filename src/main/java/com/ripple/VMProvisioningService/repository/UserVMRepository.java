package com.ripple.VMProvisioningService.repository;

import com.ripple.VMProvisioningService.data.UserVmData;
import com.ripple.VMProvisioningService.model.UserVm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserVMRepository extends JpaRepository<UserVm, Long> {

    List<UserVm> findByAppUser(final Long appUserId);

}
