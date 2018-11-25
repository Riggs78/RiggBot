package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;

public class Basic extends Command {

	public Basic() {
		this.name = "name";
		this.aliases = new String[] {};
		this.help = "";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE, Permission.MESSAGE_ADD_REACTION };
		this.arguments = "";
		this.cooldown = 1000;
		this.hidden = true;
		//this.requiredRole = "Bot Commander";
		//this.ownerCommand = true;
	}

	@Override
	protected void execute(CommandEvent event) {
		String reply = "";
		Output.msg(event, reply, name);
	}

}
