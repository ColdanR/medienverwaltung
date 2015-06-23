package database;

import java.util.ArrayList;
import java.util.List;

import data.SpeicherFormatInterface;

public class DBSpeicherFormat extends DataBaseManager {

	public DBSpeicherFormat() throws ClassNotFoundException {
		super();
	}
	
	public SpeicherFormatInterface getForId(int id) {
		// TODO Write this
		return null;
	}
	
	public boolean write (SpeicherFormatInterface speicherformat) {
		// TODO Write this
		return false;
	}
	
	public List<SpeicherFormatInterface> getSpeicherFormateForMusik (int musikId) {
		List<SpeicherFormatInterface> ret = new ArrayList<SpeicherFormatInterface>();
		// TODO Write this
		return ret;
	}
	
	public boolean writeListForMusik (List<SpeicherFormatInterface> list, int songId) {
		// TODO Write this
		return false;
	}
	
	public List<SpeicherFormatInterface> getSpeicherFormateForAlbum (int albumId) {
		List<SpeicherFormatInterface> ret = new ArrayList<SpeicherFormatInterface>();
		// TODO Write this
		return ret;
	}
	
	public boolean writeListForAlbum (List<SpeicherFormatInterface> list, int albumId) {
		// TODO Write this
		return false;
	}
}
