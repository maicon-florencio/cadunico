package com.microsservice.cad.cadunico.rest;

import com.microsservice.cad.cadunico.builder.ClientBuilder;
import com.microsservice.cad.cadunico.service.ClientService;
import com.microsservice.cad.cadunico.service.dto.ClientDTO;
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
public class ClientResourceIntTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Autowired
    private ClientBuilder clientBuilder;


    private static String API = "/api/v1/clients";

    @Test
    public void createClient() throws Exception {

        var dto = clientBuilder.retornaClientDTOCPF();

        Mockito.when(clientService.save(Mockito.any())).thenReturn(dto);

        var request = MockMvcRequestBuilders.post(API).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("nome").value(dto.getNome()))
                .andExpect(jsonPath("documento").value(dto.getDocumento()))
                .andExpect(jsonPath("status").value(dto.getStatus()));


        Assertions.assertEquals(dto.getNome(),"Juarez Rodrigues");
        Assertions.assertEquals(dto.getDocumento(),"257.049.330-92");


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


}
