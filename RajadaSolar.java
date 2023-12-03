import java.util.ArrayList;
import java.util.Random;

public class RajadaSolar implements Desafio {

    private static ArrayList<CorpoCeleste> destinos;

    @Override
    public void imprimirDescricaoEvento() {

        System.out.println("Durante sua viagem, uma rajada solar gerou uma pane eletrica no sistema de navegacao da sua nave, e voce foi direcionado para um planeta aleatorio...");

    }

    @Override 
    public void enfrentarDesafio(Nave nave)  {

        if (nave.getCombustivel() >= 5) {

        nave.decrementarCombustivel(5);

        }

        else {

            nave.decrementarCombustivel(nave.getCombustivel());

        }

    }

    public CorpoCeleste enfrentarRajada() {

        Random random = new Random();
        int aleatorio = random.nextInt(14);
        destinos = Jogo.getPlanetas();

        return destinos.get(aleatorio);


    }

}