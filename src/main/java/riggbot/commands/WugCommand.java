package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.util.CommandUtil;

public class WugCommand extends Command {

	public WugCommand() {
		this.name = "wug";
		this.help = "haha wug";
		this.guildOnly = true;
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE, Permission.MESSAGE_ADD_REACTION };
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		String emj = "" + chan.getGuild().getEmotesByName("wug", true);
		String emj1 = emj.substring(7, 25);
		String emj2 = "<:wug:" + emj1 + ">";
		chan.sendMessage(emj2).queue(m -> {
			Logger.logInfo(CommandUtil.getName(msg) + " ran command \"wug\", responded with \"wug\"");
		});
	}

}
