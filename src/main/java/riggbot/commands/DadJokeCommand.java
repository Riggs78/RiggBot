package riggbot.commands;

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
		this.aliases = new String [] { "joke", "dadjoke" };
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		int ans = (int) Math.floor(Math.random() * 42 + 1);
		String Answer = "Uhhhhh, wait a minute.";
		if (ans == 1) {
			Answer = "Did you hear about the restaurant on the moon? Great food, no atmosphere.";
		} else if (ans == 2) {
			Answer = "What do you call a fake noodle? An Impasta.";
		} else if (ans == 3) {
			Answer = "How many apples grow on a tree? All of them.";
		} else if (ans == 4) {
			Answer = "Want to hear a joke about paper? Nevermind it's tearable.";
		} else if (ans == 5) {
			Answer = "I just watched a program about beavers. It was the best dam program I've ever seen.";
		} else if (ans == 6) {
			Answer = "Why did the coffee file a police report? It got mugged.";
		} else if (ans == 7) {
			Answer = "How does a penguin build it's house? Igloos it together.";
		} else if (ans == 8) {
			Answer = "Dad, did you get a haircut? No I got them all cut.";
		} else if (ans == 9) {
			Answer = "What do you call a Mexican who has lost his car? Carlos.";
		} else if (ans == 10) {
			Answer = "Dad, can you put my shoes on? No, I don't think they'll fit me.";
		} else if (ans == 11) {
			Answer = "Why did the scarecrow win an award? Because he was outstanding in his field.";
		} else if (ans == 12) {
			Answer = "Why don't skeletons ever go trick or treating? Because they have no body to go with.";
		} else if (ans == 13) {
			Answer = "I\'ll call you later. Don't call me later, call me Dad.";
		} else if (ans == 14) {
			Answer = "What do you call an elephant that doesn't matter? An irrelephant";
		} else if (ans == 15) {
			Answer = "Want to hear a joke about construction? I'm still working on it.";
		} else if (ans == 16) {
			Answer = "What do you call cheese that isn't yours? Nacho Cheese.";
		} else if (ans == 17) {
			Answer = "Why couldn't the bicycle stand up by itself? It was two tired.";
		} else if (ans == 18) {
			Answer = "What did the grape do when he got stepped on? He let out a little wine.";
		} else if (ans == 20) {
			Answer = "I wouldn't buy anything with velcro. It's a total rip-off.";
		} else if (ans == 21) {
			Answer = "The shovel was a ground-breaking invention.";
		} else if (ans == 22) {
			Answer = "Dad, can you put the cat out? I didn't know it was on fire.";
		} else if (ans == 23) {
			Answer = "This graveyard looks overcrowded. People must be dying to get in there.";
		} else if (ans == 24) {
			Answer = "Whenever the cashier at the grocery store asks my dad if he would like the milk in a bag he replies, \"No, just leave it in the carton!\"";
		} else if (ans == 25) {
			Answer = "5/4 of people admit that they’re bad with fractions.";
		} else if (ans == 26) {
			Answer = "Two goldfish are in a tank. One says to the other, \"do you know how to drive this thing?\"";
		} else if (ans == 27) {
			Answer = "What do you call a man with a rubber toe? Roberto.";
		} else if (ans == 28) {
			Answer = "What do you call a fat psychic? A four-chin teller.";
		} else if (ans == 29) {
			Answer = "I would avoid the sushi if I was you. It’s a little fishy.";
		} else if (ans == 30) {
			Answer = "To the man in the wheelchair that stole my camouflage jacket... You can hide but you can't run.";
		} else if (ans == 31) {
			Answer = "The rotation of earth really makes my day.";
		} else if (ans == 32) {
			Answer = "I thought about going on an all-almond diet. But that's just nuts.";
		} else if (ans == 33) {
			Answer = "What's brown and sticky? A stick.";
		} else if (ans == 34) {
			Answer = "I’ve never gone to a gun range before. I decided to give it a shot!";
		} else if (ans == 35) {
			Answer = "Why do you never see elephants hiding in trees? Because they're so good at it.";
		} else if (ans == 36) {
			Answer = "Did you hear about the kidnapping at school? It's fine, he woke up.";
		} else if (ans == 37) {
			Answer = "A furniture store keeps calling me. All I wanted was one night stand.";
		} else if (ans == 38) {
			Answer = "I used to work in a shoe recycling shop. It was sole destroying.";
		} else if (ans == 39) {
			Answer = "Did I tell you the time I fell in love during a backflip? I was heels over head.";
		} else if (ans == 40) {
			Answer = "I don’t play soccer because I enjoy the sport. I’m just doing it for kicks.";
		} else if (ans == 41) {
			Answer = "People don’t like having to bend over to get their drinks. We really need to raise the bar.";
		} else {
			Answer = "I bought some shoes from a drug dealer. I don't know what he laced them with, but I've been tripping all day.";
		}
		String ANswer = Answer;
		chan.sendMessage(ANswer).queue(m -> {
		Logger.logInfo(CommandUtil.getName(msg) + " ran command \"DadJoke\", recieved " + ANswer);
	});
}}
