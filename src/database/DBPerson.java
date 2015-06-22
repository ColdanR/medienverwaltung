package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Person;

public class DBPerson extends DataBaseManager {

	public DBPerson() throws ClassNotFoundException {
		super();
	}
	
	public Person getPerson(int id) {
		Person ret = new Person();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			String sql = "SELECT id, nachname, vorname, kuenstlername FROM Person WHERE id = ?";
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			// Erster Index ist immer 1 bei SQL Befehlen!
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			if (result.next()) {
				ret.setId(result.getInt(1));
				ret.setNachname(result.getString(2));
				ret.setVorname(result.getString(3));
				ret.setKuenstlername(result.getString(4));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	
	public boolean writePerson(Person person) throws IllegalArgumentException {
		boolean ret = false;
		if (person == null) {
			throw new IllegalArgumentException();
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			if (person.getId() == 0) {
				String sql = "INSERT INTO Person (`nachname`, `vorname`, `kuenstlername`) VALUES (?, ?, ?)";
				conn = getConnection();
				stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, person.getNachname());
				stmt.setString(2, person.getVorname());
				stmt.setString(3, person.getKuenstlername());
				result = stmt.executeQuery();
				if (result.next()) {
					person.setId(result.getInt(1));
					ret = true;
				}
			} else {
				String sql = "UPDATE Person SET `nachname` = ?, `vorname` = ?, `kuenstlername` = ? WHERE `id` = ?";
				conn = getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, person.getNachname());
				stmt.setString(2, person.getVorname());
				stmt.setString(3, person.getKuenstlername());
				stmt.setInt(4, person.getId());
				ret = stmt.execute();
			}
			// Erster Index ist immer 1 bei SQL Befehlen!
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
}