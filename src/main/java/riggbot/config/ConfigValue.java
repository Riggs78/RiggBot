package riggbot.config;

public class ConfigValue {

	private final ConfigTypes type;
	private final String value;
	private final String defaultValue;
	private final String desc;
	private final String name;

	public ConfigValue(ConfigTypes type, String name, String value, String defVal, String desc) {
		this.type = type;
		this.value = value;
		this.defaultValue = defVal;
		this.desc = desc;
		this.name = name;
	}

	protected ConfigTypes getType() {
		return type;
	}

	protected String getValue() {
		return value;
	}

	protected String getDefaultValue() {
		return defaultValue;
	}

	protected String getDesc() {
		return desc;
	}

	public String getName() {
		return name;
	}

}
