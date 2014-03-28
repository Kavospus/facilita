package modelo;

import java.util.ArrayList;

public class MatrixParser {
    
    /*Static method to parse a matrix into a string*/
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
	    }
	    result += "}";
	    if (i != matrix.length - 1) {
		result += ",";
	    }
	}
	result += "}";
	return result;
    }
    
    /*Static method to parse a double into a string*/
    public static String parseString(double num) {
	String result = "";
	result = "{" + num + "}";
	return result;
    }
    
    /*Static method to parse a string into a double*/
    public static double parseNumber(String num) {
	double result = 0;
	String aux = "";
	int i;
	for (i = 0; i < num.length(); i++) {
	    if (num.charAt(i) != '{' && num.charAt(i) != '}') {
		aux += num.charAt(i);
	    }
	}
	try {
	    result = Double.parseDouble(aux);
	} catch (Exception e) {
	}
	return result;
    }
    
    /*Static method to parse a string into a matrix*/
    public static double[][] parseMatrix(String matrix) {
	String num = "";
	int i = 0, j = 0, a = 0, b = 0, k;
	for (k = 1; k < (matrix.length() - 1); k++) {
	    if (matrix.charAt(k) == ',' && matrix.charAt(k - 1) != '}') {
		b++;
	    }
	    if (matrix.charAt(k) == '}' && matrix.charAt(k + 1) != '}') {
		b = 0;
		a++;
	    }

	}
	double[][] result = new double[a + 1][b + 1];

	for (k = 1; k < (matrix.length() - 1); k++) {
	    if (matrix.charAt(k) != ',' && matrix.charAt(k) != '}'
		    && matrix.charAt(k) != '{') {
		num += matrix.charAt(k);
	    }
	    if (matrix.charAt(k) == ',' && matrix.charAt(k - 1) != '}') {
		result[i][j] = Double.parseDouble(num);
		num = "";
		j++;

	    }
	    if (matrix.charAt(k) == '}') {
		result[i][j] = Double.parseDouble(num);
		num = "";
		j = 0;
		i++;
	    }
	}

	return result;
    }
    
    /*Static method to concatenate parsed strings*/
    public static String concat(ArrayList<String> data) {
	String result = "";
	for (String s : data) {
	    result += s + ";";
	}
	return result;
    }
    
    /*Static method to unconcatenate concatenated strings*/
    public static ArrayList<String> unconcat(String data) {
	ArrayList<String> results = new ArrayList<String>();
	String aux = "";
	int i;
	for (i = 0; i < data.length(); i++) {
	    if (data.charAt(i) != ';') {
		aux += data.charAt(i);
	    } else if (data.charAt(i) == ';') {
		results.add(aux);
		aux = "";
	    }
	}
	return results;
    }
}
