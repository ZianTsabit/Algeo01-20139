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

		for (j = 0; j < 10; j++) {
			System.out.print(this.Mat[i][j] + " ");
		}
	}

	void getKolom(int j) {
		// Mengeluarkan kolom Matrix M dengan indeks ke-j
		int i;

		for (i = 0; i < 10; j++) {
			System.out.println(this.Mat[i][j]);
		}
	}

	int getFirstIndeks(int nBrs){
		/* return indeks klom tidak nol pertama*/

	}



	/* ===INPUT ATAU OUTPUT === */
	void bacaMatriks(int M, int N) {
		// Mengisi elemen matriks M[i,j] dengan input pengguna
		Scanner in = new Scanner(System.in);
		int i, j;

		for (i = 0; i < M; i++) {
			for (j = 0; j < N; j++) {
				System.out.print("Nilai baris ke-" + i + " kolom ke-" + j + ": ");
				this.Mat[i][j] = in.nextInt();
			}
		}
	}

	void tulisMatriks(int M, int N) {
		// Mencetak elemen matriks berukuran M x N ke layar
		int i, j;

		for (i = 0; i < M; i++) {
			for (j = 0; j < N; j++) {
				System.out.print(this.Mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	/* ===FUNGSI HELPER=== */
	void tukarBaris(int M, int N) {
		// Menukar baris ke-M dengan baris ke-N
		int j, temp;

		for (j = 0; j < 10; j++) {
			temp = this.Mat[M][j];
			this.Mat[M][j] = this.Mat[N][j];
			this.Mat[N][j] = temp;
		}
	}

	void tambahBaris(int M, int N) {
		// Menambah baris ke-M dengan baris ke-N
		int j;

		for (j = 0; j < 10; j++) {
			this.Mat[M][j] = this.Mat[M][j] + this.Mat[N][j];
		}
	}

	void kurangBaris(int M, int N) {
		// Mengurang baris ke-M dengan baris ke-N
		int j;

		for (j = 0; j < 10; j++) {
			this.Mat[M][j] = this.Mat[M][j] - this.Mat[N][j];
		}
	}

	void kaliBaris(int i, int val) {
		// Mengalikan baris ke-i dengan val
		int j;

		for (j = 0; j < 10; j++) {
			this.Mat[i][j] = this.Mat[i][j] * val;
		}
	}

	void Transpose(int M, int N, int Mtrx[][]) {
		// Menghasilkan matriks transpose
		int i, j;

		for (i = 0; i < M; i++) {
			for (j = 0; j < N; j++) {
				Mtrx[N][M] = this.Mat[i][j];
			}
		}
	}

	/* VALIDITAS */
	static boolean isZero(int M[][], int i, int j) {
		// Menghasilkan true apabila baris ke-i kolom ke-j dari matriks M bernilai 0
		return (M[i][j] == 0);
	}

	static boolean isBarisZero(int M[][], int i, int kolom) {
		// Menghasilkan true apabila nilai baris ke-i dari matriks M bernilai 0
		boolean flag = true;
		int j = 0;

		while (j < kolom && flag) {
			if (M[i][j] != 0) {
				flag = false;
			}
		}
		return flag;
	}

	static boolean isPersegi(int i, int j) {
		// Menghasilkan true apabila baris matriks = kolom matriks
		return (i == j);
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

	 void gaussForm(){

	 }


}
