package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.logger.LoggingSections;
import riggbot.util.CommandUtil;

public class GayGuardCommand extends Command {
	private static boolean GayGuard;

	public GayGuardCommand() {
		this.name = "gayguard";
		this.aliases = new String[] { "gay", "guard", "gg" };
		this.help = "When you're paranoid AND homophobic";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		// this.ownerCommand = true;
		this.requiredRole = "Bot Commander";
	}
	public static boolean getGayGuard() {
		return GayGuard;
	}

	@Override
	protected void execute(CommandEvent event) {
		System.out.print("?");
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		GayGuard = !GayGuard;
		if (GayGuard) {
			chan.sendMessage("GayGuard: ***ACTIVATED***").queue(m -> {
				Logger.logInfo(
						CommandUtil.getName(msg)
								+ " ran command \"GayGuard\", responded with \"GayGuard: ***ACTIVATED***\"",
						LoggingSections.COMMAND);
			});
		}else {

			chan.sendMessage("GayGuard: ***DEACTIVATED***").queue(m -> {
				Logger.logInfo(
						CommandUtil.getName(msg)
								+ " ran command \"GayGuard\", responded with \"GayGuard: ***DEACTIVATED***\"",
						LoggingSections.COMMAND);
		});
	}
}}