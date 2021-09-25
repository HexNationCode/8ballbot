package com.spoopy;

import com.spoopy.events.EightBall;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;

public class Main {

    public static void main(String[] args)
    {
        DiscordApi api = new DiscordApiBuilder().setToken(args[0]).login().join();
        api.updateActivity(ActivityType.CUSTOM, "fuck me in my ass");

        api.addListener(new EightBall());
    }
}
