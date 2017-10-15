/**
 * 
 */
package br.com.softctrl.lexor;

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
