import java.util.*;

class DriverMatrix {
    public static void main(String[] args) {
	Scanner in = new Scanner (System.in);

	// masukan baris dan kolom yang diinginkan
	System.out.print("Masukan baris: ");
	int Bar = in.nextInt();
	System.out.print("Masukan kolom: ");
	int Kol = in.nextInt();

	// membuat objek matriks
	Matrix M = new Matrix(Bar,Kol);

	// mengisi matriks
	M.bacaMatriks();

	// menulis matriks
	M.tulisMatriks();

	int n = in.nextInt();
	int x = in.nextInt();
	RLB R = new RLB(n,x);
	R.bacaRLB();
	Matrix T = R.CreateRLB(x,n);
	R.persRLB(T);
    }
}