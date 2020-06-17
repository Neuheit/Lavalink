package lavalink.server.player;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrackEndTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(TrackEndTask.class);

    private final Player player;
    private final AudioTrack track;

    public TrackEndTask(Player player, AudioTrack track) {
        this.player = player;
        this.track = track;
    }

    @Override
    public void run() {
        if (player.getPlayingTrack() != null && !player.getPlayingTrack().equals(track)) {
            return;
        }
        try {
            player.stop();

        } catch (Exception e) {
            log.error("Exception while ending track: ", e);
        }
    }
}
