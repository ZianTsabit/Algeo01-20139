import java.util.*;

class Matrix {
    
	// Atribut
	int[][] Mat = new int[10][10];

	// Method:

	/* ===CONSTRUCTOR=== */
	Matrix() {
        	int i,j;

        	for (i=0; i<10; i++) {
			for (j=0; j<10; j++) {
				this.Mat[i][j] = 0;
			}
		}
	}

	/* ===SELEKTOR=== */
	void getBaris(int i) {
	// Mengeluarkan baris Matrix M dengan indeks ke-i
		int j;

		for (j=0; j<10; j++) {
	    		System.out.print(this.Mat[i][j] + " ");
		}
    	}
    	void getKolom(int j) {
    	// Mengeluarkan kolom Matrix M dengan indeks ke-j
        	int i;

		for (i=0; i<10; j++) {
	    		System.out.println(this.Mat[i][j]);
		}
    	}

    	/* ===INPUT ATAU OUTPUT === */
    	void bacaMatriks(int M, int N) {
    	// Mengisi elemen matriks M[i,j] dengan input pengguna
		Scanner in = new Scanner (System.in);
		int i, j;

		for (i=0; i<M; i++) {
	    		for (j=0; j<N; j++) {
				System.out.print("Nilai baris ke-" + i + " kolom ke-" + j + ": ");
				this.Mat[i][j] = in.nextInt();
	    		}
		}
    	}
    	void tulisMatriks(int M, int N) {
    	// Mencetak elemen matriks berukuran M x N ke layar
		int i, j;

		for (i=0; i<M; i++) {
	    		for (j=0; j<N; j++) {
				System.out.print(this.Mat[i][j] + " ");
	    		}
	    		System.out.println();
		}
    	}

    	/* ===FUNGSI HELPER=== */
    	void tukarBaris(int M, int N) {
    	// Menukar baris ke-M dengan baris ke-N
		int j, temp;

		for (j=0; j<10; j++) {
	    		temp = this.Mat[M][j];
	    		this.Mat[M][j] = this.Mat[N][j];
	    		this.Mat[N][j] = temp;
		}
    	}
    	void tambahBaris(int M, int N) {
    	// Menambah baris ke-M dengan baris ke-N
		int j;

		for (j=0; j<10; j++) {
	    		this.Mat[M][j] = this.Mat[M][j] + this.Mat[N][j];
		}
    	}
    	void kaliBaris(int i, int val) {
    	// Mengalikan baris ke-i dengan val
		int j;

		for (j=0; j<10; j++) {
	    		this.Mat[i][j] = this.Mat[i][j] * val;
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

		while (j<kolom && flag) {
	    		if (M[i][j] != 0) {
				flag = false;
	    		}
		}
		return flag;
    	}

    	/* ===FUNGSI - FUNGSI===
    - determinan
    - inversMatrix
    - gauss
    - gaussJordan




    
    */
    void Gauss(




}
