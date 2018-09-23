package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.util.CommandUtil;

public class RollCommand extends Command {

	public RollCommand() {
		this.name = "roll";
		this.help = "Rolls a die with x number of sides";
		this.arguments = "<sides>";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.aliases = new String[] { "r" };
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		long sides = 2;
		if (event.getArgs().isEmpty()) {
			chan.sendMessage("Try again dipshit, put a number next time!").queue(m -> {
				Logger.logWarn(CommandUtil.getName(msg) + " tried to run \"roll\", but it failed: no parameter given");
			});
			return;
		}
		if (!event.getArgs().matches("^\\d+$")) {
			chan.sendMessage("Try again dipshit, put a real number next time!").queue(m -> {
				Logger.logWarn(CommandUtil.getName(msg) + " tried to run \"roll\", but it failed: invalid parameter");
			});
			return;
		}
		try {
			sides = Long.parseLong(event.getArgs());
		} catch (NumberFormatException e) {
			chan.sendMessage("Try again dipshit, put a smaller number next time!").queue(m -> {
				Logger.logWarn(CommandUtil.getName(msg) + " tried to run \"roll\", but it failed: number too large");
			});
			return;
		}
		if (sides < 2) {
			chan.sendMessage("Try again dipshit, put a bigger number next time!").queue(m -> {
				Logger.logWarn(CommandUtil.getName(msg) + " tried to run \"roll\", but it failed: number too small");
			});
			return;
		}
		long roll = (long) Math.floor(Math.random() * sides + 1);
		if (roll == sides) {
			// CRITICAL HIT!
			chan.sendMessage("***CRITICAL HIT!!! YOU GOT A " + roll + "!!!***").queue(m -> {
				Logger.logInfo(
						CommandUtil.getName(msg) + " ran command \"roll\" and got a CRITICAL HIT (" + roll + ")");
			});
		} else if (roll == 1) {
			// oof
			chan.sendMessage("***o o f*** **, you rolled a 1...**").queue(m -> {
				Logger.logInfo(
						CommandUtil.getName(msg) + " ran command \"roll\" and got a critical fail (" + roll + ")");
			});
		} else {
			chan.sendMessage("You rolled a **" + roll + "**!").queue(m -> {
				Logger.logInfo(CommandUtil.getName(msg) + " ran command \"roll\" and got a " + roll);
			});
		}
	}
}
