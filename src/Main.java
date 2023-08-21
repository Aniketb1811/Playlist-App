import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album arjitAlbum = new Album("Arjit Singh", "Arjit's Album");
        Album walkerAlbum = new Album("Alan Walker", "Alan's Album");

        arjitAlbum.addSongToAlbum("Kesaria", 4.2);
        arjitAlbum.addSongToAlbum("Tum kya mile", 2.5);
        arjitAlbum.addSongToAlbum("Kesaria", 3.6);
        arjitAlbum.addSongToAlbum("Lal ishq", 3.0);

        walkerAlbum.addSongToAlbum("Faded", 3.5);
        walkerAlbum.addSongToAlbum("Alone", 2.5);
        walkerAlbum.addSongToAlbum("Darkside", 3.3);
        walkerAlbum.addSongToAlbum("On my way", 5.0);

        LinkedList<Song> myplaylist = new LinkedList<>();

        System.out.println(arjitAlbum.addToPlaylistFromAlbum("Tum kya mile", myplaylist));
        System.out.println((arjitAlbum.addToPlaylistFromAlbum("Kesaria", myplaylist)));
        System.out.println(walkerAlbum.addToPlaylistFromAlbum(5, myplaylist)); //wrong song number
        System.out.println(walkerAlbum.addToPlaylistFromAlbum(2, myplaylist));
        System.out.println(arjitAlbum.addToPlaylistFromAlbum(2, myplaylist));

        play(myplaylist);
    }

    private static void play(LinkedList<Song> myplaylist) {
        if(myplaylist.size() == 0){
            System.out.println("Playlist is empty!");
            return;
        }

        Scanner sc = new Scanner(System.in);

        ListIterator<Song> itr = myplaylist.listIterator();
        System.out.println("Now playing : " + itr.hasNext());
        boolean wasNext = true;

        printMenu();
        boolean quit = false;

        while (!quit){
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(wasNext==false){
                        itr.next();
                        wasNext = true;
                    }
                    if(!itr.hasNext()){
                        System.out.println("You have reached the end of the playlist");
                    }
                    else{
                        System.out.println("Currently playing: "+itr.next());
                        wasNext = true;
                    }
                    break;
                case 3:
                    if(wasNext==true){
                        itr.previous();
                        wasNext = false;
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You are the start of the playlist.");
                    }
                    else{
                        System.out.println("Currently playing: "+itr.previous());
                        wasNext = false;
                    }
                    break;
                case 4:
                    if(wasNext==true){
                        System.out.println("Currently playing: "+itr.previous());
                        wasNext = false;
                    }
                    else{
                        System.out.println("Currently playing: "+itr.next());
                        wasNext = true;
                    }
                    break;
                case 5:
                    break;
                case 6:
                    printList(myplaylist);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    private static void printList(LinkedList<Song> myplaylist) {
        for(Song song: myplaylist){
            System.out.println(song);
        }

        return;
    }

    private static void printMenu() {
        System.out.println("1. Show menu");
        System.out.println("2. Play next song");
        System.out.println("3. Play previous song");
        System.out.println("4. Play current song");
        System.out.println("5. Delete current song from the playlist");
        System.out.println("6. Show all songs");
        System.out.println("7. Quit app");

    }
}