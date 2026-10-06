public class XBacon extends Lanche {

    private String bacon;

    public XBacon(String bacon) {

        super(
            "X-Bacon",
            18.00,
            "Hamburguer",
            "Mussarela",
            "Ketchup + Maionese"
        );

        this.bacon = bacon;
    }

     public String getBacon() {
        return bacon;
    }
   
}