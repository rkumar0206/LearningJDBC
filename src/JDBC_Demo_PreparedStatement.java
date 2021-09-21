import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Demo_PreparedStatement {

	public static void main(String[] args) {

		/**
		 * PreparedStatement is a class in java.sql package which lets us write and
		 * execute query
		 */

		String url = "jdbc:mysql://127.0.0.1:3306/employees_database";

		try {

			Connection connection = DriverManager.getConnection(url, "rohit", "12345");

			// dynamically assign value for sql values

			String sqlQuery_insert = "insert into employees_tbl (name, dept, salary) values(? , ? , ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery_insert);

			preparedStatement.setString(1, "Ram");
			preparedStatement.setString(2, "Project manager");
			preparedStatement.setInt(3, 650000);

			// for inserting, deleting and updating we use executeUpdate();
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			System.out.println("Rows Affected = " + rowsAffected);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
