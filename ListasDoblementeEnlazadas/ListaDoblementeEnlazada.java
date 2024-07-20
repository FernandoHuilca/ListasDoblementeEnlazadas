package ListasDoblementeEnlazadas;

import javax.swing.JOptionPane;

/**
 * @author Sebastián Ramos, Fernando Huilca, Juan Mateo Quisilema
 */
class ListaDoblementeEnlazada {
    private NodoLD cabeza;
    private NodoLD cola;

    public ListaDoblementeEnlazada() {
        super();
        this.cabeza = null;
        this.cola = null;

    }

    /**
     * Método para crear un Nodo al inicio de la Lista
     * CrearNodo(Dato, Anterior, Siguiente, Cabeza, Cola)
     * NodoNuevo <- Dato
     * Si (Cabeza = null) entonces
     * Cabeza <- NodoNuevo
     * Cola <- NodoNuevo
     * Si no:
     * NodoNuevo.Siguiente <- Cabeza
     * Cabeza.Anterior <- NodoNuevo
     * Cabeza <- NodoNuevo
     */
    public void crearNodoInicioLista() {
        NodoLD nuevoNodo = new NodoLD();
        nuevoNodo.setINFO(JOptionPane.showInputDialog("Ingrese el nombre del primer nodo"));
        nuevoNodo.setSiguiente(null);
        nuevoNodo.setAnterior(null);
        cabeza = nuevoNodo;
        cola = nuevoNodo;
        int opcion = JOptionPane.showConfirmDialog(null, "Desea Ingresar mas nodos?");
        while (opcion == JOptionPane.YES_OPTION) {
            NodoLD nodo = new NodoLD();
            nodo.setINFO(JOptionPane.showInputDialog("Ingrese el nombre del siguiete nodo"));
            nodo.setSiguiente(cabeza);
            nodo.setAnterior(null);
            cabeza.setAnterior(nodo);
            cabeza = nodo;
            opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar mas nodos?");
        }
    }

    /**
     * CrearNodo(Dato, Anterior, Siguiente, Cabeza, Cola)
     * NodoNuevo <- Dato
     * Si (Cabeza = null) entonces
     * Cabeza <- NodoNuevo
     * Cola <- NodoNuevo
     * Si no:
     * Cola.Siguiente <- NodoNuevo
     * NodoNuevo.Anterior <- Cola
     * Cola <- NodoNuevo
     */
    public void crearNodoFinalLista() {
        NodoLD nuevoNodo = new NodoLD();
        nuevoNodo.setINFO(JOptionPane.showInputDialog("Ingrese el nombre del 1er nodo"));
        nuevoNodo.setSiguiente(null);
        nuevoNodo.setAnterior(null);
        cola = nuevoNodo;
        cabeza = nuevoNodo;
        int opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar mas nodos?");
        while (opcion == JOptionPane.YES_OPTION) {
            NodoLD nodo = new NodoLD(); //Crear un nuevo nodo
            nodo.setINFO(JOptionPane.showInputDialog("Ingrese el nombre del siguiente nodo"));
            nodo.setSiguiente(null);
            nodo.setAnterior(cola);
            cola.setSiguiente(nodo);
            cola = nodo;
            opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar mas nodos?");
        }
    }

    /**
     * eliminarInicioLista()
     * Si (listaEstáVacía()) entonces
     *     Escribir "No se puede eliminar, la lista está vacía."
     * fin Si
     * Si (listaTieneUnElemento()) entonces
     *     cola = null
     *     cabeza = null
     *     Escribir "La lista tiene un solo elemento. Ahora está vacía."
     * Si no
     *     cabeza = cabeza.getSiguiente()
     *     cabeza.setAnterior(null)
     * fin eliminarInicioLista()
     */
    public void eliminarInicioLista() {
        if (listaEstáVacía()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía. Primero debe crear la lista.");
        } else if (listaTieneUnElemento()) {
            cola = null;
            cabeza = null;
            JOptionPane.showMessageDialog(null, "La lista tiene un solo elemento.\n Ahora está vacía.");
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }
    }

    /**
     * eliminarFinalLista()
     * Si (listaEstáVacía()) entonces
     *     Escribir "No se puede eliminar, la lista está vacía."
     * fin Si
     * Si (listaTieneUnElemento()) entonces
     *     cola = null
     *     cabeza = null
     *     Escribir "La lista tiene un solo elemento. Ahora está vacía."
     * Si no
     *     cola = cola.getAnterior()
     *     cola.setSiguiente(null)
     * fin eliminarFinalLista()
     */
    public void eliminarFinalLista() {
        if (listaEstáVacía()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía. Primero debe crear la lista.");
        } else if (listaTieneUnElemento()) {
            cola = null;
            cabeza = null;
            JOptionPane.showMessageDialog(null, "La lista tiene un solo elemento.\n Ahora está vacía.");
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
    }


    // Método para representar la lista doblemente enlazada como una cadena de texto
    public String toString() {
        if (listaEstáVacía()) {
            return "LISTA VACÍA";
        }
        StringBuilder salida = new StringBuilder();
        NodoLD aux = this.cabeza;
        while (aux != null) {
            salida.append(aux.getINFO()).append(" ");
            aux = aux.getSiguiente();
            if (aux != null) {
                salida.append("↔️ ");
            }
        }
        return salida.toString();
    }

    public String getCabezaInfo() {
        return cabeza.getINFO();
    }

    public String getColaInfo() {
        return cola.getINFO();
    }


    private boolean listaTieneUnElemento() {
        return cola == cabeza;
    }

    private boolean listaEstáVacía() {
        return cabeza == null && cola == null;
    }

    /**
     * búsqueda()
     * Si (listaEstáVacía()) entonces
     *     Escribir "La lista está vacía."
     * fin Si
     * Si no
     *     Inicializar una variable contador en 0
     *     Inicializar un nodo auxiliar con la cabeza de la lista
     *     Mientras (auxiliar != null)
     *         Si (auxiliar.getINFO().equals(palabraABuscar)) entonces
     *             Escribir "La palabra se ha encontrado en la posición " + contador
     *             return
     *         fin Si
     *         Incrementar contador
     *         Actualizar auxiliar a auxiliar.getSiguiente()
     *     fin Mientras
     *     Escribir "No se ha encontrado la información"
     * fin búsqueda()
     */
    public void búsqueda() {
        if (listaEstáVacía()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            String palabraABuscar = JOptionPane.showInputDialog("Ingrese la información a buscar: ");
            NodoLD auxNodo = cabeza;
            int contador = 0;
            while (auxNodo != null) {
                if (auxNodo.getINFO().equals(palabraABuscar)) {
                    JOptionPane.showMessageDialog(null, "La información buscada: " + palabraABuscar + "\nSe ha encontrado en la posición: " + contador);
                    return;
                }
                contador++;
                auxNodo = auxNodo.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La información buscada: " + palabraABuscar + "\nNO se ha encontrado en la lista.");
        }
    }

    /**
     * Algoritmo InsertarNodoAlInicio
     * cabeza, cola, nodoInsertar: apuntadorAlNodo
     * Información, anterior, siguiente: campos del Nodo.
     *
     * CrearNodoAInsertar()
     * Leer nodoAInsertar^.Info
     * Hacer nodoAInsertar^.setAnterior <-- null
     * Hacer nodoAInsertar^.setSiguiente <-- cabeza
     * Hacer cabeza^.setAnterior <-- nodoAInsertar
     * cabeza <-- nodoAInsertar
     * Fin del AlgoritmoInsertarNodoAlInicio
     */
    public void insertarALInicio() {
        if(!existeUnElementoAnterior()){
            JOptionPane.showMessageDialog(null, "La lista está vacía, primero creéla y después puede insertar al Inicio...");
            return;
        }
        NodoLD nodoAInsertar = new NodoLD();
        nodoAInsertar.setINFO(JOptionPane.showInputDialog("Ingrese el nombre al nuevo Nodo a Insertar: "));
        nodoAInsertar.setAnterior(null);
        nodoAInsertar.setSiguiente(cabeza);
        cabeza.setAnterior(nodoAInsertar);
        this.cabeza = nodoAInsertar;
    }
    /**
     * Algoritmo InsertarNodoAlFinal
     * cabeza, cola, nodoInsertarFinal: apuntadorAlNodo
     * Información, anterior, siguiente: campos del Nodo.
     *
     * CrearNodoAInsertarFinal()
     * Leer nodoAInsertarFinal^.Info
     * Hacer nodoAInsertarFinal^.setAnterior <-- null
     * Hacer nodoAInsertarFinal^.setSiguiente <-- cabeza
     * Hacer cola^.setSiguiente <-- nodoAInsertarFinal
     * cola <-- nodoAInsertarFinal
     * Fin del AlgoritmoInsertarNodoFinal()
     */
    public void insertarAlFinal() {
        if(!existeUnElementoAnterior()){
            JOptionPane.showMessageDialog(null, "La lista está vacía, primero creéla y después puede insertar al Final...");
            return;
        }
        NodoLD nodoAInsertarALFinal = new NodoLD();
        nodoAInsertarALFinal.setINFO(JOptionPane.showInputDialog("Ingrese el nombre al nuevo Nodo a Insertar: "));
        nodoAInsertarALFinal.setSiguiente(null);
        nodoAInsertarALFinal.setAnterior(cola);
        this.cola.setSiguiente(nodoAInsertarALFinal);
        this.cola = nodoAInsertarALFinal;
    }

    private boolean existeUnElementoAnterior() {
        return this.cabeza != null;
    }

    /**
     * Algoritmo RecorrerDesdeInicio(lista)
     * cabeza, aux: apuntadorAlNodo
     * información, anterior, siguiente: campos del Nodo.
     *
     * Si (cabeza == null)
     * Entonces
     * Escribir "Lista Vacía"
     * Sino
     * Escribir cabeza^.información
     * Hacer aux <-- cabeza
     * Mientras (aux^.siguiente != null)
     *  Escribir cabeza^.información
     *  Hacer aux <-- cabeza
     * Fin del Mientras
     * Fin del Algoritmo
     */
    public String recorrerDesdeElInicio() {
        return toString();
    }
    /**
     * Algorimto RecorrerDesdeFinal(lista)
     * cabeza, aux: apuntadorAlNodo
     * información, anterior, siguiente: campos del Nodo.
     *
     * Si (cola == null)
     * Entonces
     * Escribir "Lista Vacía"
     * Sino
     * Escribir cabeza^.información
     * Hacer aux <-- cola
     * Mientras (aux^.siguiente != null)
     *  Escribir cabeza^.información
     *  Hacer aux <-- cabeza
     * Fin del Mientras
     * Fin del Algoritmo
     */
    public String recorrerDesdeElFinal() {
        if (listaEstáVacía()) {
            return "LISTA VACÍA";
        }
        StringBuilder salida = new StringBuilder();
        NodoLD aux = this.cola;
        while (aux != null) {
            salida.append(aux.getINFO()).append(" ");
            aux = aux.getAnterior();
            if (aux != null) {
                salida.append("↔️ ");
            }
        }
        return salida.toString();
    }
}
