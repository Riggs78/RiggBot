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

public class ShutdownCommand extends Command {

	public ShutdownCommand() {
		this.name = "shutdown";
		this.aliases = new String[] { "shut", "bye", "fuckoff", "haveyoutriedturnignitonandoffagain",
				"haveyoutriedturningitoffandonagain", "cease", "off", "end", "terminate", "iherebyendthissessionofmao",
				"sd" };
		this.help = "Shuts RiggBot down";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE, Permission.MESSAGE_ADD_REACTION };
		this.requiredRole = "Bot Commander";
		// this.ownerCommand = true;
	}

	@Override
	protected void execute(CommandEvent event) {
		HashMap<Integer, String> gbs = new HashMap<>();
		String reply = "Shutting Down...";
		File GoodByes = new File("config/Goodbyes.txt");
		int i = 0;
		try {
			Scanner scan = new Scanner(GoodByes);
			while (scan.hasNextLine()) {
				gbs.put(i++, scan.nextLine().toLowerCase());
			}
			if (gbs.size() == 0) {
				Output.msg(event, reply, name);
				Logger.logWarn("Goodbyes.txt is empty, still shutting down", LoggingSections.COMMAND);
				event.getJDA().shutdown();
				scan.close();
			}
			reply = gbs.get((int) Math.floor(Math.random() * gbs.size()));
			Output.msg(event, reply, name);
			Logger.logInfo(Output.getName(event) + " ran command \"Shutdown\", shutting down gracfully",
					LoggingSections.COMMAND);
			event.getJDA().shutdown();
			scan.close();
		} catch (FileNotFoundException e) {
			Output.msg(event, reply, name);
			Logger.logWarn("Goodbyes.txt not found, still shutting down", LoggingSections.COMMAND);
			event.getJDA().shutdown();
		}
	}
}
