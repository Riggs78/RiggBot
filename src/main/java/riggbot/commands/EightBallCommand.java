package riggbot.commands;

import java.util.HashMap;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.util.CommandUtil;

public class EightBallCommand extends Command {

	public EightBallCommand() {
		this.name = "8ball";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.help = "Answers truthfully";
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		HashMap<Integer, String> Answers = new HashMap<>();
		Answers.put(1, "It is certain.");
		Answers.put(2, "It is decidely so.");
		Answers.put(3, "Without a doubt.");
		Answers.put(4, "Yes - definitely.");
		Answers.put(5, "You may rely on it.");
		Answers.put(6, "As I see it, yes.");
		Answers.put(7, "Most likely.");
		Answers.put(8, "Outlook good.");
		Answers.put(9, "Yes.");
		Answers.put(10, "Signs point to yes.");
		Answers.put(11, "Reply hazy, try again.");
		Answers.put(12, "Ask again later.");
		Answers.put(13, "Better not tell you now.");
		Answers.put(14, "Cannot predict now.");
		Answers.put(15, "Concentrate and ask again.");
		Answers.put(16, "Don't count on it.");
		Answers.put(17, "My reply is no.");
		Answers.put(18, "My sources say no.");
		Answers.put(19, "Outlook not so good.");
		Answers.put(20, "Very doubtful.");
		String ans = Answers.get(((int) Math.floor(Math.random() * 20 + 1)));
		chan.sendMessage(ans).queue(m -> {
			Logger.logInfo(CommandUtil.getName(msg) + " ran command \"8ball\", recieved " + ans);
		});
	}
}