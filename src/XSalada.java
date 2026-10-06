public class XSalada extends Lanche {

    private String salada;

    public XSalada(String salada) {
        super(
                "X-Salada",
                16.00,
                "Hambúrguer de Carne 120g",
                "Mussarela",
                "Maionese");
        this.salada = salada;
    }

    public String getSalada() {
        return salada;
    }

}