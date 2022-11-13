package com.ripple.VMProvisioningService.data;

import com.ripple.VMProvisioningService.model.AppUser;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;
import java.util.List;

@Data
public class ResponseData {
      LocalTime localTime;
      Integer responseCode;
      String responseStatus;
      Object data;

      public ResponseData(Integer responseCode, String responseStatus, Object data){
          this.localTime = LocalTime.now();
          this.responseStatus = responseStatus;
          this.responseCode = responseCode;
          this.data = data;
      }

    public ResponseData(Integer responseCode, String responseStatus){
        this.localTime = LocalTime.now();
        this.responseCode = responseCode;
        this.responseStatus = responseStatus;
    }
}


