import java.util.Objects;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
    }

    public Producto(String nombre, double precio) {
        this(nombre, precio, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = stock;
    }

    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
        } else {
            throw new IllegalArgumentException("La cantidad a aumentar debe ser mayor que cero.");
        }
    }

    public void reducirStock(int cantidad) {
        if (cantidad > 0 && cantidad <= this.stock) {
            this.stock -= cantidad;
        } else {
            throw new IllegalArgumentException("La cantidad a reducir debe ser mayor que cero y menor o igual al stock actual.");
        }
    }

    public static void main(String[] args) {
        Producto producto1 = new Producto("Libreta", 5.99, 100);

        System.out.println("Producto: " + producto1.getNombre());
        System.out.println("Precio: $" + producto1.getPrecio());
        System.out.println("Stock: " + producto1.getStock());

        producto1.aumentarStock(50);
        System.out.println("Nuevo stock: " + producto1.getStock());

        producto1.reducirStock(30);
        System.out.println("Stock después de reducción: " + producto1.getStock());
    }
}
