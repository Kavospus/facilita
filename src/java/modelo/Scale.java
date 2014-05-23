/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that multiply a matrix by a scalar.
 */

package modelo;

import java.util.ArrayList;
import org.ejml.simple.SimpleMatrix;

public class Scale extends Calculus {
    private double[][] inputA;
    private double inputB;
    private double[][] result;
    private int linesA;
    private int columnsA;

    public Scale() {

    }

    /*Constructor*/
    public Scale(double[][] inputA, double inputB, int linesA,
	    int columnsA) {
	ArrayList<String> inputs = new ArrayList<String>();
	this.inputA = inputA;
	this.inputB = inputB;
	this.linesA = linesA;
	this.columnsA = columnsA;
	inputs.add(MatrixParser.parseString(inputA));
	inputs.add(MatrixParser.parseString(inputB));
	this.setInputString(MatrixParser.concat(inputs));
	this.setOperation("Scale");
    }
    /**
     *
     * @param ma
     * @param inputB
     * @param linesA
     * @param columnsA
     * @return resultMultiplicationByScalar
     * Function to multiply a matrix by a scalar*/
    public double[][] scaleMatrix(double ma[][], double inputB, int linesA, int columnsA) {
	double resultMultiplicationByScalar[][] = new double[linesA][columnsA];
	int i, j;
	SimpleMatrix A = new SimpleMatrix(ma);
	SimpleMatrix x;
	x = A.scale(inputB);

	for (i = 0; i < linesA; i++) {
	    for (j = 0; j < columnsA; j++) {
		resultMultiplicationByScalar[i][j] = x.get(i, j);
	    }
	}
	return resultMultiplicationByScalar;
    }
    /**
     *
     * Abstract method implementation to calculate the operation of multiplication of a matrix by a scalar*/
    @Override
    public void calculate() {
	this.result = scaleMatrix(getInputA(), getInputB(), linesA,
		columnsA);
	this.setResultString(MatrixParser.parseString(this.result));
    }
    /**
     *
     * Abstract method implementation to feed data to variables*/
    @Override
    public void setDataString() {
	ArrayList<String> inputs = MatrixParser.unconcat(this
		.getInputString());
	this.setInputA(MatrixParser.parseMatrix(inputs.get(0)));
	this.setInputB(MatrixParser.parseNumber(inputs.get(1)));
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
	this.setResultString(MatrixParser.parseString(this.result));
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

    public double[][] getInputA() {
	return inputA;
    }

    public void setInputA(double[][] inputA) {
	this.inputA = inputA;
    }

    public double getInputB() {
	return inputB;
    }

    public void setInputB(double inputB) {
	this.inputB = inputB;
    }
}
