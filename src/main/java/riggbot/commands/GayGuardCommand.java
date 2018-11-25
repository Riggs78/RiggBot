package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;

public class GayGuardCommand extends Command {
	private static boolean GayGuard;

	public GayGuardCommand() {
		this.name = "GayGuard";
		this.aliases = new String[] { "gay", "gg", "gaydar" };
		this.help = "Detects and reflects from the homosexual";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE, Permission.MESSAGE_ADD_REACTION };
		this.requiredRole = "Bot Commander";
		// this.ownerCommand = true;
	}

	public static boolean getGayGuard() {
		return GayGuard;
	}

	@Override
	protected void execute(CommandEvent event) {
		GayGuard = !GayGuard;
		String reply;
		if (GayGuard) {
			reply = "GayGuard: ***ACTIVATED***";
			Output.msg(event, reply, name);
		} else {
			reply = "GayGuard: ***DEACTIVATED***";
			Output.msg(event, reply, name);
		}
	}
}