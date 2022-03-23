public class LexicalAnalyzer {
    public static void main(String[] args) {
        GyhLex lex = new GyhLex(args[0]);
        lex.tokenizer();
    }
}