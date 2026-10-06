public class LanchoneteXTudo extends Lanchonete {
    @Override
    protected Lanche criarLanche() {
        return new XTudo("Ovo frito", "Presunto fatiado", "Bacon crocante");
    }
}