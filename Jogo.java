
/*
 * 
 * @author helio
 * 
 */
import java.util.ArrayList;
import java.util.Random;

public class Jogo {

    private static boolean terminado = false;
    private static ArrayList<CorpoCeleste> planetas;
    private Analisador analisador;
    private AcoesJogador acao;
    private Nave nave;
    private Jogador jogador;
    private String log;

    public Jogo() {

        Random random = new Random();
        criarPlanetas();
        jogador = new Jogador();
        jogador.setPlanetaAtual(planetas.get(random.nextInt(14)));
        analisador = new Analisador();
        nave = new Nave();
        log = "";
        acao = new AcoesJogador();

    }

    public void jogar() {

        imprimirBoasVindas();

        while (!terminado) {

            imprimirEstado();
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);

        }

        System.out.println("Obrigado por jogar. Ate mais!");

    }

    private boolean processarComando(Comando comando) {

        if (comando == null) {

            System.out.println("Comando invalido!");
            return false;

        }

        String palavraGatilho = comando.getGatilho();
        System.out.println("palavra de comando: " + palavraGatilho);

        switch (palavraGatilho) {

            case "plantar":

                if (acao.plantarArvore(jogador)) {
                    terminado = true;
                }
                break;

            case "explorar":

                acao.explorarPlaneta(jogador);
                break;

            case "viajar":

                acao.viajar(comando, jogador, nave);
                break;

            case "ajuda":

                imprimirAjuda();
                break;

            case "saber":

                acao.saberPlaneta(nave, analisador, jogador);
                break;

            case "dica":

                System.out.println(getDica());
                break;

            case "beberCafe":

                acao.beberCafe(jogador);
                break;

            case "reabastecer":

                acao.reabastecer(jogador, nave);
                break;

            case "consertarNave":

                acao.consertarNave(nave, jogador);
                break;

            case "quit":

                terminado = true;
                break;

            default:

                System.out.println("Comando invalido!");
                break;

        }

        return terminado;

    }

    private void criarPlanetas() {

        planetas = new ArrayList<CorpoCeleste>();

        Planeta mercurio = new Planeta("Mercurio",
                "Enfrenta extremos térmicos, com temperaturas que variam drasticamente entre o dia e a noite.");

        Planeta venus = new Planeta("Venus",
                "Envolto em uma atmosfera espessa e tóxica, é um mundo abrasador com uma paisagem árida e vulcões ativos");

        Planeta terra = new Planeta("Terra",
                "Aqui a temperatura e agradavel dependendo do local. voce esta em um planeta rochoso com uma ou mais luas ao redor.");

        Lua lua = new Lua("Lua",
                "Ilumina noites com crateras marcantes, mares escuros e uma paisagem intrigante.");

        Planeta marte = new Planeta("Marte",
                "Apresenta paisagens desérticas, cânions profundos e antigas planícies marcianas, além de ser objeto de busca por evidências de vida passada");

        Planeta jupiter = new Planeta("Jupiter",
                "Exibe uma atmosfera turbulenta com faixas coloridas e uma tempestade colossal.");

        Lua io = new Lua("Io",
                "é um mundo vulcânico marcado por uma superfície coberta por lava recente, geysers e montanhas coloridas.");

        Lua europa = new Lua("Europa",
                "possui uma crosta gelada que esconde um vasto oceano subsuperficial, tornando-a apta a abrigar vida.");

        Lua ganimedes = new Lua("Ganimedes",
                "exibe uma superfície com crateras antigas, sulcos e regiões mais jovens, indicando uma história geológica diversificada.");

        Lua calisto = new Lua("Calisto",
                "apresenta uma paisagem antiga com uma abundância de crateras, sugerindo uma ausência de atividade geológica significativa");

        Planeta saturno = new Planeta("Saturno",
                "Muito lindo visto do espaco, com uma estrutura impressionante e uma complexa dinâmica atmosférica.");

        Planeta urano = new Planeta("Urano",
                " Inclinado em seu eixo, destaca-se por sua atmosfera fria e pela presença de anéis e luas excêntricos.");

        Planeta netuno = new Planeta("Netuno",
                "envolto em ventos supersonicos e com uma atmosfera dinâmica, exibe uma coloração azul profunda e intrigantes características atmosféricas.");

        Planeta plutao = new Planeta("Plutao",
                "Sua atmosfera tênue, superfície gelada e lua carismática, revelam a complexidade deste mundo distante.");

        planetas.add(mercurio);
        planetas.add(venus);
        planetas.add(terra);
        planetas.add(lua);
        planetas.add(marte);
        planetas.add(jupiter);
        planetas.add(io);
        planetas.add(europa);
        planetas.add(ganimedes);
        planetas.add(calisto);
        planetas.add(saturno);
        planetas.add(urano);
        planetas.add(netuno);
        planetas.add(plutao);

    }

    public static void gameOver() {

        terminado = true;

    }

    public static ArrayList<CorpoCeleste> getPlanetas() {

        return planetas;

    }

    public void imprimirBoasVindas() {

        System.out.println(pegarMensagemInicial());
        escreverLog(pegarMensagemInicial());
        System.out.println();
        String boasVindas = "planeta atual: " + jogador.getPlanetaAtual().getDescricao();
        System.out.println(boasVindas);
        log += boasVindas;

    }

    public String pegarMensagemInicial() {

        return ("Bem-vindo ao Fundacao Terra!\n" +
                "\nFundacao Terra eh um novo jogo de aventura incrivelmente chato.\n" +
                "\nDigite 'ajuda' se voce precisar de ajuda.\n" +
                "\nMuitos anos atras, antes mesmo da grande Colisao, a humanidade saia de seu planeta natal para explorar o espaço.\n"
                +
                "\nApos a Colisao, a humanidade se viu presa em uma nova super-galaxia hostil e desconhecida, com muitas de suas colonias sendo ameacadas constantemente\n"
                +
                "\nAs escritas antigas indicam que o berço da vida humana se encontra em um planeta azul rochoso com uma ou mais luas ao redor.\n"
                +
                "\nAquele e o unico lugar onde a arvore da vida pode ser plantada em toda a super-galaxia.\n" +
                "\nTudo indica que voce esta no sistema planetario certo. Agora voce precisa encontrar o planeta e garantir nossa existencia que depende da arvore da vida.\n"
                +
                "\nSeu combustivel e escasso, entao voce precisa ser rapido e eficiente.\n" +
                "\nDurante sua jornada, voce pode sofrer com tempestades solares, chuvas de asteroides ou ate mesmo com a falta de energia.\n"
                +
                "\nBoa sorte!\n");

    }

    public void imprimirAjuda() {

        String ajuda = "\nVoce esta em um planeta ou estrela desconhecido e precisa encontrar o planeta Terra para plantar a arvore da vida.\n"
                +
                "o que voce sabe sobre este planeta e: " + jogador.getPlanetaAtual().getDescricao() +
                "\nSuas palavras de comando sao:\n" + analisador.getComandosAceitos() +
                "\nexplorar-> para explorar o planeta\n" +
                "viajar-> para viajar para outro planeta\n" +
                "plantar-> para plantar a arvore da vida\n" +
                "dica-> para saber mais sobre o planeta\n" +
                "ajuda-> para ver os comandos aceitos\n" +
                "quit-> para sair do jogo\n" +
                "saber-> para saber em qual planeta voce esta(pagando um preco bem alto)\n";
        escreverLog(ajuda);
        System.out.println(ajuda);

    }

    public void imprimirEstado() {

        String imprimir = ("\n==============================================================================================\n"
                + "Planeta: " + jogador.getPlanetaAtual().getDescricao() + "\n" + "Energia: " + jogador.getEnergia()
                + "\n" + "Plantas de arvore: " + jogador.getPlantasDeArvore() + "\n"
                + "Combustivel: " + nave.getCombustivel() + "\n"
                + "==============================================================================================\n"
                + "Saidas: ");

        escreverLog(imprimir);
        System.out.println(imprimir);

    }

    public String getDica() {

        log += jogador.getPlanetaAtual().getDescricao();
        return jogador.getPlanetaAtual().getDescricao();

    }

    public void escreverLog(String texto) {

        log += texto;

    }

}
