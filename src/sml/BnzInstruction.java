package sml;

/**
 * This class ....
 * 
 * @author someone
 */

public class BnzInstruction extends Instruction {

	private int result;
	private String op1;

	public BnzInstruction(String label, String op) {
		super(label, op);
	}

	public BnzInstruction(String label, int result, String op1) {
		this(label, "bnz");
		this.result = result;
		this.op1 = op1;
	}

	@Override
	public void execute(Machine m) {
		int value = m.getRegisters().getRegister(result);
		
		if(value != 0) {
			// We use this method instead of just fetching the first character
			// because we want to support double, triple digit instruction ids i.e f23, f343
			int instructionNumber = Integer.parseInt(op1.substring(1, op1.length()));
			m.setPc(instructionNumber);
		}
	}

	@Override
	public String toString() {
		return super.toString() + " checking " + result +  " for " + op1;
	}
}
