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
		int i = 1;

		while((i <= this.kol) && !found){
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

		if (M < 0 || M > this.brs){
			System.out.println("Masukkan baris 1 tidak valid");
		}else if (N < 0 || N > this.brs){
			System.out.println("Masukkan baris 2 tidak valid");

		}else{
			for (j = 0; j < this.kol; j++) {
				temp = this.Mat[M][j];
				this.Mat[M][j] = this.Mat[N][j];
				this.Mat[N][j] = temp;
			}
		}	
	}

	public void tambahBaris(int M, int N, double k) {
		// Menambah baris ke-M dengan baris ke-N
		int j;

		if (M < 1 || M > this.brs){
			System.out.println("Masukkan baris 1 tidak valid");
		}else if(N < 1 || N > this.brs){
			System.out.println("Masukkan baris 2 tidak valid");
		}else{
			for (j = 0; j < this.kol; j++) {
				this.Mat[M][j] += (this.Mat[N][j] * k);
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
		double T[][];
		T = new double[this.brs][this.kol];

		u = 0;
		m = 0;
		while (m < this.brs) {
			if (u == i) {
				m += 1;
			} 
			for (v = 0; v < this.kol; v++) {
				T[u][v] = this.Mat[m][v];
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
			for (u = 0; u < this.brs; u++) {
				T[u][v] = T[u][n];
			}
			v += 1;
			n += 1;
		}
		
		for (i = 0; i < this.brs-1; i++) {
			for (j = 0; j < this.kol-1; j++) {
				M[i][j] = T[i][j];
			}
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

	double determinanSarrus(double[][] M,int brs, int kol) {
		int i, j, u;
		int total_kali;
		double det;
		double kali, sum;

		if (brs==2 && kol==2) {
			det = (M[0][0]*M[1][1]) - (M[0][1]*M[1][0]);
		} else {
			det = 0;
			for (j = 0; j < kol; j++) {
				i = 0;
				u = j;
				kali = 1;
				total_kali = 0;
				while (total_kali < kol) {
					kali = kali * M[i][u];
					i++;
					u++;
					if (u == kol) {
						u -= kol;
					}
					total_kali++;
				}
				det += kali;
			}

			for (j = kol - 1; j >= 0; j--) {
				i = 0;
				u = j;
				kali = 1;
				total_kali = 0;
				while (total_kali < kol) {
					kali = kali * M[i][u];
					i++;
					u--;
					if (u == -1) {
						u += kol;
					}
					total_kali++;
				}
				det -= kali;
			}
		}
		return det;
	}
	void Kofaktor() {
		
	}
	void sortMatriks(){
		int i, j;
		
		
		if (this.brs > 1){
			for (i = 1; i < this.brs;i++){
				int brsMax = i;
				for (j = i + 1;j <= this.brs;j++){
					int tempMaks = this.getFirstIndeks(j);
					if (tempMaks < this.getFirstIndeks(brsMax)){
						brsMax = j;
					}
				}
				this.tukarBaris(i, brsMax);
			}
		}

	}
	

	//fungsi untuk membuat matriks menjadi bentuk matriks echelon 
	int MakeRowEchelon(double Mat[][]){

		for (int i = 0; i < this.brs; i++){

			//Inisialisasi nilai maksimum dan index untuk pivoting
			int IdxMax = i; 
			int ValMax = (int)Mat[IdxMax][i];

			//Mencari nilai terbesar yang cocok untuk dijadikan pivot
			for (int j = i + 1;j < this.brs;j++){
				if (Math.abs(Mat[j][i]) > ValMax){
					ValMax = (int)Mat[j][i];
					IdxMax = j;
				}
			}

			//Mengecek apakah matriks singular
			if (Mat[i][IdxMax] == 0){
				return i; //Matriks singular
			}

			//Tukar baris nilai terbesar dengan baris saat ini
			if (IdxMax != i){
				tukarBaris(i, IdxMax);
			}

			for (int j = i + 1; j < this.brs;j++){
				
				double f = Mat[j][i] / Mat[i][i];
				
				for (int k = j + 1;k <= this.brs;k++){
					Mat[j][k] -= Mat[i][k] * f;
				}
				Mat[j][i] = 0;
			}
		}
		return -1;
	}


	public void gaussForm(){
		this.sortMatriks();
		for (int i = 1; i <= this.brs; i++){
			if(!this.isBarisZero(i)){
				int IdxFirst = this.getFirstIndeks(i);
				double firstCoefisien = this.Mat[i][IdxFirst];
				for (int j = i + 1; j <= this.brs;j++){
					if (!this.isBarisZero(j)){
						double k = (-1) * this.Mat[j][IdxFirst] / firstCoefisien;
						this.tambahBaris(j, i, k); 
					}
					this.Mat[j][IdxFirst] = 0;
				}
			}
		}
		for (int i = 1; i <= this.brs; i++){
			if (!this.isBarisZero(i)){
				int IdxBrs = this.getFirstIndeks(i);
				double firstCoefisien = this.Mat[i][IdxBrs];
				this.kaliBaris(i, (1 / firstCoefisien));
			}
		}
	}


}
