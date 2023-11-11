package sv.saraviasrenacar.www.clientes.controllers;

import sv.saraviasrenacar.www.entities.ArquileresEntity;
import sv.saraviasrenacar.www.entities.ImgVehiculosEntity;
import sv.saraviasrenacar.www.entities.VehiculosEntity;

import java.util.List;

public class AlquilerDTO {
	private ArquileresEntity alquiler;
	private VehiculosEntity vehiculo;
	private List<ImgVehiculosEntity> imagenes;


	public AlquilerDTO(ArquileresEntity alquiler, VehiculosEntity vehiculo, List<ImgVehiculosEntity> imagenes) {
		this.alquiler = alquiler;
		this.vehiculo = vehiculo;
		this.imagenes = imagenes;
	}

	public ArquileresEntity getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(ArquileresEntity alquiler) {
		this.alquiler = alquiler;
	}

	public VehiculosEntity getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculosEntity vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<ImgVehiculosEntity> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<ImgVehiculosEntity> imagenes) {
		this.imagenes = imagenes;
	}
}
