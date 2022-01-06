import java.util.Arrays;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        int menu;
        String sala[][];
        double bolsa = 0.0, valor = 1.0;
        Funcionalidaddes fn = new Funcionalidaddes();
        do {
            int filas = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese el numero de filas para la sala de cine\nel numero debe de ser mayor o igual a 5"));
            int columnas = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese el numero de columnas para la sala de cine\nel numero debe de ser mayor o igual a 5"));
            sala = fn.nSala(filas, columnas);
        } while (sala.length == 0);

        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(
                    "Rafael Garcia\n1. Ver sala de cine\n2. Comprar asiento\n3. Devolver asiento\n4. Terminar funcion\n5. Ver valor de caja\nOtro numeo para salir"));
            switch (menu) {
                case 1:
                    fn.verSala(sala);
                    break;
                case 2:
                    int fila = Integer
                            .parseInt(JOptionPane.showInputDialog("Ingrese el numero de fila del asiento a comprar"));
                    int columna = Integer.parseInt(
                            JOptionPane.showInputDialog("Ingrese el numero de columna del asiento a comprar"));
                    String[][] resultado = fn.llenarAsiento(fila, columna, sala, valor);
                    if (resultado != null) {
                        sala = resultado;
                        bolsa += valor;
                    }
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "El valor de la bolsa es de: " + bolsa);
                    break;

                default:
                    break;
            }
        } while (menu >= 1 && menu <= 5);
    }
}
