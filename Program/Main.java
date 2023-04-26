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
			System.out.println("Digite o nome do usu�rio ou 'sair' para encerrar:");
			String nome = scanner.nextLine();

			if (nome.equals("sair")) {
				break;
			}

			System.out.println("Digite o tipo de usu�rio (1 - Administrador, 2 - Vendedor, 3 - Mec�nico):");
			int tipoInt = scanner.nextInt();
			TipoUsuario tipo = TipoUsuario.fromValor(tipoInt);

			System.out.println("Digite a senha do usu�rio:");
			String senha = scanner.next();

			controller.adicionarUsuario(nome, tipo, senha);
			System.out.println("Usu�rio adicionado com sucesso!");
			scanner.nextLine(); // Consumir a nova linha restante do buffer
		}

		scanner.close();

		// adicionando usu�rios
		controller.adicionarUsuario("Admin", TipoUsuario.ADMINISTRADOR, "123456");
		controller.adicionarUsuario("Vendedor 1", TipoUsuario.VENDEDOR, "abcdef");
		controller.adicionarUsuario("Mec�nico 1", TipoUsuario.MECANICO, "7891011");

		// verificando se os usu�rios foram adicionados
		System.out.println("Usu�rios adicionados:");
		for (Usuario usuario : controller.getUsuarios()) {
			System.out.println(
					"Nome: " + usuario.getNome() + " | Tipo: " + usuario.getTipo() + " | Senha: " + usuario.getSenha());
		}

		// validando usu�rios
		boolean usuarioValido = controller.validarUsuario("Admin", TipoUsuario.ADMINISTRADOR, "123456");
		System.out.println("Admin | Administrador | 123456 | V�lido? " + usuarioValido);

		usuarioValido = controller.validarUsuario("Vendedor 1", TipoUsuario.VENDEDOR, "abcdef");
		System.out.println("Vendedor 1 | Vendedor | abcdef | V�lido? " + usuarioValido);

		usuarioValido = controller.validarUsuario("Mec�nico 1", TipoUsuario.MECANICO, "123456");
		System.out.println("Mec�nico 1 | Mec�nico | 123456 | V�lido? " + usuarioValido);

		usuarioValido = controller.validarUsuario("Mec�nico 1", TipoUsuario.ADMINISTRADOR, "7891011");
		System.out.println("Mec�nico 1 | Administrador | 7891011 | V�lido? " + usuarioValido);

	}

}
