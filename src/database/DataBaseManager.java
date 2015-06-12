package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class DataBaseManager {
	/**
	 * ResourceBundle für Daten der Datenbankverbindung
	 */
	private static ResourceBundle db = ResourceBundle.getBundle("database");
	
	/**
	 * Instance Constructor
	 * @throws ClassNotFoundException
	 */
	public DataBaseManager() throws ClassNotFoundException {
		Class.forName(db.getString("databaseClass"));
	}
	
	/**
	 * Gets the Connection object
	 * @return the connection object
	 * @throws SQLException Connection refused
	 */
	protected static Connection getConnection () throws SQLException {
		return DriverManager.getConnection(db.getString("databaseConnection") + 
				db.getString("dbName") + "?user=" + db.getString("dbUser") + 
				"&password=" + db.getString("dbPassword"));
	}
	
	public abstract Object read(int id);
	
	public abstract boolean write(Object object);
}
