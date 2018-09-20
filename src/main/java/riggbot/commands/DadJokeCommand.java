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
		/*
		 * Flie f = new File("config/dadjokes.txt");
		 * Scanner s = new Scanner(f);
		 */
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
		DadJokes.put(42, "You know, people say they pick their nose, but I feel like I was just born with mine.");
		DadJokes.put(43, "A steak pun is a rare medium well done.");
		DadJokes.put(44, "How can you tell if a ant is a boy or a girl? They’re all girls, otherwise they’d be uncles.");
		DadJokes.put(45, "Milk is one of the fastest liquid on earth – its pasteurized before you even see it.");
		DadJokes.put(46, "Did I tell you the time I fell in love during a backflip? I was heels over head.");
		DadJokes.put(47, "Where did the one-legged waitress work? IHOP!");
		DadJokes.put(48, "Today at the bank, an old lady asked me to help check her balance. So I pushed her over.");
		DadJokes.put(49, "I told my girlfriend she drew her eyebrows too high. She seemed surprised.");
		DadJokes.put(50, "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.");
		DadJokes.put(51, "I'm so good at sleeping. I can do it with my eyes closed.");
		DadJokes.put(52, "My boss told me to have a good day.. so I went home.");
		DadJokes.put(53, "Why is Peter Pan always flying? He neverlands.");
		DadJokes.put(54, "A woman walks into a library and asked if they had any books about paranoia. The librarian says \"They're right behind you!\"");
		DadJokes.put(55, "The other day, my wife asked me to pass her lipstick but I accidentally passed her a glue stick. She still isn't talking to me.");
		DadJokes.put(56, "Why do blind people hate skydiving? It scares the hell out of their dogs.");
		DadJokes.put(57, "When you look really closely, all mirrors look like eyeballs.");
		DadJokes.put(58, "My friend says to me: \"What rhymes with orange\" I said: \"No it doesn't\"");
		DadJokes.put(59, "What did the pirate say when he turned 80 years old? Aye matey.");
		DadJokes.put(60, "My wife told me I had to stop acting like a flamingo. So I had to put my foot down.");
		DadJokes.put(61, "I couldn't figure out why the baseball kept getting larger. Then it hit me.");
		DadJokes.put(62, "Why did the old man fall in the well? Because he couldn't see that well.");
		DadJokes.put(63, "I ate a clock yesterday, it was very time consuming.");
		DadJokes.put(64, "Whatdya call a frenchman wearing sandals? Phillipe Phillope.");
		DadJokes.put(65, "A blind man walks into a bar. And a table. And a chair.");
		DadJokes.put(66, "I know a lot of jokes about unemployed people but none of them work.");
		DadJokes.put(67, "What's orange and sounds like a parrot? A carrot.");
		DadJokes.put(68, "Did you hear about the italian chef that died? He pasta way.");
		DadJokes.put(69, "Parallel lines have so much in common. It’s a shame they’ll never meet.");
		DadJokes.put(70, "My wife accused me of being immature. I told her to get out of my fort.");
		DadJokes.put(71, "Where do you find a cow with no legs? Right where you left it.");
		DadJokes.put(72, "When a deaf person sees someone yawn do they think it’s a scream?");
		DadJokes.put(73, "As I suspected, someone has been adding soil to my garden. The plot thickens.");
		DadJokes.put(74, "How do crazy people go through the forest? They take the physco path.");
		DadJokes.put(75, "And the lord said unto John, \"Come forth and you will receive eternal life\". John came fifth and won a toaster.");
		DadJokes.put(76, "What did the traffic light say to the car? Don’t look! I’m about to change.");
		DadJokes.put(77, "I just wrote a book on reverse psychology. Do *not* read it!");
		DadJokes.put(78, "What did one hat say to the other? You stay here. I’ll go on ahead.");
		DadJokes.put(79, "Why wouldn’t the shrimp share his treasure? Because he was a little shellfish.");
		String dadjoke = DadJokes.get((int) Math.floor(Math.random() * DadJokes.size() + 1));
		chan.sendMessage(dadjoke).queue(m -> {
			Logger.logInfo(CommandUtil.getName(msg) + " ran command \"DadJoke\", recieved " + dadjoke);
		});
	}
}
