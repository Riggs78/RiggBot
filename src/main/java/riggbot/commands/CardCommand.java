package riggbot.commands;

import java.io.File;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;

public class CardCommand extends Command {

	public CardCommand() {
		this.name = "card";
		this.aliases = new String[] { "draw", "c" };
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.help = "Picks a card, any card";
		// this.ownerCommand = true;
	}

	@Override
	protected void execute(CommandEvent event) {
		int Number_of_Cards = 143;
		int img = (int) Math.floor(Math.random() * Number_of_Cards);
		File file = new File("src/main/resources/Cards/card (" + img + ").png");
		String filename = "card (" + img + ").png";
		Output.fil(event, file, name, filename);
	}
}
