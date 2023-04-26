package Program;

import Enuns.TipoUsuario;
import Controller.Controller;
import Entities.Usuario;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Controller controller = new Controller();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Digite o nome do usuário ou 'sair' para encerrar:");
			String nome = scanner.nextLine();

			if (nome.equals("sair")) {
				break;
			}

			System.out.println("Digite o tipo de usuário (1 - Administrador, 2 - Vendedor, 3 - Mecânico):");
			int tipoInt = scanner.nextInt();
			TipoUsuario tipo = TipoUsuario.fromValor(tipoInt);

			System.out.println("Digite a senha do usuário:");
			String senha = scanner.next();

			controller.adicionarUsuario(nome, tipo, senha);
			System.out.println("Usuário adicionado com sucesso!");
			scanner.nextLine(); // Consumir a nova linha restante do buffer
		}

		scanner.close();

		// adicionando usuários
		controller.adicionarUsuario("Admin", TipoUsuario.ADMINISTRADOR, "123456");
		controller.adicionarUsuario("Vendedor 1", TipoUsuario.VENDEDOR, "abcdef");
		controller.adicionarUsuario("Mecânico 1", TipoUsuario.MECANICO, "7891011");

		// verificando se os usuários foram adicionados
		System.out.println("Usuários adicionados:");
		for (Usuario usuario : controller.getUsuarios()) {
			System.out.println(
					"Nome: " + usuario.getNome() + " | Tipo: " + usuario.getTipo() + " | Senha: " + usuario.getSenha());
		}

		// validando usuários
		boolean usuarioValido = controller.validarUsuario("Admin", TipoUsuario.ADMINISTRADOR, "123456");
		System.out.println("Admin | Administrador | 123456 | Válido? " + usuarioValido);

		usuarioValido = controller.validarUsuario("Vendedor 1", TipoUsuario.VENDEDOR, "abcdef");
		System.out.println("Vendedor 1 | Vendedor | abcdef | Válido? " + usuarioValido);

		usuarioValido = controller.validarUsuario("Mecânico 1", TipoUsuario.MECANICO, "123456");
		System.out.println("Mecânico 1 | Mecânico | 123456 | Válido? " + usuarioValido);

		usuarioValido = controller.validarUsuario("Mecânico 1", TipoUsuario.ADMINISTRADOR, "7891011");
		System.out.println("Mecânico 1 | Administrador | 7891011 | Válido? " + usuarioValido);

	}

}
