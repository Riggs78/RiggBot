package riggbot.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import riggbot.logger.Logger;
import riggbot.logger.LoggingSections;

public class DadJokeCommand extends Command {
	public DadJokeCommand() {
		this.name = "DadJoke";
		this.aliases = new String[] {"dj","dad","joke","j"};
		this.help = "Tells you a joke";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE, Permission.MESSAGE_ADD_REACTION };
		//this.ownerCommand = true;
	}

	@Override
	protected void execute(CommandEvent event) {
		String reply = "I'm not mad, I'm just disappointed.";
		HashMap<Integer, String> Fortunes = new HashMap<>();
		File FortuneList = new File("config/DadJokeList.txt");
		int i = 0;
		try {
			Scanner scan = new Scanner(FortuneList);
			while (scan.hasNextLine()) {
				Fortunes.put(i++, scan.nextLine().toLowerCase());
			}
			if (Fortunes.size() == 0) {
				Output.msg(event, reply, name);
				Logger.logWarn("DadJokeList.txt is empty", LoggingSections.COMMAND);
			}
			reply = Fortunes.get((int)Math.floor(Math.random()*Fortunes.size()));
			Output.msg(event, reply, name);
			scan.close();
		} catch (FileNotFoundException e) {
				Output.msg(event, reply, name);
				Logger.logWarn("DadJokeList.txt not found", LoggingSections.COMMAND);
		}
	}

}
