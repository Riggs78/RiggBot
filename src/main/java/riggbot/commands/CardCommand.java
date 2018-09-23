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
		this.aliases = new String[] { "draw" , "c" };
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.help = "Picks a card, any card";
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		// 109 jpgs, 106 pngs
		int fti = (int) Math.floor(Math.random() * 2);
		String fts = ".img";
		int num = 0;
		Logger.logDebug("card ("+num+")"+fts);
		if (fti == 0) {
			fts = ".png";
			num = (int) Math.floor(Math.random() * 106 + 1);
			Logger.logDebug("card ("+num+")"+fts);
		} else {
			fts = ".jpg";
			num = (int) Math.floor(Math.random() * 109 + 1);
			Logger.logDebug("card ("+num+")"+fts);
		}
		final int Num = num;
		final String FTS = fts;
		Logger.logDebug("card ("+num+")"+fts);
		chan.sendFile(new File("src/main/resources/Cards/card (" + num +")"+ fts)).queue(m -> {
			Logger.logInfo(CommandUtil.getName(msg) + " ran command \"card\", received " + "card ("+Num+")"+FTS);
		});
	}
}
