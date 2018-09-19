package riggbot.commands;

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
		int ans = 0;
		ans = (int) Math.floor(Math.random() * 20 + 1);
		String Answer = "Uhhhhh, wait a minute.";
		if (ans == 1) {
			Answer = "It is certain.";
		} else if (ans == 2) {
			Answer = "It is decidedly so.";
		} else if (ans == 3) {
			Answer = "Without a doubt.";
		} else if (ans == 4) {
			Answer = "Yes - definitely.";
		} else if (ans == 5) {
			Answer = "You may rely on it.";
		} else if (ans == 6) {
			Answer = "As I see it, yes.";
		} else if (ans == 7) {
			Answer = "Most likely.";
		} else if (ans == 8) {
			Answer = "Outlook good.";
		} else if (ans == 9) {
			Answer = "Yes.";
		} else if (ans == 10) {
			Answer = "Signs point to yes.";
		} else if (ans == 11) {
			Answer = "Reply hazy, try again.";
		} else if (ans == 12) {
			Answer = "ASk again later.";
		} else if (ans == 13) {
			Answer = "Better not tell you now.";
		} else if (ans == 14) {
			Answer = "Cannot predict now.";
		} else if (ans == 15) {
			Answer = "Concecntrate and ask again.";
		} else if (ans == 16) {
			Answer = "Don't count on it.";
		} else if (ans == 17) {
			Answer = "My reply is no.";
		} else if (ans == 18) {
			Answer = "My sources say no.";
		} else if (ans == 19) {
			Answer = "Outlook not so good.";
		} else {
			Answer = "Very doubtful.";
		}
		String ANswer = Answer;
		chan.sendMessage(ANswer).queue(m -> {
			Logger.logInfo(CommandUtil.getName(msg) + " ran command \"8ball\", recieved " + ANswer);
		});
	}
}
