import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        int menu;
        Scanner input = new Scanner(System.in);
        
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Regresi linier berganda");
        System.out.println("6. Keluar");
        System.out.print("Masukkan menu (1-6): ");
        menu = input.nextInt();

        if (menu == 1) {
            SubMenuSPL();
        } else if (menu == 2) {
            SubMenuDet();
        } else if (menu == 3) {
            SubMenuInv();
        } else if (menu == 4){
            SubMenuIntpol();
        } else if (menu == 5){
            SubMenuRLB();
        } else if (menu == 6){
            System.exit(0);
        } else {
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
        int submenu;
        Matrix mat = new Matrix(2,2); // inisiasi awal matriks 3x3
        Scanner input = new Scanner(System.in);
        System.out.println("Metode yang digunakan: ");
        System.out.println("1. Metode eliminasi Gauss ");
        System.out.println("2. Metode ekspansi kofaktor ");
        System.out.print("Masukkan metode yang digunakan: ");
        submenu = input.nextInt();

        if (submenu==1 || submenu==2) {
            int jenis;
            System.out.println("Jenis Masukan: ");
            System.out.println("1. Masukan dari keyboard");
            System.out.println("2. Masukan dari file text");
            System.out.print("Masukkan jenis masukan: ");
            jenis = input.nextInt();

            if(jenis == 1) {
                // baca matriks
                mat.bacaMatriks();
                // keluarkan hasil determinan
                double hasil;
                hasil = mat.determinanKofaktor();
                System.out.print("Nilai determinan dari matriks tersebut adalah ");
                System.out.println(hasil);
            }
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