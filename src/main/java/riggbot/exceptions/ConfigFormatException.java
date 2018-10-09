package riggbot.exceptions;

public class ConfigFormatException extends Exception{
	
	private static final long serialVersionUID = 6969L;

	public ConfigFormatException() {
		super();
	}
	
	public ConfigFormatException(String reason) {
		super(reason);
	}
}
