/**
 * 
 */
package br.com.softctrl.lexor;

import java.io.Closeable;

/**
 * @author timoshenko
 *
 */
public interface Reader extends Closeable {

	public static final int EOF = -1;
	public static final char NL = '\n';
	public static final char TAB = '\t';
	public static final char NULL = '\0';

	/**
	 * Recover the next character.
	 * 
	 * @return
	 */
	int next();

	void prior();

	/**
	 * Return the current character.
	 * 
	 * @return
	 */
	int current();

	int row();

	int col();

	// void update();

}
