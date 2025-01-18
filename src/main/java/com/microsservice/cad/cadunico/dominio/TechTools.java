package com.microsservice.cad.cadunico.dominio;

import com.microsservice.cad.cadunico.dominio.key.TechToolsEmId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class TechTools {

    @EmbeddedId
    private TechToolsEmId id;

    private String name;
    private String description;
    private boolean isCertificate;

    private LocalDateTime dtCreated;
    private LocalDateTime dtUpdated;

    @ManyToOne
    private StacksTech stackTech;
}
