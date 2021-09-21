import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

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

				System.out.println(resultSet.getLong("id") + " --- " + resultSet.getString("name") + " -----  "
						+ resultSet.getInt("salary"));
			}
			System.out.println("\nTotal Salary : " + totalSalary);

			// inserting
			int rowsAffected_insert = statement.executeUpdate(
					"insert into employees_tbl (name, dept, salary) values('Rohit', 'Project manager', 850000)");
			System.out.println("Insert Statement -> rows affected : " + rowsAffected_insert);

			// updating
			int rowsAffected_update = statement
					.executeUpdate("update  employees_tbl SET salary = 70000 WHERE id = 101");
			System.out.println("Update Statement -> rows affected : " + rowsAffected_update);

			// deleting
			int rowsAffected_delete = statement.executeUpdate("delete from employees_tbl where id = 111");
			System.out.println("Delete Statement ->  rows affected : " + rowsAffected_delete);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
