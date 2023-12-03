/*
 * @author helio
 */
public class Jogador {
    
    private Inventario mochila;
    private int plantasDeArvore;
    private int energia;
    private CorpoCeleste planetaAtual;

    public Jogador() {

        mochila = new Inventario(); 
        energia = 20;
        plantasDeArvore = 3;

    }

    public int getEnergia() {

        return energia;

    }

    public void descansar() {

        energia += 5;

    }

    public void incrementarEnergia(int incremento) {

        energia += incremento;

    }

    public void decrementarEnergia(int decremento) {

        energia -= decremento;

    }

    public int getPlantasDeArvore() {

        return plantasDeArvore;

    }

    public void decrementarPlantasDeArvore() {

        plantasDeArvore -= 1;
        
    }

    public CorpoCeleste getPlanetaAtual() {

        return planetaAtual;

    }

    public void setPlanetaAtual(CorpoCeleste planeta) {

        planetaAtual = planeta;

    }

    public void verificarMochila() { 

        mochila.listarItens();

    }

    public Inventario getMochila() {

        return mochila;

    }

}
