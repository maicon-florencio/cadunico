package com.microsservice.cad.cadunico.service.chain;

/**
 * Classe abtract que representa a corrente que será indicada a parti dela.
 *
 */
public abstract class AcrescimoProcessoStep {
    protected AcrescimoProcessoStep nextStep;
    protected Object[] args;

    public AcrescimoProcessoStep(Object... args) { this.args = args; }

    /**
     *
     * @param context
     * @return
     * Class AcrescimoProcessContext representada no processo como objeto a ser verificado
     * esse metodo abtract será implementado nas class que estenderem AcrescimoProcessoStep
     * pois passam a ser classe concreta e aplicaram as regra de processamento necessario
     * sempre desconhecendo a proxima chama que fizerem.
     * @throws Exception
     */
    public abstract AcrescimoProcessContext execute(AcrescimoProcessContext context)throws Exception;

    public void setNextStep(AcrescimoProcessoStep next){ this.nextStep = next;}

    protected  AcrescimoProcessContext next(AcrescimoProcessContext context, Object actualResult) throws Exception{
        context.addProcessResult(actualResult);
        return this.nextStep != null? nextStep.execute(context): context;
    }

}
