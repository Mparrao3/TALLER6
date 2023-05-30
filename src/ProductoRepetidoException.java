import java.util.HashSet;
import java.util.Set;

abstract class HamburguesaException extends Exception {
    public HamburguesaException(String message) {
        super(message);
    }
}

public class ProductoRepetidoException {
	class ProductoRepetidoException extends HamburguesaException {
	    private String producto;

	    public ProductoRepetidoException(String producto) {
	        super("Producto repetido: " + producto);
	        this.producto = producto;
	    }

	    public String getProducto() {
	        return producto;
	    }
	}
}
