package riggbot.config;

import java.io.File;
import java.io.IOException;

import riggbot.logger.ErrorCodes;
import riggbot.logger.Logger;

public class Config {

	public static final File cfg = new File("config/config.cfg");

	public static boolean configExist() {
		if (!cfg.exists()) {
			try {
				cfg.getParentFile().mkdirs();
				cfg.createNewFile();
			} catch (IOException e) {
				Logger.logFatal("Failed to make config file!", ErrorCodes.CONFIG_NO_ACCESS);
			}
			populateCfg(cfg);
			return false;
		} else {
			
			return true;
		}
	}

	private static void populateCfg(File file) {
		Logger.logDebug("Populating Config");
		ConfigWriter.makeHeader(cfg);
		ConfigWriter.write(cfg, new ConfigValue(ConfigTypes.STRING, "testvalString", "haha lol", "defaultString", "lol zozole test desc"));
		ConfigWriter.write(cfg, new ConfigValue(ConfigTypes.INT, "testvalnt", "69696969", "defaultInt", "lol zozole test desc"));
		ConfigWriter.write(cfg, new ConfigValue(ConfigTypes.BOOLEAN, "testvalBoolean", "false", "defaultBool", "lol zozole test desc"));
		ConfigWriter.write(cfg, new ConfigValue(ConfigTypes.DOUBLE, "testvalDouble", "420.69", "defaultDouble", "lol zozole test desc"));
	}
}
