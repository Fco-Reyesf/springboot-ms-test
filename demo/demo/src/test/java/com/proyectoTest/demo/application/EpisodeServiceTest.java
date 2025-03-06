package com.proyectoTest.demo.application;

import com.proyectoTest.demo.domain.Episode;
import com.proyectoTest.demo.infrastructure.EpisodeApiClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EpisodeServiceTest {

    @Mock
    private EpisodeApiClient episodeApiClient;

    @InjectMocks
    private EpisodeService episodeService;

    @Test
    public void testGetEpisodeById() {
        // Configura el mock
        Episode expectedEpisode = new Episode();
        expectedEpisode.setId(28);
        expectedEpisode.setName("The Ricklantis Mixup");
        expectedEpisode.setAir_date("September 10, 2017");
        expectedEpisode.setEpisode("S03E07");
        expectedEpisode.setCharacters(new ArrayList<>());
        expectedEpisode.setUrl("https://rickandmortyapi.com/api/episode/28");
        expectedEpisode.setCreated(ZonedDateTime.parse("2021-09-10T12:00:00Z"));

        when(episodeApiClient.getEpisodeById(28)).thenReturn(expectedEpisode);

        // Ejecuta el método bajo prueba
        Episode actualEpisode = episodeService.getEpisodeById(28);

        // Verifica el resultado
        assertEquals(expectedEpisode, actualEpisode);
    }
}