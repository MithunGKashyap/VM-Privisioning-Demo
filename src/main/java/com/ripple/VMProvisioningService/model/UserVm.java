package com.ripple.VMProvisioningService.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "user_vm")
@Getter
@Setter
@EqualsAndHashCode
public class UserVm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "app_user_id", nullable = false, length = 100)
    private Long appUser;

    @Column(name = "vm_os_id", nullable = false, length = 100)
    private Long os;

    @Column(name = "vm_ram_id", nullable = false, length = 100)
    private Long ram;

    @Column(name = "vm_hard_disk_id", nullable = false, length = 100)
    private Long hardDisk;

    @Column(name = "vm_cpu_id", nullable = false, length = 100)
    private Long cpuCores;

}
