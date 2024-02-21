package com.microsservice.cad.cadunico.service.chain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class AumentoSalarioTempCasa extends AcrescimoProcessoStep{

    public AumentoSalarioTempCasa(Object... args) {
        super(args);
    }

    @Override
    public AcrescimoProcessContext execute(AcrescimoProcessContext context) throws Exception {

    String msg = "Regra não atendida";
        var dtInic = context.getContext().getCargo().getDtInicioCargo();
        if(dtInic.isBefore(LocalDate.now())
                && (Objects.isNull(context.getContext().getCargo().getDtFimCargo()))){

            if((ChronoUnit.YEARS.between(dtInic,LocalDate.now()) >= 1) && (ChronoUnit.YEARS.between(dtInic,LocalDate.now()) <=3) ){
                var salarioAtual =  context.getContext().getCargo().getSalario();
                context.getContext().getCargo().setSalario(salarioAtual + ((salarioAtual * 10)/100));
                msg ="Acrescimo de 10%";
            }
        }
        return next(context,msg);
    }
}
