package com.proyectoTest.demo.infrastructure;

import com.proyectoTest.demo.domain.Episode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EpisodeApiClient {

    private static final String API_URL = "https://rickandmortyapi.com/api/episode/";

    private final RestTemplate restTemplate;

    public EpisodeApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Episode getEpisodeById(int id) {
        String url = API_URL + id;
        return restTemplate.getForObject(url, Episode.class);
    }
}