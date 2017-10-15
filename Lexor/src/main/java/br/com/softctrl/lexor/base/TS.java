/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.softctrl.lexor.base;

import java.util.HashMap;

/**
 *
 * @author gustavo
 */
public class TS {
    
    private HashMap<Token, InfIdentificador> tabelaSimbolos; // Tabela de símbolos do ambiente

    public TS() {
        tabelaSimbolos = new HashMap();

        // Inserindo as palavras reservadas
        Token word;
        word = new Token(Tag.KW, "public", 0, 0);
        this.tabelaSimbolos.put(word, new InfIdentificador());
        
        word = new Token(Tag.KW, "class", 0, 0);
        this.tabelaSimbolos.put(word, new InfIdentificador());
        
        word = new Token(Tag.KW, "SystemOutDispln", 0, 0);
        this.tabelaSimbolos.put(word, new InfIdentificador());
        
        word = new Token(Tag.KW, "end", 0, 0);
        this.tabelaSimbolos.put(word, new InfIdentificador());
        
        word = new Token(Tag.KW, "integer", 0, 0);
        this.tabelaSimbolos.put(word, new InfIdentificador());
        
        word = new Token(Tag.KW, "string", 0, 0);
        this.tabelaSimbolos.put(word, new InfIdentificador());
    }
    
    public void put(Token w, InfIdentificador i) {
        tabelaSimbolos.put(w, i);
    }

    // Retorna um identificador de um determinado token
    public InfIdentificador getIdentificador2(Token w) {
        InfIdentificador infoIdentificador = (InfIdentificador) tabelaSimbolos.get(w);
        return infoIdentificador;
    }

    // Pesquisa na tabela de símbolos se há algum tokem com determinado lexema
    public Token retornaToken(String lexema) {
        for (Token token : tabelaSimbolos.keySet()) {
            if (token.getLexema().equals(lexema)) {
                return token;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        String saida = "";
        int i = 1;
        for (Token token : tabelaSimbolos.keySet()) {
            saida += ("posicao " + i + ": \t" + token.toString()) + "\n";
            i++;
        }
        return saida;
    }
}