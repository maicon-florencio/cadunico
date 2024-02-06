package com.microsservice.cad.cadunico.service.chain;

import com.microsservice.cad.cadunico.service.dto.ClientDTO;
import lombok.Getter;

@Getter
public class AcrescimoProcessContext {
    private ClientDTO context;
    private Object processResult;

    public AcrescimoProcessContext() { this.context =  ClientDTO.builder().build();  }

    public void reset(){
        context = ClientDTO.builder().build();
        processResult = null;
    }

    public void addProcessResult(Object result){this.processResult = result;}

    public Object getProcessResult(){return processResult;}
}
