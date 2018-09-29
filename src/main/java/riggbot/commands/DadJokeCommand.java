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

public class DadJokeCommand extends Command {

	public DadJokeCommand() {
		this.name = "dad";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.help = "Tells a really good joke.";
		this.aliases = new String[] { "joke", "dadjoke", "dj" };
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		HashMap<Integer, String> DadJokes = new HashMap<>();
		int i = 0;
		File JokeList = new File("config/DadJokeList.txt");
		try {
			Scanner JokeScan = new Scanner(JokeList);
			while (JokeScan.hasNextLine()) {
				DadJokes.put(i++, JokeScan.nextLine().toLowerCase());
			}
			if (DadJokes.size()==0) {
				chan.sendMessage("Sorry, I don't have any jokes right now.").queue(m->{
					Logger.logWarn("DadJokeList.txt is empty");
				});
				JokeScan.close();
				return;
			}
			chan.sendMessage(DadJokes.get((int) Math.floor(Math.random() * DadJokes.size()))).queue(m -> {
			});
			Logger.logInfo(CommandUtil.getName(msg) + " ran command \"dadjoke\", received a joke");

			JokeScan.close();
		} catch (FileNotFoundException e) {
			chan.sendMessage("Sorry, I don't have any jokes right now.").queue(m -> {
				Logger.logWarn("DadJokeList.txt not found");
				return;
			});
		}
	}
}
