import java.util.*;
import java.io.*;

public class Interpolasi{

    static Matrix createPoints(){
        Scanner input = new Scanner(System.in);
        int Ntitik;
        int i,j;
        Matrix matTitik = new Matrix(0,0);

        System.out.print("Masukkan banyak titik: ");
        Ntitik = input.nextInt();
        matTitik = new Matrix(Ntitik,2);
        System.out.println("Masukkan koordinat titik x y: ");
        for (i = 0; i < matTitik.brs; i++) {
            for (j = 0; j < matTitik.kol; j++) {
            	matTitik.Mat[i][j] = input.nextDouble();
            }
        }
        return matTitik;
        
    }

    static Matrix createPolinom(Matrix matTitik){
        int i,j;
        Matrix matPolinom = new Matrix(matTitik.brs, matTitik.brs+1);
        for (i = 0; i < matPolinom.brs; i++) {
            for (j = 0; j < matPolinom.kol; j++) {
                if (j==matPolinom.kol-1){
                    matPolinom.Mat[i][j] = matTitik.Mat[i][1];
                } else {
                    matPolinom.Mat[i][j] = Math.pow(matTitik.Mat[i][0],j);
                }
            }
        }
        matPolinom.MakeReduceEchelon();
        return matPolinom;
    }

    static void persPolinom(Matrix matPolinom){
        int i;
        System.out.println("Persamaan hasil interpolasi: ");
        System.out.printf("p%d(x) = ",matPolinom.brs-1);
        for (i = 0; i < matPolinom.brs; i++) {
            if (i==0){
                System.out.print(matPolinom.Mat[i][matPolinom.kol-1]);
            } else {
                if (matPolinom.Mat[i][matPolinom.kol-1]>0){
                    System.out.print(" + ");
                } else {
                    System.out.print(" - ");
                }
    
                if (i==1){
                    System.out.print(Math.abs(matPolinom.Mat[i][matPolinom.kol-1]) + "x");
                } else {
                    System.out.printf(Math.abs(matPolinom.Mat[i][matPolinom.kol-1]) + "x^" + i);
                }
            }
        }
    }

    static Matrix nilaix (){
        Scanner input = new Scanner(System.in);
        int banyakx;
        int i;
        
        System.out.print("Masukkan banyak nilai x yang ditaksir: ");
        banyakx = input.nextInt();
        Matrix titikx = new Matrix(banyakx,1);
        System.out.println("Masukkan nilai x: ");
        for (i=0; i<titikx.brs; i++){
            titikx.Mat[i][0] = input.nextDouble();
        }

        return titikx;
    }

    static void hasilTaksir(Matrix matPolinom, Matrix titikx){
        Scanner input = new Scanner(System.in);
        double hasil;
        int i,j;
        
        System.out.println("Hasil penaksiran: ");
        for (i = 0; i < titikx.brs; i++){
            hasil = 0;
            for (j = 0; j < matPolinom.brs; j++) {
            hasil += matPolinom.Mat[j][matPolinom.kol-1]*Math.pow(titikx.Mat[i][0],j);
            }
            System.out.printf("p%d(%.3f) = ",matPolinom.brs-1,titikx.Mat[i][0]);
            System.out.println(hasil);
        }
    }

    static void simpanInterpolasi(Matrix matTitik, Matrix matPolinom, Matrix titikx, String namafile) throws IOException{
        int i,j;
        int banyakx;
        double hasil;
        BufferedWriter tulis = new BufferedWriter(new FileWriter("../test/output/"+namafile));
        for (i = 0; i < matTitik.brs; i++) {
            String baris = "";
            for (j= 0; j < matTitik.kol; j++){
                baris += Double.toString(matTitik.Mat[i][j]);
                if (j!=matTitik.kol){
                    baris += " ";
                }
            }
            if (i!=matTitik.brs){
                baris += "\n";
            }
            tulis.write(baris);
        }
        tulis.write("\nDari kombinasi titik di atas, persamaan polinom yang terbentuk adalah: \n" );
        String perspolinom = "p" + Integer.toString(matTitik.brs-1) + "(x) = ";
        for (i = 0; i < matPolinom.brs; i++) {
            if (i==0){
                perspolinom += Double.toString(matPolinom.Mat[i][matPolinom.kol-1]);
            } else {
                if (matPolinom.Mat[i][matPolinom.kol-1]>0){
                    perspolinom += String.format(" + ");
                } else {
                    perspolinom += String.format(" - ");
                }
    
                if (i==1){
                    perspolinom += Double.toString(Math.abs(matPolinom.Mat[i][matPolinom.kol-1]));
                    perspolinom += "x";
                } else {
                    perspolinom += Double.toString(Math.abs(matPolinom.Mat[i][matPolinom.kol-1]));
                    perspolinom += "x^";
                    perspolinom += String.format("%d",i);
                }
            }
        }
        tulis.write(perspolinom+"\n");
        tulis.write("\nHasil penaksiran: \n");

        for (i = 0; i < titikx.brs; i++){
            String line = "";
            hasil = 0;
            for (j = 0; j < matPolinom.brs; j++) {
            hasil += matPolinom.Mat[j][matPolinom.kol-1]*Math.pow(titikx.Mat[i][0],j);
            }
            line += String.format("p%d(%.2f) = ",matPolinom.brs-1,titikx.Mat[i][0]);
            line += Double.toString(hasil);
            tulis.write(line+"\n");
        }

        tulis.close();
    }
}