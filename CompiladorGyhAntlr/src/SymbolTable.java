// Classe para representar a tabela de simbolos (variáveis)

import java.util.ArrayList;
import java.util.Hashtable;
public class SymbolTable {
    private Hashtable<String, Symbol> symbolTable;  // Tabela de simbolos
    public SymbolTable() {
        symbolTable = new Hashtable<String, Symbol>();
    }
    public void addSymbol(Symbol symbol) {
        symbolTable.put(symbol.getName(), symbol);
    }   // Adiciona um simbolo na tabela
    public Symbol getSymbol(String name) {
        return symbolTable.get(name);
    }   // Retorna um simbolo com o nome
    public boolean contains(String name) {
        return getSymbol(name) != null;
    }   // Verifica se o simbolo está na lista
    public ArrayList<Symbol> getAll() {
        return new ArrayList<Symbol>(symbolTable.values());
    }   // Retorna todos os simbolos como uma lista

    public Hashtable<String, Symbol> getSymbolTable() {
        return symbolTable;
    }
}