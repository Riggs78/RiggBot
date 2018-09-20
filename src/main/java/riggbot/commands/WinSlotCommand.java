package riggbot.commands;

import java.util.HashMap;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import riggbot.logger.Logger;
import riggbot.util.CommandUtil;

public class WinSlotCommand extends Command {
	public WinSlotCommand() {
		this.name = "wslot";
		this.aliases = new String[] { "wslots" , "ws" };
		this.botPermissions = new Permission[] { Permission.MESSAGE_WRITE };
		this.requiredRole = "Bot Commander";
		this.help = "Get a Jackpot";
		this.arguments = "(outcome)";
	}

	@Override
	protected void execute(CommandEvent event) {
		TextChannel chan = event.getTextChannel();
		Message msg = event.getMessage();
		HashMap<Integer, String> slotEmote = new HashMap<>();
		slotEmote.put(1, "\uD83C\uDFB7");// saxophone
		slotEmote.put(2, "\uD83D\uDCAF");// 100
		slotEmote.put(3, "\uD83C\uDF52");// cherries
		slotEmote.put(4, "\u0037\u20E3");// seven
		slotEmote.put(5, "\uD83D\uDC8E");// gem
		slotEmote.put(6, "\uD83D\uDD14");// bell
		slotEmote.put(7, "\uD83E\uDD14");// thinking
		slotEmote.put(8, "\uD83D\uDCA9");// poop
		slotEmote.put(9, "\uD83D\uDD2F");// star_of_david
		slotEmote.put(10, "\uD83C\uDF46");// eggplant
		slotEmote.put(11, "\uD83C\uDF2E");// taco
		slotEmote.put(12, "\uD83E\uDD5A");// egg
		slotEmote.put(13, "\uD83C\uDD71");// b
		slotEmote.put(14, "\uD83D\uDC83");// tango girl
		slotEmote.put(15, "\uD83D\uDED1");// stop
		slotEmote.put(16, "\uD83C\uDFB0");// slot machine
		slotEmote.put(17, "\uD83D\uDC8A");// pill
		String slot1;
		if (event.getArgs().isEmpty()) {
			slot1 = slotEmote.get(((int) Math.floor(Math.random() * slotEmote.size() + 1)));
			}else{
			 slot1 = slotEmote.get((int)Integer.parseInt(event.getArgs()));
			};
		String slot2 = slot1;
		String slot3 = slot2;
		String slots = slot1 + slot2 + slot3;
		String win = "You lost, shithead!";
		if (slot1.equals(slot2) && slot1.equals(slot3)) {
			switch (slot1) {
			case "\uD83C\uDFB7":
				win = "***Toot your horn, you magnificent bastard***";
				break;
			case "\uD83D\uDCAF":
				win = "**you like, 100 dollaroonies**";
				break;
			case "\uD83C\uDF52":
				win = "**You're a cherry man!**";
				break;
			case "\u0037\u20E3":
				win = "**thats like, two more sevens than one seven.**";
				break;
			case "\uD83D\uDC8E":
				win = "***HOLY FUCKING $HIT YOU GOTTA A JACK POT $$$$$ !!!!!!!***";
				break;
			case "\uD83D\uDD14":
				win = "**dingus, dongus**";
				break;
			case "\uD83E\uDD14":
				win = "*Contemplate on your actions*";
				break;
			case "\uD83D\uDCA9":
				win = "**ha ha you got shit**";
				break;
			case "\uD83D\uDD2F":
				win = "***Mazel Tov, You're a Jew now!!!***";
				break;
			case "\uD83C\uDF46":
				win = "***OoOoooOOOoOooOoooooOOOOoOOooO hes gotta big dick***";
				break;
			case "\uD83C\uDF2E":
				win = "**You can have like, 4 tacos, congratz**";
				break;
			case "\uD83E\uDD5A":
				win = "*hahahaha* ***EGGNART***";
				break;
			case "\uD83C\uDD71":
				win = "*wug*";
				break;
			case "\uD83D\uDC83"://tango
				win = "***La cu-ca- | ra-cha, la cu-ca-ra-cha\r\n| ya no pue-de ca-mi-nar\r\npor-que no | tie-ne, por-que le fal-ta\r\n| u-na pa-ta de a-trás.***";
				break;
			case "\uD83D\uDED1"://stop
				win = "**Halt, you have broken the law!**";
				break;
			case "\uD83C\uDFB0"://slot
				win = "***BBBWWWWWWWWWWWWWWWWWWWAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHH***";
				break;
			case "\uD83D\uDC8A"://pill
				win = "***d*** *R* **u** ***G*** **s**";
				break;
			default:
				win = "Fuck You, you didn't win";
				break;
			}
			chan.sendMessage(slots + "\n" + win).queue(m -> {
				Logger.logInfo(CommandUtil.getName(msg) + " ran command \"slots\", of course they won!");
			});
		} else {
			// don't win
			chan.sendMessage(slots).queue(m -> {
				Logger.logInfo(CommandUtil.getName(msg) + " ran command \"slots\", they didn't win");
			});
		}
	}

}
