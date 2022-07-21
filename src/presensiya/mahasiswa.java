package presensiya;
import java.sql.*;


public class mahasiswa {
	
	String nim;
	String name;
	String prodi; 
	String email;
	int akun_id;
	
	public int getAkun_id() {
		return akun_id; 
	}
	public void setAkun_id(int akun_id) {
		this.akun_id = akun_id;
	}
		public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		public String getProdi() {
		return prodi;
	}
	public void setProdi(String prodi) {
		this.prodi = prodi;
	}
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}


		public static void main(String[] args) throws SQLException{
		String databaseURL = "jdbc:sqlite:D:/Database/SQLite/presensiya1.db";
		
		System.out.println("View Data Mahasiswa:");
		System.out.println("   NIM  ||       NAME         ||PRODI||   EMAIL    ");
		try {
			Connection connection = DriverManager.getConnection(databaseURL);
		    String sql = "SELECT * FROM Mahasiswa";
			Statement statement = connection.createStatement();
		    ResultSet result = statement.executeQuery(sql);

		 while (result.next()) {
			 String NIM = result.getString("nim");
			 String NAME = result.getString("name");
			 String PRODI = result.getString("prodi");
			 String EMAIL = result.getString("email");
			System.out.println(NIM + "||" +NAME + "||" +PRODI +"   ||" + EMAIL);
					    	
			  }
		 connection.close();
					    	
			   }catch(SQLException e) {
					 	e.printStackTrace();
			}
	 	}
	}