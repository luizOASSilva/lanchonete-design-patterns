public class XSalada extends Lanche {

    private String salada;   // atributo exclusivo da XSalada

    public XSalada(String salada) {
        super(
            "X-Salada",
            16.00,
            "Hambúrguer de Carne 120g",
            "Mussarela",
            "Maionese"
        );
        this.salada = salada;
    }

    public String getSalada() { 
        return salada; 
    }

    @Override
    public void preparar() {
        System.out.println("Adicionando salada: " + salada);
        System.out.println("Adicionando " + getQueijo() + " e " + getMolho() + ".");
        System.out.println("Montando o lanche.");
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Salada: " + salada);
    }
}