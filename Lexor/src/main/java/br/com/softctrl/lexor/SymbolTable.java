/**
 * 
 */
package br.com.softctrl.lexor;

import java.util.ArrayList;

/**
 * @author timoshenko
 *
 */
public final class SymbolTable extends ArrayList<Token> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1312088838634263530L;

	/**
	 * 
	 * @param type
	 * @param lexeme
	 * @param row
	 * @param col
	 */
	public void add(Type type, String lexeme, int row, int col) {
		this.add(new Token(type, lexeme, row, col));
	}

	public void print() {
		for (Token token : this) {
			System.out.println(token);
		}
	}

	public void printCode() {
		for (Token token : this) {
			if (token.isCode())
				System.out.println(token);
		}
	}

}
