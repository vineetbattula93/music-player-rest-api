package com.musicplayer.musicplayerrestapi.controllertests;

import TestUtils.TestSongs;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicplayer.musicplayerrestapi.controllers.SongController;
import com.musicplayer.musicplayerrestapi.models.Song;
import com.musicplayer.musicplayerrestapi.services.SongService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(SongController.class)
public class SongControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongService songService;

    @Autowired
    private ObjectMapper objectMapper;



    @Test
    public void postingSong_savesTheSong() throws Exception{

        Song song = TestSongs.getSongs().get(0);

        //act
        mockMvc.perform(MockMvcRequestBuilders.post("/song").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(song)))
                .andExpect(status().isOk());

        //assert
        verify(songService,times(1)).saveSong(any(Song.class));

    }
}