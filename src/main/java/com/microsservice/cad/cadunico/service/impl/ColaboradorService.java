package com.microsservice.cad.cadunico.service.impl;

import com.microsservice.cad.cadunico.dominio.Colaborador;
import com.microsservice.cad.cadunico.exception.BusinessException;
import com.microsservice.cad.cadunico.mapper.ColaboradorMapper;
import com.microsservice.cad.cadunico.repository.CargoRepository;
import com.microsservice.cad.cadunico.repository.ColaboradorRepository;
import com.microsservice.cad.cadunico.service.chain.AcrescimoProcessContext;
import com.microsservice.cad.cadunico.service.chain.ServiceCatalog;
import com.microsservice.cad.cadunico.service.dto.ColaboradorDTO;
import com.microsservice.cad.cadunico.service.facade.FacadeChainStartService;
import com.microsservice.cad.cadunico.util.ColaboradorUtil;
import com.microsservice.cad.cadunico.util.ErroMsgutil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ColaboradorService {


    @Autowired
    private ColaboradorRepository colaboradorRepository;
    @Autowired
    private CargoRepository cargoRepository;


    public ColaboradorDTO save(ColaboradorDTO dto) {
        if(dto == null) throw  new BusinessException(ErroMsgutil.ERRO_COLABORADOR_NOT_FOUND);
        if(colaboradorRepository.getClientByDocumento(dto.getDocumento())) throw  new BusinessException(ErroMsgutil.ERRO_COLABORADOR_CADASTRADO);
        this.validarDocumento(dto.getDocumento());
        var produtoSave =  colaboradorRepository.save(ColaboradorMapper.INSTANCE.toEntity(dto));
        return ColaboradorMapper.INSTANCE.toDTO(produtoSave);
    }

    public ColaboradorDTO update(ColaboradorDTO dto) {
        if(!colaboradorRepository.existsById(dto.getId())) throw new BusinessException(ErroMsgutil.ERRO_COLABORADOR_NOT_FOUND);
        var clienteUpdated = colaboradorRepository.save(ColaboradorMapper.INSTANCE.toEntity(dto));
        return ColaboradorMapper.INSTANCE.toDTO(clienteUpdated);
    }

    public ColaboradorDTO findById(Long id) {
        if(id == null || !colaboradorRepository.existsById(id)) throw new BusinessException(ErroMsgutil.ERRO_COLABORADOR_NOT_FOUND);
        return ColaboradorMapper.INSTANCE.toDTO(colaboradorRepository.getReferenceById(id));
    }

    public List<ColaboradorDTO> findall() {
        return ColaboradorMapper.INSTANCE.toDTOs(colaboradorRepository.findAll());
    }

    public void deleteById(Long id) {
        if(!colaboradorRepository.existsById(id)) throw new BusinessException(ErroMsgutil.ERRO_COLABORADOR_NOT_FOUND);
        colaboradorRepository.deleteById(id);
    }

    private void validarDocumento(String doc){
        if(ColaboradorUtil.removeCaracteresEspeciais(doc).length() > 11) {
            if (!ColaboradorUtil.isCNPJ(doc)) throw new BusinessException(ErroMsgutil.ERRO_CNPJ_INVALIDO);
        }else {
            if (!ColaboradorUtil.isCPF(doc)) throw new BusinessException(ErroMsgutil.ERRO_CPF_INVALIDO);
        }
    }

    public ColaboradorDTO growUpAmountSalary(String documento){
        var colaboradorFound =  colaboradorRepository.getColaboradorByDocumento(documento);
        String result = contextStepAnalise(colaboradorFound);
        if(result.contains("Erro:"))  throw new BusinessException(result);
        cargoRepository.save(colaboradorFound.getCargo());
        return ColaboradorMapper.INSTANCE.toDTO( colaboradorFound );
    }

    private String contextStepAnalise(Colaborador colaboradorFound) {
        var context =  new AcrescimoProcessContext();
        context.reset();
        context.put(colaboradorFound);
        return  (String) FacadeChainStartService.run(ServiceCatalog.acrescimoSalarioSolicitacao,context);
    }


}
