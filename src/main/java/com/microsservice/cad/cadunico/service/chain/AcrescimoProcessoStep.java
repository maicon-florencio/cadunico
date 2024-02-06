package com.microsservice.cad.cadunico.service.chain;

public abstract class AcrescimoProcessoStep {
    protected AcrescimoProcessoStep nextStep;
    protected Object[] args;

    public AcrescimoProcessoStep(Object... args) { this.args = args; }
    public abstract AcrescimoProcessContext execute(AcrescimoProcessContext context)throws Exception;

    public void setNextStep(AcrescimoProcessoStep next){ this.nextStep = next;}

    protected  AcrescimoProcessContext next(AcrescimoProcessContext context, Object actualResult) throws Exception{
        context.addProcessResult(actualResult);
        return this.nextStep != null? nextStep.execute(context): context;
    }

}
