/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Profile class, contains the profile attributes.
 */

package modelo;

import java.util.ArrayList;

public class Profile {
    private int id;
    private String profile;
    private ArrayList<Menu> menus;

    public Profile() {
    }

    /*Constructor*/
    public Profile(int id, String profile) {
	this.id = id;
	this.profile = profile;
    }

    /*Constructor*/
    public Profile(int id, String profile, ArrayList<Menu> menus) {
	this.id = id;
	this.profile = profile;
	this.menus = menus;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getProfile() {
	return profile;
    }

    public void setProfile(String profile) {
	this.profile = profile;
    }

    public ArrayList<Menu> getMenus() {
	return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
	this.menus = menus;
    }

}
