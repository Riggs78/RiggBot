package riggbot.util;

import net.dv8tion.jda.core.entities.Message;

public class CommandUtil {

	public static String getName(Message mxg) {
		String name;
		if (mxg.getMember().getNickname() == null) {
			name = mxg.getAuthor().getName();
		} else {
			name = mxg.getMember().getNickname() + " (" + mxg.getAuthor().getName() + ")";
		}
		return name;
	}
	
}
