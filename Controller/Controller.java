package Controller;

import java.util.ArrayList;
import java.util.List;

import Entities.Usuario;
import Enuns.TipoUsuario;

public class Controller {

	private List<Usuario> usuarios;

	public Controller() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public void adicionarUsuario(String nome, TipoUsuario tipo, String senha) {
		Usuario usuario = new Usuario(nome, tipo, senha);
		this.usuarios.add(usuario);
	}

	public void removerUsuario(String nome, TipoUsuario tipo) {
		this.usuarios.removeIf(usuario -> usuario.getNome().equals(nome) && usuario.getTipo().equals(tipo));
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public List<Usuario> getUsuariosPorTipo(TipoUsuario tipo) {
		List<Usuario> usuariosPorTipo = new ArrayList<Usuario>();
		for (Usuario usuario : this.usuarios) {
			if (usuario.getTipo().equals(tipo)) {
				usuariosPorTipo.add(usuario);
			}
		}
		return usuariosPorTipo;
	}

	public boolean validarUsuario(String nome, TipoUsuario tipo, String senha) {
		for (Usuario usuario : this.getUsuariosPorTipo(tipo)) {
			if (usuario.getNome().equals(nome)) {
				return usuario.getSenha().equals(senha);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Controller controller = new Controller();

		// Adicionando um usuário
		controller.adicionarUsuario("João", TipoUsuario.ADMINISTRADOR, "123");

		// Removendo um usuário
		controller.removerUsuario("João", TipoUsuario.ADMINISTRADOR);

		// Validando um usuário
		boolean usuarioValido = controller.validarUsuario("João", TipoUsuario.ADMINISTRADOR, "123");
		if (usuarioValido) {
			System.out.println("Usuário válido");
		} else {
			System.out.println("Usuário inválido");
		}
	}

}
