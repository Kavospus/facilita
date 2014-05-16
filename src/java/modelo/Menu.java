/*
*Licensed under ..., see LICENSE.md
*Authors: André Bernardes.
*Created on: 28/03/2014, 11:23:34
*Description: Menu class, contains the menu attributes.
*/

package modelo;

public class Menu {
    private int id;
    private String menu;
    private String link;
    private String icon;

    public Menu() {
    }

    /*Constructor*/
    public Menu(int id, String menu, String link, String icon) {
        this.id = id;
        this.menu = menu;
        this.link = link;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
