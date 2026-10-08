public class CompleRefri extends AddComplemento {

    @Override
    protected Complementos criarComplemento() {
        return new Refrigerante();
    }
}