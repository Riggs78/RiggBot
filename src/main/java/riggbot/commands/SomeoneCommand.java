package riggbot.commands;

import java.util.List;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.logger.LoggingSections;
import riggbot.util.CommandUtil;

public class SomeoneCommand extends Command {
	public SomeoneCommand() {
		this.aliases = new String[] { "anyone" , "any" };
		this.cooldown = 30;
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.help = "Mentions someone, anyone";
		this.name = "someone";
		};

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		List<Member> mems = chan.getGuild().getMembers();
		String men = mems.get((int) Math.floor(Math.random()*mems.size())).getAsMention();
		chan.sendMessage(men).queue(m -> Logger.logInfo(CommandUtil.getName(msg) + " ran command \"someone\", mentioned " + men, LoggingSections.COMMAND));
	}
}
