/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: User class, contains the user attributes.
 */

package modelo;

public class User {
    private int id;
    private String nome;
    private Profile perfil;
    private String login;
    private String senha;

    public User() {
    }

    /*Constructor*/
    public User(int id, String nome, Profile perfil, String login,
	    String senha) {
	this.id = id;
	this.nome = nome;
	this.perfil = perfil;
	this.login = login;
	this.senha = senha;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Profile getProfile() {
	return perfil;
    }

    public void setProfile(Profile perfil) {
	this.perfil = perfil;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }
    
    /*Verify the permission of the User on the given context*/
    public boolean temPermissao(String uri, String context, User user) {
	boolean result = false;
	String path = null;
	for (Menu m : user.getProfile().getMenus()) {
	    path = context + "/" + m.getLink();
	    if (path.equals(uri)) {
		result = true;
	    }
	}
	return result;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

}
