package enums;

public enum ErrorsSpeicherFormateLogik implements ErrorMessage {
	NoObjectLoaded("Es ist kein Speicherformat gesetzt."),
	UnableToDelete("Das Speicherformat konnte nicht geloescht werden.")
	;
	private	String	errorMessage	=	"";

	private ErrorsSpeicherFormateLogik(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
