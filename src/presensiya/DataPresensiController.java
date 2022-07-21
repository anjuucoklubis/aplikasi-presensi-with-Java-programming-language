
//FUNGSI MENGIMPORT PACKAGE JAVA.SQL
package presensiya;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class DataPresensiController {

//FUNGSI MEMANGGIL DRIVER JDBC
	public Connection connect() {
		Connection connect = null;
		try {
			
			connect = DriverManager.getConnection("jdbc:sqlite:lib//presensiya1.db");

		
		} catch (Exception e) {
			System.out.println(e);
		}
		return connect;
	}

// Fungsi LOGIN
	boolean login(String username, String password) {
		String query = "Select username , password from akun where username=? and password =?";
		try {
			Connection connect = this.connect();
			PreparedStatement stmt = connect.prepareStatement(query); 
			stmt.setString(1, username); 
			stmt.setString(2, password);
			
;			ResultSet rs = stmt.executeQuery(); 
			
		
			
			
		
		
			if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
				
				return true;
			}else {
				return false;
			}

			
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	// fungsi untuk mengambil seluruh data pada tabel mahasiswa
	public void FindAllDataPresensiMahasiswa() {
		String query = "Select * from System";
		try {
			Connection connect = this.connect();
			PreparedStatement stmt = connect.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("nim") + "\t" + rs.getString("name") + "||\t" + rs.getString("prodi")
						+ "  ||\t" + rs.getString("email") + "    ||\t" + rs.getString("sesi_1") + "\t"
						+ rs.getString("sesi_2") + "\t" + rs.getString("sesi_3") + "\t" + rs.getString("sesi_4") + "\t"
						+ rs.getString("sesi_5") + "\t" + rs.getString("sesi_6") + "\t" + rs.getString("sesi_7") + "\t"
						+ rs.getString("sesi_8") + "\t" + rs.getString("sesi_9") + "\t" + rs.getString("sesi_10") + "\t"
						+ rs.getString("sesi_11") + "\t" + rs.getString("sesi_12") + "\t" + rs.getString("sesi_13")
						+ "\t" + rs.getString("total_keseluruhan"));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// fungsi untuk mengambil data salah satu mahasiswa berdasarkan nim
	public void SearchAndFindNim(String nim) {
		String query = "Select * from System where nim =?";
		try {
			Connection connect = this.connect();
			PreparedStatement stmt = connect.prepareStatement(query);
			stmt.setString(1, nim);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("nim") + "\t" + rs.getString("name") + "\t" + rs.getString("prodi")
						+ "\t" + rs.getString("email") + "\t" + rs.getString("sesi_1") + "\t" + rs.getString("sesi_2")
						+ "\t" + rs.getString("sesi_3") + "\t" + rs.getString("sesi_4") + "\t" + rs.getString("sesi_5")
						+ "\t" + rs.getString("sesi_6") + "\t" + rs.getString("sesi_7") + "\t" + rs.getString("sesi_8")
						+ "\t" + rs.getString("sesi_9") + "\t" + rs.getString("sesi_10") + "\t"
						+ rs.getString("sesi_11") + "\t" + rs.getString("sesi_12") + "\t" + rs.getString("sesi_13")
						+ "\t" + rs.getString("total_keseluruhan"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	// MAHASISWA
	public void FindTotalPerMahasiswa(String nim) {
		
		int total_sesi = 932;
		float persenan;
		String stat = "Aman";
	    String query = "select Mahasiswa.nim,Mahasiswa.name,Mahasiswa.prodi,Mahasiswa.email,total_keseluruhan from System join Mahasiswa on Mahasiswa.nim=System.nim where Mahasiswa.nim = ?";
		try {
			Connection connect = this.connect();
			
			PreparedStatement stmt = connect.prepareStatement(query);
			stmt.setString(1, nim);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				persenan = (Integer.valueOf(rs.getString("total_keseluruhan"))*100 / total_sesi);
				
				if (persenan < 70) {
					stat = "Anda Perlu Pembinaan";
				} else {
					stat = "Anda Aman";
				}
				System.out.println( rs.getString("nim")+ "\t" + rs.getString("name") + "\t" + rs.getString("prodi") + "\t"
						+ rs.getString("email") + "\tTotal Kehadiran anda =" + rs.getString("total_keseluruhan") + "(menit)\tPersenan Kehadiran = " + persenan 
						+ "\t Status = "
						+ stat + "\t");
				
				
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	mahasiswa findMahasiswa(String nim) {
		mahasiswa mhs = new mahasiswa();
	
		int total_sesi = 932;
		float persenan;
		String stat = "Aman";
		String query = "select Mahasiswa.nim,Mahasiswa.name,Mahasiswa.prodi,Mahasiswa.email,total_keseluruhan from System join Mahasiswa on Mahasiswa.nim=System.nim where Mahasiswa.nim = ?";
		try {
			Connection connect = this.connect();
			
			PreparedStatement stmt = connect.prepareStatement(query);
			stmt.setString(1, nim);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				persenan = (Integer.valueOf(rs.getString("total_keseluruhan"))*100 / total_sesi) ;
				if (persenan < 70) {
					stat = "Anda Perlu Pembinaan";
				} else {
					stat = "Anda Aman";
				}
				System.out.println(rs.getString("nim")+ "\n" + rs.getString("name") + "\n" + rs.getString("prodi") + "\n"
						+ rs.getString("email") + "\nTotal Kehadiran anda =" + rs.getString("total_keseluruhan") + "(menit)\nPersenan Kehadiran = " + persenan 
						+ "\n Status = "
						+ stat + "\t");
				
				mhs.setNim(rs.getString("nim"));
				mhs.setName(rs.getString("name"));
				mhs.setProdi(rs.getString("prodi"));
				mhs.setEmail(rs.getString("email"));
				mhs.setAkun_id(rs.getInt("akun_id"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mhs;
	}
	
	
	// UNTUK DOSEN
	public void FindAllTotal() {
		int total_sesi = 932;
		float persenan;	
		String stat = "Aman";
		String query = "select Mahasiswa.nim,Mahasiswa.name,Mahasiswa.prodi,Mahasiswa.email,total_keseluruhan from System join Mahasiswa on Mahasiswa.nim=System.nim";
		try {
			Connection connect = this.connect();
			PreparedStatement stmt = connect.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				persenan = (Integer.valueOf(rs.getString("total_keseluruhan"))*100 / total_sesi) ;
				if (persenan < 70) {
					stat = "Perlu Pembinaan";
				} else {
					stat = "Aman";
				}
				System.out.println(rs.getString("nim")+ "\t" + rs.getString("name") + "\t" + rs.getString("prodi") + "\t"
						+ rs.getString("email") + "\t" + rs.getString("total_keseluruhan") + "\t" + persenan +"\t"
						+ stat + "\t");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void FindMaxTotalPresensi() {
		int total_sesi = 932;
		float persenan;	
		String stat = "Aman";
		String query = "Select * FROM System order by total_keseluruhan DESC";
		try {
			Connection connect = this.connect();
			PreparedStatement stmt = connect.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				persenan = (Integer.valueOf(rs.getString("total_keseluruhan"))*100 / total_sesi) ;
				if (persenan < 70) {
					stat = "Perlu Pembinaan";
				} else {
					stat = "Aman";
				}
				System.out.println(rs.getString("nim")+ "\t" + rs.getString("name") + "\t" + rs.getString("prodi") + "\t"
						+ rs.getString("email") + "\t" + rs.getString("total_keseluruhan") + "\t" + persenan + "\t"
						+ stat + "\t");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		}
		public void FindMinTotalPresensi() {
			int total_sesi = 932;
			float persenan;	
			String stat = "Aman";
			String query = "Select * FROM System order by total_keseluruhan ASC";
			try {
				Connection connect = this.connect();
				PreparedStatement stmt = connect.prepareStatement(query);

				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					persenan = (Integer.valueOf(rs.getString("total_keseluruhan"))*100 / total_sesi) ;
					if (persenan < 70) {
						stat = "Perlu Pembinaan";
					} else {
						stat = "Aman";
					}
					System.out.println(rs.getString("nim")+ "\t" + rs.getString("name") + "\t" + rs.getString("prodi") + "\t"
							+ rs.getString("email") + "\t" + rs.getString("total_keseluruhan") + "\t" + persenan + "\t"
							+ stat + "\t");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		
	}

		public void infoTimePresensi(){
			String query = "Select * from Presensi";
			try {
				Connection connect = this.connect();
				PreparedStatement stmt = connect.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("sesi") + "\t" + rs.getString("start_metting") 
							
							+ "\t" + rs.getString("end_metting"));
				
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
			
		
}


