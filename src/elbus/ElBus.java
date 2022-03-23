package elbus;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ElBus {

    public static void main(String[] args) {
        int bus[][];
        int filas;
        int menu;
        JTextArea hoja = new JTextArea();
        String mostrar;
        int cualFila, cualColumna;
        double caja = 0;

        do {
            filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas del bus (entre 1 - 10)"));
            if (filas >= 1 && filas <= 10) {
                JOptionPane.showMessageDialog(null, "Numero de filas correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Numero de filas incorrecta");
            }
        } while (filas <= 0 || filas > 10);
        bus = new int[filas][2];
        mostrar = "Distribucion del bus: \n";
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < 2; columna++) {
                mostrar += (bus[fila][columna] = 0) + "\t";
            }
            mostrar = mostrar + "\n";
        }
        menu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion: "
                + "\n1.Ver bus"
                + "\n2.Comprar un asiento"
                + "\n3.Devolver un asiento"
                + "\n4.Ver caja"
                + "\nCualquier numero para salir"));
        while (menu >= 1 && menu <= 4) {
            switch (menu) {
                case 1:
                    mostrar = "Distribucion del bus: \n";
                    for (int fila = 0; fila < filas; fila++) {
                        for (int columna = 0; columna < 2; columna++) {
                            mostrar += (bus[fila][columna]) + "\t";
                        }
                        mostrar = mostrar + "\n";
                    }
                    hoja.setText(mostrar);
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 2:
                    cualFila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila que desea comprar (entre 1 y " + filas + ")"));
                    if (cualFila > 0 && cualFila <= filas) {
                        cualColumna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna deseada comprar (entre 1 - 2)"));
                        if (cualColumna >= 1 && cualColumna <= 2) {
                            if (bus[cualFila - 1][cualColumna - 1] == 0) {
                                bus[cualFila - 1][cualColumna - 1] = 1;
                                JOptionPane.showMessageDialog(null, "Asiento comprado");
                                caja = caja + 0.50;
                            } else if (bus[cualFila - 1][cualColumna - 1] == 1) {
                                bus[cualFila - 1][cualColumna - 1] = 2;
                                caja = caja + 0.50;
                                JOptionPane.showMessageDialog(null, "Asiento comprado");
                            } else if (bus[cualFila - 1][cualColumna - 1] == 2) {
                                JOptionPane.showMessageDialog(null, "Asiento ocupado");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Columna no encontrada");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La fila no se encuentra");
                    }
                    break;
                case 3:
                    cualFila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila que desea devolver (entre 1 y " + filas + ")"));
                    if (cualFila > 0 && cualFila <= filas) {
                        cualColumna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna deseada devolver (entre 1 - 2)"));
                        if (cualColumna >= 1 && cualColumna <= 2) {
                            if (bus[cualFila - 1][cualColumna - 1] == 0) {
                                JOptionPane.showMessageDialog(null, "Asiento aun disponible");
                            } else if (bus[cualFila - 1][cualColumna - 1] == 2) {
                                bus[cualFila - 1][cualColumna - 1] = 1;
                                JOptionPane.showMessageDialog(null, "Asiento devuelto");
                                caja = caja - 0.40;
                            } else if (bus[cualFila - 1][cualColumna - 1] == 1) {
                                bus[cualFila - 1][cualColumna - 1] = 0;
                                JOptionPane.showMessageDialog(null, "Asiento devuelto");
                                caja = caja - 0.40;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Columna no encontrada");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La fila no se encuentra");
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, caja);
                    break;
            }
            menu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion: "
                    + "\n1.Ver bus"
                    + "\n2.Comprar un asiento"
                    + "\n3.Devolver un asiento"
                    + "\n4.Ver caja"
                    + "\nCualquier numero para salir"));
        }
    }

}
