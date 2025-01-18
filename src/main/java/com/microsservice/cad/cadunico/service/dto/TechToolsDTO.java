package com.microsservice.cad.cadunico.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microsservice.cad.cadunico.dominio.key.TechToolsEmId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TechToolsDTO {

    private UUID techToolsId;
    private UUID StacksTechId;

    private String name;
    private String description;
    private boolean isCertificate;

    private LocalDateTime dtCreated;

    private LocalDateTime dtUpdated;
}
