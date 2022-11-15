package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.data.UserVmData;
import com.ripple.VMProvisioningService.data.VmDetailsData;
import com.ripple.VMProvisioningService.exception.ResourceNotFoundException;
import com.ripple.VMProvisioningService.model.*;
import com.ripple.VMProvisioningService.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserVmReadServiceImpl implements UserVmReadService {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public ResponseEntity getVMByUserId(final Long appUserId) {
        final var mapper = new UserVMDetailsMapper();
        final var sqlQuery = "Select au.username as username, " + mapper.schemaSql()
                + " JOIN app_user au on uv.app_user_id = au.id" + " where uv.app_user_id = " + appUserId;
        final var vmDataList = this.jdbcTemplate.query(sqlQuery, mapper);
        final var responseData = new ResponseData(HttpStatus.OK.value(), ResponseStatusConstants.SUCCESS.name(), vmDataList);
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @Override
    public ResponseEntity getTopNUserVM(final Long topN, final Long appUserId) {
        final var mapper = new UserVMDetailsMapper();
        String whereClause = "";
        String limitClause = "";
        if (null != appUserId) {
            whereClause = " where uv.app_user_id = " + appUserId;
        }
        if (null != topN) {
            limitClause = " limit " + topN;
        }
        final var sqlQuery = "Select au.username as username, " + mapper.schemaSql() +
                "JOIN app_user au on uv.app_user_id = au.id " + whereClause + " order by vr.id desc " + limitClause;

        final var vmDataList = this.jdbcTemplate.query(sqlQuery, mapper);
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), ResponseStatusConstants.SUCCESS.name(), vmDataList);
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    public static class UserVMDetailsMapper implements RowMapper<UserVmData> {
        private String sql;

        public UserVMDetailsMapper() {
            final var builder = new StringBuilder();
            builder.append(" vo.os_name as os, vc.cpu_type as cpu, vhd.hard_disk_size as hardDisk, vr.ram_size as ram");
            builder.append(" from user_vm uv");
            builder.append(" JOIN vm_cpu vc on uv.vm_cpu_id = vc.id ");
            builder.append(" JOIN vm_hard_disk vhd on vhd.id = uv.vm_hard_disk_id");
            builder.append(" JOIN vm_ram vr on uv.vm_ram_id = vr.id");
            builder.append(" JOIN vm_os vo on uv.vm_os_id = vo.id ");
            this.sql = builder.toString();
        }

        public String schemaSql() {
            return this.sql;
        }

        @Override
        public UserVmData mapRow(ResultSet rs, int rowNum) throws SQLException {

            final var username = rs.getString("username");
            final var os = rs.getString("os");
            final var cpu = rs.getString("cpu");
            final var hardDisk = rs.getString("hardDisk");
            final var ram = rs.getString("ram");

            return new UserVmData(username, os, ram, hardDisk, cpu);
        }
    }

}
