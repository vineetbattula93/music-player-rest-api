package TestUtils;

import com.musicplayer.musicplayerrestapi.models.Playlist;

public class TestPlaylist{

    private static Playlist playlist;

    public static Playlist getTestPlaylist(){
        playlist = new Playlist();
        playlist.setName("JMoney's Top 20");
        TestSongs.getSongs().forEach((song) -> playlist.addSong(song));
        return playlist;
    }

}
