package playlist.data;

import playlist.data.Data;

public class Song implements Data {
    private String songName;

    public Song(String songName) {
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Override
    public String toString() {
        return "Song = '" + songName + '\'';
    }
}
