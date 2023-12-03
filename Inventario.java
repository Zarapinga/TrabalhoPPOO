import java.util.HashMap;
import java.util.Map;
public class Inventario {

    private HashMap<Item, Integer> listaInventario;

    public Inventario() {
        listaInventario = new HashMap<Item, Integer>();
    } 
    
    public void adicionarItem(String nome) {
        Item objetoAdd = new Item(nome);
        if (verificarItem(nome)) {
            Integer qtdAtual = listaInventario.get(objetoAdd);
            listaInventario.put(objetoAdd, qtdAtual + 1);
        } else {    
            listaInventario.put(objetoAdd, 1);
        }
    }

    public int buscarItem(String nome) {
        
        for (Map.Entry<Item, Integer> entrada : listaInventario.entrySet()) {
            Item objeto = entrada.getKey();
            if (objeto.getNome().equals(nome)) {
                return entrada.getValue(); 
            }
        }
        return -1; 
    }

    public void decrementarItem(String nome) {
        Item objetoAdd = new Item(nome);
        if (verificarItem(nome)) {
            Integer qtdAtual = listaInventario.get(objetoAdd);
            if (qtdAtual > 0) {

                listaInventario.put(objetoAdd, qtdAtual - 1);

            }
        } else {    
            System.out.println("Item nao encontrado...");
        }
    }

    public boolean verificarItem(String nome) {
        return buscarItem(nome) >= 0;
    }

    public void listarItens() {
        System.out.println("Listando itens no inventario: ");
        for (Map.Entry<Item, Integer> entrada : listaInventario.entrySet()) {
            Item objeto = entrada.getKey();
            System.out.println(objeto.getNome() + " " + entrada.getValue());           
        }
        System.out.println("Todos os itens listados.");
    }

    public boolean mochilaVazia() {
        if (listaInventario.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}