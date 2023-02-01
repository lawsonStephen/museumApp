package com.example.museumApp.controllerTest;

import com.example.museumApp.controller.ArtistController;
import com.example.museumApp.model.Artist;
import com.example.museumApp.service.ArtistService;
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
public class ArtistControllerTest {

    @MockBean
    private ArtistService artistService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ArtistController uut;

    @Test
    public void isUutNotNull(){
        assertThat(uut != null);
    }

    @Test
    public void doesGetAllArtistsReturnCorrectly() throws Exception {
        ModelAndView mnV = new ModelAndView("artists");
        Artist artist = new Artist();
        List<Artist> artists = new ArrayList<>(Arrays.asList(artist));
        artists.add(artist);
        mnV.addObject("artists", artists);

        when(artistService.findAll()).thenReturn(artists);
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/artist"));
        verify(artistService, times(1)).findAll();
        assertThat(mnV.equals(uut.get()));
    }
}
