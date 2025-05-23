public class Factura {
    private String dni;
    private String fecha;
    private Lista listaProductos;
    private boolean cobrada;

    public Factura(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        this.listaProductos = new Lista();
        this.cobrada = false;
    }

    public String getDNI() {
        return dni;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean estaCobrada() {
        return cobrada;
    }

    public void cobrada() {
        this.cobrada = true;
    }

    public void anyadirProducto(Producto producto) {
        Iterador it = listaProductos.getIterador();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.equals(producto)) {
                p.setUnidades(p.getUnidades() + producto.getUnidades());
                return;
            }
        }
        listaProductos.insertar(producto);
    }

    public void mostrar() {
        System.out.println("FACTURA de: " + dni + ". Fecha: " + fecha);
        listaProductos.mostrar();
        System.out.println("IMPORTE TOTAL: " + importeTotal() + " €");
    }

    public float importeTotal() {
        float total = 0.0f;
        Iterador it = listaProductos.getIterador();
        while (it.hasNext()) {
            Producto p = it.next();
            total += p.getPrecio() * p.getUnidades();
        }
        return total;
    }

    public int eliminarProducto(Producto producto) {
        Iterador it = listaProductos.getIterador();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.equals(producto)) {
                int unidadesEliminadas = Math.min(p.getUnidades(), producto.getUnidades());
                if (p.getUnidades() <= producto.getUnidades()) {
                    listaProductos.borrar(p);
                } else {
                    p.setUnidades(p.getUnidades() - unidadesEliminadas);
                }
                return unidadesEliminadas;
            }
        }
        return 0;
    }

    public Lista mayoresPrecios(float precio) {
        Lista nuevaLista = new Lista();
        Iterador it = listaProductos.getIterador();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.getPrecio() > precio) {
                nuevaLista.insertar(p);
            }
        }
        return nuevaLista;
    }
}
