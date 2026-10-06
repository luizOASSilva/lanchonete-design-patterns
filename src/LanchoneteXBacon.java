public class LanchoneteXBacon extends Lanchonete {
    @Override
    protected Lanche criarLanche() {
        return new XBacon("Bacon");
    }
}