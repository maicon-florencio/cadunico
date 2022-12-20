package com.microsservice.cad.cadunico.service.impl;

import com.microsservice.cad.cadunico.exception.BusinessException;
import com.microsservice.cad.cadunico.mapper.ClientMapper;
import com.microsservice.cad.cadunico.repositorio.ClientRepository;
import com.microsservice.cad.cadunico.service.ClientService;
import com.microsservice.cad.cadunico.service.dto.ClientDTO;
import com.microsservice.cad.cadunico.util.ClientUtil;
import com.microsservice.cad.cadunico.util.ErroMsgutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository clientRepository;


    @Override
    public ClientDTO save(ClientDTO dto) {
        if(dto == null) throw  new BusinessException(ErroMsgutil.ERRO_CLIENTE_NOT_FOUND);
        if(clientRepository.getClientByDocumento(dto.getDocumento())) throw  new BusinessException(ErroMsgutil.ERRO_CLIENTE_CADASTRADO);

        this.validarDocumento(dto.getDocumento());
        var produtoSave =  clientRepository.save(ClientMapper.INSTANCE.toEntity(dto));
        return ClientMapper.INSTANCE.toDTO(produtoSave);
    }

    @Override
    public ClientDTO update(ClientDTO dto) {
        if(!clientRepository.existsById(dto.getId())) throw new BusinessException(ErroMsgutil.ERRO_CLIENTE_NOT_FOUND);
        var clienteUpdated = clientRepository.save(ClientMapper.INSTANCE.toEntity(dto));
        return ClientMapper.INSTANCE.toDTO(clienteUpdated);
    }

    @Override
    public ClientDTO findById(Long id) {
        if(id == null && !clientRepository.existsById(id)) throw new BusinessException(ErroMsgutil.ERRO_CLIENTE_NOT_FOUND);
        return ClientMapper.INSTANCE.toDTO(clientRepository.getOne(id));
    }

    @Override
    public List<ClientDTO> findall() {
        return ClientMapper.INSTANCE.toDTOs(clientRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        if(!clientRepository.existsById(id)) throw new BusinessException(ErroMsgutil.ERRO_CLIENTE_NOT_FOUND);
        clientRepository.deleteById(id);
    }

    private void validarDocumento(String doc){
        if(!ClientUtil.isCNPJ(doc)) throw new BusinessException(ErroMsgutil.ERRO_CNPJ_INVALIDO);
        if(!ClientUtil.isCPF(doc))  throw new BusinessException(ErroMsgutil.ERRO_CPF_INVALIDO);
    }


}
