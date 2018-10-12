package riggbot.config;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import riggbot.exceptions.ConfigFormatException;
import riggbot.exceptions.ConfigValueNotFoundException;
import riggbot.logger.ErrorCodes;
import riggbot.logger.Logger;
import riggbot.logger.LoggingSections;

public class Config {

	private static HashMap<String, ConfigValue> cfgValues = new HashMap<>();
	public static final File cfg = new File("config/config.cfg");

	public static boolean configExist() {
		if (!cfg.exists()) {
			try {
				cfg.getParentFile().mkdirs();
				cfg.createNewFile();
			} catch (IOException e) {
				Logger.logFatal("Failed to make config file: " + e.getMessage(), ErrorCodes.CONFIG_NO_ACCESS, LoggingSections.CONFIG);
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
			Logger.logDebug(cfgValues.toString(),LoggingSections.CONFIG);
		} catch (ConfigFormatException e) {
			Logger.stackTrace(e);
			Logger.logFatal("The config file was malformed: " + e.getMessage(), ErrorCodes.CONFIG_INVALID, LoggingSections.CONFIG);
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
		ConfigWriter.makeHeader(file);
		ConfigWriter.write(file,new ConfigValue(ConfigTypes.STRING, "prefix", "!", "!", "Command prefix the bot uses"));
		ConfigWriter.write(file,new ConfigValue(ConfigTypes.STRING, "LogLevel", "Info", "Info", "Logging level to use. Will log everything from the given level up. Fatal->Warn->Info->Debug"));
		ConfigWriter.write(file,new ConfigValue(ConfigTypes.STRING, "token", "", "undef", "Token the bot uses to connect to the bot account"));
	
		ConfigWriter.write(file,new ConfigValue(ConfigTypes.INT, "test", "3838383", "2381239810283", "test"));
	}
}
