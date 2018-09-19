package riggbot.commands;

import java.io.File;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.util.CommandUtil;

public class ForceCardCommand extends Command {

	public ForceCardCommand() {
		this.name = "fcard";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.help = "Picks a card, a very specific card";
		this.ownerCommand = true;
		this.arguments = "<card>";
		this.hidden = true;
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		if (event.getArgs().isEmpty()) {
			chan.sendMessage("Try again dipshit, put a number next time!").queue(m -> {
				Logger.logWarn(CommandUtil.getName(msg) + " tried to run \"fcard\", but it failed: no parameter given");
			});
		} else {
			int num = 0;
			num = (int) Long.parseLong(event.getArgs());
			final int Num = num;
			chan.sendFile(new File("src/main/resources/Cards/" + num + ".png")).queue(m -> {
				Logger.logInfo(CommandUtil.getName(msg) + " ran command \"card\", received " + Num);
			});
		}
		;
	}
}
