package ru.jointvibe.player;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.jointvibe.common.pojo.TrackEntity;
import ru.jointvibe.common.pojo.TrackList;
import ru.jointvibe.service.JukeboxStore;

import static java.util.Arrays.asList;

@Controller
@Slf4j
public class MusicController {

    public static final String TOPIC_ENDPOINT = "/topic/test";

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private JukeboxStore jukeBoxStore;

    @MessageMapping("/get/{jukeboxId}")
    public void getTracks(@DestinationVariable String jukeboxId) {
        TrackList trackList = jukeBoxStore.popTrackListWithNowPlaying(jukeboxId);
        simpMessagingTemplate.convertAndSend(TOPIC_ENDPOINT + "/" + jukeboxId, trackList);
        return;
    }
}