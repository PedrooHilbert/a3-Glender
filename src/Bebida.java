public class Bebida extends Item {

    public Bebida(String nome, String subtitulo, double valorAntigo, double valorAtual, int quantidade, int horarioRetirada) {
        super(nome, subtitulo, valorAntigo, valorAtual, quantidade, horarioRetirada);
    }


    public String getCategoria() {
        return "Bebida";
    }
}
