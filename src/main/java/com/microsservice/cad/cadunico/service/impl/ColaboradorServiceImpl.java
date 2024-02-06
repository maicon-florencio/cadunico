package com.microsservice.cad.cadunico.service.impl;

import com.microsservice.cad.cadunico.exception.BusinessException;
import com.microsservice.cad.cadunico.mapper.ColaboradorMapper;
import com.microsservice.cad.cadunico.repository.ColaboradorRepository;
import com.microsservice.cad.cadunico.service.ColaboradorServiceInt;
import com.microsservice.cad.cadunico.service.dto.ColaboradorDTO;
import com.microsservice.cad.cadunico.util.ColaboradorUtil;
import com.microsservice.cad.cadunico.util.ErroMsgutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ColaboradorServiceImpl implements ColaboradorServiceInt {


    @Autowired
    private ColaboradorRepository clientRepository;


    @Override
    public ColaboradorDTO save(ColaboradorDTO dto) {
        if(dto == null) throw  new BusinessException(ErroMsgutil.ERRO_CLIENTE_NOT_FOUND);
        if(clientRepository.getClientByDocumento(dto.getDocumento())) throw  new BusinessException(ErroMsgutil.ERRO_CLIENTE_CADASTRADO);

        this.validarDocumento(dto.getDocumento());
        var produtoSave =  clientRepository.save(ColaboradorMapper.INSTANCE.toEntity(dto));
        return ColaboradorMapper.INSTANCE.toDTO(produtoSave);
    }

    @Override
    public ColaboradorDTO update(ColaboradorDTO dto) {
        if(!clientRepository.existsById(dto.getId())) throw new BusinessException(ErroMsgutil.ERRO_CLIENTE_NOT_FOUND);
        var clienteUpdated = clientRepository.save(ColaboradorMapper.INSTANCE.toEntity(dto));
        return ColaboradorMapper.INSTANCE.toDTO(clienteUpdated);
    }

    @Override
    public ColaboradorDTO findById(Long id) {
        if(id == null && !clientRepository.existsById(id)) throw new BusinessException(ErroMsgutil.ERRO_CLIENTE_NOT_FOUND);
        return ColaboradorMapper.INSTANCE.toDTO(clientRepository.getOne(id));
    }

    @Override
    public List<ColaboradorDTO> findall() {
        return ColaboradorMapper.INSTANCE.toDTOs(clientRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        if(!clientRepository.existsById(id)) throw new BusinessException(ErroMsgutil.ERRO_CLIENTE_NOT_FOUND);
        clientRepository.deleteById(id);
    }

    private void validarDocumento(String doc){
        if(!ColaboradorUtil.isCNPJ(doc)) throw new BusinessException(ErroMsgutil.ERRO_CNPJ_INVALIDO);
        if(!ColaboradorUtil.isCPF(doc))  throw new BusinessException(ErroMsgutil.ERRO_CPF_INVALIDO);
    }


}
