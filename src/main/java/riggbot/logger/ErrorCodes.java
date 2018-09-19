package riggbot.logger;

public enum ErrorCodes {
	NO_CONFIG(1),
	LOGIN_EXCEPTION(2), 
	ILLEAGE_ARGS(3),
	CONFIG_NO_ACCESS(4);
	
	private final int errCode;

	ErrorCodes(int errCode) {
		this.errCode = errCode;
	}

	protected int getErrCode() {
		return errCode;
	}
}
