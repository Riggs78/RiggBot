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
			@SuppressWarnings("resource")
			Scanner Scan = new Scanner(FortuneList);
			while (Scan.hasNextLine()) {
				Fortunes.put(i++, Scan.nextLine());
			}
			chan.sendMessage(Fortunes.get((int) Math.floor(Math.random() * Fortunes.size()))).queue(m -> {
				Logger.logInfo(CommandUtil.getName(msg) + " ran command \"crystalball\", received a joke");
			});
		} catch (FileNotFoundException e) {
			chan.sendMessage("Sorry, I don't have any fortunes right now.").queue(m -> {
				Logger.logWarn("Fortunes.txt not found");
				return;
			});
		}
	}

}
