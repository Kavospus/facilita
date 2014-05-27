/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that calculates least-squares to a linear,gauss,
 *parabolico or exponential functions.
 */

package modelo;

import org.ejml.factory.SingularMatrixException;
import org.ejml.simple.SimpleMatrix;


public class LeastSquares {

    String erro = null;
    /**
     *
     * @param vx
     * @param  vy
     * @param qnt
     * @param opcao
     * @throws SingularMatrixException
     * @return resultLeastSquares
     * Function to calculate Least-Squares*/
    public double[] calculateLeastSquares(double vx[], double vy[], int qnt, int opcao)
	    throws SingularMatrixException {

        int dimens = 2;

	switch (opcao) {

	    case 1:
		dimens = 2;
		break;
	    case 2:
		dimens = 3;
		break;
	    case 3:
		dimens = 3;
		break;
	    case 4:
		dimens = 2;
		break;
	}

        double resultLeastSquares[] = new double[dimens];
	double reverteLn[] = new double[dimens];
	SimpleMatrix A = new SimpleMatrix(dimens, dimens);
	SimpleMatrix b = new SimpleMatrix(dimens, 1);
	SimpleMatrix x;
        int i;

        switch (opcao) {

	    case 1:
		// Linear
                x = linearAdjust(A, b, dimens, qnt, vx, vy);
		for (i = 0; i < dimens; i++) {
		    resultLeastSquares[i] = x.get(i, 0);
		}
		break;
	    case 2:
		// Gauss
                x = gaussianAdjust(A, b, dimens, qnt, vx, vy);
		reverteLn[1] = x.get(2, 0);
		reverteLn[2] = x.get(1, 0) / (2 * reverteLn[1]);
		reverteLn[0] = Math.exp(x.get(0, 0) - reverteLn[1]
			* Math.pow(reverteLn[2], 2));

		for (i = 0; i < dimens; i++) {
		    resultLeastSquares[i] = reverteLn[i];
		}
		break;
	    case 3:
		// Parabolico
                x = parabolicAdjust(A, b, dimens, qnt, vx, vy);
		for (i = 0; i < dimens; i++) {
		    resultLeastSquares[i] = x.get(i, 0);
		}
		break;
	    case 4:
		// Exponencial                
                x = expAdjust(A, b, dimens, qnt, vx, vy);
		reverteLn[0] = Math.exp(x.get(0, 0));
		reverteLn[1] = x.get(1, 0);
		for (i = 0; i < dimens; i++) {
		    resultLeastSquares[i] = reverteLn[i];
		}
		break;
	}

	return resultLeastSquares;
    }
    
    SimpleMatrix linearAdjust(SimpleMatrix A, SimpleMatrix b, int dimens, 
            int qnt, double vx[], double vy[]) {
        for (int i = 0; i < qnt; i++) {
		    A.set(0, 0, A.get(0, 0) + Math.pow(vx[i], 2));
		    A.set(0, 1, A.get(0, 1) + vx[i]);
		    A.set(1, 0, A.get(1, 0) + vx[i]);
		    A.set(1, 1, A.get(1, 1) + 1);
		}
		for (int i = 0; i < qnt; i++) {
		    b.set(0, 0, b.get(0, 0) + vx[i] * vy[i]);
		    b.set(1, 0, b.get(1, 0) + vy[i]);
		}
		return solveMatrix(A, b, dimens);
    }
    
    SimpleMatrix gaussianAdjust(SimpleMatrix A, SimpleMatrix b, int dimens,
            int qnt, double vx[], double vy[]) {
        for (int i = 0; i < qnt; i++) {
		    A.set(0, 0, A.get(0, 0) + 1);
		    A.set(0, 1, A.get(0, 1) + vx[i]);
		    A.set(0, 2, A.get(0, 2) + Math.pow(vx[i], 2));
		    A.set(1, 0, A.get(1, 0) + vx[i]);
		    A.set(1, 1, A.get(1, 1) + Math.pow(vx[i], 2));
		    A.set(1, 2, A.get(1, 2) + Math.pow(vx[i], 3));
		    A.set(2, 0, A.get(2, 0) + Math.pow(vx[i], 2));
		    A.set(2, 1, A.get(2, 1) + Math.pow(vx[i], 3));
		    A.set(2, 2, A.get(2, 2) + Math.pow(vx[i], 4));
		}
		for (int i = 0; i < qnt; i++) {
		    b.set(0, 0, b.get(0, 0) + Math.log(vy[i]));
		    b.set(1, 0, b.get(1, 0) + vx[i] * Math.log(vy[i]));
		    b.set(2, 0,
			    b.get(2, 0) + Math.pow(vx[i], 2) * Math.log(vy[i]));
		}
                
                return solveMatrix(A, b, dimens);
    }
    
    SimpleMatrix parabolicAdjust(SimpleMatrix A, SimpleMatrix b, int dimens,
            int qnt, double vx[], double vy[]){
        for (int i = 0; i < qnt; i++) {
		    A.set(0, 0, A.get(0, 0) + 1);
		    A.set(0, 1, A.get(0, 1) + vx[i]);
		    A.set(0, 2, A.get(0, 2) + Math.pow(vx[i], 2));
		    A.set(1, 0, A.get(1, 0) + vx[i]);
		    A.set(1, 1, A.get(1, 1) + Math.pow(vx[i], 2));
		    A.set(1, 2, A.get(1, 2) + Math.pow(vx[i], 3));
		    A.set(2, 0, A.get(2, 0) + Math.pow(vx[i], 2));
		    A.set(2, 1, A.get(2, 1) + Math.pow(vx[i], 3));
		    A.set(2, 2, A.get(2, 2) + Math.pow(vx[i], 4));
		}
		for (int i = 0; i < qnt; i++) {
		    b.set(0, 0, b.get(0, 0) + vy[i]);
		    b.set(1, 0, b.get(1, 0) + vx[i] * vy[i]);
		    b.set(2, 0, b.get(2, 0) + Math.pow(vx[i], 2) * vy[i]);
		}
                
		return solveMatrix(A, b, dimens);
    }
    
    SimpleMatrix expAdjust(SimpleMatrix A, SimpleMatrix b, int dimens,
            int qnt, double vx[], double vy[]) {
        for (int i = 0; i < qnt; i++) {
		    A.set(0, 0, A.get(0, 0) + 1);
		    A.set(0, 1, A.get(0, 1) + vx[i]);
		    A.set(1, 0, A.get(1, 0) + vx[i]);
		    A.set(1, 1, A.get(1, 1) + Math.pow(vx[i], 2));
		}
		for (int i = 0; i < qnt; i++) {
		    b.set(0, 0, b.get(0, 0) + Math.log(vy[i]));
		    b.set(1, 0, b.get(1, 0) + vx[i] * Math.log(vy[i]));
		}
		
                return solveMatrix(A, b, dimens);
    }
    /**
     *
     * @param A
     * @param b
     * @param  dimension
     * @throws SingularMatrixException
     * @return resultMatrixLU
     * Static method to solve a LU decomposition*/
    public static SimpleMatrix solveMatrix(SimpleMatrix A, SimpleMatrix b,
					   int dimension)
	    throws SingularMatrixException {
	SimpleMatrix resultMatrixLU = new SimpleMatrix(dimension, 1);
	resultMatrixLU = A.solve(b);

	return resultMatrixLU;
    }

    public String getErro() {
	return erro;
    }

    public void setErro(String erro) {
	this.erro = erro;
    }

}
