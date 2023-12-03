import java.util.Objects;

public class Item {

    private String nome; 

    public Item(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override // para o incremento do valor associado as chaves dar certo
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(nome, item.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}