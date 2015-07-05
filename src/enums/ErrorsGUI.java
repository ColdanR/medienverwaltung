package enums;

public enum ErrorsGUI implements ErrorMessage {
	NoSelection("Es wurde kein Element der Liste ausgewaehlt.")
	;

	private	String errorMessage;
	
	private ErrorsGUI(String error) {
		this.errorMessage = error;
	}
	
	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

}
