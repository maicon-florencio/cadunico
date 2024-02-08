package com.microsservice.cad.cadunico.dominio.enumeration;

public enum MaturidadeCargoEnum {


    TRAINER("TRAINER",1),
    JUNIOR("JUNIOR",2),
    MIDDLE("MIDDLE",3),
    SENIOR("SENIOR",4),
    SPECIALIST("SPECIALIST",5);


    private Integer id;
    private String desc;

    MaturidadeCargoEnum(String descricao, Integer indicador){
        this.desc = descricao;
        this.id = indicador;
    }


}
