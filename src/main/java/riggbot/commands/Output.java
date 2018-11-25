package riggbot.commands;

import java.io.File;

import com.jagrosh.jdautilities.command.CommandEvent;

import riggbot.logger.Logger;
import riggbot.logger.LoggingSections;

public class Output {
	public static void msg(CommandEvent event, String reply, String name) {
		System.out.print("?");
		event.getChannel().sendMessage(reply).queue(m -> {
			Logger.logInfo(getName(event) + " ran command \"" + name + "\", replied \"" + reply + "\"",
					LoggingSections.COMMAND);
		});
	}

	public static void fil(CommandEvent event, File reply, String commandname, String filename) {
		System.out.print("?");
		event.getChannel().sendFile(reply).queue(m -> {
			Logger.logInfo(getName(event) + " ran command \"" + commandname + "\", sent \"" + filename + "\"",
					LoggingSections.COMMAND);
		});
	}

	public static String getName(CommandEvent event) {
		return event.getMessage().getMember().getEffectiveName() + " (" + event.getMessage().getAuthor().getName()
				+ ")";
	}
}
