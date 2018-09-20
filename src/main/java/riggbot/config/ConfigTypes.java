package riggbot.config;

public enum ConfigTypes {
	STRING("String"),
	INT("Integer"),
	DOUBLE("Double"),
	BOOLEAN("Boolean");
	
	private final String type;

	ConfigTypes(String type){
		this.type = type;
	}
	
	protected String getType() {
		return type;
	}
}
