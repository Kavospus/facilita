package modelo;


/**
 *
 * @author andrebsguedes
 */
public abstract class Calculo {
    private int id;
    private String operacao;
    private String stringEntrada;
    private String stringResultado;
    private Usuario usuario;

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
    
    public abstract void calcular();
    public abstract void setDadosString();
    public abstract void setStringDados();

    public String getStringEntrada() {
        return stringEntrada;
    }

    public void setStringEntrada(String stringEntrada) {
        this.stringEntrada = stringEntrada;
    }

    public String getStringResultado() {
        return stringResultado;
    }

    public void setStringResultado(String stringResultado) {
        this.stringResultado = stringResultado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
