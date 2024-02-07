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
        var dtInic = context.getContext().getCargo().getDtInicioCargo();
        if(dtInic.isBefore(LocalDate.now())
                && (Objects.isNull(context.getContext().getCargo().getDtFimCargo()))){

            if(ChronoUnit.YEARS.between(LocalDate.now(),dtInic) >= 1 || ChronoUnit.YEARS.between(LocalDate.now(),dtInic) <=3 ){

            }

        }

        return next(context,true);
    }
}
