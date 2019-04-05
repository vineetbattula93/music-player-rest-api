package com.musicplayer.musicplayerrestapi.controllers;


import com.musicplayer.musicplayerrestapi.models.Song;
import com.musicplayer.musicplayerrestapi.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    private SongService songService;

    @Autowired
    public SongController(SongService songService) {

        this.songService = songService;

    }

    @PostMapping("/song")
    public String addSong(@RequestBody Song  song){

        songService.saveSong(song);

        return "saved";
    }

}
