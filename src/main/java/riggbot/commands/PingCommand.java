package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;

public class PingCommand extends Command {

	public PingCommand() {
		this.name = "ping";
		this.help = "Pong";
		this.aliases = new String[] { "pingo" };
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
	}

	@Override
	protected void execute(CommandEvent event) {
		String reply = "Pong! (" + event.getJDA().getPing() + "ms)";
		Output.msg(event, reply, name);
	}

}
