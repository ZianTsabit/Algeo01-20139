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

    void makeMatriks(Matrix M) {
    // Membuat matriks M
        M = new Matrix();
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
    // Mencetak elemen matriks ke layar
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
    } /*
    - tambahBaris
    - kaliBaris
    - 
	

        ===FUNGSI - FUNGSI===
    - determinan
    - inversMatrix
    - gauss
    - gaussJordan




    */






}
