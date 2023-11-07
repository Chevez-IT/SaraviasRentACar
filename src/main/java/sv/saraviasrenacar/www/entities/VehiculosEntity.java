package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "vehiculos", schema = "saravias_rentacar", catalog = "")
public class VehiculosEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "vehiculo_id", nullable = false, length = 10)
	private String vehiculoId;
	@Basic
	@Column(name = "marca_vehiculo", nullable = false, length = 50)
	private String marcaVehiculo;
	@Basic
	@Column(name = "modelo_vehiculo", nullable = false, length = 50)
	private String modeloVehiculo;
	@Basic
	@Column(name = "año_vehiculo", nullable = false)
	private Integer añoVehiculo;
	@Basic
	@Column(name = "tipo_vehiculo", nullable = false, length = 100)
	private String tipoVehiculo;
	@Basic
	@Column(name = "color_vehiculo", nullable = false, length = 20)
	private String colorVehiculo;
	@Basic
	@Column(name = "estado_vehiculo", nullable = false, length = 25)
	private String estadoVehiculo;
	@Basic
	@Column(name = "placa_vehiculo", nullable = false, length = 20)
	private String placaVehiculo;
	@Basic
	@Column(name = "motor_vehiculo", nullable = false, length = 50)
	private String motorVehiculo;
	@Basic
	@Column(name = "consumo_vehiculo", nullable = false, length = 50)
	private String consumoVehiculo;
	@Basic
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	@OneToMany(mappedBy = "vehiculosByVehiculoId")
	private Collection<ArquileresEntity> arquileresByVehiculoId;
	@OneToMany(mappedBy = "vehiculosByVehiculoId")
	private Collection<ImgVehiculosEntity> imgVehiculosByVehiculoId;
	@ManyToOne
	@JoinColumn(name = "propietario_vehiculo", referencedColumnName = "propietario_id", nullable = false)
	private PropietariosEntity propietariosByPropietarioVehiculo;
	@OneToMany(mappedBy = "vehiculosByVehiculoId")
	private Collection<VentasEntity> ventasByVehiculoId;

	public String getVehiculoId() {
		return vehiculoId;
	}

	public void setVehiculoId(String vehiculoId) {
		this.vehiculoId = vehiculoId;
	}

	public String getMarcaVehiculo() {
		return marcaVehiculo;
	}

	public void setMarcaVehiculo(String marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}

	public String getModeloVehiculo() {
		return modeloVehiculo;
	}

	public void setModeloVehiculo(String modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}

	public Integer getAñoVehiculo() {
		return añoVehiculo;
	}

	public void setAñoVehiculo(Integer añoVehiculo) {
		this.añoVehiculo = añoVehiculo;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getColorVehiculo() {
		return colorVehiculo;
	}

	public void setColorVehiculo(String colorVehiculo) {
		this.colorVehiculo = colorVehiculo;
	}

	public String getEstadoVehiculo() {
		return estadoVehiculo;
	}

	public void setEstadoVehiculo(String estadoVehiculo) {
		this.estadoVehiculo = estadoVehiculo;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public String getMotorVehiculo() {
		return motorVehiculo;
	}

	public void setMotorVehiculo(String motorVehiculo) {
		this.motorVehiculo = motorVehiculo;
	}

	public String getConsumoVehiculo() {
		return consumoVehiculo;
	}

	public void setConsumoVehiculo(String consumoVehiculo) {
		this.consumoVehiculo = consumoVehiculo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Collection<ArquileresEntity> getArquileresByVehiculoId() {
		return arquileresByVehiculoId;
	}

	public void setArquileresByVehiculoId(Collection<ArquileresEntity> arquileresByVehiculoId) {
		this.arquileresByVehiculoId = arquileresByVehiculoId;
	}

	public Collection<ImgVehiculosEntity> getImgVehiculosByVehiculoId() {
		return imgVehiculosByVehiculoId;
	}

	public void setImgVehiculosByVehiculoId(Collection<ImgVehiculosEntity> imgVehiculosByVehiculoId) {
		this.imgVehiculosByVehiculoId = imgVehiculosByVehiculoId;
	}

	public PropietariosEntity getPropietariosByPropietarioVehiculo() {
		return propietariosByPropietarioVehiculo;
	}

	public void setPropietariosByPropietarioVehiculo(PropietariosEntity propietariosByPropietarioVehiculo) {
		this.propietariosByPropietarioVehiculo = propietariosByPropietarioVehiculo;
	}

	public Collection<VentasEntity> getVentasByVehiculoId() {
		return ventasByVehiculoId;
	}

	public void setVentasByVehiculoId(Collection<VentasEntity> ventasByVehiculoId) {
		this.ventasByVehiculoId = ventasByVehiculoId;
	}
}
