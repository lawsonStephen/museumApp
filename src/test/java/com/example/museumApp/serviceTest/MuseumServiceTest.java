package com.example.museumApp.serviceTest;

import com.example.museumApp.model.Artist;
import com.example.museumApp.model.Museum;
import com.example.museumApp.repository.ArtistRepository;
import com.example.museumApp.repository.MuseumRepository;
import com.example.museumApp.service.ArtistServiceImpl;
import com.example.museumApp.service.MuseumServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MuseumServiceTest {

    MuseumServiceImpl uut;
    MuseumRepository repository;
    Optional<Museum> museum = Optional.of(new Museum());
    Optional<Museum> actualMuseum = Optional.of(new Museum());
    Long museumId;

    @BeforeEach
    public void setUp(){
        repository = mock(MuseumRepository.class);
        uut = new MuseumServiceImpl(repository);
    }

    @Test
    public void isUutNotNull(){
        assertThat(uut != null);
    }

    @Test
    public void testFindByIdCallsRepositoryCorrectly() {
        museumId = 1L;
        when(repository.findById(museumId)).thenReturn(museum);
        actualMuseum = Optional.ofNullable(uut.findById(museumId));
        verify(repository, times(1)).findById(museumId);
    }

}
