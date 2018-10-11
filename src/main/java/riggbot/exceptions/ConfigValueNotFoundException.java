package riggbot.exceptions;

public class ConfigValueNotFoundException extends Exception{
	
	private static final long serialVersionUID = 696969L;

	public ConfigValueNotFoundException() {
		super();
	}
	
	public ConfigValueNotFoundException(String reason) {
		super(reason);
	}
}
