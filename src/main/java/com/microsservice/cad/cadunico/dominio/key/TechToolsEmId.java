package com.microsservice.cad.cadunico.dominio.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class TechToolsEmId {

    @Column(name = "tech_tools_id")
    private UUID techToolsId;

    @Column(name = "stack_tech_id")
    private UUID stacksTechId;

}
