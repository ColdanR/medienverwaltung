package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class DataBaseManager {
	/**
	 * ResourceBundle für Daten der Datenbankverbindung
	 */
	private	static	ResourceBundle	db			=	ResourceBundle.getBundle("database");
	private static	String			sqlConnect	=	"";
	
	private enum SqlServers {
		MySQL ("com.mysql.jdbc.Driver", "jdbc:mysql://", "mysql");
		
		private	String	driver		=	"";
		private	String	connectPart	=	"";
		private	String	name		=	"";
		
		private SqlServers (String driver, String connectPart, String name) {
			this.driver			=	driver;
			this.connectPart	=	connectPart;
			this.name			=	name;
		}
		
		public String getDriver() {
			return driver;
		}
		
		public String getconnectPart() {
			return connectPart;
		}
		
		public String getName() {
			return name;
		}
		
		public static SqlServers getServerByName(String name) {
			for (SqlServers value : SqlServers.values()) {
				if (name.equals(value.getName())) {
					return value;
				}
			}
			return null;
		}
	}
	
	static {
		try {
			SqlServers	server	=	SqlServers.getServerByName(db.getString("dbDriver"));
			Class.forName(server.getDriver());
			sqlConnect			=	server.getconnectPart() + db.getString("dbHost") + "/" + db.getString("dbName");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the Connection object
	 * @return the connection object
	 * @throws SQLException Connection refused
	 */
	protected Connection getConnection () throws SQLException {
		return DriverManager.getConnection(sqlConnect, db.getString("dbUser"), db.getString("dbPassword"));
	}
}
