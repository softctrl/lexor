/**
 * 
 */
package br.com.softctrl.lexor;

import java.io.IOException;
import java.util.HashSet;

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
public abstract class Machine {

	private final Reader reader;
	private final SymbolTable symbolTable = new SymbolTable();
	private final HashSet<String> keyWords = new HashSet<String>();

	private State initialState;

	/**
	 * 
	 * @param reader
	 * @param initialState
	 */
	public Machine(Reader reader) {
		this.reader = reader;
		this.loadKeyWords(this.keyWords);
	}

	/**
	 * 
	 * @param initialState
	 */
	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

	/**
	 * 
	 * @param type
	 * @param word
	 * @param row
	 * @param col
	 */
	protected void addSymbol(Type type, String word, int row, int col) {
		this.symbolTable.add(type, word, row, col);
	}

	/**
	 * 
	 * @return
	 */
	public final SymbolTable getSymbolTable() {
		return symbolTable;
	}

	/**
	 * 
	 * @param keyWords
	 */
	protected abstract void loadKeyWords(final HashSet<String> keyWords);

	/**
	 * 
	 * @param word
	 * @return
	 */
	protected final boolean isKeyWord(final String word) {
		return this.keyWords.contains(word);
	}

	@Deprecated
	public void proccess2() throws IOException {

		Tail tail = new Tail();
		tail.move(this.reader.next());
		while (this.reader.current() != Reader.EOF) {

			System.out.printf("Row: %d Col: %d -> [%c]\n", tail.row(), tail.col(), this.reader.current());
			tail.move(this.reader.next());

		}

	}

	/**
	 * 
	 * @throws IOException
	 */
	public void proccess() throws IOException {

		int value = '\0';
		StringBuilder strb = new StringBuilder();
		value = this.reader.next();
		State st = null;
		try {

			while (value != Reader.EOF) {

				st = this.initialState.nextTransition((char) value);
				strb.append(st.readChar((char) value));

				value = this.reader.next();
				// int _row = this.row();
				// int _col = this.col();
				boolean zero = true;
				while (value != Reader.EOF && !st.isFinal()) {
					st = st.nextTransition((char) value);
					strb.append(st.readChar((char) value));
					if (zero || !st.isFinal() || st.moveToNext())
						value = this.reader.next();
					zero = false;
				}

				if (value == Reader.EOF) {

					if (st.isInitial() || st.isFinal()) {
						this.addSymbol(Type.EOF, "EOF", this.row(), this.col());
						// this.println(br.com.softctrl.javinha.Type.EOF.value(),
						// "EOF",
						// this.row() + ((char) value == Reader.NL ? -1 : 0),
						// this.col());
						break;
					} else {
						throw new LexorRuntimeException(this.reader.row(), this.reader.col());
					}

				}

				final String word = strb.toString().trim();

				if (this.isKeyWord(word)) {
					this.addSymbol(Type.KW, word, this.row(), this.col());
					// this.println(br.com.softctrl.javinha.Type.KW.value(),
					// word,
					// this.row(), this.col());
				} else {
					this.addSymbol(st.getType(), word, this.row(), this.col());
					// this.println(st.getType().value(), word, this.row(),
					// this.col());
				}
				strb = new StringBuilder();
			}

		} catch (LexorRuntimeException le) {

			final String message = String.format("\nState: %s\nPartial Word: %s",
					(st == null ? null : st.getClass().getSimpleName()), strb.toString().trim());
			throw new LexorRuntimeException(message, le);

		}
		this.reader.close();

	}

	/**
	 * 
	 * @param type
	 * @param value
	 * @param row
	 * @param col
	 */
	// private void println(String type, String value, int row, int col) {
	// System.out.printf("Token: <%s, \"%s\"> Linha: %d Coluna: %d\n", type,
	// value, row, (col /*- value.length()*/));
	// }

	protected final int next() {
		return this.reader.next();
	}

	public final void prior() {
		this.reader.prior();
	}

	public final int row() {
		return this.reader.row();
	}

	public final int col() {
		return this.reader.col();
	}

}
