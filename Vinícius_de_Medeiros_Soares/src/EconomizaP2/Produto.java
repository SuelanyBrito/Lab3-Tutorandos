/* 115110236 - Vinícius de Medeiros Soares: LAB 3 - Turma 1 */

package EconomizaP2;

public class Produto {

    private String nomeProduto;
    private double precoUnitario;
    private String tipoProduto;
    private int qtProduto;
       
    public Produto(String novoNome, double novoPreco, String novoTipo, int novaQt){
        this.nomeProduto = novoNome;
        this.precoUnitario = novoPreco;
        this.tipoProduto = novoTipo;
        this.qtProduto = novaQt;
    }
       
    public void setNome(String novoNome){
        this.nomeProduto = novoNome;
    }
       
    public void setPreco(double novoPreco){
        this.precoUnitario = novoPreco;
    }
       
    public void setTipo(String novoTipo){
        this.tipoProduto = novoTipo;
    }
       
    public void setQuantidade(int novaQt){
        this.qtProduto = novaQt;
    }
   
    public String getNome(){
        return this.nomeProduto;
    }
       
    public double getPreco(){
        return this.precoUnitario;
    }
       
    public String getTipo(){
        return this.tipoProduto;
    }
       
    public int getQuantidade(){
        return this.qtProduto;
    }
       
    public String toString(){
        String produto;
        produto = String.format(" " + this.nomeProduto +" ("+ this.tipoProduto +"). R$"+ this.precoUnitario + ". Restante: " + this.qtProduto);
        return produto;
    }
       
    //Utilizado para calcular o valor total que pode ser arrecadado.
    public double valorParcialEstoque(){
        double valorParcial = 0.0;
        valorParcial = valorParcial + this.precoUnitario * this.qtProduto;
        return valorParcial;
    }
   
    public boolean equals(Object objeto){
        if(objeto instanceof Produto){
            Produto outroProduto = (Produto) objeto;
            if(outroProduto.getNome().equals(this.nomeProduto)){
                return true;
            }return false;
        }return false;
    }
}