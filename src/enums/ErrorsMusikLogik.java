package enums;

public enum ErrorsMusikLogik implements ErrorMessage {
	NoKuenstler("Kein Kuenstler uebergeben."),
	NoTitel("Kein Titel vorhanden."),
	NoAlben("Kein Wert fuer die Alben erkannt."),
	NoMitwirkende("Kein Wert fuer die Mitwirkenden erkannt."),
	NoSpeicherworte("Keine Formate erkannt."),
	NotLoaded("Kein Titel geladen.");
	
	private	String	errorMessage	=	"";

	private ErrorsMusikLogik(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

}
