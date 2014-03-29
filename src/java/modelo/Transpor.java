/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that transpose matrices.
 */

package modelo;

import org.ejml.simple.SimpleMatrix;

public class Transpor extends Calculo {
    private double[][] entrada;
    private double[][] resultado;
    private int dimensaoA;
    private int dimensaoB;

    public Transpor() {

    }

    /*Constructor*/
    public Transpor(double[][] entrada, int dimensaoA, int dimensaoB) {
	this.entrada = entrada;
	this.dimensaoA = dimensaoA;
	this.dimensaoB = dimensaoB;
	this.setStringEntrada(MatrixParser.parseString(entrada));
	this.setOperacao("Transpor");
    }
    
    /*Function to transpose the matrix*/
    public double[][] transporMatriz(double ma[][], int dima, int dimb) {
	double result[][] = new double[dimb][dima];
	int i, j;
	SimpleMatrix A = new SimpleMatrix(ma);
	SimpleMatrix x;
	x = A.transpose();
	for (i = 0; i < dimb; i++) {
	    for (j = 0; j < dima; j++) {
		result[i][j] = x.get(i, j);
	    }
	}
	return result;
    }

    /*Abstract method implementation to feed data to variables*/
    @Override
    public void setDadosString() {
	this.setEntrada(MatrixParser.parseMatrix(this.getStringEntrada()));
	this.setDimensaoA(this.getEntrada().length);
	this.setDimensaoB(this.getEntrada()[0].length);
	this.setResultado(MatrixParser.parseMatrix(this.getStringResultado()));
    }

    /*Abstract method implementation to feed data to string*/
    @Override
    public void setStringDados() {
	this.setStringEntrada(MatrixParser.parseString(entrada));
	this.setStringResultado(MatrixParser.parseString(this.resultado));
    }

    public double[][] getEntrada() {
	return entrada;
    }

    public void setEntrada(double[][] entrada) {
	this.entrada = entrada;
    }

    public double[][] getResultado() {
	return resultado;
    }

    public void setResultado(double[][] resultado) {
	this.resultado = resultado;
    }

    public int getDimensaoA() {
	return dimensaoA;
    }

    public void setDimensaoA(int dimensaoA) {
	this.dimensaoA = dimensaoA;
    }

    public int getDimensaoB() {
	return dimensaoB;
    }

    public void setDimensaoB(int dimensaoB) {
	this.dimensaoB = dimensaoB;
    }

    /*Abstract method implementation to calculate the operation of matrix transposition*/
    @Override
    public void calcular() {
	this.resultado = transporMatriz(entrada, dimensaoA, dimensaoB);
	this.setStringResultado(MatrixParser.parseString(this.resultado));
    }
}
