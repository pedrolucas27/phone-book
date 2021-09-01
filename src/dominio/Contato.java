package dominio;


public class Contato {
    
    private String dd;
    private String numero;
    private String nome;
    
    public Contato(){
        
    }

    public Contato(String dd, String numero, String nome){
        this.dd = dd;
        this.numero = numero;
        this.nome = nome;
    }
    
    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
