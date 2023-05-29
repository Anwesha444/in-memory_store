import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PlayedStorageTest {
    @Test
    public void testRecentlyPlayedStore() {
        PlayedStorage store = new PlayedStorage(3);

        store.addSong("User1", "S1");
        store.addSong("User1", "S2");
        store.addSong("User1", "S3");
       assertEquals(store.getRecentlyPlayed("User1"), Arrays.asList("S3", "S2", "S1"));

        store.addSong("User1", "S4");
     assertEquals(store.getRecentlyPlayed("User1"), Arrays.asList("S4", "S3", "S2"));

        store.addSong("User1", "S2");
     assertEquals(store.getRecentlyPlayed("User1"), Arrays.asList("S2", "S4", "S3"));

        store.addSong("User1", "S1");
assertEquals(store.getRecentlyPlayed("User1"), Arrays.asList("S1", "S2", "S4"));

        store.addSong("User2", "S5");
     assertEquals(store.getRecentlyPlayed("User2"), Arrays.asList("S5"));
    }

}
