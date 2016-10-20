package cz.eNcoo.AdvancedReport;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MySQL {
	public static Connection connection;
	private static String host;
	private static int port;
	private static String user;
	private static String pass;
	private static String db;

	public void ConfigDB() {
		File file = new File("/home/mc/configs/database_reports.yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Configuration config = YamlConfiguration.loadConfiguration(file);
		host = config.getString("host");
		port = config.getInt("port");
		user = config.getString("user");
		pass = config.getString("pass");
		db = config.getString("db");
	}

	public static synchronized void openConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
