package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "empleados", schema = "saravias_rentacar")
public class EmpleadosEntity implements Serializable {
	@Id
	@Column(name = "empleado_id", nullable = false, length = 6)
	private String empleadoId;
	@Basic
	@Column(name = "foto_emp", nullable = false, length = -1)
	private String fotoEmp;
	@Basic
	@Column(name = "nombres_emp", nullable = false, length = 255)
	private String nombresEmp;
	@Basic
	@Column(name = "apellidos_emp", nullable = false, length = 255)
	private String apellidosEmp;
	@Basic
	@Column(name = "telefono_emp", nullable = false, length = 10)
	private String telefonoEmp;
	@Basic
	@Column(name = "dui_emp", nullable = false, length = 11)
	private String duiEmp;
	@Basic
	@Column(name = "direccion_emp", nullable = false, length = -1)
	private String direccionEmp;
	@Basic
	@Column(name = "fecha_creacion_emp", nullable = false)
	private Date fechaCreacionEmp;
	@Basic
	@Column(name = "estado_emp", nullable = false, length = 25)
	private String estadoEmp;
	@OneToMany(mappedBy = "empleadosByGestorId")
	private Collection<ArquileresEntity> arquileresByEmpleadoId;
	@ManyToOne
	@JoinColumn(name = "usuario_empleado", referencedColumnName = "usuario_id", nullable = false)
	private UsuariosEntity usuariosByUsuarioEmpleado;
	@ManyToOne
	@JoinColumn(name = "creador_id", referencedColumnName = "administrador_id", nullable = false)
	private AdministradoresEntity administradoresByCreadorId;
	@OneToMany(mappedBy = "empleadosByGestorId")
	private Collection<PropietariosEntity> propietariosByEmpleadoId;
	@OneToMany(mappedBy = "empleadosByGestorId")
	private Collection<VentasEntity> ventasByEmpleadoId;

	public String getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(String empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getFotoEmp() {
		return fotoEmp;
	}

	public void setFotoEmp(String fotoEmp) {
		this.fotoEmp = fotoEmp;
	}

	public String getNombresEmp() {
		return nombresEmp;
	}

	public void setNombresEmp(String nombresEmp) {
		this.nombresEmp = nombresEmp;
	}

	public String getApellidosEmp() {
		return apellidosEmp;
	}

	public void setApellidosEmp(String apellidosEmp) {
		this.apellidosEmp = apellidosEmp;
	}

	public String getTelefonoEmp() {
		return telefonoEmp;
	}

	public void setTelefonoEmp(String telefonoEmp) {
		this.telefonoEmp = telefonoEmp;
	}

	public String getDuiEmp() {
		return duiEmp;
	}

	public void setDuiEmp(String duiEmp) {
		this.duiEmp = duiEmp;
	}

	public String getDireccionEmp() {
		return direccionEmp;
	}

	public void setDireccionEmp(String direccionEmp) {
		this.direccionEmp = direccionEmp;
	}

	public Date getFechaCreacionEmp() {
		return fechaCreacionEmp;
	}

	public void setFechaCreacionEmp(Date fechaCreacionEmp) {
		this.fechaCreacionEmp = fechaCreacionEmp;
	}

	public String getEstadoEmp() {
		return estadoEmp;
	}

	public void setEstadoEmp(String estadoEmp) {
		this.estadoEmp = estadoEmp;
	}

	public Collection<ArquileresEntity> getArquileresByEmpleadoId() {
		return arquileresByEmpleadoId;
	}

	public void setArquileresByEmpleadoId(Collection<ArquileresEntity> arquileresByEmpleadoId) {
		this.arquileresByEmpleadoId = arquileresByEmpleadoId;
	}

	public UsuariosEntity getUsuariosByUsuarioEmpleado() {
		return usuariosByUsuarioEmpleado;
	}

	public void setUsuariosByUsuarioEmpleado(UsuariosEntity usuariosByUsuarioEmpleado) {
		this.usuariosByUsuarioEmpleado = usuariosByUsuarioEmpleado;
	}

	public AdministradoresEntity getAdministradoresByCreadorId() {
		return administradoresByCreadorId;
	}

	public void setAdministradoresByCreadorId(AdministradoresEntity administradoresByCreadorId) {
		this.administradoresByCreadorId = administradoresByCreadorId;
	}

	public Collection<PropietariosEntity> getPropietariosByEmpleadoId() {
		return propietariosByEmpleadoId;
	}

	public void setPropietariosByEmpleadoId(Collection<PropietariosEntity> propietariosByEmpleadoId) {
		this.propietariosByEmpleadoId = propietariosByEmpleadoId;
	}

	public Collection<VentasEntity> getVentasByEmpleadoId() {
		return ventasByEmpleadoId;
	}

	public void setVentasByEmpleadoId(Collection<VentasEntity> ventasByEmpleadoId) {
		this.ventasByEmpleadoId = ventasByEmpleadoId;
	}
}
