public class BatataF extends Complementos {

    private String batata;
    private String chedder;

    public BatataF(String batata, String chedder) {

        super(
            "Batata Frita com chedder",
            28.00           
        );

        this.batata = batata;
        this.chedder = chedder;
    }

     public String getBatata() {
        return batata;
    }

     public String getChedder() {
        return chedder;
    }
   
   
}