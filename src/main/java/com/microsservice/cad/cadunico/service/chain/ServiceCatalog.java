package com.microsservice.cad.cadunico.service.chain;

public class ServiceCatalog {

    public static AcrescimoProcessoStep melhorarSalario = buildChain(new RequiredFields(), new AumentoSalarioTempCasa());
    
    private static AcrescimoProcessoStep buildChain(AcrescimoProcessoStep... steps){
        for(int index = 0; index < steps.length -1; index++) {
            AcrescimoProcessoStep currentProcess = steps[index];
            currentProcess.setNextStep(steps[index + 1]);
        }
        return steps[0];
    }
        
}
