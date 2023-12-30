package tm;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Arrays;
import java.lang.Exception;
import java.lang.Character;

public class TuringMachine
{
    // Direction
    public static final boolean R = true;
    public static final boolean L = false;

    private final LinkedList<Character> tape;
    private String stateRegister;
    private Iterator<Character> head;

    private final Set<Character> symbols;
    private final Set<String> states;
    private char blankSymbol;
    private String initialState;
    private final Set<String> finalStates;
    private String inputSymbols;
    private final HashMap<String[], String[]> transitionFunction;

    public TuringMachine()
    {
        this.tape = new LinkedList<>();
        this.stateRegister = "";
        this.head = null;
        this.symbols = new HashSet<>();
        this.states = new HashSet<>();
        this.blankSymbol = ' ';
        this.initialState = "";
        this.finalStates = new HashSet<>();
        this.inputSymbols = "";
        this.transitionFunction = new HashMap<>();
    }

    public void setStates(String... states)
    {
        this.states.clear();
        this.states.addAll(Arrays.asList(states));
    }

    public Set<String> getStates()
    {
        return this.states;
    }

    public void setInitState(String state) throws Exception
    {
        if (!this.states.contains(state))
            throw new Exception();
        this.initialState = state;
    }

    public String getInitState()
    {
        return this.initialState;
    }

    public void setFinalStates(String... states) throws Exception
    {
        this.finalStates.clear();
        for (String state : states)
            if (!this.states.contains(state))
                throw new Exception();
        this.finalStates.addAll(Arrays.asList(states));
    }

    public Set<String> getFinalStates()
    {
        return this.finalStates;
    }

    public void setBlankSymbol(char symbol) throws Exception
    {
        if (!this.symbols.contains(symbol))
            throw new Exception();
        this.blankSymbol = symbol;
    }

    public char getBlankSymbol()
    {
        return this.blankSymbol;
    }

    public void setSymbols(String symbols)
    {
        this.symbols.clear();
        for (char c : symbols.toCharArray())
            this.symbols.add(c);
    }

    public Set<Character> getSymbols()
    {
        return this.symbols;
    }

    public void setInput(String symbols) throws Exception
    {
        for (char c : symbols.toCharArray())
            if (!this.symbols.contains(c))
                throw new Exception();
        this.inputSymbols = symbols;
    }

    public String getInput()
    {
        return this.inputSymbols;
    }
}
