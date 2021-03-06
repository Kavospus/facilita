/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: User class, contains the user attributes.
 */

package modelo;

public class User {
    private int id;
    private String name;
    private Profile profile;
    private String login;
    private String password;

    public User() {
    }

    /*Constructor*/
    public User(int id, String name, Profile profile, String login,
	    String password) {
	this.id = id;
	this.name = name;
	this.profile = profile;
	this.login = login;
	this.password = password;
    }
    
    /**
     *
     * @param uri
     * @param context
     * @param user
     * @return result
     * Verify the permission of the User on the given context*/
    public boolean havePermission(String uri, String context, User user) {
	boolean result = false;
	String path = null;
	for (Menu m : user.getProfile().getMenus()) {
	    path = context + "/" + m.getLink();
	    if (path.equals(uri)) {
		result = true;
	    }
            else{
                //Nothing to do
            }
	}
	return result;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Profile getProfile() {
	return profile;
    }

    public void setProfile(Profile profile) {
	this.profile = profile;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
