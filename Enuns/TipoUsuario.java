package Enuns;
public enum TipoUsuario {
	
	ADMINISTRADOR(1, "Administrador"), 
	VENDEDOR(2, "Vendedor"), 
	MECANICO(3, "Mecânico");

	private int valor;
	private String descricao;

	private TipoUsuario(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
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
			throw new IllegalArgumentException("Valor inválido para o tipo de usuário: " + valor);
		}
	}
}
