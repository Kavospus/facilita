/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that calculates the inverse matrix.
 */

package modelo;

import org.ejml.simple.SimpleMatrix;

public class Inverter extends Calculus {
    private double[][] input;
    private double[][] result;
    private int linesA;
    private int columnsA;

    public Inverter() {

    }

    /*Constructor*/
    public Inverter(double[][] input, int linesA, int columnsA) {
	this.input = input;
	this.linesA = linesA;
	this.columnsA = columnsA;
	this.setInputString(MatrixParser.parseString(input));
	this.setOperation("Inverter");
    }

    /*Function to invert a matrix*/
    public double[][] invertMatrix(double ma[][], int dima, int dimb) {
	double result[][] = new double[dima][dimb];
	int i, j;
	SimpleMatrix A = new SimpleMatrix(ma);
	SimpleMatrix x;
	x = A.invert();
	for (i = 0; i < dima; i++) {
	    for (j = 0; j < dimb; j++) {
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

    /*Abstract method implementation to calculate the matrix inversion operation*/
    @Override
    public void calculate() {
	this.result = invertMatrix(input, linesA, columnsA);
	this.setResultString(MatrixParser.parseString(this.result));
    }

}
