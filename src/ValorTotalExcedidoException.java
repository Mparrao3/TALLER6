class ValorTotalExcedidoException extends Exception {
    public ValorTotalExcedidoException() {
        super("El valor total del pedido excede el límite permitido");
    }
}

class Pedido {
    private List<Producto> productos;
    private double valorTotal;

    public Pedido() {
        productos = new ArrayList<>();
        valorTotal = 0;
    }

    public void agregarProducto(Producto producto) throws ValorTotalExcedidoException {
        double nuevoValorTotal = valorTotal + producto.getPrecio();
        if (nuevoValorTotal > 150000) {
            throw new ValorTotalExcedidoException();
        }
        productos.add(producto);
        valorTotal = nuevoValorTotal;
    }

}
