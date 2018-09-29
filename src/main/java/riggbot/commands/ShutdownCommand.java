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

public class ShutdownCommand extends Command{

	public ShutdownCommand() {
		this.name = "shutdown";
		this.help = "Shuts the bot down";
		this.botPermissions = new Permission[] {Permission.MESSAGE_WRITE};
		this.ownerCommand = true;
		this.aliases = new String[] { "shut" , "stop" , "quit" , "end" , "fuck" , "oof" , "whoops" , "oops" , "leave" , "off", "haveyoutriedturningitonandoffagain" };
	}
	
	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		HashMap<Integer, String> gbs = new HashMap<>();
		int i = 0;
		File GoodByes = new File("config/Goodbyes.txt");
			try {
				Scanner scan = new Scanner(GoodByes);
				while (scan.hasNextLine()) {
					gbs.put(i++, scan.nextLine().toLowerCase());
				}
				if (gbs.size()==0) {
					chan.sendMessage("Shutting Down...").queue(m->{
						Logger.logWarn("Goodbyes.txt is empty, still shutting down");
						m.getJDA().shutdown();
					});
					scan.close();
					return;
				}
				chan.sendMessage(gbs.get((int)Math.floor(Math.random()*gbs.size()))).queue(m -> {
				Logger.logInfo(CommandUtil.getName(msg) + " ran command \"Shutdown\", shutting down gracfully");
				m.getJDA().shutdown();
				scan.close();
				});} catch (FileNotFoundException e) {
				chan.sendMessage("Shutting Down...").queue(m -> {
					Logger.logWarn("Goodbyes.txt not found, still shutting down");
					m.getJDA().shutdown();
					return;
			});
		
	}
	
}}
