/**
 * 
 */
package br.com.softctrl.lexor;

/**
 * 
 * @author timoshenko
 *
 */
public abstract class FinalState implements State {

	private final Machine machine;

	/**
	 * 
	 * @param machine
	 */
	public FinalState(Machine machine) {
		this.machine = machine;
	}

	/**
	 * 
	 * @return
	 */
	protected Machine getMachine() {
		return machine;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.softctrl.lexor.State#nextTransition(char)
	 */
	public final State nextTransition(char c) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.softctrl.lexor.State#isInitial()
	 */
	public final boolean isInitial() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.softctrl.lexor.State#isFinal()
	 */
	public final boolean isFinal() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.softctrl.lexor.State#moveToNext()
	 */
	public boolean moveToNext() {
		return false;
	}

}
