package co.uk.rileythefox.twitchintellij;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.intellij.openapi.components.Service;

@Service
public final class TwitchService {

    private final TwitchClient client;

    public TwitchService() {
        client = TwitchClientBuilder.builder().withEnableHelix(true).build();
    }
}
