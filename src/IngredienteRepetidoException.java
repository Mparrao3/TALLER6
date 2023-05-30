
public class IngredienteRepetidoException {
	import java.util.HashSet;
	import java.util.Set;

	abstract class HamburguesaException extends Exception {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public HamburguesaException(String message) {
	        super(message);
	    }
	}

	class IngredienteRepetidoException extends HamburguesaException {
	    private String ingrediente;

	    public IngredienteRepetidoException(String ingrediente) {
	        super("Ingrediente repetido: " + ingrediente);
	        this.ingrediente = ingrediente;
	    }

	    public String getIngrediente() {
	        return ingrediente;
	    }
	}
}
