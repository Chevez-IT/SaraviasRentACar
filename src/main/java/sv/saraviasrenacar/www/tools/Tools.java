package sv.saraviasrenacar.www.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Pattern;

public class Tools {

	public StringBuilder GenerarContraseña() {
		String regex = "^[a-zA-Z0-9!@#$%^&*]*$"; // Se definen los caracteres permitidos
		SecureRandom random = new SecureRandom();
		StringBuilder contraseña = new StringBuilder();

		int longitud = 8 + random.nextInt(8); // Generaremos la longitud de la contraseña de manera aleatoria

		Pattern pattern = Pattern.compile(regex);

		while (contraseña.length() < longitud) {
			char caracter = (char) (33 + random.nextInt(94)); // Genera un caracter aleatorio del rango permitido
			if (pattern.matcher(String.valueOf(caracter)).matches()) {
				contraseña.append(caracter);
			}
		}
		return contraseña;
	}


	public String encriptarContraseña(String contraseña) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String contraseñaEncryp = encoder.encode(contraseña);
		return contraseñaEncryp;
	}


	public boolean ComprobarContraseña(String contraseña, String contraseñaEncryp) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y);
		return encoder.matches(contraseña, contraseñaEncryp);
	}


	public String GenerarUsername(String nombres, String apellidos) {
		String[] nombresSeparados = nombres.split(" ");
		String[] apellidosSeparados = apellidos.split(" ");
		String primerNombre = "";
		String primerApellido = "";
		if (nombresSeparados.length > 0) {
			primerNombre = nombresSeparados[0];
		}
		if (apellidosSeparados.length > 0) {
			primerApellido = apellidosSeparados[0];
		}
		String usuario = primerNombre + primerApellido;
		return usuario;
	}


	public String GenerarIdIniciales(String nombres, String apellidos) {
		String primeraLetraNombres = obtenerPrimeraLetra(nombres);
		String primeraLetraApellidos = obtenerPrimeraLetra(apellidos);

		return primeraLetraNombres + primeraLetraApellidos;
	}

	private String obtenerPrimeraLetra(String cadena) {
		if (cadena != null && !cadena.isEmpty()) {
			return cadena.substring(0, 1);
		} else {
			return "";
		}
	}


	public String GenerarIdNRandom() {
		Random random = new Random();
		int numeroAleatorio = random.nextInt(1000);
		String NRamdom = String.format("%03d", numeroAleatorio);
		return NRamdom;
	}



}