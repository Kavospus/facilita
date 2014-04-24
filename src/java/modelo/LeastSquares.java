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
    
    /*Function to calculate Least-Squares*/
    public double[] calculateLeastSquares(double vx[], double vy[], int qnt, int opcao)
	    throws SingularMatrixException {

	int i, dimens = 2;

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
	double result[] = new double[dimens];
	double reverteLn[] = new double[dimens];
	SimpleMatrix A = new SimpleMatrix(dimens, dimens);
	SimpleMatrix b = new SimpleMatrix(dimens, 1);
	SimpleMatrix x;

	switch (opcao) {

	    case 1:
		// Linear
		for (i = 0; i < qnt; i++) {
		    A.set(0, 0, A.get(0, 0) + Math.pow(vx[i], 2));
		    A.set(0, 1, A.get(0, 1) + vx[i]);
		    A.set(1, 0, A.get(1, 0) + vx[i]);
		    A.set(1, 1, A.get(1, 1) + 1);
		}
		for (i = 0; i < qnt; i++) {
		    b.set(0, 0, b.get(0, 0) + vx[i] * vy[i]);
		    b.set(1, 0, b.get(1, 0) + vy[i]);
		}
		x = solveMatrix(A, b, dimens);

		for (i = 0; i < dimens; i++) {
		    result[i] = x.get(i, 0);
		}
		break;
	    case 2:
		// Gauss
		for (i = 0; i < qnt; i++) {
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
		for (i = 0; i < qnt; i++) {
		    b.set(0, 0, b.get(0, 0) + Math.log(vy[i]));
		    b.set(1, 0, b.get(1, 0) + vx[i] * Math.log(vy[i]));
		    b.set(2, 0,
			    b.get(2, 0) + Math.pow(vx[i], 2) * Math.log(vy[i]));
		}
		x = solveMatrix(A, b, dimens);
		reverteLn[1] = x.get(2, 0);
		reverteLn[2] = x.get(1, 0) / (2 * reverteLn[1]);
		reverteLn[0] = Math.exp(x.get(0, 0) - reverteLn[1]
			* Math.pow(reverteLn[2], 2));

		for (i = 0; i < dimens; i++) {
		    result[i] = reverteLn[i];
		}
		break;
	    case 3:
		// Parabolico
		for (i = 0; i < qnt; i++) {
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
		for (i = 0; i < qnt; i++) {
		    b.set(0, 0, b.get(0, 0) + vy[i]);
		    b.set(1, 0, b.get(1, 0) + vx[i] * vy[i]);
		    b.set(2, 0, b.get(2, 0) + Math.pow(vx[i], 2) * vy[i]);
		}
		x = solveMatrix(A, b, dimens);

		for (i = 0; i < dimens; i++) {
		    result[i] = x.get(i, 0);
		}
		break;
	    case 4:
		// Exponencial
		for (i = 0; i < qnt; i++) {
		    A.set(0, 0, A.get(0, 0) + 1);
		    A.set(0, 1, A.get(0, 1) + vx[i]);
		    A.set(1, 0, A.get(1, 0) + vx[i]);
		    A.set(1, 1, A.get(1, 1) + Math.pow(vx[i], 2));
		}
		for (i = 0; i < qnt; i++) {
		    b.set(0, 0, b.get(0, 0) + Math.log(vy[i]));
		    b.set(1, 0, b.get(1, 0) + vx[i] * Math.log(vy[i]));
		}
		x = solveMatrix(A, b, dimens);
		reverteLn[0] = Math.exp(x.get(0, 0));
		reverteLn[1] = x.get(1, 0);
		for (i = 0; i < dimens; i++) {
		    result[i] = reverteLn[i];
		}
		break;
	}

	return result;
    }
    
    /*Static method to solve a LU decomposition*/
    public static SimpleMatrix solveMatrix(SimpleMatrix A, SimpleMatrix b,
					   int dimension)
	    throws SingularMatrixException {
	SimpleMatrix x = new SimpleMatrix(dimension, 1);
	x = A.solve(b);

	return x;
    }

    public String getErro() {
	return erro;
    }

    public void setErro(String erro) {
	this.erro = erro;
    }

}
