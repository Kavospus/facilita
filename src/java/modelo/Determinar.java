package modelo;

import org.ejml.simple.SimpleMatrix;

public class Determinar extends Calculo {
    private double[][] entrada;
    private double resultado;
    private int dimensaoA;
    private int dimensaoB;

    public Determinar() {

    }

    public Determinar(double[][] entrada, int dimensaoA, int dimensaoB) {
	this.entrada = entrada;
	this.dimensaoA = dimensaoA;
	this.dimensaoB = dimensaoB;
	this.setStringEntrada(MatrixParser.parseString(entrada));
	this.setOperacao("Determinar");

    }

    @Override
    public void setDadosString() {
	this.setEntrada(MatrixParser.parseMatrix(this.getStringEntrada()));
	this.setDimensaoA(this.getEntrada().length);
	this.setDimensaoB(this.getEntrada()[0].length);
	this.setResultado(MatrixParser.parseNumber(this.getStringResultado()));
    }

    @Override
    public void setStringDados() {
	this.setStringEntrada(MatrixParser.parseString(getEntrada()));
	this.setStringResultado(MatrixParser.parseString(this.getResultado()));
    }

    public double determinanteMatriz(double ma[][]) {
	double result = 0;
	SimpleMatrix A = new SimpleMatrix(ma);
	result = A.determinant();
	return result;
    }

    @Override
    public void calcular() {
	this.setResultado(determinanteMatriz(getEntrada()));
	this.setStringResultado(MatrixParser.parseString(this.getResultado()));
    }

    public double[][] getEntrada() {
	return entrada;
    }

    public void setEntrada(double[][] entrada) {
	this.entrada = entrada;
    }

    public double getResultado() {
	return resultado;
    }

    public void setResultado(double resultado) {
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
}
