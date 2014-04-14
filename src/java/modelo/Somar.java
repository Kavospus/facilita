/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that sum two matrices.
 */

package modelo;

import java.util.ArrayList;
import org.ejml.simple.SimpleMatrix;

public class Somar extends Calculo {
    private double[][] entradaA;
    private double[][] entradaB;
    private double[][] resultado;
    private int dimensaoA;
    private int dimensaoB;

    public Somar() {

    }
    
    /*Constructor*/
    public Somar(double[][] entradaA, double[][] entradaB, int dimensaoA,
	    int dimensaoB) {
	ArrayList<String> entradas = new ArrayList<String>();
	this.entradaA = entradaA;
	this.entradaB = entradaB;
	this.dimensaoA = dimensaoA;
	this.dimensaoB = dimensaoB;
	entradas.add(MatrixParser.parseString(entradaA));
	entradas.add(MatrixParser.parseString(entradaB));
	this.setStringEntrada(MatrixParser.concat(entradas));
	this.setOperacao("Somar");
    }
    
    /*Function to sum two matrices*/
    public double[][] somaMatrizes(double ma[][], double mb[][], int dima,
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
    public void setDadosString() {
	ArrayList<String> entradas = MatrixParser.unconcat(this
		.getStringEntrada());
	this.setEntradaA(MatrixParser.parseMatrix(entradas.get(0)));
	this.setEntradaB(MatrixParser.parseMatrix(entradas.get(1)));
	this.setDimensaoA(this.getEntradaA().length);
	this.setDimensaoB(this.getEntradaA()[0].length);
	this.setResultado(MatrixParser.parseMatrix(this.getStringResultado()));
    }
    
    /*Abstract method implementation to feed data to string*/
    @Override
    public void setStringDados() {
	ArrayList<String> entradas = new ArrayList<String>();
	entradas.add(MatrixParser.parseString(getEntradaA()));
	entradas.add(MatrixParser.parseString(getEntradaB()));
	this.setStringEntrada(MatrixParser.concat(entradas));
	this.setStringResultado(MatrixParser.parseString(this.getResultado()));
    }

    public double[][] getResultado() {
	return resultado;
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
    
    /*Abstract method implementation to calculate the operation of sum of two matrices*/
    @Override
    public void calcular() {
	this.setResultado(somaMatrizes(getEntradaA(), getEntradaB(),
		getDimensaoA(), getDimensaoB()));
	this.setStringResultado(MatrixParser.parseString(this.getResultado()));
    }

    public double[][] getEntradaA() {
	return entradaA;
    }

    public double[][] getEntradaB() {
	return entradaB;
    }

    public void setEntradaA(double[][] entradaA) {
	this.entradaA = entradaA;
    }

    public void setEntradaB(double[][] entradaB) {
	this.entradaB = entradaB;
    }

    public void setResultado(double[][] resultado) {
	this.resultado = resultado;
    }
}
