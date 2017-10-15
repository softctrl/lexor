/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package br.com.softctrl.lexor.base;
//
//import java.io.*;
//
///**
// *
// * @author gustavo
// */
//public class LexerAluno {
//    
//    private static final int END_OF_FILE = -1; // contante para fim do arquivo
//    private static int lookahead = 0; // armazena o último caractere lido do arquivo	
//    public static int n_line = 1; // contador de linhas
//    public static int n_column = 1; // contador de linhas
//    private RandomAccessFile instance_file; // referencia para o arquivo
//    private static TS tabelaSimbolos; // tabela de simbolos
//    
//    public LexerAluno(String input_data) {
//		
//        // Abre instance_file de input_data
//	try {
//            instance_file = new RandomAccessFile(input_data, "r");
//	}
//	catch(IOException e) {
//            System.out.println("Erro de abertura do arquivo " + input_data + "\n" + e);
//            System.exit(1);
//	}
//	catch(Exception e) {
//            System.out.println("Erro do programa ou falha da tabela de simbolos\n" + e);
//            System.exit(2);
//	}
//    }
//    
//    // Fecha instance_file de input_data
//    public void fechaArquivo() {
//
//        try {
//            instance_file.close();
//        }
//	catch (IOException errorFile) {
//            System.out.println ("Erro ao fechar arquivo\n" + errorFile);
//            System.exit(3);
//	}
//    }
//    
//    //Reporta erro para o usuário
//    public void sinalizaErro(String mensagem) {
//
//        System.out.println("[Erro Lexico]: " + mensagem + "\n");
//    }
//    
//    //Volta uma posição do buffer de leitura
//    public void retornaPonteiro(){
//
//        try {
//            // Não é necessário retornar o ponteiro em caso de Fim de Arquivo
//            if (lookahead != END_OF_FILE) {
//                instance_file.seek(instance_file.getFilePointer() - 1);
//                n_column -= 1; // decrementar a coluna
//            }    
//        }
//        catch(IOException e) {
//            System.out.println("Falha ao retornar a leitura\n" + e);
//            System.exit(4);
//        }
//    }
//    
//    /* TODO:
//    //[1]   Voce devera se preocupar quando incremetar as linhas e colunas,
//    //      assim como quando decrementar ou reseta-las.
//    //[2]   Toda vez que voce encontrar um lexema completo, voce deve retornar
//    //      um objeto new Token(Tag, "lexema", linha, coluna). Cuidado com as
//    //      palavras reservadas que ja sao codastradas na TS. Essa consulta
//    //      voce devera fazer somente quando encontrar um Identificador.
//    //[3]   Se o caractere lido nao casar com nenhum caractere esperado,
//    //      apresentar a mensagem de erro na linha e coluna correspondente.
//    //[4]   Dica: Para saber se 'c' eh uma letra, use Character.isLetter(c).
//    //[5]   Dica: a variavel 'lexema' eh responsavel por montar o lexema pelo 
//    //      metodo lexema.append(c).
//    //[6]   Atencao com as strings. Assim que aparacer o segundo '"' (aspas duplas) 
//    //      retornar a string. Cuidado, strings devem ser fechadas, antes do 
//    //      fim do arquivo.
//    //[7]   Nao eh necessario criar nenhuma outra variavel para finalizar seu AFD.
//    */
//    
//    // Obtém próximo token
//    public Token proxToken() {
//
//	StringBuilder lexema = new StringBuilder();
//	int estado = 1;
//	char c;
//		
//	while(true) {
//            c = '\u0000'; // null char
//            
//            // avanca caractere
//            try {
//                lookahead = instance_file.read(); 
//		if(lookahead != END_OF_FILE) {
//                    c = (char) lookahead;
//                }
//            }
//            catch(IOException e) {
//                System.out.println("Erro na leitura do arquivo");
//                System.exit(3);
//            }
//            
//            // movimentacao do automato
//            switch(estado) {
//                case 1:
//                    if (lookahead == END_OF_FILE)
//                        return new Token(Tag.EOF, "EOF", n_line, n_column);
//                    else if (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
//                        // Permance no estado = 1
//                        //Dica: pode ser necessario alterar o valor da linha e coluna
//                    }
//                    else if (Character.isDigit(c)) {
//                        lexema.append(c);
//                        // Dica: alterar variavel estado indica a movimentacao do AFD.
//                        // Isso sera feito constantemente nos varios case's e if's
//                    }
//                    else if (c == '=') {
//                        estado = 2;
//                    }
//                    else if ...
//                    ...
//                    ...
//                    else {
//                        // Dica: sinalizaErro(string); string eh uma mensagem informando
//                        // qual o simbolo encontrado e onde esta esse simbolo.
//                        return null;
//                    }
//                    break;
//                case 2:
//                    if (c == '=') {
//                        // Dica: retornar novo objeto Token(Tag.RELOP_EQ, "==", n_line, n_column);
//                    }
//                    else {
//                        // Dica: usar retornaPonteiro() para voltar uma posicao no arquivo
//                        // Dica: retornar novo objeto Token(Tag.RELOP_ASSIGN, "=", n_line, n_column);
//                    }
//                case ...:
//                ...
//                case 12:
//                    if (Character.isDigit(c)) {
//                        lexema.append(c);
//                        // Permanece no estado 12
//                    }
//                    else { // Estado 13
//                        estado = 13;
//                        retornaPonteiro();						
//			return new Token(Tag, lexema.toString(), linha, coluna);
//                    }
//                    break;
//                ...
//            }
//        }
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        Lexer lexer = new Lexer("HelloJavinha.jvn");
//	Token token;
//        tabelaSimbolos = new TS();
//
//	// Enquanto não houver erros ou não for fim de arquivo:
//	do {
//            token = lexer.proxToken();
//            
//            // Imprime token
//	    if(token != null) {
//                System.out.println("Token: " + token.toString() + "\t Linha: " +
//                        n_line + "\t Coluna: " + n_column);
//                
//                // Dica: verifica se existe o token na tabela de símbolos para
//                // entao cadastra-lo com tabelaSimbolos.put(token, new InfIdentificador());
//            }
//	     
//	} while(token != null && token.getClasse() != Tag.EOF);
//	lexer.fechaArquivo();
//        
//        // Imprime a tabela de simbolos
//        System.out.println("");
//        System.out.println("Tabela de simbolos:");
//        System.out.println(tabelaSimbolos.toString());
//    }
//    
//}