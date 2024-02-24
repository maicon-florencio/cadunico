package com.microsservice.cad.cadunico.service.facade;

import com.microsservice.cad.cadunico.service.chain.AcrescimoProcessContext;
import com.microsservice.cad.cadunico.service.chain.AcrescimoProcessoStep;

public class FacadeChainStartService {
    public static Object run(AcrescimoProcessoStep startProcess, AcrescimoProcessContext inicialContext){
        try{
            AcrescimoProcessContext result = startProcess.execute(inicialContext);
            return result.getProcessResult();
        }catch (Exception ex){
            return "Pendencias : " + ex.getMessage();
        }

    }
}
