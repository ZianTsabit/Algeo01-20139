
public class SPL {
    
    Matrix mat;

    public SPL(Matrix mat2) {

        Matrix mat = new Matrix(mat2.brs, mat2.kol + mat2.kol);

        for (int i = 0; i < mat.brs; i++) {
            for (int j = 0; j < mat.kol; j++) {
                mat.setElmt(i, j, mat.Mat[i][j]);
            }
        }

        for (int i = 0; i < mat.brs; i++) {
            mat.setElmt(i, mat.kol+i, 1);
        }

    }

    // Fungsi
    public void MaxDiagonal() {

        for (int i = 0; i < mat.brs; i++) {
            double mx = 0;
            int mr = i;

            for (int j = i; j < mat.brs; j++) {
                if (Math.abs(mat.Mat[j][i]) > mx) {
                    mx = Math.abs(mat.Mat[j][i]);
                    mr = j;
                }
            }

            if (mr != i) {
                mat.tukarBaris(i, mr);
            }
        }
    }

    void DivByDiagonal() {

        for (int i = 0; i < mat.brs; i++) {
            
            double idia = mat.Mat[i][i];

            for (int j = mat.brs; j < mat.kol; j++) {
                mat.setElmt(i, j, mat.Mat[i][j] / idia);
            }
            mat.setElmt(i, i, mat.Mat[i][i] / idia);
        }
    }

    void Diagonalize() {

        for (int i = 0; i < mat.brs; i++) {
            for (int j = 0; j < mat.brs; j++) {
                if (i != j) {
                    double ratio = mat.Mat[j][i] / mat.Mat[i][i];
                    mat.TambahElmt(mat, j, i, -ratio);

                }
            }
        }
    }

    public Matrix inverseGaussJordan() {
        this.MaxDiagonal();
        this.Diagonalize();
        this.DivByDiagonal();

        Matrix InvMat = new Matrix(mat.brs, mat.brs);
        for (int i = 0; i < mat.brs; i++) {
            for (int j = 0; j < mat.brs; j++) {
                InvMat.setElmt(i, j, mat.Mat[i][mat.brs+j]);
            }
        }
        return InvMat;
    }
}