
package modelo;

public class Menu {
    private int id;
    private String menu;
    private String link;
    private String icone;

    public Menu() {
    }

    public Menu(int id, String menu, String link, String icone) {
        this.id = id;
        this.menu = menu;
        this.link = link;
        this.icone = icone;
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

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }
    
}
