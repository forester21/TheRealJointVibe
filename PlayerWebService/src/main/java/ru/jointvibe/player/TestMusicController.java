package ru.jointvibe.player;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.jointvibe.common.pojo.TrackEntity;
import ru.jointvibe.common.pojo.TrackList;

import static java.util.Arrays.asList;
@Controller
@Slf4j
public class TestMusicController {

    public static final String TOPIC_ENDPOINT = "/topic/test";

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/test/{jukeboxId}")
    public void getTest(@DestinationVariable String jukeboxId) {
        log.info("getTest() called with id " + jukeboxId);
        simpMessagingTemplate.convertAndSend(TOPIC_ENDPOINT, testTrackList());
    }

    @MessageMapping("/test1")
    public void getTest1() {
        log.info("getTest1() called!");
        simpMessagingTemplate.convertAndSend(TOPIC_ENDPOINT, testTrackList1());
    }

    private TrackList testTrackList() {
        return TrackList.builder()
                .nowPlaying(testTrack("first"))
                .tracks(asList(
                        testTrack("second"),
                        testTrack("third")
                ))
                .build();
    }

    private TrackList testTrackList1() {
        return TrackList.builder()
                .nowPlaying(testTrack("second", "Nomak - Chrystaline.mp3"))
                .tracks(asList(
                        testTrack("third")
                ))
                .build();
    }

    private TrackEntity testTrack(String name, String url) {
        return TrackEntity.builder()
                .trackName(name)
                .trackUrl(url)
                .build();
    }

    private TrackEntity testTrack(String name) {
        return testTrack(name, "Lemaitre - Go.mp3");
    }
}
