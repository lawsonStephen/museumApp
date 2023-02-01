package com.example.museumApp.serviceTest;

import com.example.museumApp.model.Artist;
import com.example.museumApp.repository.ArtistRepository;
import com.example.museumApp.service.ArtistServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ArtistServiceTest {

    ArtistServiceImpl uut;
    ArtistRepository repository;
    Optional<Artist> artist = Optional.of(new Artist());
    Optional<Artist> actualArtist = Optional.of(new Artist());
    Long artistId;


    @BeforeEach
    public void setUp(){
        repository = mock(ArtistRepository.class);
        uut = new ArtistServiceImpl(repository);
    }

    @Test
    public void isUutNotNull(){
        assertThat(uut != null);
    }

    @Test
    public void testFindByIdCallsRepositoryCorrectly() {
        artistId = 1L;
        when(repository.findById(artistId)).thenReturn(artist);
        actualArtist = Optional.ofNullable(uut.findById(artistId));
        verify(repository, times(1)).findById(artistId);
    }

}
