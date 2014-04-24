/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that transpose matrices.
 */

package modelo;

import org.ejml.simple.SimpleMatrix;

public class Transpose extends Calculus {
    private double[][] input;
    private double[][] result;
    private int linesA;
    private int columnsA;

    public Transpose() {

    }

    /*Constructor*/
    public Transpose(double[][] input, int linesA, int columnsA) {
	this.input = input;
	this.linesA = linesA;
	this.columnsA = columnsA;
	this.setInputString(MatrixParser.parseString(input));
	this.setOperation("Transpose");
    }
    
    /*Function to transpose the matrix*/
    public double[][] transposeMatrix(double ma[][], int dima, int dimb) {
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
    public void setDataString() {
	this.setInput(MatrixParser.parseMatrix(this.getInputString()));
	this.setLinesA(this.getInput().length);
	this.setColumnsA(this.getInput()[0].length);
	this.setResult(MatrixParser.parseMatrix(this.getResultString()));
    }

    /*Abstract method implementation to feed data to string*/
    @Override
    public void setStringData() {
	this.setInputString(MatrixParser.parseString(input));
	this.setResultString(MatrixParser.parseString(this.result));
    }

    public double[][] getInput() {
	return input;
    }

    public void setInput(double[][] input) {
	this.input = input;
    }

    public double[][] getResult() {
	return result;
    }

    public void setResult(double[][] result) {
	this.result = result;
    }

    public int getLinesA() {
	return linesA;
    }

    public void setLinesA(int linesA) {
	this.linesA = linesA;
    }

    public int getColumnsA() {
	return columnsA;
    }

    public void setColumnsA(int columnsA) {
	this.columnsA = columnsA;
    }

    /*Abstract method implementation to calculate the operation of matrix transposition*/
    @Override
    public void calculate() {
	this.result = transposeMatrix(input, linesA, columnsA);
	this.setResultString(MatrixParser.parseString(this.result));
    }
}
