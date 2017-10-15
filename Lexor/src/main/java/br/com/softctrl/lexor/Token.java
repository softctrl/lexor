/**
 * 
 */
package br.com.softctrl.lexor;

/**
 * @author timoshenko
 *
 */
public class Token {

	private String lexeme = null;
	private int row = -1;
	private int col = -1;
	private Type type = null;

	public Token() {
	}

	public Token(Type type, String lexeme, int row, int col) {
		this.type = type;
		this.lexeme = lexeme;
		this.row = row;
		this.col = col;
	}
	
	public boolean isCode() {
		return this.type == null ? false : this.type.isCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Token: <%s,\"%s\"> Linha: %d Coluna: %d", (this.type == null ? "" : this.type.value()),
				this.lexeme, this.row, this.col);
	}

}
