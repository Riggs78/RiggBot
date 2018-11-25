package riggbot.commands;

import java.util.HashMap;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import riggbot.util.Pair;

public class SlotCommand extends Command {
	public SlotCommand() {
		this.name = "slot";
		this.aliases = new String[] { "slots", "slotmachine", "vegas", "sl" };
		this.help = "Try for a jackpot";
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE, Permission.MESSAGE_ADD_REACTION };
		// this.ownerCommand = true;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	protected void execute(CommandEvent event) {
		String reply;
		HashMap<Integer, Pair<String, String>> slotEmote = new HashMap<>();
		int c = 0;
		slotEmote.put(c++, new Pair<String, String>("\uD83C\uDFB7", "***Toot your horn, you magnificent bastard!***"));// saxophone
		slotEmote.put(c++, new Pair<String, String>("\uD83D\uDCAF", "**you like, 100 dollaroonies**"));// 100
		slotEmote.put(c++, new Pair<String, String>("\uD83C\uDF52", "**You're a cherry man!**"));// cherries
		slotEmote.put(c++, new Pair<String, String>("\u0037\u20E3", "**thats like, two more sevens than one seven.**"));// seven
		slotEmote.put(c++,
				new Pair<String, String>("\uD83D\uDC8E", "***HOLY FUCKING $HIT YOU GOTTA A JACK POT $$$$$ !!!!!!!***"));// gem
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
		slotEmote.put(c++, new Pair<String, String>("\uD83D\uDD2E", "***Your future is uhh, oof***"));// crystal_ball
		slotEmote.put(c++, new Pair<String, String>("\uD83D\uDCb6", "**have some euros**"));// euro
		String slot1 = slotEmote.get(((int) Math.floor(Math.random() * slotEmote.size()))).getLeft();
		String slot2 = slotEmote.get(((int) Math.floor(Math.random() * slotEmote.size()))).getLeft();
		String slot3 = slotEmote.get(((int) Math.floor(Math.random() * slotEmote.size()))).getLeft();
		String slots = slot1 + slot2 + slot3;
		String win;
		if (slot1.equals(slot2) && slot1.equals(slot3)) {
			win = slotEmote.get(slotEmote.get(slot1)).getRight();
			reply = slots + "\n" + win + "\n***Congratulations, " + event.getMessage().getAuthor().getName() + "***";
			Output.msg(event, reply, name);
		} else {
			reply = slots + "\n **HAHA YOU LOST!!!!**";
			Output.msg(event, reply, name);
		}

	}
}
