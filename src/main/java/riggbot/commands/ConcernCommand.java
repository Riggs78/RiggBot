package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.logger.LoggingSections;
import riggbot.util.CommandUtil;

public class ConcernCommand extends Command {
	private static String IdNum;

	public ConcernCommand() {
		this.name = "concern";
		this.aliases = new String[] { "con", "drunk", "high" };
		this.help = "When you're concerned for someone";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.arguments = "[@Inebriated]";
		//this.ownerCommand = true;
		this.requiredRole = "Bot Commander";
	}

	public static String getIdNum() {
		return IdNum;
	}

	public static void setIdNum(String s) {
		IdNum = "" + s;
	}
	@Override
	protected void execute(CommandEvent event) {
		System.out.print("?");
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		if (!event.getArgs().equals("off")) {
			long Id = Long.parseLong(event.getArgs().replaceAll("[^0-9]", ""));
			IdNum = ""+Id;
			System.out.println(Id);
			chan.sendMessage("Get well soon, <@" + IdNum + ">").queue(m -> {
				Logger.logInfo(CommandUtil.getName(msg) + " ran command \"Concern\", responded with \"Get well soon\"",
						LoggingSections.COMMAND);
			});
		} else {
			IdNum = "0";
			chan.sendMessage("I guess you got well").queue(m -> {
				Logger.logInfo(CommandUtil.getName(msg) + " ran command \"Concern\", responded with \"I guess you got well\"",
						LoggingSections.COMMAND);
			});
		}
	}

}