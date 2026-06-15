

public abstract class Item {
    private String nome;
    private String subtitulo;
    private double valorAntigo;
    private double valorAtual;
    private int quantidade;
    private int horarioRetirada;

    public Item(String nome, String subtitulo, double valorAntigo, double valorAtual, int quantidade, int horarioRetirada) {
        this.nome = nome;
        this.subtitulo = subtitulo;
        this.valorAntigo = valorAntigo;
        this.valorAtual = valorAtual;
        this.quantidade = quantidade;
        this.horarioRetirada = horarioRetirada;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSubtitulo() { return subtitulo; }
    public void setSubtitulo(String subtitulo) { this.subtitulo = subtitulo; }

    public double getValorAntigo() { return valorAntigo; }
    public void setValorAntigo(double valorAntigo) { this.valorAntigo = valorAntigo; }

    public double getValorAtual() { return valorAtual; }
    public void setValorAtual(double valorAtual) { this.valorAtual = valorAtual; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public int getHorarioRetirada() { return horarioRetirada; }
    public void setHorarioRetirada(int horarioRetirada) { this.horarioRetirada = horarioRetirada; }

    public abstract String getCategoria();


    public String toString() {
        return String.format(
                "  [%s] %s\n  %s\n  Unidades disponíveis: %d\n  Valor: R$%.2f (De: R$%.2f)\n  Retirada até: %dh",
                getCategoria(), nome, subtitulo, quantidade, valorAtual, valorAntigo, horarioRetirada
        );
    }
}
