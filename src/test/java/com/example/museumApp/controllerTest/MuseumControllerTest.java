package com.example.museumApp.controllerTest;

import com.example.museumApp.controller.MuseumController;
import com.example.museumApp.model.Museum;
import com.example.museumApp.service.MuseumService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class MuseumControllerTest {

    @MockBean
    private MuseumService museumService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MuseumController uut;

    @Test
    public void doesUutExist(){
        assertThat(uut != null);
    }

    @Test
    public void doesGetAllArtistsReturnCorrectly() throws Exception {
        ModelAndView mnV = new ModelAndView("museums");
        Museum museum = new Museum();
        List<Museum> museums = new ArrayList<>(Arrays.asList(museum));
        museums.add(museum);
        mnV.addObject("museums", museums);

        when(museumService.findAll()).thenReturn(museums);
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/museum"));
        verify(museumService, times(3)).findAll();
        assertThat(mnV.equals(uut.get()));
    }
}
