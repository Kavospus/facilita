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
public class Transpor extends Calculo {
    private double[][] entrada;
    private double[][] resultado;
    private int dimensaoA;
    private int dimensaoB;

    public Transpor() {

    }

    public Transpor(double[][] entrada, int dimensaoA, int dimensaoB) {
	this.entrada = entrada;
	this.dimensaoA = dimensaoA;
	this.dimensaoB = dimensaoB;
	this.setStringEntrada(MatrixParser.parseString(entrada));
	this.setOperacao("Transpor");
    }

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

    @Override
    public void setDadosString() {
	this.setEntrada(MatrixParser.parseMatrix(this.getStringEntrada()));
	this.setDimensaoA(this.getEntrada().length);
	this.setDimensaoB(this.getEntrada()[0].length);
	this.setResultado(MatrixParser.parseMatrix(this.getStringResultado()));
    }

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

    @Override
    public void calcular() {
	this.resultado = transporMatriz(entrada, dimensaoA, dimensaoB);
	this.setStringResultado(MatrixParser.parseString(this.resultado));
    }
}
