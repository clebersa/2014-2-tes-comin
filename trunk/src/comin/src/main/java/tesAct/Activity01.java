package tesAct;

import tesAct.controller.ModelController;
import tesAct.controller.ProfileController;
import tesAct.model.Address;
import tesAct.model.Email;
import tesAct.model.Name;
import tesAct.model.Organization;
import tesAct.model.Profile;

public class Activity01 {

	public static void main(String[] args) {
		ModelController modelController = new ModelController();

		Profile cleber = new Profile();
		cleber.setName(new Name("Cleber", "de Souza", "Alcântara"));
		cleber.setNickname("Clebin");
		cleber.setBirthDate("03/07/1993");
		cleber.setEmail(new Email("gmail", "cleber.93cd@gmail.com"));
		cleber.setAddress(new Address("Rua R 22", "Goiânia", "GO", "Brasil",
				"74690-470"));
		cleber.setOrganization(new Organization("UFG",
				"Assistente de Desenvolvimento"));
		cleber.setGender("Masculino");
		ProfileController cleberProfileController = new ProfileController(
				cleber);
		modelController.addProfile(cleberProfileController);

		Profile larissa = new Profile();
		larissa.setName(new Name("Larissa Angélica", "Siqueira", "Nunes"));
		larissa.setNickname("Sem Apelido");
		larissa.setBirthDate("09/12/1990");
		larissa.setEmail(new Email("gmail", "larissamean@gmail.com"));
		larissa.setAddress(new Address("R 22", "Goiânia", "GO", "Brasil",
				"74690-470"));
		larissa.setOrganization(new Organization("UFG", "Estudante"));
		larissa.setGender("Feminino");
		ProfileController larissaProfileController = new ProfileController(
				larissa);
		modelController.addProfile(larissaProfileController);

		Profile leticia = new Profile();
		leticia.setName(new Name("Letícia", "Nunes", "Borges"));
		leticia.setNickname("Big");
		leticia.setBirthDate("11/03/1992");
		leticia.setEmail(new Email("gmail", "leticianb1@gmail.com"));
		leticia.setAddress(new Address("Rua R 22", "Goiânia", "GO", "Brasil",
				"74690-470"));
		leticia.setOrganization(new Organization("Multidata",
				"Estagiária de Desenvolvimento Java"));
		leticia.setGender("Feminino");
		ProfileController leticiaProfileController = new ProfileController(
				leticia);
		modelController.addProfile(leticiaProfileController);

		Profile samuel = new Profile();
		samuel.setName(new Name("Samuel Junio", "de Almeida", "Pires"));
		samuel.setNickname("Samuca");
		samuel.setBirthDate("13/04/1993");
		samuel.setEmail(new Email("gmail", "almeida.samuel.junio@gmail.com"));
		samuel.setAddress(new Address("Av. Contorno, 109", "Goiânia", "Goiás",
				"Brasil", "74690-020"));
		samuel.setOrganization(new Organization("UFG", "Estudante"));
		samuel.setGender("Masculino");
		ProfileController samuelProfileController = new ProfileController(
				samuel);
		modelController.addProfile(samuelProfileController);

		modelController.printRDF();
		modelController.printTurle();
	}
}
