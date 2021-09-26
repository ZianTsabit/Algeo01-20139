import java.util.*;

class DriverMatrix {
    public static void main(String[] args) {
	Scanner in = new Scanner (System.in);
	
	int nBrsA;

	System.out.printf("\nMasukkan n: ");
	nBrsA = in.nextInt();
	Matrix M = new Matrix(nBrsA, nBrsA);
	System.out.println("Masukkan matriks : ");
	M.bacaMatriks();

	M.Regresi(M);

	}
}