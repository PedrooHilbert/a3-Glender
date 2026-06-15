import java.util.Scanner;

public class Itens {
    private Scanner input;

    public Itens(Scanner input) {
        this.input = input;
    }

    public Item criarItem(String categoria) {
        System.out.print("  Nome: ");
        String nome = input.nextLine().trim();
        System.out.print("  Subtítulo: ");
        String subtitulo = input.nextLine().trim();
        System.out.print("  Valor antigo (R$): ");
        double valorAntigo = Double.parseDouble(input.nextLine().trim());
        System.out.print("  Valor atual (R$): ");
        double valorAtual = Double.parseDouble(input.nextLine().trim());
        System.out.print("  Quantidade: ");
        int quantidade = Integer.parseInt(input.nextLine().trim());
        System.out.print("  Horário de retirada (ex: 18): ");
        int horario = Integer.parseInt(input.nextLine().trim());

        return switch (categoria.toLowerCase()) {
            case "lanche"   -> new Lanche(nome, subtitulo, valorAntigo, valorAtual, quantidade, horario);
            case "refeicao" -> new Refeicao(nome, subtitulo, valorAntigo, valorAtual, quantidade, horario);
            case "bebida"   -> new Bebida(nome, subtitulo, valorAntigo, valorAtual, quantidade, horario);
            default -> {
                System.out.println("  ✘ Categoria inválida.");
                yield null;
            }
        };
    }

    public void editarItem(Item item) {
        System.out.println("  Editando: " + item.getNome());
        System.out.println("  (Enter para manter o valor atual)");

        System.out.print("  Novo nome [" + item.getNome() + "]: ");
        String nome = input.nextLine().trim();
        if (!nome.isEmpty()) item.setNome(nome);

        System.out.print("  Novo subtítulo [" + item.getSubtitulo() + "]: ");
        String sub = input.nextLine().trim();
        if (!sub.isEmpty()) item.setSubtitulo(sub);

        System.out.print("  Novo valor atual [" + item.getValorAtual() + "]: ");
        String val = input.nextLine().trim();
        if (!val.isEmpty()) item.setValorAtual(Double.parseDouble(val));

        System.out.print("  Nova quantidade [" + item.getQuantidade() + "]: ");
        String qtd = input.nextLine().trim();
        if (!qtd.isEmpty()) item.setQuantidade(Integer.parseInt(qtd));

        System.out.println("\n  ✔ Item atualizado com sucesso!");
    }
}