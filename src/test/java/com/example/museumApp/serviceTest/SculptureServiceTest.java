package com.example.museumApp.serviceTest;

import com.example.museumApp.model.Artist;
import com.example.museumApp.model.Sculpture;
import com.example.museumApp.repository.ArtistRepository;
import com.example.museumApp.repository.SculptureRepository;
import com.example.museumApp.service.ArtistServiceImpl;
import com.example.museumApp.service.SculptureServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SculptureServiceTest {

    SculptureServiceImpl uut;
    SculptureRepository repository;
    Optional<Sculpture> sculpture = Optional.of(new Sculpture());
    Optional<Sculpture> actualSculpture = Optional.of(new Sculpture());
    Long sculptureId;


    @BeforeEach
    public void setUp(){
        repository = mock(SculptureRepository.class);
        uut = new SculptureServiceImpl(repository);
    }

    @Test
    public void isUutNotNull(){
        assertThat(uut != null);
    }

    @Test
    public void testFindByIdCallsRepositoryCorrectly() {
        sculptureId = 1L;
        when(repository.findById(sculptureId)).thenReturn(sculpture);
        actualSculpture = Optional.ofNullable(uut.findById(sculptureId));
        verify(repository, times(1)).findById(sculptureId);
    }

}
