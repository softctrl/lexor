/**
 * 
 */
package br.com.softctrl.lexor;

import java.util.ArrayList;

/*
The GNU Lesser General Public License v3 (or later)

Copyright (c) 2017 Carlos Timoshenko Rodrigues Lopes
http://www.0x09.com.br

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

/**
 * @author carlostimoshenkorodrigueslopes@gmail.com
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
