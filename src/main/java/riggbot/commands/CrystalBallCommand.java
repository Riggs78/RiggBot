package riggbot.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.util.CommandUtil;

public class CrystalBallCommand extends Command {
	public CrystalBallCommand() {
		this.name = "crystalball";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.help = "Gives you your fortune.";
		this.aliases = new String[] { "fortune", "crystal", "cb" };
	}
			
	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		HashMap<Integer, String> Fortunes = new HashMap<>();
		int i = 0;
		File FortuneList = new File("config/Fortunes.txt");
		try {
			Scanner scan = new Scanner(FortuneList);
			while (scan.hasNextLine()) {
				Fortunes.put(i++, scan.nextLine().toLowerCase());
			}
			if (Fortunes.size()==0) {
				chan.sendMessage("Sorry, I don't have any jokes right now.").queue(m->{
					Logger.logWarn("DadJokeList.txt is empty");
				});
				scan.close();
				return;
			}
			chan.sendMessage(Fortunes.get((int) Math.floor(Math.random() * Fortunes.size()))).queue(m -> {
				Logger.logInfo(CommandUtil.getName(msg) + " ran command \"crystalball\", received their fortune");
			});
			scan.close();
		} catch (FileNotFoundException e) {
			chan.sendMessage("Sorry, I don't have any fortunes right now.").queue(m -> {
				Logger.logWarn("Fortunes.txt not found");
				return;
			});
		}
	}

}
