
package encapsulation_access_control.assigment_problems;

import java.util.Arrays;

public class Playlist {

    private final String[] songs;
    private int songCount;

    Playlist(int maximumSongs) {
        if (maximumSongs < 0) {
            maximumSongs = 0;
        }

        songs = new String[maximumSongs];
        songCount = 0;
    }

    void addSong(String title) {
        if (title == null || title.isEmpty()) {
            System.out.println("Song rejected: invalid title");
            return;
        }

        if (songCount >= songs.length) {
            System.out.println("Song rejected: playlist is full");
            return;
        }

        songs[songCount] = title;
        songCount++;
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Song count: " + p.getSongCount());
    }
}
