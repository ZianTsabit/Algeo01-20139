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

    /*    ===INPUT ATAU OUTPUT ===
    - BacaMatriks
    - TulisMatriks

        ===FUNGSI HELPER===
    - tukarBaris
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
