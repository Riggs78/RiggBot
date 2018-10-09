package riggbot.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import riggbot.exceptions.ConfigFormatException;

public class ConfigParse {

	public static boolean parseAll(File cfg) throws ConfigFormatException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(cfg));
			String st;
			int line = 1;
			while ((st = br.readLine()) != null) {
				if (isValid(st, line)) {
					System.out.println(line + "valid");
				}
				line++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static boolean isValid(String st, int line) throws ConfigFormatException {
		if (st.startsWith("##")) {
			return true;
		} else if (st.startsWith("#")) {
			if (!st.matches("^#.+?[SIBD]{1}:\\[.+\\]$")) {
				throw new ConfigFormatException("Invalid config format on line " + line);
			}
		} else if (st.startsWith("S:")) {
			if (!st.matches("^S:.+?=.+;$")) {
				throw new ConfigFormatException("Invalid config format on line " + line);
			}
		}else if (st.startsWith("I:")) {
			if (!st.matches("^I:.+?=[0-9]+;$")) {
				throw new ConfigFormatException("Invalid config format on line " + line);
			}
		}else if (st.startsWith("B:")) {
			if (!st.matches("^B:.+?=(true|false){1};$")) {
				throw new ConfigFormatException("Invalid config format on line " + line);
			}
		}else if (st.startsWith("D:")) {
			if (!st.matches("^D:.+?=[0-9]+\\.?[0-9]*?;$")) {
				throw new ConfigFormatException("Invalid config format on line " + line);
			}
		}
		return true;
	}
}
