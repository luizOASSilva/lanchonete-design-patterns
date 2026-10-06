public class LanchoneteXSalada extends Lanchonete {
    @Override
    protected Lanche criarLanche() {
        return new XSalada("Alface, tomate e cebola roxa");
    }
}