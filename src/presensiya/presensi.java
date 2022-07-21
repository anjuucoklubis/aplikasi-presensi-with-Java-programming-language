package presensiya;


import java.sql.*;
public class presensi {
	
	String sesi;
	String start_metting;
	String end_meeting;
	
	public String getSesi() {
		return sesi;
	}

	public void setSesi(String sesi) {
		this.sesi = sesi;
	}

	public String getStart_metting() {
		return start_metting;
	}

	public void setStart_metting(String start_metting) {
		this.start_metting = start_metting;
	}

	public String getEnd_meeting() {
		return end_meeting;
	}

	public void setEnd_meeting(String end_meeting) {
		this.end_meeting = end_meeting;
	}

	public static void main(String[] args) throws SQLException{
	String databaseURL = "jdbc:sqlite:D:/Database/SQLite/presensiya1.db";
	
	System.out.println("View Data Presensi:");
	System.out.println("");
	System.out.println("SESI||STAR MEETING||END MEETING");
	System.out.println("");
	try {
		Connection connection = DriverManager.getConnection(databaseURL);
	    String sql = "SELECT * FROM Presensi";
		Statement statement = connection.createStatement();
	    ResultSet result = statement.executeQuery(sql);

	 while (result.next()) {
		 Integer SESI = result.getInt("sesi");
		 String SM = result.getString("start_metting");
		 String MK = result.getString("end_metting");
	
		System.out.println(SESI + "||" + SM + "||" + MK +" ||");
				    	
		  }
	 connection.close();
				    	
		   }catch(SQLException e) {
				 	e.printStackTrace();
		   }
	}
}