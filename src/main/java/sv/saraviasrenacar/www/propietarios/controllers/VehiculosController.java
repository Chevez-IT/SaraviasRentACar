package sv.saraviasrenacar.www.propietarios.controllers;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class VehiculosController {
	private void guardarImagen(String nombreArchivo, MultipartFile imagen) {
		try {
			String rutaAlmacenamiento = "/ruta/del/directorio/" + nombreArchivo;
			Files.copy(imagen.getInputStream(), Paths.get(rutaAlmacenamiento), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace(); // Manejo adecuado de excepciones en producción
		}
	}
}
