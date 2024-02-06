package com.microsservice.cad.cadunico.service.chain;

public class AumentoSalarioTempCasa extends AcrescimoProcessoStep{

    public AumentoSalarioTempCasa(Object... args) {
        super(args);
    }

    @Override
    public AcrescimoProcessContext execute(AcrescimoProcessContext context) throws Exception {
        return next(context,true);
    }
}
