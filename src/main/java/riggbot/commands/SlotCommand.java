package riggbot.commands;

import java.util.HashMap;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.util.CommandUtil;

public class SlotCommand extends Command {
	public SlotCommand() {
		this.name = "slot";
		this.aliases = new String[] { "slots", "s" };
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.help = "Try for a Jackpot";
		this.arguments = "(trys)";
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		int c = 0;
		int v = 0;
		HashMap<Integer, String> slotEmote = new HashMap<>();
		slotEmote.put(c++, "\uD83C\uDFB7");// saxophone
		slotEmote.put(c++, "\uD83D\uDCAF");// 100
		slotEmote.put(c++, "\uD83C\uDF52");// cherries
		slotEmote.put(c++, "\u0037\u20E3");// seven
		slotEmote.put(c++, "\uD83D\uDC8E");// gem
		slotEmote.put(c++, "\uD83D\uDD14");// bell
		slotEmote.put(c++, "\uD83E\uDD14");// thinking
		slotEmote.put(c++, "\uD83D\uDCA9");// poop
		slotEmote.put(c++, "\uD83D\uDD2F");// star_of_david
		slotEmote.put(c++, "\uD83C\uDF46");// eggplant
		slotEmote.put(c++, "\uD83C\uDF2E");// taco
		slotEmote.put(c++, "\uD83E\uDD5A");// egg
		slotEmote.put(c++, "\uD83C\uDD71");// b
		slotEmote.put(c++, "\uD83D\uDC83");// tango girl
		slotEmote.put(c++, "\uD83D\uDED1");// stop
		slotEmote.put(c++, "\uD83C\uDFB0");// slot machine
		slotEmote.put(c++, "\uD83D\uDC8A");// pill
		HashMap<String, String> slotWin = new HashMap<>();
		slotWin.put(slotEmote.get(v++), "***Toot your horn, you magnificent bastard***");
		slotWin.put(slotEmote.get(v++), "**you like, 100 dollaroonies**");
		slotWin.put(slotEmote.get(v++), "**You're a cherry man!**");
		slotWin.put(slotEmote.get(v++), "**thats like, two more sevens than one seven.**");
		slotWin.put(slotEmote.get(v++), "***HOLY FUCKING $HIT YOU GOTTA A JACK POT $$$$$ !!!!!!!***");
		slotWin.put(slotEmote.get(v++), "**dingus, dongus**");
		slotWin.put(slotEmote.get(v++), "*Contemplate on your actions*");
		slotWin.put(slotEmote.get(v++), "**ha ha you got shit**");
		slotWin.put(slotEmote.get(v++), "***Mazel Tov, You're a Jew now!!!***");
		slotWin.put(slotEmote.get(v++), "***OoOoooOOOoOooOoooooOOOOoOOooO hes gotta big dick***");
		slotWin.put(slotEmote.get(v++), "**You can have like, 4 tacos, congratz**");
		slotWin.put(slotEmote.get(v++), "*hahahaha* ***EGGNART***");
		slotWin.put(slotEmote.get(v++), "*wug*");
		slotWin.put(slotEmote.get(v++), "***La cu-ca-ra-cha, la cu-ca-ra-cha \\n ya no pue-de ca-mi-nar\\npor-que no tie-ne, por-que le fal-ta\\nu-na pa-ta de a-trás.***");
		slotWin.put(slotEmote.get(v++), "**Halt, you have broken the law!**");
		slotWin.put(slotEmote.get(v++), "***BBBWWWWWWWWWWWWWWWWWWWAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHH***");
		slotWin.put(slotEmote.get(v++), "***d*** *R* **u** ***G*** **s**");
/* uhhh ok, so this next bit SHOULD work, I tested it a bunch
		this took  a while to get it in the right order to output what I wanted since i didn't want to require the arg
		i prolly coulda done it better but im not sure how and this does work.*/
		int trys = 1;
//		Logger.logDebug("recieved command " + trys);
		if (event.getArgs().isEmpty()) {
			trys = 1;
//			Logger.logDebug("empty args " + trys);
		} else {
			try {
				trys = Integer.parseInt(event.getArgs());
//				Logger.logDebug("got something " + trys);
			} catch (NumberFormatException e) {
				trys = 1;
//				Logger.logDebug("not an int " + trys);
				return;
			}
		}
		;
//		Logger.logDebug("recieved an int " + trys);
		if (!(trys > 0 && trys <= 3)) {
			trys = 1;
//			Logger.logDebug("not in bounds " + trys);
		} else {
			for (int i = 0; i < trys; i++) {
//				Logger.logDebug("in for loop " + trys);
				/* This stuff is now in a for loop
					which wasnt hard but the syntax scared me a bit
				 	evertything under this comment is as it was when you showed me Hashmaps*/
				String slot1 = slotEmote.get(((int) Math.floor(Math.random() * slotEmote.size() + 1)));
				String slot2 = slotEmote.get(((int) Math.floor(Math.random() * slotEmote.size() + 1)));
				String slot3 = slotEmote.get(((int) Math.floor(Math.random() * slotEmote.size() + 1)));
				String slots = slot1 + slot2 + slot3;
				String win;
				String winner;
				if (slot1.equals(slot2) && slot1.equals(slot3)) {
					winner = CommandUtil.getName(msg);
					//win = slotWin.get(slotEmote.get(slot1));switch (slot1) {
				switch (slot1) {
					case "":// sax
						win = "\uD83C\uDFB7";
						break;
					case "\uD83D\uDCAF":// 100
						win = "**you like, 100 dollaroonies**";
						break;
					case "\uD83C\uDF52":// cher
						win = "**You're a cherry man!**";
						break;
					case "\u0037\u20E3":// sev
						win = "**thats like, two more sevens than one seven.**";
						break;
					case "\uD83D\uDC8E":// gem
						win = "***HOLY FUCKING $HIT YOU GOTTA A JACK POT $$$$$ !!!!!!!***";
						break;
					case "\uD83D\uDD14":// bell
						win = "**dingus, dongus**";
						break;
					case "\uD83E\uDD14":// think
						win = "*Contemplate on your actions*";
						break;
					case "\uD83D\uDCA9":// poo
						win = "**ha ha you got shit**";
						break;
					case "\uD83D\uDD2F":// jew
						win = "***Mazel Tov, You're a Jew now!!!***";
						break;
					case "\uD83C\uDF46":// egplan
						win = "***OoOoooOOOoOooOoooooOOOOoOOooO hes gotta big dick***";
						break;
					case "\uD83C\uDF2E":// taco
						win = "**You can have like, 4 tacos, congratz**";
						break;
					case "\uD83E\uDD5A":// egg
						win = "*hahahaha* ***EGGNART***";
						break;
					case "\uD83C\uDD71":// B
						win = "*wug*";
						break;
					case "\uD83D\uDC83":// tango
						win = "***La cu-ca-ra-cha, la cu-ca-ra-cha \n ya no pue-de ca-mi-nar\npor-que no tie-ne, por-que le fal-ta\nu-na pa-ta de a-trás.***";
						break;
					case "\uD83D\uDED1":// stop
						win = "**Halt, you have broken the law!**";
						break;
					case "\uD83C\uDFB0":// slot
						win = "***BBBWWWWWWWWWWWWWWWWWWWAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHH***";
						break;
					case "\uD83D\uDC8A":// pill
						win = "***d*** *R* **u** ***G*** **s**";
						break;
					default:
						win = "Fuck You, you don't win";
						break;
					}
					chan.sendMessage(slots + "\n" + win + "\n ***Congratulations, ***"+ winner).queue(m -> {
						Logger.logInfo(CommandUtil.getName(msg) + " ran command \"slots\", they won!");
					});
				} else {
					// don't win
					chan.sendMessage(slots + "\n **HAHA YOU LOST!!!!**").queue(m -> {
						Logger.logInfo(CommandUtil.getName(msg) + " ran command \"slots\", they didn't win");
					});
				}
			}

		}
	}
}
