package com.proyectoTest.demo.domain;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Episode {
    private int id;
    private String name;

    @JsonProperty("air_date")
    private String air_date;

    private String episode;
    public ArrayList<String> characters;
    public String url;
    public ZonedDateTime created;
}