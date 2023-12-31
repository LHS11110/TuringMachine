import tm.TuringMachine;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        TuringMachine machine = new TuringMachine();

        machine.setStates("q0", "q1", "q2", "q3", "qf");
        machine.setSymbols("012");
        machine.setBlankSymbol('0');
        machine.setInitState("q0");
        machine.setFinalStates("qf");
        machine.setInputSymbols("1");

        machine.addTransition("q0", '1', "q0", '1', TuringMachine.R);
        machine.addTransition("q0", '2', "q0", '2', TuringMachine.R);
        machine.addTransition("q0", '0', "q0", '0', TuringMachine.L);
        machine.addTransition("q1", '2', "q1", '2', TuringMachine.L);
        machine.addTransition("q1", '1', "q2", '2', TuringMachine.R);
        machine.addTransition("q2", '2', "q2", '2', TuringMachine.R);
        machine.addTransition("q2", '0', "q2", '2', TuringMachine.L);
        machine.addTransition("q1", '0', "q3", '0', TuringMachine.R);
        machine.addTransition("q3", '2', "q3", '1', TuringMachine.R);
        machine.addTransition("q3", '0', "qf", '0', TuringMachine.L);
    }
}