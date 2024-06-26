package src.edu.up.modelos;

public class Pessoa {
    
    int codigo;
    String nome;
    String rua;
    String cidade;
    
    public Pessoa(int codigo, String nome, String rua, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
    }

    public Pessoa() {
    }

    public Pessoa(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Pessoa(int codigo, String rua, String cidade) {
        this.codigo = codigo;
        this.rua = rua;
        this.cidade = cidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", rua=" + rua + ", cidade=" + cidade + "]";
    }

    public String toCSV() {
        return codigo + ";" + nome + ";" + rua + ";" + cidade;
    }
  
}
