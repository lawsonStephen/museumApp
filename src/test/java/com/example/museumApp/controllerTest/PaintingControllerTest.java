package com.example.museumApp.controllerTest;

import com.example.museumApp.controller.PaintingController;
import com.example.museumApp.model.Painting;
import com.example.museumApp.service.PaintingService;
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
public class PaintingControllerTest {

    @MockBean
    private PaintingService paintingService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PaintingController uut;

    @Test
    public void doesUutExist(){
        assertThat(uut != null);
    }

    @Test
    public void doesGetAllPaintingsReturnCorrectly() throws Exception {
        ModelAndView mnV = new ModelAndView("paintings");
        Painting painting = new Painting();
        List<Painting> paintings = new ArrayList<>(Arrays.asList(painting));
        paintings.add(painting);
        mnV.addObject("paintings", paintings);

        when(paintingService.findAll()).thenReturn(paintings);
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/painting"));
        verify(paintingService, times(1)).findAll();
        assertThat(mnV.equals(uut.get()));
    }


}
