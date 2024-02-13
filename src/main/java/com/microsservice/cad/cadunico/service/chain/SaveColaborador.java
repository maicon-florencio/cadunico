package com.microsservice.cad.cadunico.service.chain;

import java.util.Objects;

public class SaveColaborador extends AcrescimoProcessoStep{
    public SaveColaborador(Object... args) {
        super(args);
    }

    @Override
    public AcrescimoProcessContext execute(AcrescimoProcessContext context) throws Exception {

        var colaboradorDTO =  context.getContext();

        if(Objects.isNull(colaboradorDTO)) throw new Exception(" Contexto de dados nulos.");

        return next(context," Parabens Novo Salario " + context.getContext().getCargo().getSalario());
    }
}
