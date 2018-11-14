package playlist.player;

import playlist.data.Film;
import playlist.data.Song;

public class Player {
    public static void main(String[] args) {
        PlayerOptions playerOptions = new PlayerOptions();

        playerOptions.addDataToPlay(new Song("Op hej lalalej"));
        playerOptions.addDataToPlay(new Song("One Love"));
        playerOptions.addDataToPlay(new Song("Live"));
        playerOptions.play();

        playerOptions.setPlayType(PlayType.MIX_PLAY);
        playerOptions.addDataToPlay(new Film("Titanic"));
        playerOptions.play();
    }
}
