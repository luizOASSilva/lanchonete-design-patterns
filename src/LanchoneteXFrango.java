public class LanchoneteXFrango extends Lanchonete {
    @Override
    protected Lanche criarLanche() {
        return new XFrango();
    }
}