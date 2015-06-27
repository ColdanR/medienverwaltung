package enums;


public enum DatabaseErrors implements ErrorMessage {
	NoDBAvailable("Datenbank nicht verfuegbar."),
	UnableToRead("Es konnte nicht aus der Datenbank gelesen werden."),
	UnableToDelete("Der Datensatz konnte nicht aus der Datenbank geloescht werden."),
	UnableToWrite("Das Schreiben in die Datenbank ist fehlgeschlagen.");
	
	String errorMessage = "";
	
	private DatabaseErrors(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

}
