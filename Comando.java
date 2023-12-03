/*
 * @author helio
 */

import java.util.ArrayList;

public class Comando {

    private ArrayList<String> comando;

    public Comando(ArrayList<String> comando) {

        this.comando = comando;

    }

    public String getGatilho() {

        return comando.get(0);

    }

    public String getComplemento() {

        if (comando.size() > 1) {

            return comando.get(1);

        }

        return null;

    }

}
