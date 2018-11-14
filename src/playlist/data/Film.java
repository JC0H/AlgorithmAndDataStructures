package playlist.data;

import playlist.data.Data;

public class Film implements Data {

    private String filmName;

    public Film(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    @Override
    public String toString() {
        return "Film = '" + filmName + '\'';
    }
}
