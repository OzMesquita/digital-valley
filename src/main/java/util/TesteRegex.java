package util;

import java.util.regex.Pattern;
import java.util.StringJoiner;
 
class TesteRegex {
 
    private static final String MAIUSCULA = "(?:[\\p{Lu}&&[\\p{IsLatin}]])";
    private static final String MINUSCULA = "(?:[\\p{Ll}&&[\\p{IsLatin}]])";
 
    private static final String PREFIXO = choice("d'", "D'", "O'", "Mc", "Mac", "al\\-");
    private static final String SUFIXO = choice("Jr\\.", "II", "III", "IV");
    private static final String CONJUNCAO = choice("e", "y", "de" + opt(choice(" la", " las", " lo", " los")), "do", "dos", "da", "das", "del", "van", "von", "bin", "le");
    private static final String NOME = MAIUSCULA + plus(opt("'") + MAIUSCULA);
    private static final String PRENOME = NOME + star("\\-" + NOME);
    private static final String SOBRENOME = choice(opt(PREFIXO) + NOME, PRENOME);
    private static final String NOME_COMPLETO = "^" + PRENOME + plus(" " + opt(CONJUNCAO + " ") + SOBRENOME) + opt(" " + SUFIXO) + "$";
 
    private static String opt(String in) {
        return "(?:" + in + ")?";
    }
 
    private static String plus(String in) {
        return "(?:" + in + ")+";
    }
 
    private static String star(String in) {
        return "(?:" + in + ")*";
    }
 
    private static String choice(String... in) {
        StringJoiner sj = new StringJoiner("|", "(?:", ")");
        for (String s : in) {
            sj.add(s);
        }
        return sj.toString();
    }
 
    private static final Pattern REGEX_NOME = Pattern.compile(NOME_COMPLETO);
 
    private static final String[] NOMES = {
        "Maria Silva",
        "Pedro Carlos",
        "Luiz Antônio",
        "Albert Einstein",
        "João Doria",
        "Barack Obama",
        "Friedrich von Hayek",
        "Ludwig van Beethoven",
        "Jeanne d'Arc",
        "Saddam Hussein al-Tikriti",
        "Osama bin Mohammed bin Awad bin Laden",
        "Luís Inácio Lula da Silva",
        "Getúlio Dornelles Vargas",
        "Juscelino Kubitschek de Oliveira",
        "Jean-Baptiste le Rond d'Alembert",
        "Pierre-Simon Laplace",
        "Hans Christian Ørsted",
        "Joseph Louis Gay-Lussac",
        "Scarlett O'Hara",
        "Ronald McDonald",
        "María Antonieta de las Nieves",
        "Pedro de Alcântara Francisco António João Carlos Xavier de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim",
        "Luís Augusto Maria Eudes de Saxe-Coburgo-Gota",
        "Martin Luther King Jr.",
        "William Henry Gates III",
        "John William D'Arcy",
        "John D'Largy",
        "Samuel Eto'o",
        "Åsa Ekström",
        "Gregor O'Sulivan",
        "Ítalo Gonçalves"
    };
 
    private static final String[] LIXOS = {
        "",
        "Maria",
        "Maria-Silva",
        "Marcos E",
        "E Marcos",
        "Maria  Silva",
        "Maria Silva ",
        " Maria Silva ",
        "Maria silva",
        "maria Silva",
        "MARIA SILVA",
        "MAria Silva",
        "Maria SIlva",
        "Jean-Baptiste",
        "Jeanne d' Arc",
        "Joseph Louis Gay-lussac",
        "Pierre-simon Laplace",
        "Maria daSilva",
        "Maria~Silva",
        "Maria Silva~",
        "~Maria Silva",
        "Maria~ Silva",
        "Maria ~Silva",
        "Maria da da Silva",
        "Maria da e Silva",
        "Maria de le Silva",
        "William Henry Gates iii",
        "Martin Luther King, Jr.",
        "Martin Luther King JR",
        "Martin Luther Jr. King",
        "Martin Luther King Jr. III",
        "Maria G. Silva",
        "Maria G Silva",
        "Maria É Silva",
        "Maria wi Silva",
        "Samuel 'Etoo",
        "Samuel Etoo'",
        "Samuel Eto''o"
    };
 
    public static boolean testar(String nome) {
        boolean bom = REGEX_NOME.matcher(nome).matches();
        return bom;
    }
}