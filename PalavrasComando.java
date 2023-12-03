/*
 * 
 * @author helio
 */

public class PalavrasComando {

    private String[] comandosValidos;

    public PalavrasComando() {

        comandosValidos = new String[] { "explorar", "quit", "ajuda", "plantar", "dica", "viajar", "saber", "beberCafe", "reabastecer", "consertarNave"};

    }

    public boolean ehComando(String umaString) {

        for (int i = 0; i < comandosValidos.length; i++) {

            if (comandosValidos[i].equals(umaString)) {

                return true;

            }

        }

        return false;

    }

    public String getComandos() {

        String comandos = "";

        for (int i = 0; i < comandosValidos.length; i++) {

            comandos += comandosValidos[i] + " ";

        }

        return comandos;

    }
    
}