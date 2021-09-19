import java.util.*;


public class Matrix {

	// Atribut
	public double[][] Mat;
	protected int brs, kol;


	// Method:

	/* ===CONSTRUCTOR=== */
	public Matrix(int i, int j) {
		this.brs = i;
		this.kol = j;
		
		Mat = new double[i][j];
		for (i = 0; i < this.brs; i++) {
			for (j = 0; j < this.kol; j++) {
				Mat[i][j] = 0;
			}
		}
	}

	/* ===SELEKTOR=== */
	void getBaris(int i) {
		// Mengeluarkan baris Matrix M dengan indeks ke-i
		int j;

		for (j = 0; j < this.kol; j++) {
			System.out.print(this.Mat[i][j] + " ");
		}
	}

	void getKolom(int j) {
		// Mengeluarkan kolom Matrix M dengan indeks ke-j
		int i;

		for (i = 0; i < this.brs; j++) {
			System.out.println(this.Mat[i][j]);
		}
	}

	public int getJmlBrs(){
		// Mengeluarkan jumlah baris
		return this.brs;
	}

	public int getJmlKol(){
		//Mengeluarkan jumlah kolom
		return	this.kol;
	}

	int getFirstIndeks(int jmlBrs){
		/* return indeks kolom tidak nol pertama*/
		boolean found = false;
		int i = 0;

		while((i < this.kol) && !found){
			if (this.Mat[jmlBrs][i] != 0){
				found = true;
			}else{
				i++;
			}
		}
		if (found){
			return i;
		}else{
			return this.kol;
		}


	}


	/* ===INPUT ATAU OUTPUT === */
	void bacaMatriks() {
		// Mengisi elemen matriks M[i,j] dengan input pengguna
		Scanner in = new Scanner(System.in);
		int i, j;

		for (i = 0; i < this.brs; i++) {
			for (j = 0; j < this.kol; j++) {
				this.Mat[i][j] = in.nextInt();
			}
		}
	}

	void tulisMatriks() {
		// Mencetak elemen matriks berukuran M x N ke layar
		int i, j;

		for (i = 0; i < this.brs; i++) {
			for (j = 0; j < this.kol; j++) {
				System.out.print(this.Mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	/* ===FUNGSI HELPER=== */
	public void tukarBaris(int M, int N) {
		// Menukar baris ke-M dengan baris ke-N
		int j; 
		double temp;

		if (M < 1 || M > this.brs){
			System.out.println("Masukkan baris 1 tidak valid");
		}else if (N < 1 || N > this.brs){
			System.out.println("Masukkan baris 2 tidak valid");

		}else{
			for (j = 0; j < this.kol; j++) {
				temp = this.Mat[M][j];
				this.Mat[M][j] = this.Mat[N][j];
				this.Mat[N][j] = temp;
			}
		}	
	}

	public void tambahBaris(int M, int N) {
		// Menambah baris ke-M dengan baris ke-N
		int j;

		if (M < 1 || M > this.brs){
			System.out.println("Masukkan baris 1 tidak valid");
		}else if(N < 1 || N > this.brs){
			System.out.println("Masukkan baris 2 tidak valid");
		}else{
			for (j = 0; j < this.kol; j++) {
				this.Mat[M][j] = this.Mat[M][j] + this.Mat[N][j];
			}
		}
	}

	void kurangBaris(int M, int N) {
		// Mengurang baris ke-M dengan baris ke-N
		int j;
		if (M < 1 || M > this.brs){
			System.out.println("Masukkan baris 1 tidak valid");
		}else if(N < 1 || N > this.brs){
			System.out.println("Masukkan baris 2 tidak valid");
		}else{
			for (j = 0; j < this.kol; j++) {
				this.Mat[M][j] = this.Mat[M][j] - this.Mat[N][j];
			}
		}
	}

	void kaliBaris(int i, double val) {
		// Mengalikan baris ke-i dengan val
		if (i < 1 || i > this.brs){
			System.out.println("Masukkan baris tidak valid");
		}else{
			if (val == 0){
				System.out.println("Masukkan konstanta tidak valid");
			}else{
				for (int j = 0; j < this.kol; j++) {
					this.Mat[i][j] = this.Mat[i][j] * val;
				}

			}

			
		}
	}

	void Transpose(double Mtrx[][]) {
		// Menghasilkan matriks transpose
		int i, j;

		for (i = 0; i < this.brs; i++) {
			for (j = 0; j < this.kol; j++) {
				Mtrx[j][i] = this.Mat[i][j];
			}
		}
	}

	void reduceMatriks(double M[][], int i, int j) {
		// Membuat matriks tanpa memasukkan baris ke-i dan kolom ke-j
		int u, v;
		int m, n;

		u = 0;
		m = 0;
		while (m < this.brs) {
			if (u == i) {
				m += 1;
			} 
			for (v = 0; v < this.kol; v++) {
				M[u][v] = this.Mat[m][v];
			}
			u += 1;
			m += 1;
		}

		v = 0;
		n = 0;
		while (n < this.kol) {
			if (v == j) {
				n += 1;
			} 
			for (u = 0; u < this.kol; u++) {
				M[u][v] = this.Mat[u][n];
			}
			v += 1;
			n += 1;
		}
	}

	

	/* VALIDITAS */
	boolean isZero(int i, int j) {
		// Menghasilkan true apabila baris ke-i kolom ke-j dari matriks M bernilai 0
		return (this.Mat[i][j] == 0);
	}

	boolean isBarisZero(int i) {
		// Menghasilkan true apabila nilai baris ke-i dari matriks M bernilai 0
		boolean flag = true;
		int j = 0;

		while (j < this.kol && flag) {
			if (this.Mat[i][j] != 0) {
				flag = false;
			}
		}
		return flag;
	}

	boolean isPersegi() {
		// Menghasilkan true apabila baris matriks = kolom matriks
		return (this.brs == this.kol);
	}

	boolean isIdxValid(int i, int j) {
		// Menghasilkan true apabila index valid
		return (i >= 0 && i < this.brs && j >= 0 && j < this.kol);
	}

	/*
	 * ===FUNGSI - FUNGSI=== 
	 * - determinan 
	 * - inversMatrix 
	 * - gauss 
	 * - gaussJordan
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	void d() {
	}
	public void sortMatriks(){

	}
	



	void gaussForm(){

	}


}
