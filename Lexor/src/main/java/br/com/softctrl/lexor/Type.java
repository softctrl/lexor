/**
 * 
 */
package br.com.softctrl.lexor;

/**
 * @author timoshenko
 *
 */
public interface Type {

	Type EOF = new Type() {
		
		public String value() {
			return "EOF";
		}
		
		public boolean isCode() {
			return true;
		}

	};
	Type KW = new Type() {
		
		public String value() {
			return "KW";
		}
		
		public boolean isCode() {
			return true;
		}

	};

	String value();

	boolean isCode();

}
