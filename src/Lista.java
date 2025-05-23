public class Lista {
    private Nodo inicio, fin;
    private int numElementos;

    public Lista() {
        inicio = null;
        fin = null;
        numElementos = 0;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public void insertar(Producto dato) {
        Nodo nuevo = new Nodo(dato, null);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        numElementos++;
    }

    public boolean borrar(Producto dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while (actual != null && !actual.getDato().equals(dato)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (actual != null) {
            if (actual == inicio) {
                inicio = actual.getSiguiente();
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            if (actual == fin) {
                fin = anterior;
            }
            numElementos--;
            return true;
        }
        return false;
    }

    public boolean contiene(Producto dato) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.getDato().equals(dato)) return true;
            actual = actual.getSiguiente();
        }
        return false;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public Iterador getIterador() {
        return new Iterador(inicio);
    }

    public void mostrar() {
        if (this.vacia()) {
            System.out.println("Lista vacía");
        } else {
            Nodo actual = inicio;
            while (actual != null) {
                actual.getDato().mostrar();
                actual = actual.getSiguiente();
            }
            System.out.println();
        }
    }
}
