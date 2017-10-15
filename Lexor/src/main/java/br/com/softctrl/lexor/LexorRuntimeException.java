/**
 * 
 */
package br.com.softctrl.lexor;

/**
 * @author timoshenko
 *
 */
public class LexorRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4682302753846002846L;

	/**
	 * 
	 * @param row
	 * @param col
	 */
	public LexorRuntimeException(int row, int col) {
		super("Found an error on Line: " + row + " Col: " + col);
	}

	/**
	 * 
	 * @param message
	 * @param row
	 * @param col
	 */
	public LexorRuntimeException(String message, int row, int col) {
		super("Found an error on Line: " + row + " Col: " + col + "\n" + message);
	}

	/**
	 * 
	 * @param message
	 * @param throwable
	 */
	public LexorRuntimeException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
