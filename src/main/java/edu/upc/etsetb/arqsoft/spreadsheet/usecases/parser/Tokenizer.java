package edu.upc.etsetb.arqsoft.spreadsheet.usecases.parser;


import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private class TokenInfo {

        public final Pattern regex; //Compiled form of the regular expression.
        public final int token; // Each different type of token would have its own code.

        public TokenInfo(Pattern regex, int token) {
            super();
            this.regex = regex;
            this.token = token;
        }
    }

    public class Token {
        public final int token;
        public final String sequence;

        public Token(int token, String sequence) {
            super();
            this.token = token;
            this.sequence = sequence;
        }
    }

    private LinkedList<TokenInfo> tokenInfos;
    private LinkedList<Token> tokens;

    public Tokenizer() {
        tokenInfos = new LinkedList<TokenInfo>();
        tokens = new LinkedList<Token>();
        this.add("\\(", 2); // open bracket
        this.add("MIN|MAX|MEAN|SUM", 1); // function
        this.add("\\)", 3); // close bracket
        this.add("[+-]", 4); // plus or minus
        this.add("[*/]", 5); // mult or divide
        this.add("\\^", 6); // raised
        this.add("[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)",7); // integer number
        this.add("[a-zA-Z][a-zA-Z0-9_]*", 8); // cell
        this.add("[;]", 9); // Semicolon
        this.add("[:]", 10); //
    }

    public void add(String regex, int token) {
        tokenInfos.add(new TokenInfo(Pattern.compile("^("+regex+")"), token));
    }

    public LinkedList<Token> getTokens() {
        return tokens;
    }

    public void tokenize(String str){
        String s = new String(str);
        tokens.clear();

        while (!s.equals("")) {
            boolean match = false;

            for (TokenInfo info : tokenInfos) {
                Matcher m = info.regex.matcher(s);
                if (m.find()) {
                    match = true;

                    String tok = m.group().trim();
                    tokens.add(new Token(info.token, tok));

                    s = m.replaceFirst("");
                    break;
                }
            }

            if (!match) throw new RuntimeException(
                    "Unexpected character in input: "+s);

        }

    }

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();


        try {
            tokenizer.tokenize("2.5+1.3-3+(5+2)/MIN(8;BB22)+A2+C4:D10");

            for (Tokenizer.Token tok : tokenizer.getTokens()) {
                System.out.println("" + tok.token + " " + tok.sequence);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
