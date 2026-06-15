import java.util.ArrayList;


public class Loja {
    private String nome;
    private String descricao;
    private ArrayList<Item> itens;

    public Loja(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.itens = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public ArrayList<Item> getItens() { return itens; }

    public void adicionarItem(Item item) {
        itens.add(item);
        System.out.println("✔ Item \"" + item.getNome() + "\" adicionado com sucesso!");
    }

    public boolean removerItem(String nomeItem) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itens.remove(item);
                System.out.println("✔ Item \"" + nomeItem + "\" removido com sucesso!");
                return true;
            }
        }
        System.out.println("✘ Item \"" + nomeItem + "\" não encontrado.");
        return false;
    }
    public Item buscarItem(String nomeItem) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return item;
            }
        }
        return null;
    }

    public void exibirCardapio() {
        if (itens.isEmpty()) {
            System.out.println("  Nenhum item cadastrado nesta loja.");
            return;
        }
        for (int i = 0; i < itens.size(); i++) {
            System.out.println("\n  [" + (i + 1) + "]");
            System.out.println(itens.get(i));
        }
    }

    public void exibirCardapioCategoria(String categoria) {
        boolean encontrou = false;
        for (Item item : itens) {
            if (item.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(item);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("  Nenhum item da categoria \"" + categoria + "\" encontrado.");
        }
    }


    public String toString() {
        return String.format("  Nome: %s\n  Descrição: %s\n  Itens cadastrados: %d", nome, descricao, itens.size());
    }
}

