package com.microsservice.cad.cadunico.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microsservice.cad.cadunico.dominio.TechTools;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StacksTechDTO implements Serializable {

    private UUID stackTechId;
    private Long techLaguageId;
    private Long squadId;

    private LocalDateTime dtCreated;

    private LocalDateTime dtUpdated;

    private List<TechToolsDTO> tools;
}
