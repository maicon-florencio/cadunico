package com.microsservice.cad.cadunico.builder;

import com.microsservice.cad.cadunico.dominio.Cargo;
import com.microsservice.cad.cadunico.dominio.enumeration.MaturidadeCargoEnum;
import com.microsservice.cad.cadunico.service.dto.CargoDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class CargoBuilder {

    private static Long id = 1L;
    private static String nomeCargo= "Software Engenier";
    private static Double salario = 1500.0;
    private static String maturidade = MaturidadeCargoEnum.MIDDLE.name();
    private static LocalDate dtInicCargo = LocalDate.of(2020,10,1);

    private static Integer anosExperienciaArea = 5;


    public static  Cargo createEntity(){
        return Cargo.builder()
                .id(id)
                .nomeCargo(nomeCargo)
                .salario(salario)
                .maturidade(maturidade)
                .dtInicioCargo(dtInicCargo)
                .anosExperienciaArea(anosExperienciaArea)
                .dtFimCargo(null)
                .dtUpdated(LocalDateTime.now())
                .build();
    }

    public static CargoDTO createDto(){
        return CargoDTO.builder()
                .id(2L)
                .nomeCargo("Software QA")
                .salario(2500.6)
                .anosExperienciaArea(3)
                .maturidade(MaturidadeCargoEnum.JUNIOR.name())
                .dtInicioCargo(dtInicCargo.plusYears(2))
                .build();
    }


    public static List<CargoDTO> listDTOs(){
        var dto1 = createDto();
        var dto2 = createDto();
        dto2.setId(3L);
        dto2.setAnosExperienciaArea(4);
        dto2.setSalario(6000.0);

        return Arrays.asList(dto1,dto2);

    }

    public static List<Cargo> entities(){
        var ent1 = createEntity();
        var ent2 = createEntity();
        ent2.setId(4L);
        ent2.setSalario(5541.5);
        ent2.setNomeCargo("SCRUM MASTER");
        return Arrays.asList(ent1,ent2);
    }
}
