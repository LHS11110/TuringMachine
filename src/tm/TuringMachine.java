package tm;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;

public class TuringMachine
{
    // Direction
    public static final boolean R = true;
    public static final boolean L = false;

    private LinkedList<String> tape;
    private String stateRegister;
    private Iterator<String> head;

    private Set<String> symbols;
    private Set<String> states;
    private String blankSymbol;
    private String initialState;
    private Set<String> finalStates;
    private String inputSymbols;
    private HashMap<String[], String[]> transitionFunction;

    public TuringMachine()
    {
        this.tape = new LinkedList<>();
        this.stateRegister = null;
        this.head = null;
        this.symbols = new HashSet<>();
        this.states = new HashSet<>();
        this.blankSymbol = null;
        this.initialState = null;
        this.finalStates = new HashSet<>();
        this.inputSymbols = null;
        this.transitionFunction = new HashMap<>();
    }
}
