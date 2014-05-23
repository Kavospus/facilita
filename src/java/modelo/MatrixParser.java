/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Class that parser data types into matrix and matrix into
 *data types.
 */

package modelo;

import java.util.ArrayList;

public class MatrixParser {
    /**
     *
     * @param  matrix
     * @return result
     * Static method to parse a matrix into a string*/
    public static String parseString(double[][] matrix) {
	int i, j;
	String result = "{";
	for (i = 0; i < matrix.length; i++) {
	    result += "{";
	    for (j = 0; j < matrix[0].length; j++) {
		result += matrix[i][j];
		if (j != matrix[0].length - 1) {
		    result += ",";
		}
                else{
                    //Nothing to do
                }
	    }
	    result += "}";
	    if (i != matrix.length - 1) {
		result += ",";
	    }
            else{
                //Nothing to do
            }
	}
	result += "}";
	return result;
    }
    /**
     *
     * @param  num
     * @return  result
     * Static method to parse a double into a string*/
    public static String parseString(double num) {
	String result = "";
	result = "{" + num + "}";
	return result;
    }
    /**
     *
     * @param  num
     * @return  result
     * Static method to parse a string into a double*/
    public static double parseNumber(String num) {
	double result = 0;
	String aux = "";
	int i;
	for (i = 0; i < num.length(); i++) {
	    if (num.charAt(i) != '{' && num.charAt(i) != '}') {
		aux += num.charAt(i);
	    }
            else{
                //Nothing to do
            }
	}
	try {
	    result = Double.parseDouble(aux);
	} catch (Exception e) {
	}
	return result;
    }
    /**
     *
     * @param  matrix
     * @return result
    /*Static method to parse a string into a matrix*/
    public static double[][] parseMatrix(String matrix) {
	String num = "";
	int i = 0;
        int j = 0;
        int a = 0;
        int b = 0;
        int k = 0;
	for (k = 1; k < (matrix.length() - 1); k++) {
	    if (matrix.charAt(k) == ',' && matrix.charAt(k - 1) != '}') {
		b++;
	    }
            else{
                //Nothing to do
            }
	    if (matrix.charAt(k) == '}' && matrix.charAt(k + 1) != '}') {
		b = 0;
		a++;
	    }
            else{
                //Nothing to do
            }

	}
	double[][] result = new double[a + 1][b + 1];

	for (k = 1; k < (matrix.length() - 1); k++) {
	    if (matrix.charAt(k) != ',' && matrix.charAt(k) != '}'
		    && matrix.charAt(k) != '{') {
		num += matrix.charAt(k);
	    }
            else{
                //Nothing to do
            }
	    if (matrix.charAt(k) == ',' && matrix.charAt(k - 1) != '}') {
		result[i][j] = Double.parseDouble(num);
		num = "";
		j++;

	    }
            else{
                //Nothing to do
            }
	    if (matrix.charAt(k) == '}') {
		result[i][j] = Double.parseDouble(num);
		num = "";
		j = 0;
		i++;
	    }
            else{
                //Nothing to do
            }
	}

	return result;
    }
    /**
     *
     * @param  data
     * @return result
     * Static method to concatenate parsed strings*/
    public static String concat(ArrayList<String> data) {
	String result = "";
	for (String s : data) {
	    result += s + ";";
	}
	return result;
    }
    /**
     *
     * @param  data
     * @return results
     * Static method to unconcatenate concatenated strings*/
    public static ArrayList<String> unconcat(String data) {
	ArrayList<String> results = new ArrayList<String>();
	String aux = "";
	int i;
	for (i = 0; i < data.length(); i++) {
	    if (data.charAt(i) != ';') {
		aux += data.charAt(i);
	    } 
            else if (data.charAt(i) == ';') {
		results.add(aux);
		aux = "";
	    }
            else{
                //Nothing to do
            }
	}
	return results;
    }
}
