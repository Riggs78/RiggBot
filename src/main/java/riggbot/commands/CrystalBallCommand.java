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

public class CrystalBallCommand extends Command {
	public CrystalBallCommand() {
		this.name = "CrystalBall";
		this.aliases = new String[] {"cb","crystal","fortune","f"};
		this.help = "Gives you a fortune";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE, Permission.MESSAGE_ADD_REACTION };
		//this.ownerCommand = true;
	}

	@Override
	protected void execute(CommandEvent event) {
		String reply = "Sorry, I can't find your fortune.";
		HashMap<Integer, String> Fortunes = new HashMap<>();
		File FortuneList = new File("config/Fortunes.txt");
		int i = 0;
		try {
			Scanner scan = new Scanner(FortuneList);
			while (scan.hasNextLine()) {
				Fortunes.put(i++, scan.nextLine().toLowerCase());
			}
			if (Fortunes.size() == 0) {
				Output.msg(event, reply, name);
				Logger.logWarn("Fortunes.txt is empty", LoggingSections.COMMAND);
			}
			reply = Fortunes.get((int)Math.floor(Math.random()*Fortunes.size()));
			Output.msg(event, reply, name);
			scan.close();
		} catch (FileNotFoundException e) {
				Output.msg(event, reply, name);
				Logger.logWarn("Fortunes.txt not found", LoggingSections.COMMAND);
		}
	}

}
