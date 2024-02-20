package com.microsservice.cad.cadunico.service;

import com.microsservice.cad.cadunico.builder.ColaboradorBuilder;
import com.microsservice.cad.cadunico.dominio.Colaborador;
import com.microsservice.cad.cadunico.exception.BusinessException;
import com.microsservice.cad.cadunico.repository.CargoRepository;
import com.microsservice.cad.cadunico.repository.ColaboradorRepository;
import com.microsservice.cad.cadunico.service.dto.ColaboradorDTO;
import com.microsservice.cad.cadunico.service.impl.ColaboradorService;
import com.microsservice.cad.cadunico.util.ErroMsgutil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ColabordorServiceTest {
    @Autowired
    private ColaboradorService service;
    @MockBean
    private ColaboradorRepository repository;
    @MockBean
    private CargoRepository cargoRepository;


    @Test
    void salvaColaborador_okay(){
        ColaboradorDTO dtoToSave = ColaboradorBuilder.retornaColaboradorDTOCPF();
        dtoToSave.setId(null);
        Colaborador entityReturn = ColaboradorBuilder.retornaClientCPF();

        Mockito.when(repository.getClientByDocumento(Mockito.anyString())).thenReturn(false);
        Mockito.when(repository.save(Mockito.any())).thenReturn(entityReturn);
        var result = service.save(dtoToSave);

        Assertions.assertNotNull(result);
        Assertions.assertInstanceOf(ColaboradorDTO.class,result);

        Mockito.verify(repository,Mockito.times(1)).save(Mockito.any());

    }

    @Test
    void salvaColaborador_erroNotFound(){
        try{
            service.save(null);
        }catch(BusinessException b){
            return;
        }
        Assertions.fail(new BusinessException(ErroMsgutil.ERRO_COLABORADOR_NOT_FOUND));
        Mockito.verify(repository,Mockito.never()).save(Mockito.any());

    }

    @Test
    void salvaColaborador_erroColaboradorFound(){

        ColaboradorDTO dtoToSave = ColaboradorBuilder.retornaColaboradorDTOCPF();
        Mockito.when(repository.getClientByDocumento(Mockito.anyString())).thenReturn(true);
        try{
            service.save(dtoToSave);
        }catch(BusinessException b){
            return;
        }
        Assertions.fail(new BusinessException(ErroMsgutil.ERRO_COLABORADOR_CADASTRADO));
        Mockito.verify(repository,Mockito.times(1)).getClientByDocumento(Mockito.anyString());
        Mockito.verify(repository,Mockito.never()).save(Mockito.any());

    }

    @Test
    void salvaColaborador_erroNotFoundCPF(){
        ColaboradorDTO dto = ColaboradorBuilder.retornaColaboradorDTOCPF();
        dto.setDocumento("123456789");
        try{
            service.save(dto);
        }catch(BusinessException b){
            return;
        }
        Assertions.fail(new BusinessException(ErroMsgutil.ERRO_CPF_INVALIDO));
        Mockito.verify(repository,Mockito.never()).save(Mockito.any());

    }
    @Test
    void salvaColaborador_erroNotFoundCNPJ(){
        ColaboradorDTO dto = ColaboradorBuilder.retornaColaboradorDTOCPF();
        dto.setDocumento("1111111111111");
        try{
            service.save(dto);
        }catch(BusinessException b){
            return;
        }
        Assertions.fail(new BusinessException(ErroMsgutil.ERRO_CNPJ_INVALIDO));
        Mockito.verify(repository,Mockito.never()).save(Mockito.any());

    }

    @Test
    void findById_okay(){
        Long idBusca =1L;
        var entity =  ColaboradorBuilder.retornaClientCPF();

        Mockito.when(repository.existsById(1L)).thenReturn(Boolean.TRUE);
        Mockito.when(repository.getReferenceById(Mockito.anyLong())).thenReturn(entity);

        var result = service.findById(idBusca);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(entity.getNome(),result.getNome());

      }


    @Test
    void findById_ErroNotFound(){
        Long idBusca =1L;
        Mockito.when(repository.existsById(1L)).thenReturn(Boolean.FALSE);
        try {
            service.findById(idBusca);
        }catch(BusinessException b){
            return;
        }

        Assertions.fail(new BusinessException(ErroMsgutil.ERRO_COLABORADOR_NOT_FOUND));

    }
    @Test
    void growUpAmountSalary_okay(){
        var entity = ColaboradorBuilder.retornaClientCPF();
        Mockito.when(repository.getColaboradorByDocumento(Mockito.anyString())).thenReturn(entity);
        var result = service.growUpAmountSalary(entity.getDocumento());

        Assertions.assertNotNull(result);
    }
}
