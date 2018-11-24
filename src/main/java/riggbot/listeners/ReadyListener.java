package riggbot.listeners;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import riggbot.logger.Logger;
import riggbot.logger.LoggingSections;
import riggbot.commands.*;
import riggbot.util.*;

public class ReadyListener implements EventListener {

	public void onEvent(Event event) {
		if (event instanceof ReadyEvent) {
			Logger.logInfo("Hey guys and welcome to episode 1 of my Minecraft Let's Play", LoggingSections.MAIN);
			// event.getJDA().getGuilds().get(0).getDefaultChannel().sendMessage("Penis");
		}
		if (event instanceof MessageReceivedEvent) {
			Message msg = (Message) ((MessageReceivedEvent) event).getMessage();
			if (msg.getAuthor().getId().equals(ConcernCommand.getIdNum())) {
				msg.getChannel().sendMessage("Get well soon, " + msg.getAuthor().getAsMention()).queue(m -> {
					Logger.logInfo(CommandUtil.getName(msg) + " was sent prayers", LoggingSections.COMMAND);
				});
				System.out.print("!");
			} else if (msg.getContentRaw().substring(0).equals(",")) {
				System.out.print("?");
			} else {
				System.out.print(".");
			}
		}

	}
}
