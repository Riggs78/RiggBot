package riggbot.logger;

public enum LoggingSections {

	MAIN("Main"),
	CONFIG("Config"),
	COMMAND("Command");
	
	private final String sec;
	
	private LoggingSections(String sec) {
		this.sec = sec;
	}
	
	public String getSection() {
		return sec;
	}
	
}
