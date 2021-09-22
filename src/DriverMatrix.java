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

	//double M1[][];
	//M1 = new double[Bar][Kol];
	
	M.inverse(M);
	M.tulisMatriks();
	//for (int i =0; i < Bar-1; i++) {
		//for (int j = 0; j < Kol-1; j++) {
			//System.out.print(M1[i][j]+ " ");
		//}
		//System.out.println();
	//}
	
	//double det = M.determinanSarrus(M1,Bar-1,Kol-1);
	//System.out.print(det);
    //} 
}
}