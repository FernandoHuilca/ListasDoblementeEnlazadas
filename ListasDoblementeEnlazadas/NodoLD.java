
package ListasDoblementeEnlazadas;

/**
 *
 * @author Sebastián Ramos, Fernando Huilca, Juan Mateo Quisilema
 */

/**
 * Clase NodoLc contiene getters y setters de los componentes del nodo
 */
public class NodoLD {
 private String INFO;
private NodoLD Anterior;
private NodoLD Siguiente;


    /**
     *  Construtor de partes del nodo
     * @param INFO dato del nodo
     * @param LIGA apuntador del siguiente elemento en la lista
     */
    public NodoLD (String INFO, NodoLD  Anterior, NodoLD Siguiente) {
        this.INFO = INFO;
        this.Anterior = Anterior;
        this.Siguiente= Siguiente;
    }
    public NodoLD () {
        super();
    }

    public String getINFO() {
        return INFO;
    }

    public void setINFO(String INFO) {
        this.INFO = INFO;
    }

    public NodoLD  getAnterior() {
        return Anterior;
    }

    public void setAnterior(NodoLD  Anterior) {
        this.Anterior = Anterior;
    }

    public NodoLD getSiguiente(){
        return Siguiente;
    }
    public void setSiguiente(NodoLD Siguiente){
        this.Siguiente= Siguiente;
    }
}
