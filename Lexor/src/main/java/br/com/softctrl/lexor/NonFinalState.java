/**
 * 
 */
package br.com.softctrl.lexor;

/**
 * 
 * @author timoshenko
 *
 */
public abstract class NonFinalState implements State {

	private final Machine machine;

	/**
	 * 
	 * @param machine
	 */
	public NonFinalState(Machine machine) {
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
	 * @see br.com.softctrl.lexor.State#isInitial()
	 */
	public boolean isInitial() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.softctrl.lexor.State#isFinal()
	 */
	public final boolean isFinal() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.softctrl.lexor.State#getType()
	 */
	public Type getType() {
		return null;
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
