package riggbot.commands;

import java.io.File;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.logger.LoggingSections;
import riggbot.util.CommandUtil;

public class CardCommand extends Command {

	public CardCommand() {
		this.name = "card";
		this.aliases = new String[] { "draw", "c" };
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.help = "Picks a card, any card";
		//this.ownerCommand = true;
	}

	@Override
	protected void execute(CommandEvent event) {
		System.out.print("?");
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		int Number_of_Cards = 143;
		int img = (int) Math.floor(Math.random() * Number_of_Cards);
		final int Image = img;
				chan.sendFile(new File("src/main/resources/Cards/card (" + img + ").png")).queue(m -> {
			Logger.logInfo(CommandUtil.getName(msg) + " ran command \"card\", received " + "card (" + Image + ").png", LoggingSections.COMMAND);
		});
	}
}
