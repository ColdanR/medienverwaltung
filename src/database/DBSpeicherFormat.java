package database;

import java.util.ArrayList;
import java.util.List;

import data.SpeicherFormatInterface;
import data.speicherformate.DigitalMusik;

public class DBSpeicherFormat extends DataBaseManager {
	
	public SpeicherFormatInterface getForId(int id) {
		// TODO Write this
		return null;
	}
	
	public boolean write (SpeicherFormatInterface speicherformat, int titelId) throws UnsupportedOperationException {
		try {
			switch (speicherformat.getType()) {
			case DigitalMusik:
				return writeDigitalMusik((DigitalMusik) speicherformat, titelId);
			case Blueray:
			case CD:
			case DVD:
			case DigitalBuch:
			case DigitalFilm:
			case Schallplatte:
			default:
				throw new UnsupportedOperationException("Methode noch nicht implementiert!");
			}
		} catch (ClassCastException e) {
			return false;
		}
	}

	public List<SpeicherFormatInterface> getSpeicherFormateForTitel (int titelId) {
		List<SpeicherFormatInterface> ret = new ArrayList<SpeicherFormatInterface>();
		// TODO Write this
		return ret;
	}
	
	public boolean writeList(List<SpeicherFormatInterface> list, int titelId) throws UnsupportedOperationException {
		// TODO Write this
		return false;
	}
	
	private boolean writeDigitalMusik(DigitalMusik speicherformat, int titelId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(SpeicherFormatInterface object) {
		// TODO Auto-generated method stub
		return false;
	}
}
