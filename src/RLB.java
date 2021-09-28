import java.util.*;
import java.io.*;

public class RLB {

	Matrix M;

	public RLB(int n, int jmlx) {
		M = new Matrix(n,jmlx+1);	
	}

	void bacaRLB() {
		int i, j;
		Scanner input = new Scanner(System.in);
		
		for (i = 0; i < M.brs; i++) {
			for (j = 0; j < M.kol; j++) {
				M.Mat[i][j] = input.nextDouble();
			}
		}
	}

	Matrix CreateRLB(int jmlx, int n) {
		int i, j;
		Matrix R = new Matrix(jmlx+1,jmlx+2);

		R.Mat[0][0] = n;
		for (i = 0; i < (jmlx+1); i++) {
			for (j = 1; j < (jmlx+2); j++) {
				if (i == 0) {
					R.Mat[i][j] = M.jumlahKolom(j-1);
					if (j != (jmlx+1)) {
						R.Mat[j][i] = R.Mat[i][j];
					}
				} else {
					R.Mat[i][j] = M.jumlahKaliKolom(i-1,j-1);
				}
			}
		}

		R.MakeReduceEchelon();
		return R;
	}

	Matrix CreateRLBFile(Matrix F) {
		int i, j;
		Matrix R = new Matrix(F.kol,F.kol+1);

		R.Mat[0][0] = F.brs;
		for (i = 0; i < F.kol; i++) {
			for (j = 1; j < (F.kol+1); j++) {
				if (i == 0) {
					R.Mat[i][j] = F.jumlahKolom(j-1);
					if (j != F.kol) {
						R.Mat[j][i] = R.Mat[i][j];
					}
				} else {
					R.Mat[i][j] = F.jumlahKaliKolom(i-1,j-1);
				}
			}
		}

		R.MakeReduceEchelon();
		return R;
	}

	Matrix inputX(int x) {
		Scanner input = new Scanner(System.in);
		int i;
		Matrix I = new Matrix(x,1);

		for (i = 0; i < I.brs; i++) {
			System.out.print("Masukkan nilai x" + (i+1) + " : ");
			I.Mat[i][0] = input.nextDouble();
		}

		return I;
	}

	void persRLB(Matrix R) {
		int i;
		
        	System.out.println("Persamaan hasil regresi linear berganda: ");
        	System.out.print("y = ");
        	for (i = 0; i < R.brs; i++) {
            		if (i==0){
                		System.out.print(R.Mat[i][R.kol-1]);
            		} else {
                		if (R.Mat[i][R.kol-1]>0){
                    			System.out.print(" + ");
                		} else {
                    			System.out.print(" - ");
                		}
                    		System.out.print(Math.abs(R.Mat[i][R.kol-1]) + "x" + i);
            		}
		}
		System.out.println();
        }

	void TaksirX(Matrix R, Matrix I) {
		int i;
		double x;
		double hasil = 0;
		
		for (i = 0; i < R.brs; i++) {
			if (i == 0) {
				hasil += R.Mat[i][R.kol-1];
			} else {
				hasil += I.Mat[i-1][0] * R.Mat[i][R.kol-1];
			}
		}
		
		System.out.println("Hasil taksiran regresi : " + hasil);
	}
} 