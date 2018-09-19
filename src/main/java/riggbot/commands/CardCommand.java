package riggbot.commands;

import java.io.File;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.util.CommandUtil;

public class CardCommand extends Command {

	public CardCommand() {
		this.name = "card";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.help = "Picks a card, any card";
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		int num = 0;
		num = (int) Math.floor(Math.random() * 69 + 1);
		final int Num = num;
		chan.sendFile(new File("src/main/resources/Cards/"+num+".png")).queue(m -> {
			Logger.logInfo(CommandUtil.getName(msg) + " ran command \"card\", received " + Num);
		});
	}
}
