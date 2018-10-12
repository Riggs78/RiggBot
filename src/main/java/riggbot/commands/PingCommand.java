package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.logger.LoggingSections;
import riggbot.util.CommandUtil;

public class PingCommand extends Command {

	public PingCommand() {
		this.name = "ping";
		this.help = "Pong";
		this.aliases = new String[] { "pingo" };
		this.botPermissions = new Permission[] {Permission.MESSAGE_WRITE};
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		chan.sendMessage("Pong! (" + event.getJDA().getPing() + "ms)").queue(
				m -> Logger.logInfo(CommandUtil.getName(msg) + " ran command \"ping\", responded with \"" + m.getContentRaw() + "\"", LoggingSections.COMMAND));
	}

}
