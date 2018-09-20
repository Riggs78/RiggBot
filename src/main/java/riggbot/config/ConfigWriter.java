package riggbot.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import riggbot.logger.ErrorCodes;
import riggbot.logger.Logger;

public class ConfigWriter {

	private static BufferedWriter w;
	
	protected static void write(File cfg, ConfigValue cfgVal) {
		try {
			w = new BufferedWriter(new FileWriter(cfg,true));
			w.append("#"+cfgVal.getDesc()+" ["+cfgVal.getDefaultValue()+"]\n");
			if (cfgVal.getType()==ConfigTypes.STRING) {
				w.append("S:"+cfgVal.getName()+"="+cfgVal.getValue()+";\n\n");
			}else if (cfgVal.getType()==ConfigTypes.INT) {
				w.append("I:"+cfgVal.getName()+"="+cfgVal.getValue()+";\n\n");
			}else if (cfgVal.getType()==ConfigTypes.BOOLEAN) {
				w.append("B:"+cfgVal.getName()+"="+cfgVal.getValue()+";\n\n");
			}else if (cfgVal.getType()==ConfigTypes.DOUBLE) {
				w.append("D:"+cfgVal.getName()+"="+cfgVal.getValue()+";\n\n");
			}else {
				Logger.logWarn("Tried to write config value with unknown type "+cfgVal.getType().getType()+"! Skipping...");
			}
			w.close();
		} catch (IOException e) {
			Logger.logFatal("Unable to write to config file", ErrorCodes.CONFIG_NO_ACCESS);
			e.printStackTrace();
		}
		
	}
	
	protected static void makeHeader(File cfg) {
		try {
			w = new BufferedWriter(new FileWriter(cfg));
			w.write("## " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date().getTime())+"\n");
			w.write("## This is the config file for RiggBot\n\n");
			w.close();
		} catch (IOException e1) {
			Logger.logFatal("Unable to write to config file", ErrorCodes.CONFIG_NO_ACCESS);
			e1.printStackTrace();
		}
	}

}
