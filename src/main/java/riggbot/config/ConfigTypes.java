package riggbot.config;

public enum ConfigTypes {
	STRING("S:"),
	INT("I:"),
	DOUBLE("D:"),
	BOOLEAN("B:");
	
	private final String type;

	ConfigTypes(String type){
		this.type = type;
	}
	
	protected String getType() {
		return type;
	}
}
