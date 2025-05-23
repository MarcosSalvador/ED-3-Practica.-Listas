import java.util.Iterator;
import java.util.LinkedList;

public class FacturaBib {
    private String dni;
    private String fecha;
    private LinkedList<Producto> listaProductos;
    private boolean cobrada;

    public FacturaBib(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        this.listaProductos = new LinkedList<>();
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
        Iterator<Producto> it = listaProductos.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.equals(producto)) {
                p.setUnidades(p.getUnidades() + producto.getUnidades());
                return;
            }
        }
        listaProductos.add(producto);
    }

    public void mostrar() {
        System.out.println("FACTURA de: " + dni + ". Fecha: " + fecha);
        for (Producto p : listaProductos) {
            p.mostrar();
        }
        System.out.println("IMPORTE TOTAL: " + importeTotal() + " €");
    }

    public float importeTotal() {
        float total = 0.0f;
        for (Producto p : listaProductos) {
            total += p.getPrecio() * p.getUnidades();
        }
        return total;
    }

    public int eliminarProducto(Producto producto) {
        Iterator<Producto> it = listaProductos.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.equals(producto)) {
                int unidadesEliminadas = Math.min(p.getUnidades(), producto.getUnidades());
                if (p.getUnidades() <= producto.getUnidades()) {
                    it.remove();
                } else {
                    p.setUnidades(p.getUnidades() - unidadesEliminadas);
                }
                return unidadesEliminadas;
            }
        }
        return 0;
    }

    public LinkedList<Producto> mayoresPrecios(float precio) {
        LinkedList<Producto> nuevaLista = new LinkedList<>();
        for (Producto p : listaProductos) {
            if (p.getPrecio() > precio) {
                nuevaLista.add(p);
            }
        }
        return nuevaLista;
    }
}
