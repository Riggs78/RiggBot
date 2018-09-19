package riggbot.commands;

import java.util.HashMap;

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
		this.aliases = new String[] { "joke", "dadjoke" };
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		HashMap<Integer, String> DadJokes = new HashMap<>();
		DadJokes.put(1, "Did you hear about the restaurant on the moon? Great food, no atmosphere.");
		DadJokes.put(1, "Did you hear about the restaurant on the moon? Great food, no atmosphere.");
		DadJokes.put(2, "What do you call a fake noodle? An Impasta.");
		DadJokes.put(3, "How many apples grow on a tree? All of them.");
		DadJokes.put(4, "Want to hear a joke about paper? Nevermind it's tearable.");
		DadJokes.put(5, "I just watched a program about beavers. It was the best dam program I've ever seen.");
		DadJokes.put(6, "Why did the coffee file a police report? It got mugged.");
		DadJokes.put(7, "How does a penguin build it's house? Igloos it together.");
		DadJokes.put(8, "Dad, did you get a haircut? No I got them all cut.");
		DadJokes.put(9, "What do you call a Mexican who has lost his car? Carlos.");
		DadJokes.put(10, "Dad, can you put my shoes on? No, I don't think they'll fit me.");
		DadJokes.put(11, "Why did the scarecrow win an award? Because he was outstanding in his field.");
		DadJokes.put(12, "Why don't skeletons ever go trick or treating? Because they have no body to go with.");
		DadJokes.put(13, "I\'ll call you later. Don't call me later, call me Dad.");
		DadJokes.put(14, "What do you call an elephant that doesn't matter? An irrelephant");
		DadJokes.put(15, "Want to hear a joke about construction? I'm still working on it.");
		DadJokes.put(16, "What do you call cheese that isn't yours? Nacho Cheese.");
		DadJokes.put(17, "Why couldn't the bicycle stand up by itself? It was two tired.");
		DadJokes.put(18, "What did the grape do when he got stepped on? He let out a little wine.");
		DadJokes.put(19, "I wouldn't buy anything with velcro. It's a total rip-off.");
		DadJokes.put(20, "The shovel was a ground-breaking invention.");
		DadJokes.put(21, "Dad, can you put the cat out? I didn't know it was on fire.");
		DadJokes.put(22, "This graveyard looks overcrowded. People must be dying to get in there.");
		DadJokes.put(23, "Whenever the cashier at the grocery store asks my dad if he would like the milk in a bag he replies, \"No, just leave it in the carton!\"");
		DadJokes.put(24, "5/4 of people admit that they’re bad with fractions.");
		DadJokes.put(25, "Two goldfish are in a tank. One says to the other, \"do you know how to drive this thing?\"");
		DadJokes.put(26, "What do you call a man with a rubber toe? Roberto.");
		DadJokes.put(27, "What do you call a fat psychic? A four-chin teller.");
		DadJokes.put(28, "I would avoid the sushi if I was you. It’s a little fishy.");
		DadJokes.put(29, "To the man in the wheelchair that stole my camouflage jacket... You can hide but you can't run.");
		DadJokes.put(30, "The rotation of earth really makes my day.");
		DadJokes.put(31, "I thought about going on an all-almond diet. But that's just nuts.");
		DadJokes.put(32, "What's brown and sticky? A stick.");
		DadJokes.put(33, "I’ve never gone to a gun range before. I decided to give it a shot!");
		DadJokes.put(34, "Why do you never see elephants hiding in trees? Because they're so good at it.");
		DadJokes.put(35, "Did you hear about the kidnapping at school? It's fine, he woke up.");
		DadJokes.put(36, "A furniture store keeps calling me. All I wanted was one night stand.");
		DadJokes.put(37, "I used to work in a shoe recycling shop. It was sole destroying.");
		DadJokes.put(38, "Did I tell you the time I fell in love during a backflip? I was heels over head.");
		DadJokes.put(39, "I don’t play soccer because I enjoy the sport. I’m just doing it for kicks.");
		DadJokes.put(40, "People don’t like having to bend over to get their drinks. We really need to raise the bar.");
		DadJokes.put(41, "I bought some shoes from a drug dealer. I don't know what he laced them with, but I've been tripping all day.");
		String dadjoke = DadJokes.get((int) Math.floor(Math.random() * DadJokes.size() + 1));
		chan.sendMessage(dadjoke).queue(m -> {
			Logger.logInfo(CommandUtil.getName(msg) + " ran command \"DadJoke\", recieved " + dadjoke);
		});
	}
}
