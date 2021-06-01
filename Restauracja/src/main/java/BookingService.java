import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingService extends Booking implements IBookingService {

	public void addBooking(String customerName, int numberOfPplBooking, int tableNumberBooked,
			int bookingTime, int amountOfTimeBooking) {
		Connection myconn;
		
		try {
			myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "haslo");
			String sql = "INSERT INTO `booking` " + " (`customername`, `numberofpplbooking`, `tablenumberbooked`, `bookingtime`, `amountoftimebooking` ) " +" VALUES (?,?,?,?,?)";
			PreparedStatement mystmt = myconn.prepareStatement(sql);
			mystmt.setString(1, customerName);
			mystmt.setLong(2, numberOfPplBooking);
			mystmt.setLong(3, tableNumberBooked );
			mystmt.setLong(4, bookingTime );
			mystmt.setLong(5, amountOfTimeBooking);
			mystmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteBooking(int numberOfBooking) {
		Connection myconn;
		try {
			myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "haslo");
			String sql = "delete from `booking` where `bookingnumber`=?";
			PreparedStatement stmt = myconn.prepareStatement(sql);
			stmt.setInt(1, numberOfBooking);
		      stmt.executeUpdate();
		      System.out.println("Booking deleted.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void viewBooking() {
		Connection myconn;
		try {
			myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "haslo");
			Statement st = myconn.createStatement();
			st.executeQuery("select * from `booking`");
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				System.out.println("Numer rezerwacji: " + rs.getString("bookingnumber") + ", Imiê klienta: " + rs.getString("customername") + " Liczba osób rezerwuj¹cych: " + rs.getString("numberofpplbooking") + " Numer stolika: " + rs.getString("tablenumberbooked") + " Godzina rezerwacji: " + rs.getString("bookingtime") + " Iloœæ godzin rezerwacji: " + rs.getString("amountoftimebooking" ));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
}
