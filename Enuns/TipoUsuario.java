package Enuns;
public enum TipoUsuario {
	ADMINISTRADOR(1), VENDEDOR(2), MECANICO(3);

	private int valor;

	private TipoUsuario(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public static TipoUsuario fromValor(int valor) {
		switch (valor) {
		case 1:
			return ADMINISTRADOR;
		case 2:
			return VENDEDOR;
		case 3:
			return MECANICO;
		default:
			throw new IllegalArgumentException("Valor inv�lido para o tipo de usu�rio: " + valor);
		}
	}
}
