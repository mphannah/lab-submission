import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;
public class SpotifyPlaylistTest {

    String[] songs = {};
    SpotifyPlaylist newPlaylist = new SpotifyPlaylist(songs);

    // TODO: Use assertThrows() in your JUnit Tests of the methods you wrote
    @Test
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> f9e8a87 (done with lab 3)
=======
>>>>>>> 21e75b0 (finished lab 2)
=======
>>>>>>> e8eb76c (commit)
=======
=======
>>>>>>> f9e8a87 (done with lab 3)
>>>>>>> fc0de73 (done with lab 3)
    void catchError() {
        Assertions.assertThrows(EmptyTrackList.class, () -> {
            newPlaylist.playPlaylist();
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    void catchError(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
=======
>>>>>>> f9e8a87 (done with lab 3)
=======
    void catchError(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
=======
>>>>>>> 21e75b0 (finished lab 2)
=======
=======
    void catchError(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
>>>>>>> e8eb76c (commit)
=======
=======
    void catchError(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
=======
>>>>>>> f9e8a87 (done with lab 3)
>>>>>>> fc0de73 (done with lab 3)
    }

    // TODO: Use assertThrows() in your JUnit Tests of the methods you wrote
    @Test
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> f9e8a87 (done with lab 3)
=======
>>>>>>> 21e75b0 (finished lab 2)
=======
>>>>>>> e8eb76c (commit)
=======
=======
>>>>>>> f9e8a87 (done with lab 3)
>>>>>>> fc0de73 (done with lab 3)
    void catchException() {
        Error thrown = Assertions.assertThrows(Error.class, () -> {
            newPlaylist.playPlaylistIfPossible();
        }, "Playlist is empty");
        
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    void catchException(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
=======
>>>>>>> f9e8a87 (done with lab 3)
=======
    void catchException(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
=======
>>>>>>> 21e75b0 (finished lab 2)
=======
=======
    void catchException(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
>>>>>>> e8eb76c (commit)
=======
=======
    void catchException(){
>>>>>>> 72b3586 (lab2 genuinely finalized)
=======
>>>>>>> f9e8a87 (done with lab 3)
>>>>>>> fc0de73 (done with lab 3)
    }

}
