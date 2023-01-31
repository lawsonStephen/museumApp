package com.example.museumApp.controllerTest;

import com.example.museumApp.controller.PaintingController;
import com.example.museumApp.controller.SculptureController;
import com.example.museumApp.model.Painting;
import com.example.museumApp.model.Sculpture;
import com.example.museumApp.service.SculptureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@WebMvcTest(SculptureController.class)
@AutoConfigureMockMvc(addFilters = false)
public class SculptureControllerTest {

    @MockBean
    private SculptureService sculptureService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SculptureController uut;

    @Test
    public void doesUutExist(){
        assertThat(uut != null);
    }

    @Test
    public void doesGetAllSculpturesReturnCorrectly() throws Exception {
        ModelAndView mnV = new ModelAndView("sculptures");
        Sculpture sculpture = new Sculpture();
        List<Sculpture> sculptures = new ArrayList<>(Arrays.asList(sculpture));
        sculptures.add(sculpture);
        mnV.addObject("sculptures", sculptures);

        when(sculptureService.findAll()).thenReturn(sculptures);
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/sculpture"));
        verify(sculptureService, times(1)).findAll();
        assertThat(mnV.equals(uut.get()));
    }

}
