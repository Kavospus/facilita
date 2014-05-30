/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that calculates the inverse matrix.
 */

package modelo;

import org.ejml.simple.SimpleMatrix;

public class Invert extends Calculus {
    private double[][] input;
    private double[][] result;
    private int linesA;
    private int columnsA;

    public Invert() {
        this.setOperation("Invert");
    }

    /*Constructor*/
    public Invert(double[][] input, int linesA, int columnsA) {
	this.input = input;
	this.linesA = linesA;
	this.columnsA = columnsA;
	this.setInputString(MatrixParser.parseString(input));
	this.setOperation("Invert");
    }
    /**
     *
     * @param ma
     * @param linesA
     * @param columnsA
     * @return resultInverse
     * Function to invert a matrix*/
    public double[][] invertMatrix(double ma[][], int linesA, int columnsA) {
	
        double resultInverse[][] = new double[linesA][columnsA];
	int i, j;
        
	SimpleMatrix A = new SimpleMatrix(ma);
	SimpleMatrix x;
	x = A.invert();
	for (i = 0; i < linesA; i++) {
	    for (j = 0; j < columnsA; j++) {
		resultInverse[i][j] = x.get(i, j);
	    }
	}
	return resultInverse;
    }
    /**
     *
     * Abstract method implementation to calculate the matrix inversion operation*/
    @Override
    public void calculate() {
	this.result = invertMatrix(input, linesA, columnsA);
	this.setResultString(MatrixParser.parseString(this.result));
    }
    /**
     *
     * Abstract method implementation to feed data to variables*/
    @Override
    public void setDataString() {
	this.setInput(MatrixParser.parseMatrix(this.getInputString()));
	this.setLinesA(this.getInput().length);
	this.setColumnsA(this.getInput()[0].length);
	this.setResult(MatrixParser.parseMatrix(this.getResultString()));
    }
    /**
     *
     * Abstract method implementation to feed data to string*/
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
    
}
