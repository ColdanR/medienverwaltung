package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.SpeicherFormatInterface;
import data.speicherformate.DigitalMusik;

public class DBSpeicherFormat extends DataBaseManager {
	
	public SpeicherFormatInterface getForId(int id) {	
		DigitalMusik ret = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			String sql = "SELECT A.ID, A.DATENTRAEGER, A.PFAD, A.FORMAT, A.QUALITAET "
					   + "FROM MUSIKDIGITAL A "
					   + "WHERE A.ID = ?";
			
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			// Erster Index ist immer 1 bei SQL Befehlen!
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			if (result.next()) {
				ret = new DigitalMusik();
				ret.setId(result.getInt(1));
				ret.setDatentraeger(result.getString(2));
				ret.setPfad(result.getString(3));
				ret.setFormat(result.getString(4));
				ret.setQualitaet(result.getString(4));
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
	
	public boolean write (SpeicherFormatInterface speicherformat, int titelId) throws UnsupportedOperationException {
		boolean ret = false;
		Connection conn = null;
		try {
			conn = getConnection();
			switch (speicherformat.getType()) {
			case DigitalMusik:
				ret = writeDigitalMusik(conn, (DigitalMusik) speicherformat, titelId);
				break;
			default:
				throw new UnsupportedOperationException("Methode noch nicht implementiert!");
			}
		} catch (ClassCastException | SQLException e) {
			ret = false;
		} finally {
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

	public List<SpeicherFormatInterface> getSpeicherFormateForTitel (int titelId) {
		List<SpeicherFormatInterface> formatlist = new ArrayList<SpeicherFormatInterface>();
				
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		try {
			String sql = "SELECT B.ID, B.DATENTRAEGER, B.PFAD, B.FORMAT, B.QUALITAET "
					   + "FROM TITEL_MUSIKDIGITAL A "
					   + "LEFT OUTER JOIN MUSIKDIGITAL B ON A.MUSIKDIGTAL_ID = B.ID"
					   + "WHERE A.TITEL_ID = ?";
			
			conn = getConnection();
			stmt = conn.createStatement();
			
			result = stmt.executeQuery(sql);
			while (result.next()) {
				DigitalMusik dimu = new DigitalMusik();
				dimu.setId(result.getInt(1));
				dimu.setDatentraeger(result.getString(2));
				dimu.setPfad(result.getString(3));
				dimu.setFormat(result.getString(4));
				dimu.setQualitaet(result.getString(5));
				formatlist.add(dimu);
			}
		} catch (SQLException e) {
			formatlist = null;
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
		return formatlist;
	}
	
	public boolean writeList(List<SpeicherFormatInterface> list, int titelId) throws UnsupportedOperationException {
		boolean ret = false;
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			for (SpeicherFormatInterface speicherformat : list) {
				switch (speicherformat.getType()) {
				case DigitalMusik:
					ret = ret && writeDigitalMusik(conn, (DigitalMusik) speicherformat, titelId);
					break;
				default:
					throw new UnsupportedOperationException("Methode noch nicht implementiert!");
				}
			}
			if (ret) {
				conn.commit();
			}
			conn.setAutoCommit(true);
		} catch (ClassCastException | SQLException e) {
			e.printStackTrace();
			ret = false;
		} finally {
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
	
	private boolean writeDigitalMusik(Connection conn, DigitalMusik speicherformat, int titelId) {
		boolean ret = false;
		if ((speicherformat == null) || (titelId == 0) || conn == null) {
			return false;
		}
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			if (speicherformat.getId() == 0) {
				String sql = "INSERT INTO MUSIKDIGITAL (`DATENTRAEGER`, `PFAD`, `FORMAT`, `QUALITAET`) "
						   + "VALUES (?, ?, ?, ?)";
				conn = getConnection();
				stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, speicherformat.getDatentraeger());
				stmt.setString(2, speicherformat.getPfad());
				stmt.setString(3, speicherformat.getFormat());
				stmt.setString(4, speicherformat.getQualitaet());
				stmt.execute();
				result = stmt.getGeneratedKeys();
				if (result.next()) {
					speicherformat.setId(result.getInt(1));
					ret = true;
				}
				stmt.close();
				String sql2 = "INSERT INTO `TITEL_MUSIKDIGITAL` (`TITEL_ID`, `MUSIKDIGTAL_ID`) VALUES (?, ?);";
				stmt = conn.prepareStatement(sql2);
				stmt.setInt(1, titelId);
				stmt.setInt(2, speicherformat.getId());
				stmt.execute();
			} else {
				String sql = "UPDATE PERSON "
						   + "SET `DATENTRAEGER` = ?, `PFAD` = ?, `FORMAT` = ?, `QUALITAET` = ? "
						   + "WHERE `ID` = ?";
				conn = getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, speicherformat.getDatentraeger());
				stmt.setString(2, speicherformat.getPfad());
				stmt.setString(3, speicherformat.getFormat());
				stmt.setString(4, speicherformat.getQualitaet());
				stmt.execute();
				ret = true;
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

	public boolean delete(SpeicherFormatInterface object) {
		if (object == null)  {
			return false;
		}
		Connection conn = null;
		boolean ret = false;
		try {
			conn = getConnection();
			switch (object.getType()) {
			case DigitalMusik:
				if (object instanceof DigitalMusik) {
					ret = deleteMusikDigital(conn, (DigitalMusik)object);
				}
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	private boolean deleteMusikDigital(Connection conn, DigitalMusik object) {
		boolean ret = false;
		if (conn == null || object == null) {
			return false;
		}
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM TITEL_MUSIKDIGITAL WHERE MUSIKDIGITAL_ID = ?";
			String sql2 = "DELETE FROM MUSIKDIGITAL WHERE ID = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,object.getId());
			stmt.execute();
			stmt.close();
			stmt = conn.prepareStatement(sql2);
			stmt.setInt(1,object.getId());
			stmt.execute();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	
	public boolean deleteList(List<SpeicherFormatInterface> list) {
		boolean ret = false;
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			for (SpeicherFormatInterface speicherformat : list) {
				switch (speicherformat.getType()) {
				case DigitalMusik:
					ret = ret && deleteMusikDigital(conn, (DigitalMusik) speicherformat);
					break;
				default:
					throw new UnsupportedOperationException("Methode noch nicht implementiert!");
				}
			}
			if (ret) {
				conn.commit();
			}
			conn.setAutoCommit(true);
		} catch (ClassCastException | SQLException e) {
			e.printStackTrace();
			ret = false;
		} finally {
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
