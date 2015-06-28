package enums;

public enum ErrorsSpeicherFormateLogik implements ErrorMessage {
	NoObjectLoaded("Es ist kein Speicherformat gesetzt."),
	UnableToDelete("Das Speicherformat konnte nicht geloescht werden."),
	NoDatentraeger("Es wurde kein Datenträger eingegeben."),
	NoPfad("Es wurde kein Pfad eingegeben."),
	NoFormat("Es wurde kein Format eingegeben."),
	NoQualitaet("Es wurde keine Qualität eingegeben.")
	;
	private	String	errorMessage	=	"";

	private ErrorsSpeicherFormateLogik(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
