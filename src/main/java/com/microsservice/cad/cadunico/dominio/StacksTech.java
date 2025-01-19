package com.microsservice.cad.cadunico.dominio;

import com.microsservice.cad.cadunico.dominio.key.StackTechEmId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class StacksTech {

    @EmbeddedId
    private StackTechEmId id;

    private LocalDateTime dtCreated;

    private LocalDateTime dtUpdated;

    @OneToMany(mappedBy = "stackTech",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<TechTools> tools;

}
