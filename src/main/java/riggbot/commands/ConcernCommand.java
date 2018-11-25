package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;

public class ConcernCommand extends Command {
	private static String IdNum;

	public ConcernCommand() {
		this.name = "concern";
		this.aliases = new String[] { "con", "drunk", "high" };
		this.help = "When you're concerned for someone";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.arguments = "[@Inebriated]";
		this.requiredRole = "Bot Commander";
		// this.ownerCommand = true;
	}

	public static String getIdNum() {
		return IdNum;
	}

	@Override
	protected void execute(CommandEvent event) {
		String reply;
		if (!event.getArgs().equals("off")) {
			long Id = Long.parseLong(event.getArgs().replaceAll("[^0-9]", ""));
			IdNum = "" + Id;
			reply = "Get well soon, <@" + IdNum + ">";
			Output.msg(event, reply, name);
		} else {
			IdNum = "0";
			reply = "I guess you got well";
			Output.msg(event, reply, name);
		}
	}

}