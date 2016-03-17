/* 115110236 - Vinícius de Medeiros Soares: LAB 3 - Turma 1 */

package EconomizaP2;

public class Estoque {

    private Produto[] estoque;
    
    public Estoque(int estoqueInicial){
        this.estoque = new Produto[estoqueInicial];
    }
   
    //Salva os objetos Produto no array.
    public void guardaProdutoNoEstoque(String nome, double preco, String tipo, int quantidade, int posicaoEstoque){
        Produto produto = new Produto(nome, preco, tipo, quantidade);
        this.estoque[posicaoEstoque] = produto;
    }
   
    //Dobra o array, este método é utilizado sempre que o array ficar completamente preenchido.
    private void aumentaEstoque(int tamanhoEstoque){
        Produto[] novoEstoque = new Produto[tamanhoEstoque * 2];
           
        for(int i = 0; i < tamanhoEstoque; i++){
            novoEstoque[i] = this.estoque[i];
        }
        this.estoque = novoEstoque;
    }
       
    //Retorna o índice do produto, caso esteja cadastrado, ou -1, caso não esteja cadastrado.
    public int verificaProdutoEmEstoque(String nomeProduto, int tamanhoAtualEstoque){
   
        for(int i = 0; i < tamanhoAtualEstoque; i++){
            if(nomeProduto.equals(this.estoque[i].getNome())){
                return i;
            }
        }
        return -1;
    }
 
    public void confereEstoque(int tamanhoAtualEstoque){
        if(tamanhoAtualEstoque == this.estoque.length){
            aumentaEstoque(this.estoque.length);
        }
    }
     
     
     
    // gets, sets e equals
    public double valorParcialProduto(int posicaoEstoque){
        return this.estoque[posicaoEstoque].valorParcialEstoque();
    } 
     
    public Produto getProduto(int posicaoEstoque){
        return this.estoque[posicaoEstoque];
    }
     
    public String getNomeProduto(int i){
        return estoque[i].getNome();
    }
     
    public String getTipoProduto(int i){
        return estoque[i].getTipo();
    }
     
    public double getPrecoProduto(int i){
        return estoque[i].getPreco();
    }
     
    public int getQuantidadeProduto(int i){
        return estoque[i].getQuantidade();
    }
     
    public void setNomeProduto(String novoNome, int i){
        estoque[i].setNome(novoNome);
    }
     
    public void setTipoProduto(String novoTipo, int i){
        estoque[i].setTipo(novoTipo);
    }
     
    public void setPrecoProduto(double novoPreco, int i){
        estoque[i].setPreco(novoPreco);
    }
     
    public void setQuantidadeProduto(int novoQuantidade, int i){
        estoque[i].setQuantidade(novoQuantidade);
    }
     
    public boolean equals(Object objeto){
        if(objeto instanceof Estoque){
            Estoque[] outroEstoque = (Estoque[]) objeto;
            if(outroEstoque.length != this.estoque.length){
                for (int i = 0; i < this.estoque.length; i++) {
                    if(!outroEstoque[i].equals(this.estoque[i])){
                        return false;
                    }return true;
                }
            }return false;
        }return false;
    }
      
}

