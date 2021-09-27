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
		return R;
	}

	void persRLB(Matrix R) {
		R.MakeReduceEchelon();

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
        }
} 