import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableService extends Table implements ITableService {

	public void viewTables() {
		Connection myconn;
		try {
			myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "haslo");
			Statement st = myconn.createStatement();
			st.executeQuery("select * from `table`");
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				System.out.println("Numer stolika: " + rs.getString("tablenumber") + ", Liczba miejsc: " + (rs.getString("numberofseats") ));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public void deleteTable(int numberOfTable) {
		
		Connection myconn;
		try {
			myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "haslo");
			String sql = "delete from `table` where `tablenumber`=?";
			PreparedStatement stmt = myconn.prepareStatement(sql);
			stmt.setInt(1, numberOfTable);
		      stmt.executeUpdate();
		      System.out.println("Table deleted.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void addTable(int NumberOfSeats) {
		Connection myconn;
		try {
		
			myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "haslo");
			String sql = "INSERT INTO `table` " + " (`numberofseats`) " + " VALUES (?)";
			PreparedStatement mystmt = myconn.prepareStatement(sql);
			
			mystmt.setLong(1, numberOfSeats);
			mystmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
