package riggbot.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import riggbot.config.Config;
import riggbot.exceptions.ConfigValueNotFoundException;

public class Logger {
	
	public static String stackTrace(Exception e) {
		StackTraceElement[] stack = e.getStackTrace();
		for (StackTraceElement s : stack) {
			logDebug(s.toString(), LoggingSections.CONFIG);
		}
		return "lol";
	}
	
	public static void logInfo(String m, LoggingSections l) {
		try {
			String level = Config.getValue("LogLevel").getValue().trim().toUpperCase();
			if (level.equals("INFO")||level.equals("DEBUG")) {
				System.out.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [" +l.getSection()+ "] [INFO] "+m);		
			}
		} catch (ConfigValueNotFoundException e) {
			logFatal(e.getMessage(), ErrorCodes.CONFIG_VALUE_NONEXISTANT, LoggingSections.CONFIG);
		}
	}
	
	public static void logWarn(String m, LoggingSections l) {
		try {
			String level = Config.getValue("LogLevel").getValue().trim().toUpperCase();
			if (level.equals("WARN")||level.equals("INFO")||level.equals("DEBUG")) {
				System.err.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [" +l.getSection()+ "] [WARN] "+m);		
			}
		} catch (ConfigValueNotFoundException e) {
			logFatal(e.getMessage(), ErrorCodes.CONFIG_VALUE_NONEXISTANT, LoggingSections.CONFIG);
			e.printStackTrace();
		}
	}
	
	public static void logFatal(String m, ErrorCodes errCode, LoggingSections l) {
		System.err.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [FATAL] "+m);
		System.exit(errCode.getErrCode());
	}
	
	public static void logDebug(String m, LoggingSections l) {
		try {
			String level = Config.getValue("LogLevel").getValue().trim().toUpperCase();
			if (level.equals("DEBUG")) {
				System.out.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [DEBUG] "+m);
			}
		} catch (ConfigValueNotFoundException e) {
			logFatal(e.getMessage(), ErrorCodes.CONFIG_VALUE_NONEXISTANT, LoggingSections.CONFIG);
			e.printStackTrace();
		}
	}
}
