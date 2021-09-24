import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RLB {


    Matrix mat;
    
    public RLB(){
        
        Scanner s = new Scanner(System.in);
        int i, j, k, jmlBrs, jmlKol;

        double jumlah = 0;

        jmlBrs = mat.brs;
        jmlKol = mat.kol;


        HashMap<String, String> SolusiHM = new HashMap<>();
        ArrayList<Double> Solusi = new ArrayList<>();
        String yx;

        //Membuat matriks baru

        Matrix m1 = new Matrix(jmlBrs, (jmlKol+1));

        //Mengisi m1 dengan (0, 0)

        m1.setElmt(0, 0, jmlBrs);

        //Mengisi m1 untuk baris pertama

        for (i = 0; i < jmlKol; i++){
            for (j = 0; j < jmlBrs; j++){
                jumlah = jumlah + mat.Mat[j][i];
            }
            m1.setElmt(0, (i+1), jumlah);
            jumlah = 0;
        }

        //Mengisi m1 untuk kolom pertama

        for (i = 1; i < jmlKol; i++){
            m1.setElmt(i, 0, m1.Mat[0][i]);
        }

        //Mengisi m1 untuk sisanya

        for (i = 1; i < jmlKol; i++){
            for (j = 0; j < jmlKol; j++){
                for (k = 0; k < jmlBrs; k++){
                    jumlah = jumlah + (mat.Mat[k][i-1] * mat.Mat[k][j]);
                }
                m1.setElmt(i, (j+1), jumlah);
                jumlah = 0;
                
            }
        }

        //Melakukan Gauss-Jordan

        SolusiHM = Matrix.gaussJordanEliminasi(m1);
        Matrix.DisplaySolusi(SolusiHM);

        for (i = 0; i < m1.brs; ++i){
            Solusi.add(i, m1.Mat[i][mat.kol-1]);
        }

        //Membuat persamaan y

        yx = "y = ";
        for (i = 0; i < m1.brs; ++i){
            yx += String.format("%.2f", Solusi.get(i) >= 0 || i == 0 ? Solusi.get(i) : -1*(Solusi.get(i)));
            
            if (i != 0){
                yx += "x" + i;
            }

            if (i < m1.brs-1){
                yx += (Solusi.get(i+1) >= 0) ? "+" : " - ";
            }
        }
        System.out.println(yx);


        //Prediksi

        String xPrediksi = "";
        jumlah = Solusi.get(0);
        System.out.print("Ingin memprediksi? (y/n)");




    }








} 