
class Restaurante {
    private Set<String> ingredientes;
    private Set<String> menu;

    public Restaurante() {
        ingredientes = new HashSet<>();
        menu = new HashSet<>();
    }

    public void cargarIngredientes(String[] nuevosIngredientes) throws HamburguesaException {
        for (String ingrediente : nuevosIngredientes) {
            if (ingredientes.contains(ingrediente)) {
                throw new IngredienteRepetidoException(ingrediente);
            }
            ingredientes.add(ingrediente);
        }
    }

    public void cargarMenu(String[] nuevosProductos) throws HamburguesaException {
        for (String producto : nuevosProductos) {
            if (menu.contains(producto)) {
                throw new ProductoRepetidoException(producto);
            }
            menu.add(producto);
        }
    }
