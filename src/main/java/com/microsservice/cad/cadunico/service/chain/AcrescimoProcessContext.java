package com.microsservice.cad.cadunico.service.chain;

import com.microsservice.cad.cadunico.dominio.Colaborador;
import lombok.Getter;

@Getter
public class AcrescimoProcessContext {
    private Colaborador context;
    private Object processResult;

    public AcrescimoProcessContext() { this.context =  Colaborador.builder().build();  }


    public void reset(){
        context = Colaborador.builder().build();
        processResult = null;
    }
    public Object put(Colaborador entity){
         return this.context =entity;
    }


    public void setProcessResult(Object result){this.processResult = result;}

    public Object getProcessResult(){return processResult;}
}
