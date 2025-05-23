import java.util.LinkedList;

public class PruebasLista {
    public static void main(String[] args) {
        //PRUEBAS PARA FACTURA
        Factura factura = new Factura("12345678B", "17/03/2021");

        Producto p1 = new Producto("Mesa escritorio", 185, 2);
        Producto p2 = new Producto("Silla oficina", 95.9f, 3);
        Producto p3 = new Producto("Mesa cocina", 125, 1);
        Producto p4 = new Producto("Sillón reclinable", 230, 2);

        factura.anyadirProducto(p1);
        factura.anyadirProducto(p2);
        factura.anyadirProducto(p3);
        factura.anyadirProducto(p4);

        factura.mostrar();

        Producto p5 = new Producto("Silla oficina", 95.9f, 1);
        factura.anyadirProducto(p5);

        factura.mostrar();

        Producto p6 = new Producto("Silla oficina", 95.9f, 2);
        Producto p7 = new Producto("Sillón reclinable", 230, 3);

        System.out.println("Se han eliminado " + factura.eliminarProducto(p6) + " unidades");
        factura.mostrar();

        //PRUEBAS PARA FACTURABIB
        FacturaBib facturaBib = new FacturaBib("88888888A", "08/08/2008");

        Producto a1 = new Producto("Armario", 385, 5);
        Producto c1 = new Producto("Cama", 255, 3);
        Producto c2 = new Producto("Cama", 255, 2);
        Producto a2 = new Producto("Armario", 385, 1);

        facturaBib.anyadirProducto(a1);
        facturaBib.anyadirProducto(c1);
        facturaBib.anyadirProducto(c2);
        facturaBib.eliminarProducto(a2);

        facturaBib.mostrar();

        LinkedList<Producto> caros = facturaBib.mayoresPrecios(250);
        System.out.println("Se han obtenido " + caros.size() + " productos con precio mayor a 250 € por unidad");

        for (Producto p : caros) {
            p.mostrar();
        }
    }
}
