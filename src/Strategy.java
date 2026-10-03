
//criado inteface
interface FormaPagamento{
    void pagar(double valor);
}
//criando estrategias
class Dinheiro implements FormaPagamento{
    public void pagar(double valor){
        System.out.println("Pagando R$ "+ valor + "no Dinheiro");
    }

}
class Pix implements FormaPagamento{
    public void pagar(double valor){
        System.out.println("Pagando R$ "+ valor + "no Dinheiro");
    }

}
class Cartao implements FormaPagamento{
    public void pagar(double valor){
        System.out.println("Pagando R$ "+ valor + "no Dinheiro");
    }

}
class VR implements FormaPagamento{
    public void pagar(double valor){
        System.out.println("Pagando R$ "+ valor + "no Dinheiro");
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
