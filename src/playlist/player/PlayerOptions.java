package playlist.player;

import playlist.data.Data;
import playlist.data.Film;
import playlist.data.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerOptions {

    private List<Data> playList = new ArrayList<>();
    private PlayType playType = PlayType.MERELY_PLAY;

    public void addDataToPlay(Song song) {
        playList.add(song);
    }

    public void addDataToPlay(Film film) {
        playList.add(film);
    }

    public void play() {
        switch (playType) {
            case MIX_PLAY:
                int length = playList.size();

                while(length!=0){
                    int idx = new Random().nextInt(length);
                    System.out.println("Now playing : " + playList.get(idx));
                    length--;
                }
                break;

            case MERELY_PLAY:
                for (int i = 0; i < playList.size();i++){
                    System.out.println("Now playing : " + playList.get(i));
                }
                break;
        }
        System.out.println("\n");
    }

    public void setPlayType(PlayType merelyPlay) {
        this.playType = merelyPlay;
    }
}
