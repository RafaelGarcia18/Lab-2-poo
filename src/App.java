import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // Definicion de variable globalers
        int menu, filas, columnas, fila, columna;
        String[][] sala, resultado;
        double bolsa = 0.0, valor = 1.0;
        // Iniciacion de clase de funcionabilidad
        Funcionalidaddes fn = new Funcionalidaddes();
        // Dimensionar matriz
        do {
            filas = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese el numero de filas para la sala de cine\nel numero debe de ser mayor o igual a 5"));
            columnas = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese el numero de columnas para la sala de cine\nel numero debe de ser mayor o igual a 5"));
            sala = fn.nSala(filas, columnas);
        } while (sala.length == 0);
        // Menu de opciones
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(
                    "Rafael Garcia\n1. Ver sala de cine\n2. Comprar asiento\n3. Devolver asiento\n4. Terminar funcion\n5. Ver valor de caja\nOtro numeo para salir"));
            switch (menu) {
                case 1:
                    fn.verSala(sala);
                    break;
                case 2:
                    fila = Integer
                            .parseInt(JOptionPane.showInputDialog("Ingrese el numero de fila del asiento a comprar"));
                    columna = Integer.parseInt(
                            JOptionPane.showInputDialog("Ingrese el numero de columna del asiento a comprar"));
                    resultado = fn.llenarAsiento(fila, columna, sala, valor);
                    if (resultado != null) {
                        sala = resultado;
                        bolsa += valor;
                    }
                    break;
                case 3:
                    fila = Integer
                            .parseInt(JOptionPane.showInputDialog("Ingrese el numero de fila del asiento a devolver"));
                    columna = Integer.parseInt(
                            JOptionPane.showInputDialog("Ingrese el numero de columna del asiento a devolder"));
                    resultado = fn.vaciarAsiento(fila, columna, sala, valor);
                    if (resultado != null) {
                        sala = resultado;
                        bolsa -= (valor * 0.8);
                    }
                    break;
                case 4:
                    sala = fn.nSala(filas, columnas);
                    JOptionPane.showMessageDialog(null,
                            "Funcion terminada\nNueva sala ya esta vacia y liosta\nEl valor de la bolsa es de: "
                                    + bolsa);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "El valor de la bolsa es de: " + bolsa);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Gracias por utilizar el sistema de control de salas\nEl valor de la bolsa es de: "
                                    + bolsa);
                    break;
            }
        } while (menu >= 1 && menu <= 5);
    }
}
