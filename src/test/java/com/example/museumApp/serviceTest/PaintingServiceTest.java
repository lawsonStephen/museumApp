package com.example.museumApp.serviceTest;

import com.example.museumApp.model.Museum;
import com.example.museumApp.model.Painting;
import com.example.museumApp.repository.MuseumRepository;
import com.example.museumApp.repository.PaintingRepository;
import com.example.museumApp.service.MuseumServiceImpl;
import com.example.museumApp.service.PaintingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class PaintingServiceTest {

    PaintingServiceImpl uut;
    PaintingRepository repository;
    Optional<Painting> painting = Optional.of(new Painting());
    Optional<Painting> actualPainting = Optional.of(new Painting());
    Long paintingId;

    @BeforeEach
    public void setUp(){
        repository = mock(PaintingRepository.class);
        uut = new PaintingServiceImpl(repository);
    }

    @Test
    public void isUutNotNull(){
        assertThat(uut != null);
    }

    @Test
    public void testFindByIdCallsRepositoryCorrectly() {
        paintingId = 1L;
        when(repository.findById(paintingId)).thenReturn(painting);
        actualPainting = Optional.ofNullable(uut.findById(paintingId));
        verify(repository, times(1)).findById(paintingId);
    }
}
