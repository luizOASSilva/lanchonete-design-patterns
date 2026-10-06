public class XTudo extends Lanche {

    private String ovo;
    private String presunto;
    private String bacon;

    public XTudo(String ovo, String presunto, String bacon) {

        super(
            "X-Frango",
            22.00,
            "Frango + Hamburguer",
            "Mussarela",
            "Ketchup + Maionese"
        );
        this.ovo = ovo;
        this.presunto = presunto;
        this.bacon = bacon;
    }

    @Override
    public void preparar() {
      
    }
}