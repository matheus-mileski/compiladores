public class Token {
    public TipoToken nome;
    public String lexema;

    public Token(TipoToken nome) {
        this.nome = nome;
    }

    public Token(TipoToken nome, String lexema) {
        this.nome = nome;
        this.lexema = lexema;
    }

    @Override
    public String toString() {
        if (nome == TipoToken.EOF) {
            return "<" + nome + ">";
        }

        return "<" + nome + "," + '"' + lexema + '"' + ">";
    }

}
