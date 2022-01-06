import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Funcionalidaddes {

    private String vacio = "Vacio";
    private String ocupado = "Ocupado";

    /**
     * Metodo para definir una matriz de una sala de cine
     * 
     * @param filas    Recive un numero entero mayor a 5
     * @param columnas Recive un numero entero mayor a 5
     * @return Retorna un vector de tipo string definido con las dimensiones antes
     *         dadas, si no cumple las condiciones retorna una matriz de 0x0
     */
    public String[][] nSala(int filas, int columnas) {
        if (filas < 5 || columnas < 5) {
            return new String[0][0];
        } else {
            String matriz[][] = new String[filas][columnas];
            matriz = llenarMatriz(matriz);
            return matriz;
        }
    }

    /**
     * Metodo para visualizar los datos de la matriz
     * 
     * @param matriz
     */
    public void verSala(String[][] matriz) {
        JTextArea pantalla = new JTextArea();
        String texto = "Filas/Columnas\t";
        for (int i = 0; i < matriz[0].length; i++) {
            texto += (i + 1) + "\t";
        }
        texto += "\n";
        for (int i = 0; i < matriz.length; i++) {
            texto += (i + 1) + "\t";
            for (int j = 0; j < matriz[0].length; j++) {
                texto += matriz[i][j] + "\t";
            }
            texto += "\n";
        }
        pantalla.setText(texto);
        JOptionPane.showMessageDialog(null, pantalla);
    }

    /**
     * Llena una matriz con la pálabra ocupado
     * 
     * @param matriz Recive una matriz de tipo string
     * @return retorna una matriz de la misma dimension a la recivida pero llena con
     *         las palabra ocupado
     */
    public String[][] llenarMatriz(String[][] matriz) {
        String datos[][] = matriz;
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[0].length; j++) {
                datos[i][j] = vacio;
            }
        }
        return datos;
    }

    public String[][] llenarAsiento(int fila, int columna, String[][] sala, double bolsa) {
        String matriz[][] = sala;

        if (matriz[(fila - 1)][(columna - 1)].equals(vacio)) {
            matriz[(fila - 1)][(columna - 1)] = ocupado;
            JOptionPane.showMessageDialog(null, "Asiento vendido con exito\nCosto a cobrar del asiento: " + bolsa);
        } else {
            JOptionPane.showMessageDialog(null, "Este asiento ya se encuentra ocupado");
        }
        return matriz;
    }

}
