import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String artist;
    private String name;
    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //Functionalities of PlayList

    //Find song
    public boolean findSong(String title){
        for(Song song: songs){
            if(title.equals(song.getTitle())){
                return true;
            }
        }

        return false;
    }

    //Adding song to Album
    public String addSongToAlbum(String title, double duration){
        if(!findSong(title)){
            Song song = new Song(title, duration);
            this.songs.add(song);
            return "Song is added successfully";
        }
        return "Song already exists in album";
    }

    //Adding song to playlist from album
    public String addToPlaylistFromAlbum(String title, LinkedList<Song> playlist){
        for(Song song : songs){
            if(title.equals(song.getTitle())){
                playlist.add(song);
                return "Song is added successfully to your playlist.";
            }
        }
        return "Song doesn't exist in album.";
    }

    //Adding song to playlist using Song No
    public String addToPlaylistFromAlbum(int songNo, LinkedList<Song> playlist){
        int index = songNo - 1;
        if(index >=0 && index < songs.size()){
            playlist.add(songs.get(index));
            return "Song added successfully to playlist.";
        }

        return "Incorrect song number";
    }

}
