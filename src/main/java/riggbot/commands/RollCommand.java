package riggbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import riggbot.logger.Logger;
import riggbot.logger.LoggingSections;

public class RollCommand extends Command {

	public RollCommand() {
		this.name = "roll";
		this.aliases = new String[] { "r", "d" };
		this.help = "Rolls a dice of the given sides";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE, Permission.MESSAGE_ADD_REACTION };
		this.arguments = "[sides]";
		// this.ownerCommand = true;
	}

	@Override
	protected void execute(CommandEvent event) {
		String reply = "Invalid Argument";
		String args = event.getArgs();
		long sides;
		if (args.isEmpty() | !event.getArgs().matches("^\\d+$")) {
			Output.msg(event, reply, name);
			Logger.logWarn(Output.getName(event) + " tried to run \"roll\", but it failed: no args given",
					LoggingSections.COMMAND);
		}
		if (!args.matches("^\\d+$")) {
			Output.msg(event, reply, name);
			Logger.logWarn(Output.getName(event) + " tried to run \"roll\", but it failed: arg is no int",
					LoggingSections.COMMAND);
		}
		try {
			sides = Long.parseLong(args);
		} catch (NumberFormatException e) {
			Output.msg(event, reply, name);
			Logger.logWarn(Output.getName(event) + " tried to run \"roll\", but it failed: arg too large",
					LoggingSections.COMMAND);
			return;
		}
		if (sides < 2) {
			Output.msg(event, reply, name);
			Logger.logWarn(Output.getName(event) + " tried to run \"roll\", but it failed: arg too small",
					LoggingSections.COMMAND);
		}
		long roll = (long) Math.floor(Math.random() * sides + 1);
		if (roll == sides) {
			reply = "***CRITICAL SUCCESS***, You rolled a " + roll;
			Output.msg(event, reply, name);
		} else if (roll == 1) {
			reply = "***CRITICAL FAILURE***, You rolled a " + roll;
			Output.msg(event, reply, name);
		} else {
			reply = "You rolled a " + roll;
			Output.msg(event, reply, name);
		}
	}
}
