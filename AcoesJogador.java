import java.util.ArrayList;
import java.util.Random;

public class AcoesJogador {

    public boolean plantarArvore(Jogador jogador) {

        if (jogador.getPlanetaAtual().getNome() == "Terra") {

            System.out.println("Parabens! Voce salvou a humanidade!");
            return true;

        }

        else {

            System.out.println("Voce nao esta no planeta certo para plantar a arvore da vida");
            jogador.decrementarPlantasDeArvore();

            if (jogador.getPlantasDeArvore() > 0) {

                System.out.println("Voce ainda tem " + jogador.getPlantasDeArvore() + " arvores para plantar");

            }

            else {

                System.out.println("Voce nao tem mais arvores para plantar... Sua missao falhou...");
                Jogo.gameOver();

            }

        }

        return false;

    }

    public void explorarPlaneta(Jogador jogador) {

        CorpoCeleste planeta = jogador.getPlanetaAtual();
        

        if (planeta.getTemItem() && !planeta.getFoiExplorado()) {

            String[] itens = planeta.pegarItens().split("-");
            System.out.println("Item adicionado: ");
            for (String nomes : itens) {

                jogador.getMochila().adicionarItem(nomes);
                System.out.println(nomes + "  +1");

            }

            planeta.setFoiExplorado();

        }

        else {

            System.out.println("Nao ha itens nesse planeta...");

        }

    }

    public boolean viajar(Comando comando, Jogador jogador, Nave nave) {

        if (!nave.getEstado()) {

            System.out.println("Sua nave esta quebrada! Voce precisa consertar ela antes de viajar!");

            if (checkGameOver(nave, jogador)) {

                Jogo.gameOver();
                return false;

            }

            return false;

        }

        

        ArrayList<CorpoCeleste> destinos = Jogo.getPlanetas();
        int indiceDoPlanetaAtual = indiceDoPlanetaAtual(destinos, jogador.getPlanetaAtual());
        int tamanhoArrayCorpoCeleste = destinos.size();

        if (comando.getComplemento() != null) {

            char operador;
            System.out.println("comando: " + comando.getGatilho());
            System.out.println("destino: " + comando.getComplemento());

            if (comando.getComplemento().equals("esquerda")) {

                operador = '-';

            }

            else if (comando.getComplemento().equals("direita")) {

                operador = '+';

            }

            else {

                System.out.println("direcao invalida");
                return false;

            }

            if (dentroDoSistemaSolar(indiceDoPlanetaAtual, operador, tamanhoArrayCorpoCeleste)) {

                if (1 > nave.getCombustivel()) {

                    System.out.println("Voce nao tem combustivel suficiente para viajar");
                    checkGameOver(nave, jogador);
                    return false;

                }

                else {

                    if (chanceDesafio()) {

                        Desafio desafio = definirDesafio();
                        desafio.imprimirDescricaoEvento();

                        if (desafio instanceof RajadaSolar) {

                            RajadaSolar rajada = (RajadaSolar)desafio;
                            jogador.setPlanetaAtual(rajada.enfrentarRajada());
                            rajada.enfrentarDesafio(nave);
                            return true;

                        }

                        else {

                            desafio.enfrentarDesafio(nave);

                            if (operador == '+') {

                                jogador.setPlanetaAtual(destinos.get(indiceDoPlanetaAtual + 1));

                            }

                            else if (operador == '-') {

                                jogador.setPlanetaAtual(destinos.get(indiceDoPlanetaAtual - 1));

                            }

                            nave.decrementarCombustivel(1);
                            return true;

                        }   

                    }

                    else {

                        if (operador == '+') {

                            jogador.setPlanetaAtual(destinos.get(indiceDoPlanetaAtual + 1));

                        }

                        else if (operador == '-') {

                            jogador.setPlanetaAtual(destinos.get(indiceDoPlanetaAtual - 1));

                        }

                        nave.decrementarCombustivel(1);
                        return true;

                    }
               
                }

            }

            else {

                System.out.println("Ir nessa direcao seria morte certa... Destino invalido");
                return false;

            }

        }

        System.out.println("destino invalido");
        return false;

    }

    public void saberPlaneta(Nave nave, Analisador analisador, Jogador jogador) {

        if (nave.getCombustivel() == 0) {

            System.out.println("Você não tem combustivel...");

        }

        else {

            if (analisador.getSaberNomePlaneta().equals("sim")) {

                if (nave.getCombustivel() < 10) {

                    nave.decrementarCombustivel(nave.getCombustivel());

                }

                else {

                    nave.decrementarCombustivel(10);
                    System.out.println("Voce esta no planeta " + jogador.getPlanetaAtual().getNome());

                }

            }

        }

    }

    public int indiceDoPlanetaAtual(ArrayList<CorpoCeleste> planetas, CorpoCeleste planetaAtual) {

        for (int i = 0; i < planetas.size(); i++) {

            if (planetas.get(i).getNome() == planetaAtual.getNome())
                return i;

        }

        return 0;

    }

    public boolean dentroDoSistemaSolar(int indiceDoPlanetaAtual, char operador, int tamanhoArrayCorpoCeleste) {

        if (operador == '-' && indiceDoPlanetaAtual - 1 > 0) {

            return true;

        }

        if (operador == '+' && indiceDoPlanetaAtual + 1 < tamanhoArrayCorpoCeleste) {

            return true;

        }

        return false;

    }

    public Desafio definirDesafio() {

        Random random = new Random();
        int desafioAtual = random.nextInt(3);

        switch (desafioAtual) {

            case 0:
                return new FalhaMecanica();
            case 1:
                return new RajadaSolar();
            case 2:
                return new ImpactoMeteoro();
            default:
                break;

        }

        return null;

    }

    public boolean chanceDesafio() {

        Random random = new Random();
        int chance = random.nextInt(10);

        if (chance == 1) {

            return true;

        }

        return false;

    }

    public void beberCafe(Jogador jogador) {

        if (jogador.getMochila().buscarItem("java coffee") > 0) {

            jogador.incrementarEnergia(1);
            jogador.getMochila().decrementarItem("java coffee");
            System.out.println("Energia +1");

        }

        else {

            System.out.println("Voce nao tem cafe!!!");

        }

    }

    public void consertarNave(Nave nave, Jogador jogador) {

        if (nave.getEstado()) {

            System.out.println("A nave ja esta funcionando normalmente");

        }

        else {

            if (jogador.getMochila().buscarItem("rebimboca de parafuseta") > 0) {

                nave.consertar();
                jogador.getMochila().decrementarItem("rebimboca de parafuseta");
                System.out.println("Nave consertada com sucesso");

            }

            else {

                System.out.println("Voce nao tem rebimbocas...Explore a planeta para tentar achar...");

            }

        }

    }

    public void reabastecer(Jogador jogador, Nave nave) {

        if (jogador.getMochila().buscarItem("combustivel") > 0) {

            nave.incrementarCombustivel(1);
            jogador.getMochila().decrementarItem("combustivel");
            System.out.println("Combustivel nave +1");

        }

        else {

            System.out.println("Voce nao tem combustivel...Explore a planeta para tentar achar...");

        }

    }

    public boolean checkGameOver(Nave nave, Jogador jogador) {

        boolean foiExplorado = jogador.getPlanetaAtual().getFoiExplorado();

        if (!nave.getEstado() && foiExplorado) {
            
            if (jogador.getMochila().buscarItem("rebimboca de parafuseta") == -1) {

                return true;

            }

        }

        if (nave.getCombustivel() == 0 && foiExplorado) {

            if (jogador.getMochila().buscarItem("combustivel") == -1) {

                return true;

            }

        }

        return false;

    }

}