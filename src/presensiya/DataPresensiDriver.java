package presensiya;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class DataPresensiDriver {

	private static final String Scanner = null;
	public static void main(String[] args) {
		Scanner sa = new Scanner(System.in);
		String pilihanUser;
		String username, password;
		boolean login = false;
		boolean isLanjutkan = true;
		boolean isLanjutkann = true;
		boolean isLanjutkannnn = true;
		boolean isLanjutkannnnn = true;
       
		JOptionPane.showMessageDialog(null, "    =====================================\n"
				+ "===   SELAMAT DATANG DI PRESENSIYA APP    ===\n" + "    =====================================");

		System.out.println("====== APLIKASI PRESENSIYA BOOM MEETING ======");
		System.out.println(" ");
		while (isLanjutkan) {
			System.out.println("");
			System.out.println(">>> LOGIN SEBAGAI <<< \n" + "1. DOSEN \n" + "2. MAHASISWA \n");
			System.out.print("PRES 1 FOR LOGIN AS DOSEN >>>\n" + "PRES 2 FOR LOGIN AS MAHASISWA >>> \n");
			System.out.print("[1]/[2]  : ");

			int menuLoginAs;
			Scanner sb = new Scanner(System.in);
			menuLoginAs = sa.nextInt();
			{
				switch (menuLoginAs) {
				// CASE 1: LOGIN AS DOSEN
				case 1:
					Scanner sc = new Scanner(System.in);

					System.out.println("");
					System.out.println(">>>>> LOGIN SEBAGAI DOSEN <<<<<");
					System.out.println("");

					System.out.print("Username :");
					username = sb.next();
					System.out.print("Password :");
					password = sb.next();

					if (new DataPresensiController().login(username, password)) {
						System.out.println(">> LOGIN SUCCES !!! <<");
						login = true;
					} else {
						System.out.println("");
						System.out.println(">>>>> LOGIN GAGAL!!! <<<<<");
						System.out.println(">>>>> SILAHKAN MEMASUKKAN USERNAME ATAU PASSWORD DENGAN BENAR!!! <<<<<");
						System.out.println("");
						break;
					}

					while (login) {
						System.out.println("");
						System.out.println("LIST MENU: \n\n" + "1. MENU DAFTAR HADIR PRESENSIYA MAHASISWA \n"
						        + "2. INFORMASI WAKTU PERSESI\n"
								+ "3. MENU DAFTAR HADIR PRESENSIYA MAHASISWA 1 ORANG \n" //"6. INFO TIME MEETING\n"
								+ "4. MENU TOTAL PRESENSIYA MAHASISWA \n" + "5. MENU MENAMPILKAN TOTAL PRESENSI URUTAN DARI YANG TERKECIL. \n" +"6. MENU MENAMPILKAN TOTAL PRESENSI URUTAN DARI YANG BANYAK\n" +"7. LOGOUT \n");

						System.out.print("==Pilih Menu yang anda Inginkan== : ");
                        
						// MENU DOSEN
						int menuDosen;
						Scanner sd = new Scanner(System.in);
						menuDosen = sd.nextInt();
						{
							switch (menuDosen) {
							case 1:
								Scanner sm = new Scanner(System.in);
								String ulang;
								do {
									System.out.println(">>>>> MENU DAFTAR HADIR PRESENSIYA MAHASISWA <<<<<");
									System.out.println("");
									System.out.println("=> DAFTAR KESELURUHAN :");
									System.out.println("__NIM_____||__________NAME________ ||_PRODI_||_________________EMAIL________________________||SESI 1||SESI 2|SESI 3||SESI 4|SESI 5||SESI 6||SESI 7||SESI 8||SESI 9||SESI 10||SESI 11||SESI 12||SESI 13||TOTAL KESELURUHAN||");
									(new DataPresensiController()).FindAllDataPresensiMahasiswa();
									System.out.println("");
									System.out.print("REFRESS press 'YES' , LANJUT press 'NO' ?  [YES|NO] ? :");

									pilihanUser = sm.next();
								} while (pilihanUser.equals("YES") || pilihanUser.equals("yes"));

								break;
								
							case 2:
								Scanner so = new Scanner(System.in);
								String ulango;
								do {
									System.out.println(">>>>> INFORMASI WAKTU PERSESI <<<<<");
									System.out.println("");
									System.out.println("=> DAFTAR KESELURUHAN :");
									System.out.println("SESI|START MEET|END MEET");
									(new DataPresensiController()).infoTimePresensi();
									System.out.println("");
									System.out.print("REFRESS press 'YES' , LANJUT press 'NO' ?  [YES|NO] ? :");

									pilihanUser = so.next();
								} while (pilihanUser.equals("YES") || pilihanUser.equals("yes"));

								break;
						
							case 3:
					    		Scanner sp=new Scanner(System.in);
					         	String ulangt;
					         	do {
					         		System.out.println(">>>>> Menu Daftar Hadir Presensiya Mahasiswa <<<<<");
					        	System.out.print("Masukkan NIM UNTUK MENCARI DETAIL PRESENSIYA 1 MAHASISWA :");
					            String nim=sb.next();
					            System.out.println("__NIM_____||__________NAME________ ||_PRODI_||_________________EMAIL________________________||SESI 1||SESI 2|SESI 3||SESI 4|SESI 5||SESI 6||SESI 7||SESI 8||SESI 9||SESI 10||SESI 11||SESI 12||SESI 13||TOTAL KESELURUHAN||");
					            (new DataPresensiController()).SearchAndFindNim(nim);
					        	System.out.println("========================================================================================================================================================================================================================== ");
					            System.out.print("INPUT NIM AGAIN ?  [YES|NO] ? :");
					            
					            ulangt = sp.next();
					            }
					         	while(ulangt.equals("YES") || ulangt.equals("yes")); 
					        
					        	
					        	break;
					        	

								
							case 4:
								Scanner sj = new Scanner(System.in);
								do {
									System.out.println(">>>>> MENU TOTAL PRESENSIYA MAHASISWA <<<<<:");
									System.out.println("");
									System.out.println("=> DAFTAR KESELURUHAN :");
									System.out.println(
											"__NIM_____||__________NAME________ ||_PRODI_||____________________EMAIL_______________________|TOTAL KESELURUHAN|PERSENTASI|KETERANGAN||");

									(new DataPresensiController()).FindAllTotal();
									System.out.println("");
									System.out.print("REFRESS press 'YES' , LANJUT press 'NO' ?  [YES|NO] ? :");

									pilihanUser = sj.next();
								} while (pilihanUser.equals("YES") || pilihanUser.equals("yes"));

								break;
								
							case 5:
								Scanner sq = new Scanner(System.in);
								do {
									System.out.println(">>>>> MENU MENAMPILKAN TOTAL PRESENSI URUTAN DARI YANG TERKECIL <<<<<:");
									System.out.println("");
									System.out.println("=> DAFTAR KESELURUHAN :");
									System.out.println(
											"__NIM_____||__________NAME________ ||_PRODI_||_________________EMAIL__________________________|TOTAL KESELURUHAN|PRESENTASI|_KETERANGAN_||");

									(new DataPresensiController()).FindMinTotalPresensi();
									System.out.println("");
									System.out.print("REFRESS press 'YES' , LANJUT press 'NO' ?  [YES|NO] ? :");

									pilihanUser = sq.next();
								} while (pilihanUser.equals("YES") || pilihanUser.equals("yes"));

								break;
							case 6:
								Scanner se = new Scanner(System.in);
								String ulangin;
								do {
									System.out.println(">>>>> MENU MENAMPILKAN TOTAL PRESENSI URUTAN DARI YANG TERBANYAK <<<<<:");
									System.out.println("");
									System.out.println("=> DAFTAR KESELURUHAN :");
									System.out.println(
											"__NIM_____||__________NAME________ ||_PRODI_||_________________EMAIL__________________________|TOTAL KESELURUHAN|PRESENTASI|_KETERANGAN_||");
								
									(new DataPresensiController()).FindMaxTotalPresensi();
									System.out.println("");
									System.out.print("REFRESS press 'YES' , LANJUT press 'NO' ?  [YES|NO] ? :");
									
								
									ulangin = se.next();
								} while (ulangin.equals("YES") || ulangin.equals("yes"));
								
								break;
						

							case 7:

								System.out.println("");
								System.out.println("                           LOGOUT SUCSES");
								System.out.println("                  ===============================");
								System.out.println("            ===== TERIMA KASIH UNTUK KUNJUNGANNYA =====");
								System.out.println("           =====         APLIKASI PRESENSIYA       =====");
								System.out.println("");
								System.out.println(
										"===========================================================================");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.exit(0);
								break;

							default:
								System.out.println("ANGKA MENU YANG ADA MASUKAN TIDAK TERSEDIA");
								System.out.println("WARNING!!! MASUKKAN NO MENU YANG TERSEDIA");

							}
							System.out.print("\n Acces Menu lain (y/n) ?");
							pilihanUser = sa.next();
							isLanjutkan = pilihanUser.equalsIgnoreCase(pilihanUser);

						}
					}

					break;
			
				// LOGIN AS MAHASISWA
				case 2:
					Scanner sj = new Scanner(System.in);
					String ulanginnnn;

					System.out.println("");
					System.out.println(">>>>> LOGIN SEBAGAI MAHASISWA <<<<<");
					System.out.println("");

					System.out.print("Username :");
					username = sb.next();
					System.out.print("Password :");
					password = sb.next();

					if (new DataPresensiController().login(username, password)) {
						System.out.println(">> LOGIN SUCCES!!! <<");
						login = true;
					} else {
						System.out.println("");
						System.out.println(">>>>> LOGIN GAGAL !!!<<<<<");
						System.out.println(">>>>> SILAHKAN MASUKKAN USERNAME ATAU PASSWORD DENGAN BENAR! <<<<<");
						System.out.println("");
						break;
					}

					while (login) {
						System.out.println("");
						System.out.println(">>> DAFTAR MENU <<< \n\n" +

								"1. MENU DAFTAR HADIR \n" + "2. INFORMASI WAKTU PERSESI \n" +"3. MENU TOTAL PRESENSIYA MAHASISWA\n" + "4. LOGOUT. \n");

						System.out.print("==Pilih Menu yang anda Inginkan== : ");

						// 	 MENU MAHASISWA
						int menuMahasiswa;
						Scanner so = new Scanner(System.in);
						menuMahasiswa = so.nextInt();
						{
							switch (menuMahasiswa)

							{
							case 1:

								System.out.println(
										"__NIM_____||__________NAME________ ||_PRODI_||_________________EMAIL________________________||SESI 1||SESI 2|SESI 3||SESI 4|SESI 5||SESI 6||SESI 7||SESI 8||SESI 9||SESI 10||SESI 11||SESI 12||SESI 13||TOTAL KESELURUHAN||");
								(new DataPresensiController()).SearchAndFindNim(username);
								System.out.println("==============================================================================================================================================================================================================");
								break;
								
							case 2:
								Scanner sq = new Scanner(System.in);
								String ulango;
								do {
									System.out.println(">>>>> MENU INFO TIME MEETING <<<<<");
									System.out.println("");
									System.out.println("=> DAFTAR KESELURUHAN :");
									System.out.println("SESI|STAR MEET|END MEET");
									(new DataPresensiController()).infoTimePresensi();
									System.out.println("");
									System.out.print("REFRESS press 'YES' , LANJUT press 'NO' ?  [YES|NO] ? :");

									pilihanUser = sq.next();
								} while (pilihanUser.equals("YES") || pilihanUser.equals("yes"));

								break;	
								
							case 3:
								Scanner sf = new Scanner(System.in);
								System.out.println(">>>>> Menu Total Presensi Mahasiswa <<<<<:");
								System.out.println("__NIM_____||__________NAME________ ||_PRODI_||______________EMAIL_________________||______________DURASI_________________||__________PERSENAN_____________||____________STATUS________________||");
						
								(new DataPresensiController()).FindTotalPerMahasiswa(username);
								break;
								
							

							case 4:

								System.out.println("");
								System.out.println("                           LOGOUT SUCSES");
								System.out.println("                  ===============================");
								System.out.println("            ===== TERIMA KASIH UNTUK KUNJUNGANNYA =====");
								System.out.println("           =====          APLIKASI PRESENSIYA      =====");
								System.out.println("");
								System.out.println(
										"===========================================================================");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.exit(0);
								break;

							default:
								System.out.println("ANGKA MENU YANG ADA MASUKAN TIDAK TERSEDIA");
								System.out.println("WARNING!!! MASUKKAN NO MENU YANG TERSEDIA");

							}
							System.out.print("\n Acces Menu lain (y/n) ?");
							pilihanUser = sa.next();
							isLanjutkan = pilihanUser.equalsIgnoreCase(pilihanUser);

						}

					}

				}
			}
		}
	}
}


