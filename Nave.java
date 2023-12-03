
/*
 * @author helio
 */
public class Nave {
    
    private int combustivel; 
    private int tiro;
    private boolean estado;

    public Nave() {

        combustivel = 20;
        tiro = 5;
        estado = true; 
    }

    public void incrementarCombustivel(int incremento) {

        combustivel += incremento;

    }

    public void decrementarCombustivel(int decremento) {

        combustivel -= decremento;

    }

    public int getCombustivel() {

        return combustivel;

    }

    public int getTiro() {

        return tiro;

    }

    public void incrementarTiro(int incremento) {

        tiro += incremento;

    }

    public void decrementarTiro(int decremento) {

        tiro -= decremento;

    }

    public void quebrar() {

        estado = false;

    }

    public void consertar() {

        estado = true;

    }

    public boolean getEstado() {

        return estado;

    }
    
}
