package riggbot.util;

import net.dv8tion.jda.core.entities.Message;

public class CommandUtil {
	public static String getName(Message msg) {
		return msg.getMember().getEffectiveName() + " (" + msg.getAuthor().getName()+ ")";
	}
}
