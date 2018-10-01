package riggbot.util;

public class Flip {

	public static String flip(String IN) {
		String input = IN;
		String output = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			output = output + input.charAt(i);
		}
		return output;
	}
}
