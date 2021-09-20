import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        try{
            int menu;
            Scanner input = new Scanner(System.in);
            System.out.println("================================");
            System.out.println("MENU");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Regresi linier berganda");
            System.out.println("6. Keluar");
            System.out.println("================================");
            System.out.print("Masukkan menu (1-6): ");
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
        int submenu;
        Scanner input = new Scanner(System.in);
        System.out.println("Metode yang digunakan: ");
        System.out.println("1. Metode eliminasi Gauss ");
        System.out.println("2. Metode eliminasi Gauss-Jordan ");
        System.out.println("3. Metode matriks balikan ");
        System.out.println("4. Kaidah Cramer ");
        System.out.print("Masukkan metode yang digunakan: ");
        submenu = input.nextInt();

    }
    public static void SubMenuDet() {
        try{
            int metode, jenis, ukuran;
            double hasil = 0;
            metode = 0;
            jenis = 0;
            ukuran = 0;
            hasil = 0;
            String namafile = null;
            Matrix mat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);
            
            System.out.println("================================");
            System.out.println("Menu yang dipilih: 2. Determinan");
            System.out.println("================================");
            System.out.println("Metode yang akan digunakan: ");
            System.out.println("1. Metode eliminasi Gauss ");
            System.out.println("2. Metode ekspansi kofaktor ");
            System.out.println("3. Kembali ke menu utama");
            System.out.println("================================");
            System.out.print("Masukkan metode yang digunakan: ");
            metode = input.nextInt();
            
            switch (metode) {
                case 1:
                    System.out.println("================================");
                    System.out.println("Metode yang dipilih: 1. Metode eliminasi Gauss");
                    System.out.println("================================");
                    System.out.println("Jenis Masukan: ");
                    System.out.println("1. Masukan dari keyboard");
                    System.out.println("2. Masukan dari file text");
                    System.out.println("3. Kembali ke menu metode");
                    System.out.println("================================");
                    System.out.print("Masukkan jenis masukan: ");
                    jenis = input.nextInt();
                    break;
                case 2:
                    System.out.println("================================");
                    System.out.println("Metode yang dipilih: 2. Metode ekspansi kofaktor");
                    System.out.println("================================");
                    System.out.println("Jenis Masukan: ");
                    System.out.println("1. Masukan dari keyboard");
                    System.out.println("2. Masukan dari file text");
                    System.out.println("3. Kembali ke menu metode");
                    System.out.println("================================");
                    System.out.print("Masukkan jenis masukan: ");
                    jenis = input.nextInt();
                    break;
                case 3:
                    MainMenu();
                default:
                    System.out.println("Masukan metode tidak valid. Ulang kembali masukan metode.");
                    SubMenuDet();
            }

            switch (jenis) {
                case 1:
                    System.out.println("================================");
                    System.out.println("Jenis masukan yang dipilih: 1. Masukan dari keyboard");
                    System.out.println("PERHATIAN: Matriks yang diterima hanya matriks persegi");
                    System.out.println("================================");
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
                    System.out.println("================================");
                    System.out.println("Jenis masukan yang dipilih: 1. Masukan dari file txt");
                    System.out.println("PERHATIAN: Matriks yang diterima hanya matriks persegi");
                    System.out.println("================================");
                    System.out.print("Masukkan nama file diikuti oleh ekstensi .txt: ");
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

            System.out.println("Matriks yang terbaca: ");
            mat.tulisMatriks();

            if (metode==1 && (jenis==1 || jenis==2) ){
                // mencari nilai determinan menggunakan eliminasi Gauss
            } else if (metode==2 && (jenis==1 || jenis==2) ) {
                // mencari nilai determinan menggunakan ekspansi kofaktor
                System.out.println("================================");
                System.out.print("Dengan menggunakan ekspansi kofaktor, didapatkan nilai determinan matriks tersebut adalah: ");
                hasil = mat.determinanKofaktor();
                System.out.println(hasil);
                System.out.println("================================");
                // Menyimpan file
            }
        } catch(Exception e){ 
            System.out.println("Masukan tidak valid. Ulang kembali masukkan metode.");
            SubMenuDet();

        }
    }
    public static void SubMenuInv() {
        
    }
    public static void SubMenuIntpol() {
        
    }
    public static void SubMenuRLB() {
        
    }
    public static int JenisInput() {
        int jenis;
        Scanner input = new Scanner(System.in);
        System.out.println("Jenis Masukan: ");
        System.out.println("1. Masukan dari keyboard");
        System.out.println("2. Masukan dari file text");
        System.out.println("Masukkan jenis masukan: ");
        jenis = input.nextInt();
        return jenis;
    }
}