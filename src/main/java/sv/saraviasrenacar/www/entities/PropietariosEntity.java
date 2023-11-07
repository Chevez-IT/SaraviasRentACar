package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "propietarios", schema = "saravias_rentacar", catalog = "")
public class PropietariosEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "propietario_id", nullable = false, length = 6)
	private String propietarioId;
	@Basic
	@Column(name = "foto_prop", nullable = false, length = -1)
	private String fotoProp;
	@Basic
	@Column(name = "nombres_prop", nullable = false, length = 255)
	private String nombresProp;
	@Basic
	@Column(name = "apellidos_prop", nullable = false, length = 255)
	private String apellidosProp;
	@Basic
	@Column(name = "telefono_prop", nullable = false, length = 10)
	private String telefonoProp;
	@Basic
	@Column(name = "dui_prop", nullable = false, length = 11)
	private String duiProp;
	@Basic
	@Column(name = "direccion_prop", nullable = false, length = -1)
	private String direccionProp;
	@Basic
	@Column(name = "fecha_creacion_prop", nullable = false)
	private Date fechaCreacionProp;
	@Basic
	@Column(name = "estado_prop", nullable = false, length = 25)
	private String estadoProp;
	@ManyToOne
	@JoinColumn(name = "usuario_propietario", referencedColumnName = "usuario_id", nullable = false)
	private UsuariosEntity usuariosByUsuarioPropietario;
	@ManyToOne
	@JoinColumn(name = "gestor_id", referencedColumnName = "empleado_id", nullable = false)
	private EmpleadosEntity empleadosByGestorId;
	@OneToMany(mappedBy = "propietariosByPropietarioVehiculo")
	private Collection<VehiculosEntity> vehiculosByPropietarioId;

	public String getPropietarioId() {
		return propietarioId;
	}

	public void setPropietarioId(String propietarioId) {
		this.propietarioId = propietarioId;
	}

	public String getFotoProp() {
		return fotoProp;
	}

	public void setFotoProp(String fotoProp) {
		this.fotoProp = fotoProp;
	}

	public String getNombresProp() {
		return nombresProp;
	}

	public void setNombresProp(String nombresProp) {
		this.nombresProp = nombresProp;
	}

	public String getApellidosProp() {
		return apellidosProp;
	}

	public void setApellidosProp(String apellidosProp) {
		this.apellidosProp = apellidosProp;
	}

	public String getTelefonoProp() {
		return telefonoProp;
	}

	public void setTelefonoProp(String telefonoProp) {
		this.telefonoProp = telefonoProp;
	}

	public String getDuiProp() {
		return duiProp;
	}

	public void setDuiProp(String duiProp) {
		this.duiProp = duiProp;
	}

	public String getDireccionProp() {
		return direccionProp;
	}

	public void setDireccionProp(String direccionProp) {
		this.direccionProp = direccionProp;
	}

	public Date getFechaCreacionProp() {
		return fechaCreacionProp;
	}

	public void setFechaCreacionProp(Date fechaCreacionProp) {
		this.fechaCreacionProp = fechaCreacionProp;
	}

	public String getEstadoProp() {
		return estadoProp;
	}

	public void setEstadoProp(String estadoProp) {
		this.estadoProp = estadoProp;
	}

	public UsuariosEntity getUsuariosByUsuarioPropietario() {
		return usuariosByUsuarioPropietario;
	}

	public void setUsuariosByUsuarioPropietario(UsuariosEntity usuariosByUsuarioPropietario) {
		this.usuariosByUsuarioPropietario = usuariosByUsuarioPropietario;
	}

	public EmpleadosEntity getEmpleadosByGestorId() {
		return empleadosByGestorId;
	}

	public void setEmpleadosByGestorId(EmpleadosEntity empleadosByGestorId) {
		this.empleadosByGestorId = empleadosByGestorId;
	}

	public Collection<VehiculosEntity> getVehiculosByPropietarioId() {
		return vehiculosByPropietarioId;
	}

	public void setVehiculosByPropietarioId(Collection<VehiculosEntity> vehiculosByPropietarioId) {
		this.vehiculosByPropietarioId = vehiculosByPropietarioId;
	}
}
