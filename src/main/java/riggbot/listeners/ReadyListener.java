package riggbot.listeners;

import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import riggbot.logger.Logger;

public class ReadyListener implements EventListener {

	public void onEvent(Event event) {
		if (event instanceof ReadyEvent) {
			Logger.logInfo("Hey guys and welcome to episode 1 of my Minecraft Let's Play");
		}
	}
	
}
