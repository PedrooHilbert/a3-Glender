import java.util.Scanner;

public class CardapioMain {
    private static Scanner input = new Scanner(System.in);
    private static Lojas lojas = new Lojas();
    private static Itens itens = new Itens(input);

    public static void main(String[] args) {
        boolean rodando = true;

        while (rodando) {
            System.out.println("EcoFood — Administrador");
            System.out.println("  1 - Acessar cardápio de uma loja");
            System.out.println("  2 - Cadastrar loja ou item");
            System.out.println("  3 - Editar item");
            System.out.println("  4 - Remover loja ou item");
            System.out.println("  5 - Listar todas as lojas");
            System.out.println("  0 - Fechar");
            System.out.print("\n  Opção: ");

            int opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> menuAcessarCardapio();
                case 2 -> menuCadastrar();
                case 3 -> menuEditarItem();
                case 4 -> menuRemover();
                case 5 -> lojas.listarLojas();
                case 0 -> {
                    System.out.println("\n  Obrigado por usar o EcoFood! Até logo.\n");
                    rodando = false;
                }
                default -> System.out.println("  ✘ Opção inválida.\n");
            }
        }
    }

    private static void menuAcessarCardapio() {
        if (lojas.isEmpty()) {
            System.out.println("  Nenhuma loja cadastrada.");
            return;
        }

        lojas.listarLojas();
        System.out.print("\n  Nome da loja: ");
        String nomeLoja = input.nextLine().trim();

        Loja loja = lojas.buscarLoja(nomeLoja);
        if (loja == null) {
            System.out.println("  ✘ Loja não encontrada.\n");
            return;
        }

        System.out.println("Cardápio — " + loja.getNome());
        System.out.println("  Filtrar por categoria?");
        System.out.println("  1 - Ver tudo");
        System.out.println("  2 - Lanche");
        System.out.println("  3 - Refeição");
        System.out.println("  4 - Bebida");
        System.out.print("\n  Opção: ");

        int opcao = lerInt();
        System.out.println();

        switch (opcao) {
            case 1 -> loja.exibirCardapio();
            case 2 -> loja.exibirCardapioCategoria("Lanche");
            case 3 -> loja.exibirCardapioCategoria("Refeição");
            case 4 -> loja.exibirCardapioCategoria("Bebida");
            default -> System.out.println("  ✘ Opção inválida.");
        }
        System.out.println();
    }

    private static void menuCadastrar() {
        exibirCabecalho("Cadastrar");
        System.out.println("  1 - Nova loja");
        System.out.println("  2 - Novo item em uma loja");
        System.out.print("\n  Opção: ");

        int opcao = lerInt();

        switch (opcao) {
            case 1 -> cadastrarLoja();
            case 2 -> cadastrarItem();
            default -> System.out.println("  ✘ Opção inválida.\n");
        }
    }

    private static void cadastrarLoja() {
        System.out.print("  Nome da loja: ");
        String nome = input.nextLine().trim();
        System.out.print("  Descrição da loja: ");
        String descricao = input.nextLine().trim();
        lojas.cadastrarLoja(nome, descricao);
        System.out.println();
    }

    private static void cadastrarItem() {
        if (lojas.isEmpty()) {
            System.out.println("  ✘ Cadastre uma loja primeiro.\n");
            return;
        }

        lojas.listarLojas();
        System.out.print("\n  Nome da loja: ");
        String nomeLoja = input.nextLine().trim();

        Loja loja = lojas.buscarLoja(nomeLoja);
        if (loja == null) {
            System.out.println("  ✘ Loja não encontrada.\n");
            return;
        }

        System.out.print("  Categoria do item (Lanche / Refeicao / Bebida): ");
        String categoria = input.nextLine().trim();

        Item novoItem = itens.criarItem(categoria);
        if (novoItem != null) { // ✅ CORRIGIDO: verificação de null restaurada
            loja.adicionarItem(novoItem);
        }
        System.out.println();
    }

    private static void menuEditarItem() {
        if (lojas.isEmpty()) {
            System.out.println("  ✘ Nenhuma loja cadastrada.\n");
            return;
        }

        lojas.listarLojas();
        System.out.print("\n  Nome da loja: ");
        String nomeLoja = input.nextLine().trim();

        Loja loja = lojas.buscarLoja(nomeLoja);
        if (loja == null) {
            System.out.println("  ✘ Loja não encontrada.\n");
            return;
        }

        loja.exibirCardapio();
        System.out.print("\n  Nome do item a editar: ");
        String nomeItem = input.nextLine().trim();

        Item item = loja.buscarItem(nomeItem);
        if (item == null) {
            System.out.println("  ✘ Item não encontrado.\n");
            return;
        }

        itens.editarItem(item);
        System.out.println();
    }

    private static void menuRemover() {
        System.out.println("Menu Remover");
        System.out.println("  1 - Remover loja");
        System.out.println("  2 - Remover item de uma loja");
        System.out.print("\n  Opção: ");

        int opcao = lerInt();

        switch (opcao) {
            case 1 -> {
                lojas.listarLojas();
                System.out.print("\n  Nome da loja a remover: ");
                String nome = input.nextLine().trim();
                lojas.removerLoja(nome);
            }
            case 2 -> {
                if (lojas.isEmpty()) {
                    System.out.println("  ✘ Nenhuma loja cadastrada.\n");
                    return;
                }
                lojas.listarLojas();
                System.out.print("\n  Nome da loja: ");
                String nomeLoja = input.nextLine().trim();
                Loja loja = lojas.buscarLoja(nomeLoja);
                if (loja == null) {
                    System.out.println("  ✘ Loja não encontrada.\n");
                    return;
                }
                loja.exibirCardapio();
                System.out.print("\n  Nome do item a remover: ");
                String nomeItem = input.nextLine().trim();
                loja.removerItem(nomeItem);
            }
            default -> System.out.println("  ✘ Opção inválida.");
        }
        System.out.println();
    }

    private static void exibirCabecalho(String titulo) {
        System.out.println("\n=== " + titulo + " ===");
    }

    private static int lerInt() {
        int valor = input.nextInt();
        input.nextLine();
        return valor;
    }
}