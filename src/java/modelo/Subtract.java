/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that subtract two matrices. 
 */

package modelo;

import java.util.ArrayList;
import org.ejml.simple.SimpleMatrix;

public class Subtract extends Calculus {
    private double[][] inputA;
    private double[][] inputB;
    private double[][] result;
    private int linesA;
    private int columnsA;

    public Subtract() {

    }
    
    /*Constructor*/
    public Subtract(double[][] inputA, double[][] inputB, int linesA,
	    int columnsA) {
	ArrayList<String> inputs = new ArrayList<String>();
	this.inputA = inputA;
	this.inputB = inputB;
	this.linesA = linesA;
	this.columnsA = columnsA;
	inputs.add(MatrixParser.parseString(inputA));
	inputs.add(MatrixParser.parseString(inputB));
	this.setInputString(MatrixParser.concat(inputs));
	this.setOperation("Subtract");
    }
    /**
     *
     * @param ma
     * @param mb
     * @param linesA
     * @param columnsA
     * @return resultSubtraction
     * Function to Subtract two matrices*/
    public double[][] subtractMatrices(double ma[][], double mb[][], int linesA,
				      int columnsA) {

	double resultSubtraction[][] = new double[linesA][columnsA];
	int i, j;
	SimpleMatrix A = new SimpleMatrix(ma);
	SimpleMatrix b = new SimpleMatrix(mb);
	SimpleMatrix x;
	x = A.minus(b);
	for (i = 0; i < linesA; i++) {
	    for (j = 0; j < columnsA; j++) {
		resultSubtraction[i][j] = x.get(i, j);
	    }
	}

	return resultSubtraction;
    }
    /**
     *
     * Abstract method implementation to calculate the operation*/
    @Override
    public void calculate() {
	this.setResult(subtractMatrices(getInputA(), getInputB(),
		getLinesA(), getColumnsA()));
	this.setResultString(MatrixParser.parseString(this.getResult()));
    }

    /**
     *
     * Abstract method implementation to feed data to variables*/
    @Override
    public void setDataString() {
	ArrayList<String> inputs = MatrixParser.unconcat(this
		.getInputString());
	this.setInputA(MatrixParser.parseMatrix(inputs.get(0)));
	this.setInputB(MatrixParser.parseMatrix(inputs.get(1)));
	this.setLinesA(this.getInputA().length);
	this.setColumnsA(this.getInputA()[0].length);
	this.setResult(MatrixParser.parseMatrix(this.getResultString()));
    }
    /**
     *
     * Abstract method implementation to feed data to string*/
    @Override
    public void setStringData() {
	ArrayList<String> inputs = new ArrayList<String>();
	inputs.add(MatrixParser.parseString(getInputA()));
	inputs.add(MatrixParser.parseString(getInputB()));
	this.setInputString(MatrixParser.concat(inputs));
	this.setResultString(MatrixParser.parseString(this.getResult()));
    }

    public double[][] getResult() {
	return result;
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
    
    public double[][] getInputA() {
	return inputA;
    }

    public double[][] getInputB() {
	return inputB;
    }

    public void setInputA(double[][] inputA) {
	this.inputA = inputA;
    }

    public void setInputB(double[][] inputB) {
	this.inputB = inputB;
    }

    public void setResult(double[][] result) {
	this.result = result;
    }
}
