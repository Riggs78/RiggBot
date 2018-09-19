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
import riggbot.commands.ForceCardCommand;
import riggbot.commands.PingCommand;
import riggbot.commands.RollCommand;
import riggbot.commands.ShutdownCommand;
import riggbot.commands.SlotCommand;
import riggbot.commands.SomeoneCommand;
import riggbot.commands.WinSlotCommand;
import riggbot.commands.WugCommand;
import riggbot.listeners.ReadyListener;
import riggbot.logger.Logger;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		JDA RiggBot = startBot(buildBot());
	}

	public static JDABuilder buildBot() {
		EventWaiter cmdWaiter = new EventWaiter();
		return new JDABuilder(AccountType.BOT).addEventListener(cmdWaiter).addEventListener(addCommands().build())
				.addEventListener(new ReadyListener());
	}

	public static JDA startBot(JDABuilder jda) {
		try {
			return jda.setToken("NDg5OTgyODYxMzA3MjgxNDI3.Dn9UgA.1EpGDtrDxI8nLTeS3YnSaV1ihBE").build();
		} catch (LoginException | IllegalArgumentException e) {
			Logger.logFatal("Somthing went wrong!!");
			e.printStackTrace();
		}
		return null;
	}

	public static CommandClientBuilder addCommands() {
		CommandClientBuilder c = new CommandClientBuilder();
		c.setEmojis("\u2714", "\u2B55", "\u274C");
		c.setPrefix(">");
		c.setOwnerId("117041162052698119");
		c.addCommands(new PingCommand(), new WugCommand(), new ShutdownCommand(), new RollCommand(), new CardCommand(),
				new SomeoneCommand(), new ForceCardCommand(), new EightBallCommand(), new DadJokeCommand(),
				new SlotCommand(), new WinSlotCommand());
		return c;
	}
}
