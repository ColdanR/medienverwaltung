/**
 * 
 */
package data.speicherformate.logic;

import java.util.ArrayList;
import java.util.List;

import data.DatenLogik;
import data.SpeicherFormatInterface;
import database.DBSpeicherFormat;
import enums.ErrorMessage;
import enums.ErrorsSpeicherFormateLogik;

/**
 * Klasse zur Abhandlung der Logik für Speicherformate
 * @author Bernd Schmidt
 *
 */
public class SpeicherFormateLogik implements DatenLogik<SpeicherFormatInterface> {
	private	SpeicherFormatInterface	object	=	null;
	private	int						titelId	=	0;
	private	List<ErrorMessage>		errors	=	new ArrayList<ErrorMessage>();
	
	public SpeicherFormateLogik(int titelId) {
		this.titelId = titelId;
	}

	@Override
	public boolean delete() {
		DBSpeicherFormat	dbLogik	=	new DBSpeicherFormat();
		if (object == null) {
			errors.add(ErrorsSpeicherFormateLogik.NoObjectLoaded);
			return false;
		}
		if (!dbLogik.delete(object)) {
			errors.add(ErrorsSpeicherFormateLogik.UnableToDelete);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean write() {
		DBSpeicherFormat	dbLogik	=	new DBSpeicherFormat();
		if (object == null) {
			errors.add(ErrorsSpeicherFormateLogik.NoObjectLoaded);
			return false;
		}
		if (!dbLogik.write(object, titelId)) {
			errors.add(ErrorsSpeicherFormateLogik.UnableToDelete);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean loadObject(int id) {
		DBSpeicherFormat	dbLogik	=	new DBSpeicherFormat();
		object = dbLogik.getForId(id);
		if (!dbLogik.delete(object)) {
			errors.add(ErrorsSpeicherFormateLogik.UnableToDelete);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public SpeicherFormatInterface getObject() {
		return object;
	}

	@Override
	public List<SpeicherFormatInterface> getAll() {
		throw new UnsupportedOperationException("Dieser Befehl wird nicht unterstützt!");
	}

	@Override
	public List<ErrorMessage> getErrors() {
		return errors;
	}

	public int getTitelId() {
		return titelId;
	}

	public void setTitelId(int titelId) {
		this.titelId = titelId;
	}
}
