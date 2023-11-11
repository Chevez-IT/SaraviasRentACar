package sv.saraviasrenacar.www.clientes.controllers;

import sv.saraviasrenacar.www.entities.VentasEntity;
import sv.saraviasrenacar.www.entities.ImgVehiculosEntity;
import sv.saraviasrenacar.www.entities.VehiculosEntity;

import java.util.List;

public class VentasDTO {
	private VentasEntity ventas;
	private VehiculosEntity vehiculo;
	private List<ImgVehiculosEntity> imagenes;


	public VentasEntity getVentas() {
		return ventas;
	}

	public void setVentas(VentasEntity ventas) {
		this.ventas = ventas;
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

	public VentasDTO(VentasEntity ventas, VehiculosEntity vehiculo, List<ImgVehiculosEntity> imagenes) {
		this.ventas = ventas;
		this.vehiculo = vehiculo;
		this.imagenes = imagenes;
	}

}
