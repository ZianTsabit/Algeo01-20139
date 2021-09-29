import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Main{

    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        try{
            int menu;
            Scanner input = new Scanner(System.in);
            System.out.println("--------------------------------");
            System.out.println("     Sistem Persamaan Linear,   ");
            System.out.println("   Determinan, dan Aplikasinya  ");
            System.out.println("--------------------------------");
            System.out.println("           Menu Utama           ");
            System.out.println("--------------------------------");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Regresi linier berganda");
            System.out.println("6. Keluar");
            System.out.println("--------------------------------");
            System.out.print("Pilih menu: ");
            menu = input.nextInt();

            switch (menu) {
                case 1:
                    SubMenuSPL();
                    break;
                case 2:
                    SubMenuDet();
                    break;
                case 3:
                    SubMenuInv();
                    break;
                case 4:
                    SubMenuIntpol();
                    break;
                case 5:
                    SubMenuRLB();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Masukkan menu tidak valid, ulangi kembali.");
                    MainMenu();
            }
        } catch (Exception e) {
            System.out.println("Masukkan menu tidak valid, ulangi kembali.");
            MainMenu();
        }
    }
    
    public static void SubMenuSPL() {
        try{
            int i, metode, jenis, akhir, Nbrs, Nkol;
            String hasil = "";
	    double b[][];
	    jenis = 0;
	    Nbrs = 0;
            String namafile = null;
            char simpan = 0;
	    Matrix mat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);
            
            
            System.out.println("--------------------------------");
            System.out.println("       Menu yang dipilih:       ");
            System.out.println("   1. Sistem Persamaan Linear   ");
            System.out.println("--------------------------------");
            System.out.println("             Metode             ");
            System.out.println("--------------------------------");
            System.out.println("1. Metode eliminasi Gauss ");
            System.out.println("2. Metode eliminasi Gauss-Jordan ");
            System.out.println("3. Metode matriks balikan ");
            System.out.println("4. Kaidah Cramer ");
            System.out.println("5. Kembali ke menu utama");
            System.out.println("--------------------------------");
            System.out.print("Pilih metode yang digunakan: ");
            metode = input.nextInt();
            
            switch (metode) {
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("      Metode yang dipilih:      ");
                    System.out.println("    1. Metode eliminasi Gauss   ");
                    System.out.println("--------------------------------");
                    jenis = JenisInput(1);
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("      Metode yang dipilih:      ");
                    System.out.println("2. Metode eliminasi Gauss-Jordan");
                    System.out.println("--------------------------------");
                    jenis = JenisInput(1);
                    break;
                case 3:
                    System.out.println("--------------------------------");
                    System.out.println("      Metode yang dipilih:      ");
                    System.out.println("   3. Metode matriks balikan    "); 
                    System.out.println("--------------------------------");
		    System.out.println("            PERHATIAN           ");
		    System.out.println(" Pastikan input matriks persegi ");
		    System.out.println("--------------------------------");
                    jenis = JenisInput(1);
                    break;
                case 4:
                    System.out.println("--------------------------------");
                    System.out.println("      Metode yang dipilih:      ");
                    System.out.println("        4. Kaidah Cramer        ");
                    System.out.println("--------------------------------");
		    System.out.println("            PERHATIAN           ");
		    System.out.println(" Pastikan input matriks persegi ");
		    System.out.println("--------------------------------");
                    jenis = JenisInput(1);
                    break;
                case 5:
                    MainMenu();
                default:
                    System.out.println("Masukan metode tidak valid. Ulang kembali masukan metode.");
                    SubMenuSPL();
            }

            switch (jenis) {
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("   Jenis masukan yang dipilih:  ");
                    System.out.println("    1. Masukan dari keyboard    ");
                    System.out.println("--------------------------------");
                    System.out.println("            PERHATIAN           ");
                    System.out.println("Pastikan input matriks augmented");
                    System.out.println("--------------------------------");
                    System.out.print("Masukkan jumlah baris: ");
                    Nbrs = input.nextInt();
                    System.out.print("Masukkan jumlah kolom: ");
                    Nkol = input.nextInt();
                    // inisiasi ukuran matriks persegi
                    mat = new Matrix(Nbrs,Nkol);
                    System.out.println("Masukkan matriks: ");
                    // membaca matriks
                    mat.bacaMatriks();
                    System.out.println("Matriks berhasil terbaca.");
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("   Jenis masukan yang dipilih:  ");
                    System.out.println("    2. Masukan dari file txt    ");
                    System.out.println("--------------------------------");
                    System.out.println("            PERHATIAN           ");
                    System.out.println("Pastikan input matriks augmented");
		    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.print("Masukkan nama file (.txt) : ");
                    namafile = input.next();
                    mat.bacaFileMatriks(namafile);
                    System.out.println("File "+namafile+" berhasil diproses.");
                    break;
                case 3:
                    SubMenuSPL();
                default:
                    System.out.println("Masukan jenis masukan tidak valid. Ulang kembali dari awal.");
                    SubMenuSPL();
            }
            System.out.println("--------------------------------");
            System.out.println("Matriks yang terbaca: ");
            mat.tulisMatriks();

            if (metode==1 && (jenis==1 || jenis==2) ){
                // Penyelesaian SPL dengan metode eliminasi gauss
                System.out.println("--------------------------------");
                System.out.println("Dengan menggunakan metode eliminasi gauss");
                System.out.println("Didapatkan solusi sebagai berikut : ");
                // Letakkan Operasi disini
                
                HashMap<String, String> sol = new HashMap<>();
	            sol = Matrix.gaussEliminasi(mat);
	            System.out.println(Matrix.DisplaySolusi(sol));

                System.out.println("--------------------------------");
                // Menyimpan file
                System.out.print("Simpan hasil? (y/n): ");
                simpan = input.next().charAt(0);

            } else if (metode==2 && (jenis==1 || jenis==2) ) {
                // Penyelesaian SPL dengan metode eliminasi gauss-jordan
                System.out.println("--------------------------------");
                System.out.println("Dengan menggunakan metode eliminasi gauss jordan");
                System.out.println("Didapatkan solusi sebagai berikut : ");
                // Letakkan Operasi disini
                
                HashMap<String, String> sol = new HashMap<>();
	            sol = Matrix.gaussJordanEliminasi(mat);
	            System.out.println(Matrix.DisplaySolusi(sol));
                
                System.out.println("--------------------------------");
                
                // Menyimpan file
                System.out.print("Simpan hasil? (y/n): ");
                simpan = input.next().charAt(0);

            } else if (metode==3 && (jenis==1 || jenis==2)) {
                // Penyelesaian SPL dengan metode matriks balikan
                System.out.println("--------------------------------");
                if(!mat.isPersegi()) {
		    System.out.println("Matriks balikan tidak berlaku");
		    System.out.println("Matriks tidak persegi");
		} else {
		    if(mat.determinanKofaktor() == 0) {
			System.out.println("Matriks balikan tidak berlaku");
			System.out.println("Matriks tidak memiliki balikan");
			System.out.println("Determinan matriks adalah 0");
		    }else{
			System.out.println("Masukan matriks B: ");
			b = new double[Nbrs][1];
			for (i = 0; i < Nbrs; i++) {
			    b[i][0] = input.nextInt();
			}	
			System.out.println("Dengan metode matriks balikan");
			System.out.println("Didapatkan penyelesaian");	
			hasil = mat.metodeInvers(b);
			System.out.print(hasil);
			System.out.println();
		    }   
		}
                System.out.println("--------------------------------");
                // Menyimpan file
                System.out.print("Simpan hasil? (y/n): ");
                simpan = input.next().charAt(0);

            } else if (metode==4 && (jenis==1 || jenis==2)) {
                // Penyelesaian SPL dengan metode kaidah cramer
                System.out.println("--------------------------------");
                if(!mat.isPersegi()) {
		    System.out.println("Kaidah Cramer tidak berlaku");
		    System.out.println("Matriks tidak persegi");
		}else{
		    if(mat.determinanKofaktor() == 0) {
			System.out.println("Kaidah Cramer tidak berlaku");
			System.out.println("Determinan matriks adalah 0");
		    }else{
			System.out.println("Masukan matriks B: ");
			b = new double[Nbrs][1];
			for (i = 0; i < Nbrs; i++) {
			    b[i][0] = input.nextInt();
			}	
			System.out.println("Dengan metode Kaidah Cramer");
			System.out.println("Didapatkan penyelesaian");	
			hasil = mat.Cramer(b);
			System.out.print(hasil);
			System.out.println();
		    }
		}
                System.out.println("--------------------------------");
                // Menyimpan file
                System.out.print("Simpan hasil? (y/n): ");
                simpan = input.next().charAt(0);
            }

            if (simpan=='y'){
                System.out.print("Masukkan nama file penyimpanan (.txt): ");
                namafile = input.next();
                BufferedWriter tulis = new BufferedWriter(new FileWriter("./output/"+namafile));
                // menyimpan matriks
                for (i = 0; i < mat.brs; i++) {
                    String baris = "";
                    for (int j= 0; j < mat.kol; j++){
                        baris += Double.toString(mat.Mat[i][j]);
                        if (j!=mat.kol){
                            baris += " ";
                        }
                    }
                    if (i!=mat.brs){
                        baris += "\n";
                    }
                    tulis.write(baris);
                }
                tulis.write("");
                tulis.close();
                System.out.println("File berhasil disimpan dengan nama "+namafile);
            }

            System.out.println("--------------------------------");
            System.out.println(" Operasi Sistem Persamaan Linear");
            System.out.println("            selesai             ");
            System.out.println("      Kembali ke menu utama     ");
            System.out.println("--------------------------------");
            MainMenu();

        } catch(Exception e){ 
            System.out.println("Masukan tidak valid. Ulang kembali masukkan metode.");
            SubMenuSPL();
        }

    }
    
    public static void SubMenuDet() {
        try{
            int metode, jenis, ukuran, akhir;
            double hasil = 0;
            metode = 0;
            jenis = 0;
            ukuran = 0;
            hasil = 0;
            String namafile = null;
            char simpan = 0;
            Matrix mat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);
            
            System.out.println("--------------------------------");
            System.out.println("       Menu yang dipilih:       ");
            System.out.println("         2. Determinan          ");
            System.out.println("--------------------------------");
            System.out.println("             Metode             ");
            System.out.println("--------------------------------");
            System.out.println("1. Metode eliminasi Gauss ");
            System.out.println("2. Metode ekspansi kofaktor ");
            System.out.println("3. Kembali ke menu utama");
            System.out.println("--------------------------------");
            System.out.print("Pilih metode yang digunakan: ");
            metode = input.nextInt();
            
            switch (metode) {
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("      Metode yang dipilih:      ");
                    System.out.println("    1. Metode eliminasi Gauss   ");
                    System.out.println("--------------------------------");
                    jenis = JenisInput(1);
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("        Metode yang dipilih:    ");
                    System.out.println("   2. Metode ekspansi kofaktor  ");
                    System.out.println("--------------------------------");
                    jenis = JenisInput(1);
                    break;
                case 3:
                    MainMenu();
                default:
                    System.out.println("Masukan metode tidak valid. Ulang kembali masukan metode.");
                    SubMenuDet();
            }

            switch (jenis) {
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("   Jenis masukan yang dipilih:  ");
                    System.out.println("    1. Masukan dari keyboard    ");
                    System.out.println("--------------------------------");
                    System.out.println("            PERHATIAN           ");
                    System.out.println(" Pastikan input matriks persegi ");
                    System.out.println("--------------------------------");
                    System.out.print("Masukkan ukuran matriks persegi (MxM) M: ");
                    ukuran = input.nextInt();
                    // inisiasi ukuran matriks persegi
                    mat = new Matrix(ukuran,ukuran);
                    System.out.println("Masukkan matriks: ");
                    // membaca matriks
                    mat.bacaMatriks();
                    System.out.println("Matriks berhasil terbaca.");
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("   Jenis masukan yang dipilih:  ");
                    System.out.println("    2. Masukan dari file txt    ");
                    System.out.println("--------------------------------");
                    System.out.println("            PERHATIAN           ");
                    System.out.println(" Pastikan input matriks persegi ");
                    System.out.println("--------------------------------");
                    System.out.print("Masukkan nama file (.txt) : ");
                    namafile = input.next();
                    mat.bacaFileMatriks(namafile);
                    System.out.println("File "+namafile+" berhasil diproses.");
                    break;
                case 3:
                    SubMenuDet();
                default:
                    System.out.println("Masukan jenis masukan tidak valid. Ulang kembali dari awal.");
                    SubMenuDet();
            }
            System.out.println("--------------------------------");
            System.out.println("Matriks yang terbaca: ");
            mat.tulisMatriks();

            if (metode==1 && (jenis==1 || jenis==2) ){
                // mencari nilai determinan menggunakan eliminasi Gauss
                System.out.println("--------------------------------");
                System.out.println("Dengan metode eliminasi Gauss,  ");
                System.out.println("didapatkan nilai determinan ");
                System.out.print("matriks tersebut adalah: ");
                hasil = mat.determinanReduksiBrs();
                System.out.println(hasil);
                System.out.println("--------------------------------");
                // Menyimpan file
                System.out.print("Simpan hasil? (y/n): ");
                simpan = input.next().charAt(0);

            } else if (metode==2 && (jenis==1 || jenis==2) ) {
                // mencari nilai determinan menggunakan ekspansi kofaktor
                System.out.println("--------------------------------");
                System.out.println("Dengan metode ekspansi kofaktor,   ");
                System.out.println("didapatkan nilai determinan ");
                System.out.print("matriks tersebut adalah: ");
                hasil = mat.determinanKofaktor();
                System.out.println(hasil);
                System.out.println("--------------------------------");
                // Menyimpan file
                System.out.print("Simpan hasil? (y/n): ");
                simpan = input.next().charAt(0);
            }

            if (simpan=='y'){
                System.out.print("Masukkan nama file penyimpanan (.txt): ");
                namafile = input.next();
                BufferedWriter tulis = new BufferedWriter(new FileWriter("./output/"+namafile));
                for (int i = 0; i < mat.brs; i++) {
                    String baris = "";
                    for (int j= 0; j < mat.kol; j++){
                        baris += Double.toString(mat.Mat[i][j]);
                        if (j!=mat.kol){
                            baris += " ";
                        }
                    }
                    if (i!=mat.brs){
                        baris += "\n";
                    }
                    tulis.write(baris);
                }
                if (metode==1){
                    tulis.write("\nDengan menggunakan eliminasi Gauss, didapatkan nilai determinan matriks tersebut adalah: " + hasil + "\n" );
                } else if(metode==2){
                    tulis.write("\nDengan menggunakan ekspansi kofaktor, didapatkan nilai determinan matriks tersebut adalah: " + hasil + "\n" );
                }
                tulis.close();
                System.out.println("File berhasil disimpan dengan nama "+namafile);
            }
            System.out.println("--------------------------------");
            System.out.println("   Operasi determinan selesai   ");
            System.out.println("     Kembali ke menu utama      ");
            System.out.println("--------------------------------");
            MainMenu();

        } catch(Exception e){ 
            System.out.println("Masukan tidak valid. Ulang kembali masukkan metode.");
            SubMenuDet();
        }
    }
    
    public static void SubMenuInv() {
        try{
            int metode, jenis, ukuran;
            metode = 0;
            jenis = 0;
            ukuran = 0;
            String namafile = null;
            char simpan = 0;
            Matrix mat = new Matrix(0,0);
            Matrix invmat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);
            
            System.out.println("--------------------------------");
            System.out.println("       Menu yang dipilih:       ");
            System.out.println("       3. Matriks balikan       ");
            System.out.println("--------------------------------");
            System.out.println("             Metode             ");
            System.out.println("--------------------------------");
            System.out.println("1. Metode eliminasi Gauss ");
            System.out.println("2. Metode ekspansi kofaktor ");
            System.out.println("3. Kembali ke menu utama");
            System.out.println("--------------------------------");
            System.out.print("Pilih metode yang digunakan: ");
            metode = input.nextInt();
            
            switch (metode) {
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("      Metode yang dipilih:      ");
                    System.out.println("    1. Metode eliminasi Gauss   ");
                    System.out.println("--------------------------------");
                    jenis = JenisInput(1);
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("        Metode yang dipilih:    ");
                    System.out.println("   2. Metode ekspansi kofaktor  ");
                    System.out.println("--------------------------------");
                    jenis = JenisInput(1);
                    break;
                case 3:
                    MainMenu();
                default:
                    System.out.println("Masukan metode tidak valid. Ulang kembali masukan metode.");
                    SubMenuInv();
            }

            switch (jenis) {
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("   Jenis masukan yang dipilih:  ");
                    System.out.println("    1. Masukan dari keyboard    ");
                    System.out.println("--------------------------------");
                    System.out.println("            PERHATIAN           ");
                    System.out.println(" Pastikan input matriks persegi ");
                    System.out.println("--------------------------------");
                    System.out.print("Masukkan ukuran matriks persegi (MxM) M: ");
                    ukuran = input.nextInt();
                    // inisiasi ukuran matriks persegi
                    mat = new Matrix(ukuran,ukuran);
                    System.out.println("Masukkan matriks: ");
                    // membaca matriks
                    mat.bacaMatriks();
                    System.out.println("Matriks berhasil terbaca.");
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("   Jenis masukan yang dipilih:  ");
                    System.out.println("    2. Masukan dari file txt    ");
                    System.out.println("--------------------------------");
                    System.out.println("            PERHATIAN           ");
                    System.out.println(" Pastikan input matriks persegi ");
                    System.out.println("--------------------------------");
                    System.out.print("Masukkan nama file (.txt) : ");
                    namafile = input.next();
                    mat.bacaFileMatriks(namafile);
                    System.out.println("File "+namafile+" berhasil diproses.");
                    break;
                case 3:
                    SubMenuInv();
                default:
                    System.out.println("Masukan jenis masukan tidak valid. Ulang kembali dari awal.");
                    SubMenuInv();
            }
            System.out.println("--------------------------------");
            System.out.println("Matriks yang terbaca: ");
            mat.tulisMatriks();

            if (metode==1 && (jenis==1 || jenis==2) ){
                // mencari matriks balikan menggunakan eliminasi Gauss
                if (mat.determinanKofaktor() == 0) {
                    System.out.println("Matriks tidak memiliki balikan");
                    System.out.println("Determinan matriks adalah 0");
                    } else {
                        System.out.println("--------------------------------");
                        System.out.println("Dengan metode eliminasi Gauss,  ");
                        System.out.println("didapatkan matriks balikan dari ");
                        System.out.println("matriks tersebut adalah: ");
                        // Operasi Invers matriks
                        
                        SPL spl = new SPL(mat);
                        Matrix imat = spl.inverseGaussJordan();
                        invmat = imat;
                        imat.tulisMatriks();
                }
                
                System.out.println("--------------------------------");
                // Menyimpan file
                System.out.print("Simpan hasil? (y/n): ");
                simpan = input.next().charAt(0);

            } else if (metode==2 && (jenis==1 || jenis==2) ) {
                // mencari matriks balikan menggunakan ekspansi kofaktor
                if (mat.determinanKofaktor() == 0) {
                    System.out.println("Matriks tidak memiliki balikan");
                    System.out.println("Determinan matriks adalah 0");
                } else {
                    System.out.println("--------------------------------");
                    System.out.println("Dengan metode ekspansi kofaktor,");
                    System.out.println("didapatkan matriks balikan dari ");
                    System.out.println("matriks tersebut adalah: ");
                    invmat = mat;
                    invmat.Invers();
                    invmat.tulisMatriks();
                }
                System.out.println("--------------------------------");
                        // Menyimpan file
                        System.out.print("Simpan hasil? (y/n): ");
                        simpan = input.next().charAt(0);
                    }

            if (simpan=='y'){
                System.out.print("Masukkan nama file penyimpanan (.txt): ");
                namafile = input.next();
                BufferedWriter tulis = new BufferedWriter(new FileWriter("./output/"+namafile));
                for (int i = 0; i < mat.brs; i++) {
                    String baris = "";
                    for (int j= 0; j < mat.kol; j++){
                        baris += Double.toString(mat.Mat[i][j]);
                        if (j!=mat.kol){
                            baris += " ";
                        }
                    }
                    if (i!=mat.brs){
                        baris += "\n";
                    }
                    tulis.write(baris);
                }
                if (metode==1){
                    tulis.write("\nDengan menggunakan eliminasi Gauss, didapatkan matriks balikan dari matriks tersebut adalah: \n" );
                    
                } else if (metode==2){
                    tulis.write("\nDengan menggunakan ekspansi kofaktor, didapatkan matriks balikan dari matriks tersebut adalah: \n" );
                }
                // Menulis hasil invers matriks
                for (int i = 0; i < invmat.brs; i++) {
                    String baris = "";
                    for (int j= 0; j < invmat.kol; j++){
                        baris += Double.toString(invmat.Mat[i][j]);
                        if (j!=invmat.kol){
                            baris += " ";
                        }
                    }
                    if (i!=invmat.brs){
                        baris += "\n";
                    }
                    tulis.write(baris);
                }
                tulis.close();
                System.out.println("File berhasil disimpan dengan nama "+namafile);
            }
            System.out.println("--------------------------------");
            System.out.println(" Operasi matriks balikan selesai");
            System.out.println("     Kembali ke menu utama      ");
            System.out.println("--------------------------------");
            MainMenu();

        } catch(Exception e){ 
            System.out.println("Masukan tidak valid. Ulang kembali masukkan metode.");
            SubMenuInv();
        }
    }
    
    public static void SubMenuIntpol() {
        try{
            int jenis = 0;
            String namafile = null;
            String namafilesimpan = null;
            char simpan = 0;
            Matrix mat = new Matrix(0,0);
            Matrix matTitik = new Matrix(0,0);
            Matrix matPolinom = new Matrix(0,0);
            Matrix titikx = new Matrix(0,0);

            Scanner input = new Scanner(System.in);
            
            System.out.println("--------------------------------");
            System.out.println("       Menu yang dipilih:       ");
            System.out.println("     4. Interpolasi polinom     ");
            System.out.println("--------------------------------");
            jenis = JenisInput(0);
            
            switch (jenis) {
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("   Jenis masukan yang dipilih:  ");
                    System.out.println("    1. Masukan dari keyboard    ");
                    System.out.println("--------------------------------");
                    
                    // Pembentukan titik-titik
                    matTitik = Interpolasi.createPoints();
                    titikx = Interpolasi.nilaix();
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("   Jenis masukan yang dipilih:  ");
                    System.out.println("    2. Masukan dari file txt    ");
                    System.out.println("--------------------------------");
                    System.out.print("Masukkan nama file (.txt) : ");
                    namafile = input.next();
                    matTitik.bacaFileMatriks(namafile);
                    System.out.println("File "+namafile+" berhasil diproses.");
                    titikx = Interpolasi.nilaix();
                    break;
                default:
                    System.out.println("Masukan jenis masukan tidak valid. Ulang kembali dari awal.");
                    SubMenuIntpol();
            }
            matPolinom = Interpolasi.createPolinom(matTitik);
            System.out.println("--------------------------------");
            Interpolasi.persPolinom(matPolinom);
            System.out.println("\n--------------------------------");
            if ((jenis==1 || jenis==2)){
                
                Interpolasi.hasilTaksir(matPolinom,titikx);

                System.out.println("--------------------------------");
                // Menyimpan file
                System.out.print("Simpan hasil? (y/n): ");
                simpan = input.next().charAt(0);
            }

            if (simpan=='y'){
                System.out.print("Masukkan nama file penyimpanan (.txt): ");
                namafilesimpan = input.next();
                Interpolasi.simpanInterpolasi(matTitik, matPolinom, titikx, namafilesimpan);
                System.out.println("File berhasil disimpan dengan nama "+namafilesimpan);
            }
            System.out.println("--------------------------------");
            System.out.println("   Operasi interpolasi polinom  ");
            System.out.println("            selesai             ");
            System.out.println("     Kembali ke menu utama      ");
            System.out.println("--------------------------------");
            MainMenu();

        } catch(Exception e){ 
            System.out.println("Masukan tidak valid. Ulang kembali");
            SubMenuIntpol();
        }
    }
    
    public static void SubMenuRLB() {
        try{
            int jenis = 0;
            String namafile = null;
            char simpan = 0;
            String namafilesimpan = null;
            Matrix mat = new Matrix(0,0);
            Matrix Reg = new Matrix(0,0);
            Matrix I = new Matrix(0,0);
            Matrix matTitik = new Matrix(0,0);
            int x = 0;
            int n = 0;
            RLB R = new RLB(0,0);

            Scanner input = new Scanner(System.in);
            
            System.out.println("--------------------------------");
            System.out.println("       Menu yang dipilih:       ");
            System.out.println("   5. Regresi linier berganda   ");
            System.out.println("--------------------------------");
            jenis = JenisInput(0);
            
            switch (jenis) {
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("   Jenis masukan yang dipilih:  ");
                    System.out.println("    1. Masukan dari keyboard    ");
                    System.out.println("--------------------------------");
                    
                    // Pembentukan titik-titik
                    System.out.print("Masukkan banyaknya jumlah n : ");
                            n = input.nextInt();
                    System.out.print("Masukkan banyaknya nilai x : ");
                    x = input.nextInt();
                    R = new RLB(n,x);
                    R.bacaRLB();
                    I = R.inputX(x);
                    Reg = R.CreateRLB(x,n);
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("   Jenis masukan yang dipilih:  ");
                    System.out.println("    2. Masukan dari file txt    ");
                    System.out.println("--------------------------------");
                    System.out.print("Masukkan nama file (.txt) : ");
                    namafile = input.next();
                    matTitik.bacaFileMatriks(namafile);
                    System.out.println("File "+namafile+" berhasil diproses.");
		            I = R.inputX(matTitik.kol-1);
                    Reg = R.CreateRLBFile(matTitik);
                    break;
                default:
                    System.out.println("Masukan jenis masukan tidak valid. Ulang kembali dari awal.");
                    SubMenuRLB();
            }
            R.persRLB(Reg);
            System.out.println("--------------------------------");
            R.TaksirX(Reg,I);
            System.out.println("--------------------------------");
            if ((jenis==1 || jenis==2)){
                System.out.println("--------------------------------");
                // Menyimpan file
                System.out.print("Simpan hasil? (y/n): ");
                simpan = input.next().charAt(0);
            }

            if (simpan=='y'){
                System.out.print("Masukkan nama file penyimpanan (.txt): ");
                namafilesimpan = input.next();
                RLB.simpanRLB(matTitik, Reg, I, namafilesimpan);
                System.out.println("File berhasil disimpan dengan nama "+namafilesimpan);
            }
            
            System.out.println("--------------------------------");
            System.out.println(" Operasi regresi linier berganda");
            System.out.println("            selesai             ");
            System.out.println("     Kembali ke menu utama      ");
            System.out.println("--------------------------------");
            MainMenu();

        } catch(Exception e){ 
            System.out.println("Masukan tidak valid. Ulang kembali");
            SubMenuRLB();
        }
    }
    
    public static int JenisInput(int versi) {
        int jenis=0;
        Scanner input = new Scanner(System.in);
        System.out.println("          Jenis Masukan         ");
        System.out.println("--------------------------------");
        System.out.println("1. Masukan dari keyboard");
        System.out.println("2. Masukan dari file text");
        switch (versi){
            case 1:
                System.out.println("3. Kembali ke menu metode");
            default:
                break;

        }
        System.out.println("--------------------------------");
        System.out.print("Pilih jenis masukan: ");
        jenis = input.nextInt();
        return jenis;
    }
}