/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that sum two matrices.
 */

package modelo;

import java.util.ArrayList;
import org.ejml.simple.SimpleMatrix;

public class Somar extends Calculus {
    private double[][] inputA;
    private double[][] inputB;
    private double[][] result;
    private int linesA;
    private int columnsA;

    public Somar() {

    }
    
    /*Constructor*/
    public Somar(double[][] inputA, double[][] inputB, int linesA,
	    int columnsA) {
	ArrayList<String> inputs = new ArrayList<String>();
	this.inputA = inputA;
	this.inputB = inputB;
	this.linesA = linesA;
	this.columnsA = columnsA;
	inputs.add(MatrixParser.parseString(inputA));
	inputs.add(MatrixParser.parseString(inputB));
	this.setInputString(MatrixParser.concat(inputs));
	this.setOperation("Somar");
    }
    
    /*Function to sum two matrices*/
    public double[][] sumMatrices(double ma[][], double mb[][], int dima,
				   int dimb) {

	double result[][] = new double[dima][dimb];
	int i, j;
	SimpleMatrix A = new SimpleMatrix(ma);
	SimpleMatrix b = new SimpleMatrix(mb);
	SimpleMatrix x;
	x = A.plus(b);

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
	ArrayList<String> inputs = MatrixParser.unconcat(this
		.getInputString());
	this.setInputA(MatrixParser.parseMatrix(inputs.get(0)));
	this.setInputB(MatrixParser.parseMatrix(inputs.get(1)));
	this.setLinesA(this.getInputA().length);
	this.setColumnsA(this.getInputA()[0].length);
	this.setResult(MatrixParser.parseMatrix(this.getResultString()));
    }
    
    /*Abstract method implementation to feed data to string*/
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
    
    /*Abstract method implementation to calculate the operation of sum of two matrices*/
    @Override
    public void calculate() {
	this.setResult(sumMatrices(getInputA(), getInputB(),
		getLinesA(), getColumnsA()));
	this.setResultString(MatrixParser.parseString(this.getResult()));
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
