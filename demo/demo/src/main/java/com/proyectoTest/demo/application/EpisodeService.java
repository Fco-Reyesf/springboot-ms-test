package com.proyectoTest.demo.application;

import com.proyectoTest.demo.domain.Episode;
import com.proyectoTest.demo.infrastructure.EpisodeApiClient;
import org.springframework.stereotype.Service;

@Service
public class EpisodeService {

    private final EpisodeApiClient episodeApiClient;

    public EpisodeService(EpisodeApiClient episodeApiClient) {
        this.episodeApiClient = episodeApiClient;
    }

    public Episode getEpisodeById(int id) {
        return episodeApiClient.getEpisodeById(id);
    }
}