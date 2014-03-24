package modelo;
public class Usuario{
    private int id;
    private String nome;
    private Perfil perfil;
    private String login;
    private String senha;

    public Usuario() {
    }

    public Usuario(int id, String nome, Perfil perfil, String login, String senha) {
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

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
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

    public boolean temPermissao(String uri,String context, Usuario user){
        boolean result = false;
        String path = null;
        for(Menu m:user.getPerfil().getMenus()){
        path = context +"/"+ m.getLink();
        if(path.equals(uri)){
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
