/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */

package modelo;

import org.ejml.simple.SimpleMatrix;

/**
 * 
 * @author andrebsguedes
 */
public class Inverter extends Calculo {
    private double[][] entrada;
    private double[][] resultado;
    private int dimensaoA;
    private int dimensaoB;

    public Inverter() {

    }

    /*Constructor*/
    public Inverter(double[][] entrada, int dimensaoA, int dimensaoB) {
	this.entrada = entrada;
	this.dimensaoA = dimensaoA;
	this.dimensaoB = dimensaoB;
	this.setStringEntrada(MatrixParser.parseString(entrada));
	this.setOperacao("Inverter");
    }

    /*Function to invert a matrix*/
    public double[][] inverterMatriz(double ma[][], int dima, int dimb) {
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

    /*Abstract method implementation to calculate the matrix inversion operation*/
    @Override
    public void calcular() {
	this.resultado = inverterMatriz(entrada, dimensaoA, dimensaoB);
	this.setStringResultado(MatrixParser.parseString(this.resultado));
    }

}
