// Your job is to implement these concepts: checked and unchecked exception and try-catch.
// You **must** use the Exception and Error class.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DeadFromStress extends Exception{}
class EmptyTrackList extends Exception{}

/*
Let me set the scene. You're on a one-on-one date with Blackpink Jisoo. You are sweating beads
because Blackpink Jisoo just asked you about your music taste. You hype yourself up and say that you
have the best music taste. She asks you your favorite song on the spot.
 */

// TODO: Implement SpotifyPlaylist
class SpotifyPlaylist {

    private ArrayList<String> tracklist;
    static Random rand;

    SpotifyPlaylist(String[] songs){
        tracklist = new ArrayList<String>(List.of(songs));
        rand = new Random();
    }

    // ==== TUTORIAL ====
    // Sweating, you excuse yourself for a second and pull out your phone to text your friend.
    // You attempt to ask your friend for a recommendation to play.
    // If your friend doesn't give you a proper response (an exception), then just default
    // to everyone's favorite song -- Montero by Lil Nas X. You kind of hope they don't respond
    // because wouldn't it be strange to play a Blackpink song to Blackpink Jisoo herself???
    String askFriend(){
        try{
            return friendRecommendation();
        } catch (DeadFromStress d) {
            return "Montero";
        }
    }

    // Your friend is a hardcore K-Pop stan and more specifically a Blackpink stan.
    // They will always recommend a Blackpink song unless they are dead from stress.
    // The chances of them *that* dead is 25%. It's no longer syllabus week give them a break.
    String friendRecommendation() throws DeadFromStress{
        int choice = rand.nextInt(4);
        if (choice == 3){
            throw new DeadFromStress();
        } else if (choice == 2){
            return "How you like that";
        } else if (choice == 1){
            return "Kill this love";
        } else {
            return "Pink Venom";
        }
    }

    // === END TUTORIAL ===
    // Jisoo is embarassed by the song your friend recommended (not that she knows).
    // Jisoo doesn't like Lil Nas X (so not slay). She ended up not being part of the everyone that
    // loves Lil Nas X! Who knew?!
    // Now she wants you to play your best playlist.
    // Following the method structure above, complete the following methods.

    // TODO: Create a method that throws a EmptyTracklist Exception if the tracklist is empty
    // This method should return the first song in the tracklist if it exists.
    // Hint: You will need to edit the method signature.
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    void addSong(String song) throws TracklistF
    {
        if(this.index > tracklist.length)
        {
            throw TracklistF ;
        }
        else
        {
            tracklist[index] = song ;
            index++ ;
        }
    }

    // TODO: Create a method that catches TracklistF when addSong is called and throws an Error with a custom message
    // Hint: Use try-catch
    void addSongIfPossible(String song)
    {
        try
        {
            addSong(song) ;
        }
        catch TracklistF
        {
            System.out.println("There is not enough room in the playlist") ;
        }
    }

    // TODO: Create a method that throws a TracklistE Exception if the tracklist is empty
    // Hint: You will need to edit the method signature.
    String removeSong(String song) throws TracklistE Exception
    {
        if(index == 0)
        {
            throw TracklistE Exception ;
        }
        else
        {
            tracklist[index] = null ; 
        }
=======
    String playPlaylist(){
>>>>>>> 0aab51acd633adc0601d9d1d180e29317ece7b36
        return null;
=======
=======
>>>>>>> 1c76b44 (commitlab2)
=======
>>>>>>> 17b6630 (commit)
=======
>>>>>>> a94a887 (done with lab 3)
=======
>>>>>>> c7e252d (lab2)
=======
>>>>>>> 65ebb18 (lab2 genuinely finalized)
=======
>>>>>>> 803aa1c (finished lab 2)
=======
>>>>>>> 14b7d5d (commitlab2)
=======
>>>>>>> 8fe3e60 (commit)
=======
>>>>>>> 069d06e (done with lab 3)
    String playPlaylist() throws EmptyTrackList {
        if (tracklist.size() < 1) {
            throw new EmptyTrackList();
        } else {
            return tracklist.get(0);
        }
<<<<<<< HEAD
>>>>>>> 98775a5 (finished lab 2)
=======
=======
=======
>>>>>>> f9e8a87 (done with lab 3)
=======
>>>>>>> d409503 (lab2)
=======
>>>>>>> 21e75b0 (finished lab 2)
=======
>>>>>>> dbb89c2 (commitlab2)
=======
>>>>>>> e8eb76c (commit)
=======
>>>>>>> fc0de73 (done with lab 3)
    void addSong(String song) throws TracklistF
    {
        if(this.index > tracklist.length)
        {
            throw TracklistF ;
        }
        else
        {
            tracklist[index] = song ;
            index++ ;
        }
    }

    // TODO: Create a method that catches TracklistF when addSong is called and throws an Error with a custom message
    // Hint: Use try-catch
    void addSongIfPossible(String song)
    {
        try
        {
            addSong(song) ;
        }
        catch TracklistF
        {
            System.out.println("There is not enough room in the playlist") ;
        }
    }

    // TODO: Create a method that throws a TracklistE Exception if the tracklist is empty
    // Hint: You will need to edit the method signature.
    String removeSong(String song) throws TracklistE Exception
    {
        if(index == 0)
        {
            throw TracklistE Exception ;
        }
        else
        {
            tracklist[index] = null ; 
        }
<<<<<<< HEAD
=======
    String playPlaylist(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
=======
>>>>>>> d409503 (lab2)
=======
    String playPlaylist(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
        return null;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> d409503 (lab2)
<<<<<<< HEAD
>>>>>>> 1c76b44 (commitlab2)
=======
=======
=======
>>>>>>> 21e75b0 (finished lab 2)
=======
=======
>>>>>>> 1c76b44 (commitlab2)
=======
>>>>>>> 17b6630 (commit)
=======
>>>>>>> a94a887 (done with lab 3)
    String playPlaylist() throws EmptyTrackList {
        if (tracklist.size() < 1) {
            throw new EmptyTrackList();
        } else {
            return tracklist.get(0);
        }
<<<<<<< HEAD
>>>>>>> 98775a5 (finished lab 2)
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> f9e8a87 (done with lab 3)
<<<<<<< HEAD
>>>>>>> a94a887 (done with lab 3)
=======
=======
>>>>>>> 21e75b0 (finished lab 2)
<<<<<<< HEAD
>>>>>>> 803aa1c (finished lab 2)
=======
=======
=======
=======
=======
>>>>>>> f9e8a87 (done with lab 3)
    void addSong(String song) throws TracklistF
    {
        if(this.index > tracklist.length)
        {
            throw TracklistF ;
        }
        else
        {
            tracklist[index] = song ;
            index++ ;
        }
    }

    // TODO: Create a method that catches TracklistF when addSong is called and throws an Error with a custom message
    // Hint: Use try-catch
    void addSongIfPossible(String song)
    {
        try
        {
            addSong(song) ;
        }
        catch TracklistF
        {
            System.out.println("There is not enough room in the playlist") ;
        }
    }

    // TODO: Create a method that throws a TracklistE Exception if the tracklist is empty
    // Hint: You will need to edit the method signature.
    String removeSong(String song) throws TracklistE Exception
    {
        if(index == 0)
        {
            throw TracklistE Exception ;
        }
        else
        {
            tracklist[index] = null ; 
        }
=======
    String playPlaylist(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
        return null;
<<<<<<< HEAD
>>>>>>> d409503 (lab2)
<<<<<<< HEAD
>>>>>>> 1c76b44 (commitlab2)
<<<<<<< HEAD
>>>>>>> dbb89c2 (commitlab2)
<<<<<<< HEAD
>>>>>>> 14b7d5d (commitlab2)
=======
=======
=======
=======
=======
    String playPlaylist() throws EmptyTrackList {
        if (tracklist.size() < 1) {
            throw new EmptyTrackList();
        } else {
            return tracklist.get(0);
        }
>>>>>>> 98775a5 (finished lab 2)
>>>>>>> f9e8a87 (done with lab 3)
>>>>>>> a94a887 (done with lab 3)
>>>>>>> fc0de73 (done with lab 3)
>>>>>>> 069d06e (done with lab 3)
    }

    // TODO: Create a method that catches EmptyTracklist when playPlaylist is called and throws an Error with a custom message
    // Hint: Use try-catch
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    void removeSongIfPossible(String song)
    {

=======
    void playPlaylistIfPossible(){
>>>>>>> 0aab51acd633adc0601d9d1d180e29317ece7b36
=======
=======
>>>>>>> 1c76b44 (commitlab2)
=======
>>>>>>> 17b6630 (commit)
=======
>>>>>>> a94a887 (done with lab 3)
=======
>>>>>>> c7e252d (lab2)
=======
>>>>>>> 65ebb18 (lab2 genuinely finalized)
=======
>>>>>>> 803aa1c (finished lab 2)
=======
>>>>>>> 14b7d5d (commitlab2)
=======
>>>>>>> 8fe3e60 (commit)
=======
>>>>>>> 069d06e (done with lab 3)
    void playPlaylistIfPossible() {
        try {
            playPlaylist();
        } catch (EmptyTrackList e) {
            throw new Error("Playlist is empty");
        }
<<<<<<< HEAD
>>>>>>> 98775a5 (finished lab 2)
=======
=======
=======
>>>>>>> f9e8a87 (done with lab 3)
=======
>>>>>>> 21e75b0 (finished lab 2)
=======
>>>>>>> dbb89c2 (commitlab2)
=======
>>>>>>> e8eb76c (commit)
=======
>>>>>>> fc0de73 (done with lab 3)
    void removeSongIfPossible(String song)
    {

>>>>>>> d409503 (lab2)
<<<<<<< HEAD
>>>>>>> 1c76b44 (commitlab2)
=======
=======
    void playPlaylistIfPossible(){
<<<<<<< HEAD
>>>>>>> 72b3586 (lab2 genuinely finalized)
<<<<<<< HEAD
>>>>>>> 17b6630 (commit)
=======
=======
>>>>>>> 0aab51acd633adc0601d9d1d180e29317ece7b36
=======
=======
>>>>>>> 1c76b44 (commitlab2)
=======
>>>>>>> 17b6630 (commit)
=======
>>>>>>> a94a887 (done with lab 3)
    void playPlaylistIfPossible() {
        try {
            playPlaylist();
        } catch (EmptyTrackList e) {
            throw new Error("Playlist is empty");
        }
<<<<<<< HEAD
>>>>>>> 98775a5 (finished lab 2)
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> f9e8a87 (done with lab 3)
<<<<<<< HEAD
>>>>>>> a94a887 (done with lab 3)
=======
=======
=======
>>>>>>> dbb89c2 (commitlab2)
=======
=======
>>>>>>> f9e8a87 (done with lab 3)
    void removeSongIfPossible(String song)
    {

>>>>>>> d409503 (lab2)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> c7e252d (lab2)
=======
=======
>>>>>>> 14b7d5d (commitlab2)
=======
>>>>>>> 8fe3e60 (commit)
=======
    void playPlaylistIfPossible(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
<<<<<<< HEAD
>>>>>>> 65ebb18 (lab2 genuinely finalized)
=======
=======
>>>>>>> 21e75b0 (finished lab 2)
<<<<<<< HEAD
>>>>>>> 803aa1c (finished lab 2)
=======
=======
>>>>>>> 1c76b44 (commitlab2)
>>>>>>> dbb89c2 (commitlab2)
<<<<<<< HEAD
>>>>>>> 14b7d5d (commitlab2)
=======
=======
>>>>>>> 1c76b44 (commitlab2)
=======
=======
    void playPlaylistIfPossible(){
<<<<<<< HEAD
>>>>>>> 72b3586 (lab2 genuinely finalized)
<<<<<<< HEAD
>>>>>>> 17b6630 (commit)
<<<<<<< HEAD
>>>>>>> e8eb76c (commit)
<<<<<<< HEAD
>>>>>>> 8fe3e60 (commit)
=======
=======
=======
=======
>>>>>>> 0aab51acd633adc0601d9d1d180e29317ece7b36
=======
    void playPlaylistIfPossible() {
        try {
            playPlaylist();
        } catch (EmptyTrackList e) {
            throw new Error("Playlist is empty");
        }
>>>>>>> 98775a5 (finished lab 2)
>>>>>>> f9e8a87 (done with lab 3)
>>>>>>> a94a887 (done with lab 3)
>>>>>>> fc0de73 (done with lab 3)
>>>>>>> 069d06e (done with lab 3)
    }


}


