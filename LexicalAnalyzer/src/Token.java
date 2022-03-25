public class Token {
    private TipoToken nome;
    private String lexema;

    // Construtor para gerar um token apenas com nome (EOF)
    public Token(TipoToken nome) {
        this.nome = nome;
    }

    // Construtor para gerar um token com nome e lexema
    public Token(TipoToken nome, String lexema) {
        this.nome = nome;
        this.lexema = lexema;
    }

    // Metodo para transformar um Token em uma String
    @Override
    public String toString() {
        if (nome == TipoToken.EOF)
            return "<" + nome + ">";

        return "<" + nome + "," + '"' + lexema + '"' + ">";
    }
}