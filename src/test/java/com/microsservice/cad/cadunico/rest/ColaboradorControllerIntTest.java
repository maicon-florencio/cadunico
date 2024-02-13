package com.microsservice.cad.cadunico.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsservice.cad.cadunico.builder.ColaboradorBuilder;
import com.microsservice.cad.cadunico.exception.BusinessException;
import com.microsservice.cad.cadunico.service.impl.ColaboradorService;
import com.microsservice.cad.cadunico.util.ErroMsgutil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ColaboradorControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ColaboradorService clientService;

    @Autowired
    private ColaboradorBuilder clientBuilder;


    private static String API = "/api/v1/clients";

    @Test
    public void createClient() throws Exception {

        var dto = clientBuilder.retornaClientDTOCPF();

        Mockito.when(clientService.save(Mockito.any())).thenReturn(dto);

        var request = MockMvcRequestBuilders.post(API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(dto) )
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("nome").value(dto.getNome()))
                .andExpect(jsonPath("documento").value(dto.getDocumento()));


        Assertions.assertEquals(dto.getNome(),"Juarez Rodrigues");
        Assertions.assertEquals(dto.getDocumento(),"257.049.330-92");


    }

    @Test
    public void createClientCPFinvalido() throws Exception {

        var dto = clientBuilder.retornaClientDTOCPF();

        dto.setDocumento("1111111111");

        Mockito.when(clientService.save(dto)).thenThrow(new BusinessException(ErroMsgutil.ERRO_CPF_INVALIDO));

        var request = MockMvcRequestBuilders.post(API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(dto) )
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isBadRequest());


     }

    @Test
    public void updateClient() throws Exception {

        var dtoUpdated = clientBuilder.retornaClientDTOCPF();
        dtoUpdated.setId(1L);
        dtoUpdated.setNome("MAriazinha");

        Mockito.when(clientService.update(Mockito.any())).thenReturn(dtoUpdated);

        var request = MockMvcRequestBuilders.put(API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(dtoUpdated) )
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("nome").value(dtoUpdated.getNome()))
                .andExpect(jsonPath("documento").value(dtoUpdated.getDocumento()));



        Assertions.assertEquals(dtoUpdated.getDocumento(),"257.049.330-92");
        Assertions.assertEquals(dtoUpdated.getNome(),"MAriazinha");


    }



    @Test
    public void buscarClientPorId() throws Exception {
        var dto = clientBuilder.retornaClientDTOCPF();

        dto.setId(1L);
        Mockito.when(clientService.findById(Mockito.anyLong())).thenReturn(dto);

        var request = MockMvcRequestBuilders.get(API.concat("/" +1)).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("nome").value(dto.getNome()))
                .andExpect(jsonPath("documento").value(dto.getDocumento()))
                .andExpect(jsonPath("status").value(dto.getStatus()));

    }


    @Test
    public void deletarById() throws Exception {


        var request = MockMvcRequestBuilders.delete(API.concat("/" +1)).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void buscarTodosClient() throws Exception {
        var dto = clientBuilder.retornaClientsDTO();

        Mockito.when(clientService.findall()).thenReturn(dto);

        var request = MockMvcRequestBuilders.get(API).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());

        Assertions.assertNotNull(dto);

    }


}
