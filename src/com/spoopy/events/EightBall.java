package com.spoopy.events;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import com.spoopy.classes.ReadFromFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class EightBall implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Message msg = event.getMessage();
        TextChannel channel = event.getChannel();
       /* if (channel.getIdAsString().equals("883976254175469568"))
        {*/
            try {
                if (msg.getMentionedUsers().get(0).getName().equals("8ballbot"))
                {
                    String trimmed = msg.getContent().substring(22);
                    ArrayList<String> responses = ReadFromFile.returnResponses(new File("Z://ftp/responses.txt"));


                    if (trimmed.isEmpty())
                        channel.sendMessage("Please ask me a question if you're going to @ me!");
                    else {
                        Random random = new Random();
                        int r_Num = random.nextInt(responses.size());

                        channel.sendMessage(getMentioned(event.getMessageAuthor().asUser().get()) + " " + responses.get(r_Num));
                    }

                }
            } catch (IndexOutOfBoundsException | IOException ignored){}
        //}
    }

    static String getMentioned(User user) {
        return "<@!" + user.getIdAsString() + ">";
    }
}
