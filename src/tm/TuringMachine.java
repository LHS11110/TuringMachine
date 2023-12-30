package tm;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Arrays;

public class TuringMachine
{
    // Direction
    public static final boolean R = true;
    public static final boolean L = false;

    private final LinkedList<String> tape;
    private String stateRegister;
    private Iterator<String> head;

    private final Set<String> symbols;
    private final Set<String> states;
    private String blankSymbol;
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
        this.blankSymbol = "";
        this.initialState = "";
        this.finalStates = new HashSet<>();
        this.inputSymbols = "";
        this.transitionFunction = new HashMap<>();
    }

    public void setInitState(String state)
    {
        this.initialState = state;
    }

    public String getInitState()
    {
        return this.initialState;
    }

    public void setFinalStates(String... states)
    {
        this.finalStates.clear();
        this.finalStates.addAll(Arrays.asList(states));
    }

    public Set<String> getFinalStates()
    {
        return this.finalStates;
    }
}
