/**
 * 
 */
package br.com.softctrl.lexor;

/**
 * @author timoshenko
 *
 */
public interface State {

	State nextTransition(char c);

	boolean isInitial();

	boolean isFinal();

	boolean moveToNext();

	Type getType();

	char readChar(char c);

}
