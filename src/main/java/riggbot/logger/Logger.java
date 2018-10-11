package riggbot.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import riggbot.config.Config;
import riggbot.exceptions.ConfigValueNotFoundException;

public class Logger {
	
	public static void logInfo(String m) {
		try {
			String level = Config.getValue("LogLevel").getValue().trim().toUpperCase();
			if (level.equals("INFO")||level.equals("DEBUG")) {
				System.out.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [INFO] "+m);		
			}
		} catch (ConfigValueNotFoundException e) {
			logFatal(e.getMessage(), ErrorCodes.CONFIG_VALUE_NONEXISTANT);
			e.printStackTrace();
		}
	}
	
	public static void logWarn(String m) {
		try {
			String level = Config.getValue("LogLevel").getValue().trim().toUpperCase();
			if (level.equals("WARN")||level.equals("INFO")||level.equals("DEBUG")) {
				System.err.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [WARN] "+m);		
			}
		} catch (ConfigValueNotFoundException e) {
			logFatal(e.getMessage(), ErrorCodes.CONFIG_VALUE_NONEXISTANT);
			e.printStackTrace();
		}
	}
	
	public static void logFatal(String m, ErrorCodes errCode) {
		System.err.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [FATAL] "+m);
		System.exit(errCode.getErrCode());
	}
	
	public static void logDebug(String m) {
		try {
			String level = Config.getValue("LogLevel").getValue().trim().toUpperCase();
			if (level.equals("DEBUG")) {
				System.out.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [DEBUG] "+m);
			}
		} catch (ConfigValueNotFoundException e) {
			logFatal(e.getMessage(), ErrorCodes.CONFIG_VALUE_NONEXISTANT);
			e.printStackTrace();
		}
	}
}
