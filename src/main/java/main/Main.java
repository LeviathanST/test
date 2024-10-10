import java.sql.*;

public class Main {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/member-management",
					"root",
					"admin");

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from accounts");

			while (rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("password"));
			}
			;

			System.out.println("Connection successfully!");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
