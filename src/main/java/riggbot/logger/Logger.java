package riggbot.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	
	public static void logInfo(String m) {
		System.out.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [INFO] "+m);
	}
	public static void logWarn(String m) {
		System.err.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [WARN] "+m);
	}
	public static void logFatal(String m) {
		System.err.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [FATAL] "+m);
	}
	public static void logDebug(String m) {
		System.out.println("["+new SimpleDateFormat("HH:mm:ss").format(new Date().getTime())+"] [Riggbot] [DEBUG] "+m);
	}
}
