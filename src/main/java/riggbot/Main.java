package riggbot;

import javax.security.auth.login.LoginException;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import riggbot.commands.CardCommand;
import riggbot.commands.DadJokeCommand;
import riggbot.commands.EightBallCommand;
import riggbot.commands.CrystalBallCommand;
import riggbot.commands.PingCommand;
import riggbot.commands.RollCommand;
import riggbot.commands.ShutdownCommand;
import riggbot.commands.SlotCommand;
import riggbot.commands.SomeoneCommand;
import riggbot.commands.WinSlotCommand;
import riggbot.commands.WugCommand;
import riggbot.config.Config;
import riggbot.listeners.ReadyListener;
import riggbot.logger.ErrorCodes;
import riggbot.logger.Logger;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		JDA RiggBot = startBot();
	}

	public static JDA startBot() {
		// check config exist
		// if no -> create and terminate
		// if yes -> start bot and read in values
		if (!Config.configExist()) {
			Logger.logFatal("Config File does not exist! Creating...", ErrorCodes.NO_CONFIG);
		} else {
			try {
				EventWaiter cmdWaiter = new EventWaiter();
				JDA jda = new JDABuilder(AccountType.BOT).addEventListener(cmdWaiter)
						.addEventListener(addCommands().build()).addEventListener(new ReadyListener())
						.setToken("NDg5OTgyODYxMzA3MjgxNDI3.Dn9UgA.1EpGDtrDxI8nLTeS3YnSaV1ihBE").build();
				;
				return jda;
			} catch (LoginException e) {
				Logger.logFatal("Somthing went wrong!", ErrorCodes.LOGIN_EXCEPTION);
			} catch (IllegalArgumentException e) {
				Logger.logFatal("Somthing went wrong!", ErrorCodes.ILLEAGE_ARGS);
			}
		}
		return null;
	}

	public static CommandClientBuilder addCommands() {
		CommandClientBuilder c = new CommandClientBuilder();
		c.setEmojis("\u2714", "\u2B55", "\u274C");
		c.setPrefix(">");
		c.setOwnerId("117041162052698119");
		c.addCommands(new PingCommand(), new WugCommand(), new ShutdownCommand(), new RollCommand(), new CardCommand(),
				new SomeoneCommand(), new EightBallCommand(), new DadJokeCommand(),
				new SlotCommand(), new WinSlotCommand(), new CrystalBallCommand());
		return c;
	}
}
