package riggbot.config;

import java.io.File;
import java.io.IOException;

import riggbot.logger.ErrorCodes;
import riggbot.logger.Logger;

public class Config {

	public static final File cfg = new File("config/config.cfg");

	public static boolean configExist() {
		if (!cfg.exists()) {
			cfg.getParentFile().mkdirs();
			try {
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
		ConfigWriter.makeHeader(cfg);
	}
}
