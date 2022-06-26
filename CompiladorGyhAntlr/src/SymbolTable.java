import java.util.ArrayList;
import java.util.Hashtable;

public class SymbolTable {


    private Hashtable<String, Symbol> symbolTable;

    public SymbolTable() {
        symbolTable = new Hashtable<String, Symbol>();
    }

    public void addSymbol(Symbol symbol) {
        symbolTable.put(symbol.getName(), symbol);
    }

    public Symbol getSymbol(String name) {
        return symbolTable.get(name);
    }

    public boolean contains(String name) {
        return getSymbol(name) != null;
    }

    public ArrayList<Symbol> getAll() {
        return new ArrayList<Symbol>(symbolTable.values());
    }

    public Hashtable<String, Symbol> getSymbolTable() {
        return symbolTable;
    }
}
