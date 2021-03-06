package riggbot;

import javax.security.auth.login.LoginException;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import riggbot.commands.CardCommand;
import riggbot.commands.ConcernCommand;
import riggbot.commands.CrystalBallCommand;
import riggbot.commands.DadJokeCommand;
import riggbot.commands.EightBallCommand;
import riggbot.commands.GayGuardCommand;
import riggbot.commands.PingCommand;
import riggbot.commands.RollCommand;
import riggbot.commands.ShutdownCommand;
import riggbot.commands.SlotCommand;
import riggbot.commands.SomeoneCommand;
import riggbot.commands.WugCommand;
import riggbot.config.Config;
import riggbot.exceptions.ConfigValueNotFoundException;
import riggbot.listeners.ReadyListener;
import riggbot.logger.ErrorCodes;
import riggbot.logger.Logger;
import riggbot.logger.LoggingSections;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		JDA RiggBot = startBot();
	}

	public static JDA startBot() {
		if (!Config.configExist()) {
			Logger.logFatal("Config File does not exist! Creating...", ErrorCodes.NO_CONFIG, LoggingSections.CONFIG);
		} else {
			try {
				EventWaiter cmdWaiter = new EventWaiter();
				JDA jda = new JDABuilder(AccountType.BOT).addEventListener(cmdWaiter)
						.addEventListener(addCommands().build()).addEventListener(new ReadyListener())
						.setToken(Config.getValue("token").getValue()).build();
				;
				return jda;
			} catch (LoginException e) {
				Logger.logFatal("Somthing went wrong: " + e.getMessage(), ErrorCodes.LOGIN_EXCEPTION,
						LoggingSections.MAIN);
			} catch (IllegalArgumentException e) {
				Logger.logFatal("Somthing went wrong: " + e.getMessage(), ErrorCodes.ILLEAGE_ARGS,
						LoggingSections.MAIN);
			} catch (ConfigValueNotFoundException e) {
				Logger.logFatal(e.getMessage(), ErrorCodes.CONFIG_VALUE_NONEXISTANT, LoggingSections.CONFIG);
			}
		}
		return null;
	}

	public static CommandClientBuilder addCommands() {
		CommandClientBuilder c = new CommandClientBuilder();
		c.setEmojis("\u2714", "\u2B55", "\u274C");
		try {
			c.setPrefix(Config.getValue("prefix").getValue());
		} catch (ConfigValueNotFoundException e) {
			Logger.logFatal(e.getMessage(), ErrorCodes.CONFIG_VALUE_NONEXISTANT, LoggingSections.CONFIG);
			e.printStackTrace();
		}
		c.setOwnerId("117041162052698119");
		c.addCommands(new PingCommand(), new WugCommand(), new ShutdownCommand(), new RollCommand(), new CardCommand(),
				new SomeoneCommand(), new EightBallCommand(), new DadJokeCommand(), new SlotCommand(), new CrystalBallCommand(), new ConcernCommand(),
				new GayGuardCommand());
		return c;
	}
}
