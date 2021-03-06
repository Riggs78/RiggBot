package riggbot.commands;

import java.util.List;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;

public class SomeoneCommand extends Command {
	public SomeoneCommand() {
		this.name = "Someone";
		this.help = "Pings someone at random";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE, Permission.MESSAGE_ADD_REACTION };
		this.cooldown = 5000;
		//this.requiredRole = "Bot Commander";
		//this.ownerCommand = true;
		};

	@Override
	protected void execute(CommandEvent event) {
		List<Member> mems = event.getTextChannel().getGuild().getMembers();
		String reply = mems.get((int) Math.floor(Math.random()*mems.size())).getAsMention();
		Output.msg(event, reply, name);
	}
}
