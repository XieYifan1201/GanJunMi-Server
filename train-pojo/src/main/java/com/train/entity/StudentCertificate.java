package com.train.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCertificate {

    private int id;
    private Long studentId;
    private int trainsClassId;
    private boolean isCertificate;
    private String CertificateNo;
    private int certificateId;
    private String QRcode;
    private LocalDateTime date;
    private boolean pay;

}
