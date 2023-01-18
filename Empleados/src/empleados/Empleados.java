package empleados;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Empleados {

    public static void main(String[] args) {
        ArrayList<Secretario> secretarios = new ArrayList<>();
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        ArrayList<JefeZona> jefes = new ArrayList<>();
        ArrayList<Coche> coches = new ArrayList<>();
        boolean continuar = true;
        int seleccion, opcion = 0;

        coches.add(new Coche("GSY404", "NISSAN", "KICKS 2020"));
        coches.add(new Coche("KQC402", "HONDA", "CIVIC 2021"));
        coches.add(new Coche("IZN408", "CHEVROLET", "SAIL 2020"));
        coches.add(new Coche("GHK401", "KIA", "PICANTO 2020"));

        secretarios.add(new Secretario("despacho1", 1234, "victor", "vargas", "calle 20", 8765, 2, 3383838, 2333.24));
        secretarios.add(new Secretario("despacho2", 1287654, "manuel", "vallejo", "carrrera 15", 38473, 1, 424342234, 5000.0));

        do {
            try {
                vendedores.add(new Vendedor(coches.get(0), 312334543, "publicidad", 3.4, "pepito", "medrano", "cll 22", 1111111, 8, 3333333, 1222.23));
                vendedores.add(new Vendedor(coches.get(1), 3121526, "infantes", 3.4, "alexis", "santacruz", "cll 20", 123456, 10, 863826382, 2000.43));
                vendedores.add(new Vendedor(coches.get(2), 123123232, "tercera edad", 3.4, "flor", "medina", "cll 43", 3132321, 9, 2515121, 4000.90));

                jefes.add(new JefeZona("Despacho presidencial", secretarios.get(0), coches.get(3), "Alejandra", "Yepes", "Calle 45", 2060544, 1, 314625444, 200000.0));

            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Indice fuera de rango");
            }

            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione la opcion a realizar digitando el numero correspondiente:"
                        + "\n1. Añadir Vendedor\n"
                        + "2. Cambiar Secretario\n"
                        + "3. Cambiar coche\n"
                        + "4. Imprimir Jefes\n"
                        + "5. Salir"
                )
                );
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
            }
            switch (opcion) {
                case 1:
                    String ven = "";
                    int opcion01 = 1;
                    for (Vendedor v : vendedores) {
                        ven += opcion01 + "- " + v.getNombre() + " " + v.getApellido() + "\n";
                        opcion01++;
                    }
                    try {
                        seleccion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el vendedor: \n" + ven));
                        jefes.get(0).addVendedor(vendedores.get(seleccion - 1));
                    } catch (NumberFormatException n) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
                    } catch (IndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Valor ingresado fuera del rango de la lista de vendedores");
                    }
                    break;

                case 2:
                    String secre = "";
                    int opcion02 = 1;
                    for (Secretario sec : secretarios) {
                        secre += opcion02 + "- " + sec.getNombre() + " " + sec.getApellido() + "\n";
                        opcion02++;
                    }
                    try {
                        seleccion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el secretario: \n" + secre));
                        jefes.get(0).setSecretario(secretarios.get(seleccion - 1));
                    } catch (NumberFormatException n) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
                    } catch (IndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Valor ingresado fuera del rango de la lista de secretarios");
                    }
                    break;

                case 3:
                    String co = "";
                    int opcion03 = 1;
                    for (Coche coche : coches) {
                        co += opcion03 + " - " + coche.getMatricula() + " " + coche.getModelo() + "\n";
                        opcion03++;
                    }
                    try {
                        seleccion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el coche: \n" + co));
                        jefes.get(0).setCoche(coches.get(seleccion - 1));
                    } catch (NumberFormatException n) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
                    } catch (IndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Valor ingresado fuera del rango de la lista de coches");
                    }
                    break;

                case 4:
                    for (JefeZona j : jefes) {
                        j.imprimir();
                    }
                    break;

                case 5:
                    continuar = false;
                    break;
            }

        } while (continuar);
    }
}
