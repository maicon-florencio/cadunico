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
public class StackTechEmId {
    @Column(name = "stack_tech_id")
    private UUID stackTechId;
    @Column(name = "tech_laguage_id")
    private Long techLaguageId;
    @Column(name = "squad_id")
    private Long squadId;

}
