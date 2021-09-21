import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		
		// url pattern - jdbc:mysql://ip address/database_name;

		String url = "jdbc:mysql://127.0.0.1:3306/employees_database";

		try {

			// Establish connection Object
			Connection conn = DriverManager.getConnection(url, "rohit", "12345");

			// create a statement object to send to the database
			Statement statement = conn.createStatement();

			// Execute the statement object

			ResultSet resultSet = statement.executeQuery("select * from employees_tbl");

			// Process the result
			int totalSalary = 0;
			while (resultSet.next()) {

				totalSalary += resultSet.getInt("salary");
				System.out.println(resultSet.getString("name") + " -----  " + resultSet.getInt("salary"));
			}

			System.out.println("Total Salary : " + totalSalary);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
