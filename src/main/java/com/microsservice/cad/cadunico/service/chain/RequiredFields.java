package com.microsservice.cad.cadunico.service.chain;

import javax.management.AttributeNotFoundException;
import java.math.BigDecimal;
import java.util.Objects;

public class RequiredFields extends AcrescimoProcessoStep{

    private static final String N = "\n";
    public RequiredFields(Object... args) {
        super(args);
    }

    @Override
    public AcrescimoProcessContext execute(AcrescimoProcessContext context) throws Exception {
        StringBuilder camposFaltantes = new StringBuilder();

        if(Objects.isNull(context.getContext())){
            throw new AttributeNotFoundException(camposFaltantes.append("Entity is null.").toString());
        }else{
            if(context.getContext().getCargo().getNomeCargo().isEmpty()){
                camposFaltantes.append(" Cargo não informado").append(N);
            }

            if( Objects.nonNull(context.getContext().getCargo().getAnosExperienciaArea() <=0)){
                camposFaltantes.append(" Anos Experiencia vazio.").append(N);
            }

            if( Objects.isNull(context.getContext().getCargo().getSalario()) || context.getContext().getCargo().getSalario().equals(BigDecimal.ZERO)){
                camposFaltantes.append(" Salario zerado ou null. ").append(N);
            }
            if(Boolean.FALSE.equals(context.getContext().getStatus())){
                camposFaltantes.append(" Colaborador inativo. ").append(N);
            }

        }
        if(camposFaltantes.length() > 0) throw new Exception(" Campos Faltantes : \n" + camposFaltantes);

        return next(context,true);
    }
}
