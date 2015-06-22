package data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author source Generator
 *
 */
public class Album {
	private	int								id					=	0;
	private	Person							kuenstler			=	null;
	private	String							name				=	"";
	private	LocalDate						erscheinungsdatum	=	null;
	private	List<SpeicherFormatInterface>	speicherformate		=	new ArrayList<SpeicherFormatInterface>();
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the kuenstler
	 */
	public Person getKuenstler() {
		return kuenstler;
	}
	/**
	 * @param kuenstler the kuenstler to set
	 */
	public void setKuenstler(Person kuenstler) {
		this.kuenstler = kuenstler;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the erscheinungsdatum
	 */
	public LocalDate getErscheinungsdatum() {
		return erscheinungsdatum;
	}
	/**
	 * @param erscheinungsdatum the erscheinungsdatum to set
	 */
	public void setErscheinungsdatum(LocalDate erscheinungsdatum) {
		this.erscheinungsdatum = erscheinungsdatum;
	}
	public List<SpeicherFormatInterface> getSpeicherformate() {
		return speicherformate;
	}
	public void setSpeicherformate(List<SpeicherFormatInterface> speicherformate) {
		this.speicherformate = speicherformate;
	}
}
