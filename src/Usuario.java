public class Usuario {
    private String nome;
    private String funcao;

    public Usuario(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
    }
    
    public Usuario(){};    
    

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
