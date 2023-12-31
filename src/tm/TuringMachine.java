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
    private final Set<Character> inputSymbols;
    private final HashMap<Object[], Object[]> transitionFunction;

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
        this.inputSymbols = new HashSet<>();
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
        this.symbols.addAll(Arrays.asList(symbols.chars().mapToObj(ch -> (char)ch).toArray(Character[]::new)));
    }

    public Set<Character> getSymbols()
    {
        return this.symbols;
    }

    public void setInputSymbols(String symbols) throws Exception
    {
        for (char c : symbols.toCharArray())
            if (!this.symbols.contains(c) || this.blankSymbol == c)
                throw new Exception();
        this.inputSymbols.addAll(Arrays.asList(symbols.chars().mapToObj(ch -> (char)ch).toArray(Character[]::new)));
    }

    public Set<Character> getInput()
    {
        return this.inputSymbols;
    }

    public void addTransition(String currentState, char readSymbol, String nextState, char writeSymbol, boolean direction) throws Exception
    {
        if (!this.states.contains(currentState) || !this.states.contains(nextState) || !this.symbols.contains(readSymbol) || !this.symbols.contains(writeSymbol))
            throw new Exception();
        this.transitionFunction.put(new Object[] {currentState, readSymbol}, new Object[] {nextState, writeSymbol, direction});
    }

    public void clearFunction()
    {
        this.transitionFunction.clear();
    }

    public HashMap<Object[], Object[]> getTransitionFunction()
    {
        return this.transitionFunction;
    }
}
