package com.proyectoTest.demo.infrastructure;

import com.proyectoTest.demo.application.EpisodeService;
import com.proyectoTest.demo.domain.Episode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/{id}")
    public Episode getEpisode(@PathVariable int id) {
        return episodeService.getEpisodeById(id);
    }
}