package riggbot.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import riggbot.exceptions.ConfigFormatException;

public class ConfigParse {

	public static HashMap<String, ConfigValue> parseAll(File cfg) throws ConfigFormatException {
		HashMap<String, ConfigValue> out = new HashMap<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(cfg));
			String st;
			int line = 1;
			String lastLine = "";
			while ((st = br.readLine()) != null) {
				if (isValid(st, line)) {
					if (isValue(st, line)) {
						out.put(getName(st), getValue(st, lastLine));
					}
				}
				lastLine = st;
				line++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

	private static boolean isValue(String st, int line) {
		if (st.startsWith("#") || st.startsWith("##")) {
			return false;
		} else {
			return true;
		}
	}

	private static ConfigValue getValue(String st, String lastLine) {
		String name = st.replaceAll("[SIBD]:", "").replaceAll("(?==).+;", "");
		ConfigTypes type;
		if (st.replaceAll("(?![SIBD]).+", "").equals("S")) {
			type = ConfigTypes.STRING;
		} else if (st.replaceAll("(?![SIBD]).+", "").equals("B")) {
			type = ConfigTypes.BOOLEAN;
		} else if (st.replaceAll("(?![SIBD]).+", "").equals("D")) {
			type = ConfigTypes.DOUBLE;
		} else if (st.replaceAll("(?![SIBD]).+", "").equals("I")) {
			type = ConfigTypes.INT;
		} else {
			type = ConfigTypes.UNKNOWN;
		}
		String value = st.replaceAll("^[SIBD]:.+(?==)=", "").replaceAll(";", "");
		String defVal = lastLine.replaceAll("#.+(?=\\[)\\[", "").replaceAll("\\]", "");
		String desc = lastLine.replaceAll("^#", "").replaceAll(" (?=[SIBD]).+$", "");
		return new ConfigValue(type, name, value, defVal, desc);
	}

	private static String getName(String st) {
		return st.replaceAll("[SIBD]:", "").replaceAll("(?==).+;", "");
	}

	private static boolean isValid(String st, int line) throws ConfigFormatException {
		if (st.isEmpty()||st.equals("\n")) {
			return false;
		} else if (st.startsWith("##")) {
			return true;
		} else if (st.startsWith("#")) {
			if (!st.matches("^#.+?[SIBD]{1}:\\[.+\\]$")) {
				throw new ConfigFormatException("Invalid config format on line " + line);
			}
		} else if (st.startsWith("S:")) {
			if (!st.matches("^S:.+?=.+;$")) {
				throw new ConfigFormatException("Invalid config format on line " + line);
			}
		} else if (st.startsWith("I:")) {
			if (!st.matches("^I:.+?=[0-9]+;$")) {
				throw new ConfigFormatException("Invalid config format on line " + line);
			}
		} else if (st.startsWith("B:")) {
			if (!st.matches("^B:.+?=(true|false){1};$")) {
				throw new ConfigFormatException("Invalid config format on line " + line);
			}
		} else if (st.startsWith("D:")) {
			if (!st.matches("^D:.+?=[0-9]+\\.?[0-9]*?;$")) {
				throw new ConfigFormatException("Invalid config format on line " + line);
			}
		}
		return true;
	}
}
