package riggbot.config;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import riggbot.exceptions.ConfigFormatException;
import riggbot.exceptions.ConfigValueNotFoundException;
import riggbot.logger.ErrorCodes;
import riggbot.logger.Logger;

public class Config {

	private static HashMap<String, ConfigValue> cfgValues = new HashMap<>();
	public static final File cfg = new File("config/config.cfg");

	public static boolean configExist() {
		if (!cfg.exists()) {
			try {
				cfg.getParentFile().mkdirs();
				cfg.createNewFile();
			} catch (IOException e) {
				Logger.logFatal("Failed to make config file: " + e.getMessage(), ErrorCodes.CONFIG_NO_ACCESS);
			}
			populateCfg(cfg);
			return false;
		} else {
			parseConfig(cfg);
			return true;
		}
	}

	private static void parseConfig(File file) {
		try {
			cfgValues = ConfigParse.parseAll(file);
			Logger.logDebug(cfgValues.toString());
		} catch (ConfigFormatException e) {
			Logger.logFatal("The config file was malformed: " + e.getMessage(), ErrorCodes.CONFIG_INVALID);
		}
	}

	public static ConfigValue getValue(String name) throws ConfigValueNotFoundException {
		if (cfgValues.get(name) == null) {
			throw new ConfigValueNotFoundException("The config value " + name + " does not exist");
		} else {
			return cfgValues.get(name);
		}
	}

	private static void populateCfg(File file) {
		// lol add actually values use the format given
		//test values
		ConfigWriter.makeHeader(file);
		ConfigWriter.write(file, new ConfigValue(ConfigTypes.STRING, "testvalString", "haha lol", "defaultString",
				"lol zozole test desc"));
		ConfigWriter.write(file,
				new ConfigValue(ConfigTypes.INT, "testvalnt", "69696969", "defaultInt", "lol zozole test desc"));
		ConfigWriter.write(file,
				new ConfigValue(ConfigTypes.BOOLEAN, "testvalBoolean", "false", "defaultBool", "lol zozole test desc"));
		ConfigWriter.write(file, new ConfigValue(ConfigTypes.DOUBLE, "testvalDouble", "420.69", "defaultDouble",
				"lol zozole test desc"));
		//real values
		ConfigWriter.write(file,new ConfigValue(ConfigTypes.STRING, "prefix", "!", "!", "Command prefix the bot uses"));
		ConfigWriter.write(file,new ConfigValue(ConfigTypes.STRING, "LogLevel", "Info", "Info", "Logging level to use. Will log everything from the given level up. Fatal->Warn->Info->Debug"));
	}
}
