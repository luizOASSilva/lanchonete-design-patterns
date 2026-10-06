
//criado inteface
interface FormaPagamento{
    void pagar(double valor);
}
//criando estrategias
class Dinheiro implements FormaPagamento{
    public void pagar(double valor){
        System.out.println("Pagando R$ "+ valor + " no Dinheiro");
    }

}
class Pix implements FormaPagamento{
    public void pagar(double valor){
        System.out.println("Pagando R$ "+ valor + "no PIX");
    }

}
class Cartao implements FormaPagamento{
    public void pagar(double valor){
        System.out.println("Pagando R$ "+ valor + " no Cartão");
    }

}
class VR implements FormaPagamento{
    public void pagar(double valor){
        System.out.println("Pagando R$ "+ valor + " no VR");
    }

}

class Carrinho{
    private FormaPagamento forma;

    public void setForma(FormaPagamento forma){
        this.forma = forma;
    }
    public void finalizarCompra(double valor){
        forma.pagar(valor);
    }

}
    
class Pagamento {
    private java.util.Map<String, FormaPagamento> formas = new java.util.HashMap<>();

    public Pagamento() {
        formas.put("pix", new Pix());
        formas.put("cartao", new Cartao());
        formas.put("dinheiro", new Dinheiro());
        formas.put("vr", new VR());
    }

    public FormaPagamento escolher(String nome) {
        return formas.get(nome.toLowerCase());
    }
}


