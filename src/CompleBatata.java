public class CompleBatata extends AddComplemento {

    @Override
    protected Complementos criarComplemento() {
        return new BatataF("Batata Frita", "Chedder");
    }
}