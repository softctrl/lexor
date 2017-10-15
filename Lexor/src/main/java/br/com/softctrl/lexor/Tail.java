/**
 * 
 */
package br.com.softctrl.lexor;

/**
 * @author timoshenko
 *
 */
public class Tail {

	public class Pos {
		public int row = 1;
		public int col = 0;

		void copy(Pos pos) {
			this.row = pos.row;
			this.col = pos.col;
		}

	}

	private Pos pos0;
	private Pos pos1;

	public Tail() {
		this.pos0 = new Pos();
		this.pos1 = new Pos();
	}

	public void move(int c) {

		if (c == Reader.NL) {
			this.pos1.row++;
			this.pos1.col = 0;
			this.pos0.col++;
		} else if (c != Reader.EOF) {
			this.pos0.row = this.pos1.row;
			if (c == Reader.TAB) {
				this.pos0.col = this.pos1.col = this.pos1.col + 3;
			} else {
				this.pos0.col = ++this.pos1.col;
			}
		}

	}

	public int row() {
		return this.pos0.row;
	}

	public int col() {
		return this.pos0.col;
	}

}
