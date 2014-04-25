/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that calculates the determinant.
 */


package modelo;

import org.ejml.simple.SimpleMatrix;

public class Determine extends Calculus {
    private double[][] input;
    private double result;
    private int linesA;
    private int columnsA;

    public Determine() {

    }

    /*Constructor*/
    public Determine(double[][] input, int linesA, int columnsA) {
	this.input = input;
	this.linesA = linesA;
	this.columnsA = columnsA;
	this.setInputString(MatrixParser.parseString(input));
	this.setOperation("Determine");

    }

    /*Abstract method implementation to feed data to variables*/
    @Override
    public void setDataString() {
	this.setInput(MatrixParser.parseMatrix(this.getInputString()));
	this.setLinesA(this.getInput().length);
	this.setColumnsA(this.getInput()[0].length);
	this.setResult(MatrixParser.parseNumber(this.getResultString()));
    }

    /*Abstract method implementation to feed data to string*/
    @Override
    public void setStringData() {
	this.setInputString(MatrixParser.parseString(getInput()));
	this.setResultString(MatrixParser.parseString(this.getResult()));
    }

    /*Function to calculate the determinant of a matrix*/
    public double determineMatrix(double ma[][]) {
	double resultDeterminant = 0;
	SimpleMatrix A = new SimpleMatrix(ma);
	resultDeterminant = A.determinant();
	return resultDeterminant;
    }

    /*Abstract method implementation to calculate the operation of determinant of a matrix*/
    @Override
    public void calculate() {
	this.setResult(determineMatrix(getInput()));
	this.setResultString(MatrixParser.parseString(this.getResult()));
    }

    public double[][] getInput() {
	return input;
    }

    public void setInput(double[][] input) {
	this.input = input;
    }

    public double getResult() {
	return result;
    }

    public void setResult(double result) {
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
