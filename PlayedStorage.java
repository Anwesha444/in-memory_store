import java.util.*;

public class PlayedStorage {
    private final int capacity;
    private final Map<String, Deque<String>> recentlyPlayed;

    public PlayedStorage(int capacity) {
        this.capacity = capacity;
        this.recentlyPlayed = new HashMap<>();
    }

    public void addSong(String user, String song) {
        if (!recentlyPlayed.containsKey(user)) {
            recentlyPlayed.put(user, new LinkedList<>());
        }

        Deque<String> userPlaylist = recentlyPlayed.get(user);

        if (userPlaylist.contains(song)) {
            userPlaylist.remove(song);
        } else if (userPlaylist.size() >= capacity) {
            userPlaylist.removeLast();
        }

        userPlaylist.addFirst(song);
    }

    public List<String> getRecentlyPlayed(String user) {
        return (List<String>) recentlyPlayed.getOrDefault(user, new LinkedList<>());
    }
}
