package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.util.CommandUtil;

public class ShutdownCommand extends Command{

	public ShutdownCommand() {
		this.name = "shutdown";
		this.help = "Shuts the bot down";
		this.botPermissions = new Permission[] {Permission.MESSAGE_WRITE};
		this.ownerCommand = true;
		this.aliases = new String[] { "shut" , "stop" , "quit" , "end" , "fuck" , "oof" , "whoops" , "oops" , "leave" , "off" };
	}
	
	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		chan.sendMessage("Auf Wiedersehen!").queue(m -> {
			Logger.logInfo(CommandUtil.getName(msg) + " ran command \"Shutdown\", shutting down gracfully");
			m.getJDA().shutdown();
		});
	}
	
}
