package presensiya;
import java.sql.*;
public class dosen {
	
	String name;
	String nidn;
	String mata_kuliah;
	String email;
	int akun_id;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNidn() {
		return nidn;
	}

	public void setNidn(String nidn) {
		this.nidn = nidn;
	}

	public String getMata_kuliah() {
		return mata_kuliah;
	}

	public void setMata_kuliah(String mata_kuliah) {
		this.mata_kuliah = mata_kuliah;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAkun_id() {
		return akun_id;
	}

	public void setAkun_id(int akun_id) {
		this.akun_id = akun_id;
	}

	
	
	public static void main(String[] args) throws SQLException{
	String databaseURL = "jdbc:sqlite:D:/Database/SQLite/presensiya1.db";
	
	System.out.println("View Data Dosen:");
	System.out.println("       NAME       ||   NIDN   ||MK  ||   EMAIL    ");
	try {
		Connection connection = DriverManager.getConnection(databaseURL);
	    String sql = "SELECT * FROM dosen";
		Statement statement = connection.createStatement();
	    ResultSet result = statement.executeQuery(sql);

	 while (result.next()) {
		 String NAME = result.getString("name");
		 String NIDN = result.getString("nidn");
		 String MK = result.getString("mata_kuliah");
		 String EMAIL = result.getString("email");
		System.out.println(NAME + "||" + NIDN + "||" + MK +" ||" + EMAIL);
				    	
		  }
	 connection.close();
				    	
		   }catch(SQLException e) {
				 	e.printStackTrace();
		    }
				    		
		}
	}