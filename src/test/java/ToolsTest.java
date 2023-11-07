import sv.saraviasrenacar.www.tools.*;


public class ToolsTest {
	public static void main(String[] args) {
		username();
	}

	public static void contraseña(){
		Tools tools = new Tools();
		//Generar la contraseña
		String contraseña = String.valueOf(tools.GenerarContraseña());
		System.out.println("Esta es la contraseña generada: "+contraseña);

		//Encryptamos la contraseña
		String contraseñaEncryp = String.valueOf(tools.encriptarContraseña("pa$$w0rd"));
		System.out.println("Esta es la contraseña encriptada es: "+ contraseñaEncryp);

		Boolean comprobacion = Boolean.valueOf(String.valueOf(tools.ComprobarContraseña("pa$$w0rd", contraseñaEncryp)));
		if(comprobacion != false){
			System.out.println("Las contraseñas son iguales");
		}else{
			System.out.println("Las contrasñas no son iguales");
		}
	}

	public static void username(){
		Tools tools = new Tools();
		String user = tools.GenerarUsername("Diego Ernesto", "Chevez Montes");
		String idIniciales = tools.GenerarIdIniciales("Diego Ernessto", "Chevez Montes");
		String idNRamdom = tools.GenerarIdNRandom();

		String username = user + idNRamdom;
		String idUser = idIniciales + idNRamdom;

		System.out.println("El nombre de usuario contruido es: " + username);
		System.out.println("El id del usuario contruido es: " + idUser);
	}

}
