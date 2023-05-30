import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RestauranteTest {

    private Restaurante restaurante;

    @BeforeEach
    void setUp() {
        restaurante = new Restaurante();
    }

    @Test
    void testCargarIngredientes() {
        String[] ingredientes = {"Lechuga", "Tomate", "Queso", "Cebolla"};
        try {
            restaurante.cargarIngredientes(ingredientes);
        } catch (HamburguesaException e) {
            Assertions.fail("No se esperaba una excepción al cargar ingredientes");
        }


        String[] ingredientesDuplicados = {"Tomate", "Queso"};
        try {
            restaurante.cargarIngredientes(ingredientesDuplicados);
            Assertions.fail("Se esperaba una excepción IngredienteRepetidoException");
        } catch (IngredienteRepetidoException e) {
            Assertions.assertEquals("Tomate", e.getIngrediente());
        } catch (HamburguesaException e) {
            Assertions.fail("Se esperaba una excepción IngredienteRepetidoException");
        }
    }

    @Test
    void testCargarMenu() {
        String[] menu = {"Hamburguesa simple", "Hamburguesa con queso", "Papas fritas"};
        try {
            restaurante.cargarMenu(menu);
        } catch (HamburguesaException e) {
            Assertions.fail("No se esperaba una excepción al cargar el menú");
        }


        String[] menuDuplicados = {"Hamburguesa con queso", "Papas fritas"};
        try {
            restaurante.cargarMenu(menuDuplicados);
            Assertions.fail("Se esperaba una excepción ProductoRepetidoException");
        } catch (ProductoRepetidoException e) {
            Assertions.assertEquals("Hamburguesa con queso", e.getProducto());
        } catch (HamburguesaException e) {
            Assertions.fail("Se esperaba una excepción ProductoRepetidoException");
        }
    }
}

class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
    }

    @Test
    void testAgregarProducto() {
        Producto producto1 = new Producto("Hamburguesa", 10000);
        Producto producto2 = new Producto("Papas fritas", 5000);

        try {
            pedido.agregarProducto(producto1);
            pedido.agregarProducto(producto2);
        } catch (ValorTotalExcedidoException e) {
            Assertions.fail("No se esperaba una excepción al agregar productos");
        }

    
        Producto producto3 = new Producto("Bebida", 100000);
        try {
            pedido.agregarProducto(producto3);
            Assertions.fail("Se esperaba una excepción ValorTotalExcedidoException");
        } catch (ValorTotalExcedidoException e) {

        }
    }
}
