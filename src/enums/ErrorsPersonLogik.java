package enums;


public enum ErrorsPersonLogik implements ErrorMessage {
	KeinNachname ("Kein Nachname uebergeben."),
	KeinVorname ("Kein Vorname uebergeben"),
	KeinKuenstlername("Kein Kuenstlername eingegeben")
	;
	
	private String	errorMessage	=	"";
	
	private ErrorsPersonLogik(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

}
