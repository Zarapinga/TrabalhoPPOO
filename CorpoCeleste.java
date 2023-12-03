import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CorpoCeleste {

    private String nome;
    private String descricao;
    private String tipo;
    private HashMap<Item, Integer> itens;
    private int temItem;
    private boolean foiExplorado;

    public CorpoCeleste(String nome, String descricao, String tipo) {

        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        itens = new HashMap<Item, Integer>();
        temItem = 0;
        foiExplorado = false;
        gerarItens();

    }

    public String getTipo() {

        return tipo;

    }

    public String getDescricao() {

        return descricao;

    }

    public String getNome() {

        return nome;

    }

    public void gerarItens() {

        Item objetoAdd;

        if (chanceDeGerarItem()) {

            objetoAdd = new Item("java coffee");
            itens.put(objetoAdd, 1);
            temItem++;

        }

        if (chanceDeGerarItem()) {

            objetoAdd = new Item("rebimboca de parafuso");
            itens.put(objetoAdd, 1);
            temItem++;

        }

        if (chanceDeGerarItem()) {

            objetoAdd = new Item("combustivel");
            itens.put(objetoAdd, 1);
            temItem++;

        }

    }

    public boolean chanceDeGerarItem() {

        Random random = new Random();
        int aleatorio = random.nextInt(5);

        if (aleatorio == 0) {

            return true;

        }

        return false;
        
    }

    public String pegarItens() {

        String itensDisponiveis = "";

        for (Map.Entry<Item, Integer> entrada : itens.entrySet()) {
            Item objeto = entrada.getKey();
            itensDisponiveis += objeto.getNome() + "-";           
        }

        return itensDisponiveis;

    }

    public boolean getTemItem() {

        return temItem > 0;

    }

    public int getQuantidadeDeItem() {

        return temItem;

    }

    public boolean getFoiExplorado() {

        return foiExplorado;
        
    }

    public void setFoiExplorado() {

        foiExplorado = true;
        
    }

}
