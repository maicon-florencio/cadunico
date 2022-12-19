package com.microsservice.cad.cadunico.service.impl;

import com.microsservice.cad.cadunico.exception.BusinessException;
import com.microsservice.cad.cadunico.service.ClientService;
import com.microsservice.cad.cadunico.service.dto.ClientDTO;
import com.microsservice.cad.cadunico.util.ClientUtil;
import com.microsservice.cad.cadunico.util.ErroMsgutil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public ClientDTO save(ClientDTO dto) {
        if(dto == null) throw  new BusinessException(ErroMsgutil.ERRO_CLIENTE_NOT_FOUND);

        if(!ClientUtil.isCNPJ(dto.getDocumento())) throw  new BusinessException(ErroMsgutil.ERRO_CNPJ_INVALIDO);

        if(!ClientUtil.isCPF(dto.getDocumento()))  throw new BusinessException(ErroMsgutil.ERRO_CPF_INVALIDO);


        return null;
    }

    @Override
    public ClientDTO update(ClientDTO dto) {
        return null;
    }

    @Override
    public ClientDTO findById(Long id) {
        return null;
    }

    @Override
    public List<ClientDTO> findall() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
