package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "img_vehiculos", schema = "saravias_rentacar")
public class ImgVehiculosEntity implements Serializable {
	@Id
	@Column(name = "img_vehiculo_id", nullable = false, length = 12)
	private String imgVehiculoId;
	@Basic
	@Column(name = "img_vehiculo", nullable = false, length = -1)
	private String imgVehiculo;
	@ManyToOne
	@JoinColumn(name = "vehiculo_id", referencedColumnName = "vehiculo_id", nullable = false)
	private VehiculosEntity vehiculosByVehiculoId;

	public String getImgVehiculoId() {
		return imgVehiculoId;
	}

	public void setImgVehiculoId(String imgVehiculoId) {
		this.imgVehiculoId = imgVehiculoId;
	}

	public String getImgVehiculo() {
		return imgVehiculo;
	}

	public void setImgVehiculo(String imgVehiculo) {
		this.imgVehiculo = imgVehiculo;
	}

	public VehiculosEntity getVehiculosByVehiculoId() {
		return vehiculosByVehiculoId;
	}

	public void setVehiculosByVehiculoId(VehiculosEntity vehiculosByVehiculoId) {
		this.vehiculosByVehiculoId = vehiculosByVehiculoId;
	}
}
