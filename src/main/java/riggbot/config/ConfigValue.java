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

	public ConfigTypes getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public String getDesc() {
		return desc;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Name:"+getName()+"; Type:"+getType()+"; Value:"+getValue()+"; DefaultValue:"+getDefaultValue()+"; Description:"+getDesc();
		
	}

}
