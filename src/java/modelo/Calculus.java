/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Abstract class Calculus. This class contains common
 *methods and variables of the operation classes.
 */

package modelo;


public abstract class Calculus {
    private int id;
    private String operation;
    private String dataString;
    private String resultString;
    private User user;

    public String getOperation() {
	return operation;
    }

    public void setOperation(String operation) {
	this.operation = operation;
    }

    public abstract void calculate();

    public abstract void setDataString();

    public abstract void setStringData();

    public String getInputString() {
	return dataString;
    }

    public void setInputString(String dataString) {
	this.dataString = dataString;
    }

    public String getResultString() {
	return resultString;
    }

    public void setResultString(String resultString) {
	this.resultString = resultString;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }
}
