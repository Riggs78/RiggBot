package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;

public class WugCommand extends Command {

	public WugCommand() {
		this.name = "wug";
		this.aliases = new String[] { "wuggy", "w" };
		this.help = "haha wug";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE, Permission.MESSAGE_ADD_REACTION };
		// this.ownerCommand = true;
	}

	@Override
	protected void execute(CommandEvent event) {
		String reply = "<:wug:" + ("" + event.getTextChannel().getGuild().getEmotesByName("wug", true)).substring(7, 25)
				+ ">";
		Output.msg(event, reply, name);
	}

}
