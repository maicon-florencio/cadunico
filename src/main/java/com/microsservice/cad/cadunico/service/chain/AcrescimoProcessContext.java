package com.microsservice.cad.cadunico.service.chain;

import com.microsservice.cad.cadunico.service.dto.ColaboradorDTO;
import lombok.Getter;

@Getter
public class AcrescimoProcessContext {
    private ColaboradorDTO context;
    private Object processResult;

    public AcrescimoProcessContext() { this.context =  ColaboradorDTO.builder().build();  }

    public void reset(){
        context = ColaboradorDTO.builder().build();
        processResult = null;
    }

    public void addProcessResult(Object result){this.processResult = result;}

    public Object getProcessResult(){return processResult;}
}
