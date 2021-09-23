
public class SPL {
    
    Matrix mat;

    public SPL(Matrix mat2) {

        mat = new Matrix(mat2.brs, mat2.kol+mat2.kol);

        for (int i = 0; i < mat2.brs; i++) {
            for (int j = 0; j < mat2.kol; j++) {
                mat.setElmt(i, j, mat2.Mat[i][j]);
            }
        }

        for (int i = 0; i < mat2.brs; i++) {
            mat.setElmt(i, mat2.kol+i, 1);
        }

    }

    public Matrix inverseGaussJordan() {
        mat.MakeReduceEchelon();

        Matrix InvMat = new Matrix(mat.brs, mat.brs);
        for (int i = 0; i < mat.brs; i++) {
            for (int j = 0; j < mat.brs; j++) {
                InvMat.setElmt(i, j, mat.Mat[i][mat.brs+j]);
            }
        }
        return InvMat;
    }
}