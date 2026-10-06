public class XTudo extends Lanche {

    private String ovo;
    private String presunto;
    private String bacontudo;

    public XTudo(String ovo, String presunto, String bacontudo) {

        super(
                "X-Frango",
                22.00,
                "Frango + Hamburguer",
                "Mussarela",
                "Ketchup + Maionese");
        this.ovo = ovo;
        this.presunto = presunto;
        this.bacontudo = bacontudo;
    }

    public String getOvo() {
        return ovo;
    }

    public String getBacontudo() {
        return bacontudo;
    }

    public String getPresunto() {
        return presunto;
    }
}