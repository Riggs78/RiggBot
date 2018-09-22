package riggbot.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.ErrorCodes;
import riggbot.logger.Logger;
import riggbot.util.CommandUtil;
import riggbot.util.Pair;

public class SlotCommand extends Command {
	public SlotCommand() {
		this.name = "slot";
		this.aliases = new String[] { "slots", "s" };
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.help = "Try for a Jackpot";
		this.arguments = "(trys)";
//		this.ownerCommand = true;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		int c = 0;
		HashMap<Integer, String> Fortunes = new HashMap<>();
		int f = 0;
		File FortuneList = new File("config/Fortunes.txt");
		Scanner scan;
		try {
			scan = new Scanner(FortuneList);
			while (scan.hasNextLine()) {
				Fortunes.put(f++, scan.nextLine());
			}
			String fortune = "" + Fortunes.get((int) Math.floor(Math.random() * Fortunes.size()));
			HashMap<Integer, Pair<String, String>> slotEmote = new HashMap<>();
			slotEmote.put(c++,
					new Pair<String, String>("\uD83C\uDFB7", "***Toot your horn, you magnificent bastard!***"));// saxophone
			slotEmote.put(c++, new Pair<String, String>("\uD83D\uDCAF", "**you like, 100 dollaroonies**"));// 100
			slotEmote.put(c++, new Pair<String, String>("\uD83C\uDF52", "**You're a cherry man!**"));// cherries
			slotEmote.put(c++,
					new Pair<String, String>("\u0037\u20E3", "**thats like, two more sevens than one seven.**"));// seven
			slotEmote.put(c++, new Pair<String, String>("\uD83D\uDC8E",
					"***HOLY FUCKING $HIT YOU GOTTA A JACK POT $$$$$ !!!!!!!***"));// gem
			slotEmote.put(c++, new Pair<String, String>("\uD83D\uDD14", "**dingus, dongus**"));// bell
			slotEmote.put(c++, new Pair<String, String>("\uD83E\uDD14", "*Contemplate on your actions*"));// thinking
			slotEmote.put(c++, new Pair<String, String>("\uD83D\uDCA9", "**ha ha you got shit**"));// poop
			slotEmote.put(c++, new Pair<String, String>("\uD83D\uDD2F", "***Mazel Tov, You're a Jew now!!!***"));// star_of_david
			slotEmote.put(c++,
					new Pair<String, String>("\uD83C\uDF46", "***OoOoooOOOoOooOoooooOOOOoOOooO hes gotta big dick***"));// eggplant
			slotEmote.put(c++, new Pair<String, String>("\uD83C\uDF2E", "**You can have like, 4 tacos, congratz**"));// taco
			slotEmote.put(c++, new Pair<String, String>("\uD83E\uDD5A", "*hahahaha* ***EGGNART***"));// egg
			slotEmote.put(c++, new Pair<String, String>("\uD83C\uDD71", "*wug*"));// b
			slotEmote.put(c++, new Pair<String, String>("\uD83D\uDC83",
					"***La cu-ca-ra-cha, la cu-ca-ra-cha \\\\n ya no pue-de ca-mi-nar\\\\npor-que no tie-ne, por-que le fal-ta\\\\nu-na pa-ta de a-trás.***"));// dancing_girl
			slotEmote.put(c++, new Pair<String, String>("\uD83D\uDED1", "**Halt, you have broken the law!**"));// stop
			slotEmote.put(c++, new Pair<String, String>("\uD83C\uDFB0",
					"***BBBWWWWWWWWWWWWWWWWWWWAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHH***"));// slot_machine
			slotEmote.put(c++, new Pair<String, String>("\uD83D\uDC8A", "***d*** *R* **u** ***G*** **s**"));// pill
			slotEmote.put(c++, new Pair<String, String>("\uD83C\uDF40", "***IS THAT A WEED!?***"));// four_leaf_clover
			slotEmote.put(c++, new Pair<String, String>("\uD83D\uDD2E", "***" + fortune + "***"));// crystal_ball
			slotEmote.put(c++, new Pair<String, String>("\uD83D\uDCb6", "**have some euros**"));// euro
			int t = 1;
			if (event.getArgs().isEmpty()) {
				t = 1;
			} else {
				try {
					t = Integer.parseInt(event.getArgs());
				} catch (NumberFormatException e) {
					t = 1;
					return;
				}
			}
			if (!(t > 0 && t <= 3)) {
				t = 1;
			}
			for (int i = 0; i < t; i++) {
				String slot1 = slotEmote.get(((int) Math.floor(Math.random() * slotEmote.size()))).getLeft();
				String slot2 = slotEmote.get(((int) Math.floor(Math.random() * slotEmote.size()))).getLeft();
				String slot3 = slotEmote.get(((int) Math.floor(Math.random() * slotEmote.size()))).getLeft();
				String slots = slot1 + slot2 + slot3;
				String win;
				if (slot1.equals(slot2) && slot1.equals(slot3)) {
					win = slotEmote.get(slotEmote.get(slot1)).getRight();
					chan.sendMessage(slots + "\n" + win + "\n***Congratulations, " + msg.getAuthor().getName()+"***")
							.queue(m -> {
								Logger.logInfo(CommandUtil.getName(msg) + " ran command \"slots\", they won!");
							});
				} else {
					chan.sendMessage(slots + "\n **HAHA YOU LOST!!!!**").queue(m -> {
						Logger.logInfo(CommandUtil.getName(msg) + " ran command \"slots\", they didn't win");
					});
				}
			}
		} catch (FileNotFoundException e) {
			// TODO: add new err code
			Logger.logFatal("No FortuneCookie.txt Found", ErrorCodes.NO_CONFIG);
			e.printStackTrace();
		}
	}
}
