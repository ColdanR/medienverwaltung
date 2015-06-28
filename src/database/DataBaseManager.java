package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public abstract class DataBaseManager {
	private 	static	String	sqlConnect	=	"";
	private		static	String	username	=	"";
	private		static	String	password	=	"";
	protected	static	boolean	noErrors	=	false;
	
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
			ResourceBundle	db		=	ResourceBundle.getBundle("database");
			SqlServers		server	=	SqlServers.getServerByName(db.getString("dbDriver"));
			sqlConnect				=	server.getconnectPart() + db.getString("dbHost") + "/" + db.getString("dbName");
			username				=	db.getString("dbUser");
			password				=	db.getString("dbPassword");
			Class.forName(server.getDriver());
			noErrors = true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (MissingResourceException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (LinkageError e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the Connection object
	 * @return the connection object
	 * @throws SQLException Connection refused
	 */
	protected final Connection getConnection () throws SQLException {
		return DriverManager.getConnection(sqlConnect, username, password);
	}
}
