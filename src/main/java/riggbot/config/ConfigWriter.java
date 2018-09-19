package riggbot.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import riggbot.logger.ErrorCodes;
import riggbot.logger.Logger;

public class ConfigWriter {

	private static FileWriter fileWriter;
	
	protected static void write(File cfg, ConfigValue cfgVal) {
		
	}
	
	protected static void makeHeader(File cfg) {
		try {
			fileWriter = new FileWriter(cfg);
			fileWriter.write("## " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date().getTime())+"\n");
			fileWriter.write("## This is the config file for RiggBot\n\n");
			fileWriter.close();
		} catch (IOException e1) {
			Logger.logFatal("Unable to write to config file", ErrorCodes.CONFIG_NO_ACCESS);
			e1.printStackTrace();
		}
	}

}
