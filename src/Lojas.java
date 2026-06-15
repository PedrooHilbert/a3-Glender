

import java.util.ArrayList;

public class Lojas {
    private ArrayList<Loja> lojas;

    public Lojas() { this.lojas = new ArrayList<>(); }

    public void cadastrarLoja(String nome, String descricao) {
        if (buscarLoja(nome) != null) {
            System.out.println("✘ Já existe uma loja com o nome \"" + nome + "\".");
            return;
        }
        lojas.add(new Loja(nome, descricao));
        System.out.println("✔ Loja \"" + nome + "\" cadastrada com sucesso!");
    }

    public Loja buscarLoja(String nome) {
        for (Loja loja : lojas) {
            if (loja.getNome().equalsIgnoreCase(nome)) {
                return loja;
            }
        }
        return null;
    }

    public void listarLojas() {
        if (lojas.isEmpty()) {
            System.out.println("  Nenhuma loja cadastrada.");
            return;
        }
        System.out.println("=== Lojas Cadastradas ===");
        for (int i = 0; i < lojas.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            System.out.println(lojas.get(i));
        }
    }

    public boolean removerLoja(String nome) {
        Loja loja = buscarLoja(nome);
        if (loja != null) {
            lojas.remove(loja);
            System.out.println("✔ Loja \"" + nome + "\" removida com sucesso!");
            return true;
        }
        System.out.println("✘ Loja \"" + nome + "\" não encontrada.");
        return false;
    }

    public ArrayList<Loja> getLojas() {
        return lojas;
    }

    public boolean isEmpty() {
        return lojas.isEmpty();
    }
}
