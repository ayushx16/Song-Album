import java.util.*;

public class main {
   private static ArrayList<Album>albums=new ArrayList<Album>();
    public static void main(String[] args) {

    Album album=new Album("Living Things","Linkin Park");
        album.addSong("Don't Stay",3.8);
        album.addSong("Somewhere I Belong",3.34);
        album.addSong("Lying From You",2.56);
        album.addSong("Hit the Floor",3.08);
        album.addSong("Faint",3.9);
        album.addSong("From The Inside",4.1);
        album.addSong("Session",2.43);
        album.addSong("Numb",3.06);
        album.addSong("Breaking The Habit",3.17);

        albums.add(album);
        album=new Album("Recovery","Eminem");
        album.addSong("NOT AFRAID",4.08);
        album.addSong("Space Bound",4.56);
        album.addSong("25 To Life",4.28);
        album.addSong("So Bad",3.09);
        album.addSong("Aimost Famous",4.08);
        album.addSong("Won't Back Down",3.08);
        album.addSong("Love The Way You Lie",5.08);
        album.addSong("No Love",5.02);
        album.addSong("Seduction",4.02);
        album.addSong("Cold Wind Blows",4.59);
        album.addSong("On Fire",3.9);
        album.addSong("Cinderella Man",4.4);

        albums.add(album);
        LinkedList<Song> playList=new LinkedList< Song>();
        albums.get(0).addToPlayList("Don't Stay ",playList);

        albums.get(0).addToPlayList(8,playList);
        albums.get(0).addToPlayList(2,playList);
        albums.get(0).addToPlayList(3,playList);
        albums.get(0).addToPlayList(4,playList);
        albums.get(0).addToPlayList(5,playList);
        albums.get(0).addToPlayList(6,playList);
        albums.get(0).addToPlayList(77,playList);

        albums.get(1).addToPlayList(1,playList);
        albums.get(1).addToPlayList(2,playList);
        albums.get(1).addToPlayList(3,playList);
        albums.get(1).addToPlayList(4,playList);

        play(playList);

    }
    private static void play(LinkedList<Song> playList){
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator=playList.listIterator();
        if(playList.size()==0){
            System.out.println("No song in playlist");
            return;
        }
        else{
            System.out.println("Now Playing "+listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action=sc.nextInt();
            sc.nextLine();
            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit=true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now Playing "+listIterator.next().toString());
                    }
                    else{
                        System.out.println("we have reached the end of playlist");
                        forward=false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("no playing "+listIterator.previous().toString());
                    }
                    else{
                        System.out.println("we are at the start of the playlist");
                        forward=true;
                    }
                    break;
                case 3:
                    if(forward){
                         if(listIterator.hasPrevious()){
                             System.out.println("now playing "+ listIterator.previous().toString());
                         forward=false;
                         }
                         else{
                             System.out.println("we are at the start of the list");
                         }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward=true;
                        }
                        else
                        {
                            System.out.println("We reached end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;

            }
        }
    }
    private static void printMenu(){
        System.out.println("Available options are :");
        System.out.println("0 to quit \n" +
                "1-to play next song\n" +
                "2 to play privious song\n" +
                "3 to replay the current song\n" +
                "4 list songs in the playlist\n" +
                "5- print available options\n");;
    }
    private static void printList(LinkedList<Song>playList){
        Iterator<Song> iterator=playList.iterator();
        System.out.println("=====================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("====================");

    }

}
