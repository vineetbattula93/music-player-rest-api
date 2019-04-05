package com.musicplayer.musicplayerrestapi.IntegrationTests;


import TestUtils.TestSongs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static TestUtils.TestSongs.getSongs;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SongIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void postingSong_savesTheSong(){
        //act
        ResponseEntity<String> response = testRestTemplate.postForEntity(
                "/song", getSongs().get(1),String.class
        );

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("saved");
    }

}
