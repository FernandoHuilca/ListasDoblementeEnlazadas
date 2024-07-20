package ListasDoblementeEnlazadas;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        /**
         * Menu principal para acceder a cada operation en la lista doblemente enlazada
         */
        int opcion;
        ListaDoblementeEnlazada list = new ListaDoblementeEnlazada();
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    " _______________ ELIJA UNA OPERACIÓN EN LISTA DOBLE _______________ \n\n" +

                            "1)  CREAR NODOS AL INICIO  LISTA DOBLE\n" +
                            "2)  CREAR NODOS AL FINAL LISTA DOBLE \n\n" +

                            "3)  RECORRER LISTA DOBLE DESDE EL INICIO\n" +
                            "4)  RECORRER LISTA DOBLE DESDE EL FINAL\n\n" +

                            "5)  BÚSQUEDA LISTA DOBLE\n\n" +

                            "6)  INSERTAR NODO AL INICIO LISTA DOBLE\n" +
                            "7)  INSERTAR NODO AL FINAL LISTA DOBLE\n\n" +

                            "8)  ELIMINAR NODO INICIO LISTA DOBLE\n" +
                            "9)  ELIMINAR NODO FINAL LISA DOBLE\n\n" +

                            "10)  VER LISTA DOBLE\n" +
                            "0)  SALIR\n\n"));
            switch (opcion) {
                case 1:
                    list.crearNodoInicioLista();
                    JOptionPane.showMessageDialog(null, "____ LISTA DOBLE CREADA NODOS POR INICIO ____ \n" + list);
                    JOptionPane.showMessageDialog(null, "_______ Cabeza y Cola _______ \n\n La cabeza es:  " + list.getCabezaInfo() + "\n La cola es: " + list.getColaInfo() + "\n\n");
                    break;
                case 2:
                    list.crearNodoFinalLista();
                    JOptionPane.showMessageDialog(null, "____ LISTA DOBLE CREADA NODOS  POR FINAL ____ \n" + list);
                    JOptionPane.showMessageDialog(null, "_______ Cabeza y Cola _______ \n\n La cabeza es:  " + list.getCabezaInfo() + "\n La cola es: " + list.getColaInfo() + "\n\n");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "____ RECORRER LISTA DESDE EL INICIO ____ \n" + list.recorrerDesdeElInicio());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "____ RECORRER LISTA DESDE EL INICIO ____ \n" + list.recorrerDesdeElFinal());
                    break;
                case 5:
                    list.búsqueda();
                    break;
                case 6:
                    list.insertarALInicio();
                    JOptionPane.showMessageDialog(null, "____ NUEVO ELEMENTO INSERTADO AL INICIO ____ \n" + list);
                    break;
                case 7:
                    list.insertarAlFinal();
                    JOptionPane.showMessageDialog(null, "____ NUEVO ELEMENTO INSERTADO AL FINAL ____ \n" + list);
                    break;
                case 8:
                    list.eliminarInicioLista();
                    JOptionPane.showMessageDialog(null, "____ NUEVA LISTA DOBLE NODO ELIMINADO POR INICIO ____ \n" + list);
                    break;

                case 9:
                    list.eliminarFinalLista();
                    JOptionPane.showMessageDialog(null, "____ NUEVA LISTA DOBLE NODO ELIMINADO POR FINAL ____ \n" + list);
                    break;

                case 10:
                    JOptionPane.showMessageDialog(null, " ________ LA LISTA DOBLEMENTE ENLAZADA ES ________ \n\n" + list + "\n");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR DESCONOCIDO.");
                    break;


            }
        } while (opcion != 0);
    }

}