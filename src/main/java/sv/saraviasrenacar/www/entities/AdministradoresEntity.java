package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "administradores", schema = "saravias_rentacar")
public class AdministradoresEntity implements Serializable {
	@Id
	@Column(name = "administrador_id", nullable = false, length = 6)
	private String administradorId;
	@Basic
	@Column(name = "foto_admin", nullable = false, length = -1)
	private String fotoAdmin;
	@Basic
	@Column(name = "nombres_admin", nullable = false, length = 255)
	private String nombresAdmin;
	@Basic
	@Column(name = "apellidos_admin", nullable = false, length = 255)
	private String apellidosAdmin;
	@Basic
	@Column(name = "telefono_admin", nullable = false, length = 10)
	private String telefonoAdmin;
	@Basic
	@Column(name = "fecha_creacion_admin", nullable = false)
	private Date fechaCreacionAdmin;
	@Basic
	@Column(name = "estado_admin", nullable = false, length = 25)
	private String estadoAdmin;
	@ManyToOne
	@JoinColumn(name = "usuario_admin", referencedColumnName = "usuario_id", nullable = false)
	private UsuariosEntity usuariosByUsuarioAdmin;
	@OneToMany(mappedBy = "administradoresByCreadorId")
	private Collection<EmpleadosEntity> empleadosByAdministradorId;

	public String getAdministradorId() {
		return administradorId;
	}

	public void setAdministradorId(String administradorId) {
		this.administradorId = administradorId;
	}

	public String getFotoAdmin() {
		return fotoAdmin;
	}

	public void setFotoAdmin(String fotoAdmin) {
		this.fotoAdmin = fotoAdmin;
	}

	public String getNombresAdmin() {
		return nombresAdmin;
	}

	public void setNombresAdmin(String nombresAdmin) {
		this.nombresAdmin = nombresAdmin;
	}

	public String getApellidosAdmin() {
		return apellidosAdmin;
	}

	public void setApellidosAdmin(String apellidosAdmin) {
		this.apellidosAdmin = apellidosAdmin;
	}

	public String getTelefonoAdmin() {
		return telefonoAdmin;
	}

	public void setTelefonoAdmin(String telefonoAdmin) {
		this.telefonoAdmin = telefonoAdmin;
	}

	public Date getFechaCreacionAdmin() {
		return fechaCreacionAdmin;
	}

	public void setFechaCreacionAdmin(Date fechaCreacionAdmin) {
		this.fechaCreacionAdmin = fechaCreacionAdmin;
	}

	public String getEstadoAdmin() {
		return estadoAdmin;
	}

	public void setEstadoAdmin(String estadoAdmin) {
		this.estadoAdmin = estadoAdmin;
	}

	public UsuariosEntity getUsuariosByUsuarioAdmin() {
		return usuariosByUsuarioAdmin;
	}

	public void setUsuariosByUsuarioAdmin(UsuariosEntity usuariosByUsuarioAdmin) {
		this.usuariosByUsuarioAdmin = usuariosByUsuarioAdmin;
	}

	public Collection<EmpleadosEntity> getEmpleadosByAdministradorId() {
		return empleadosByAdministradorId;
	}

	public void setEmpleadosByAdministradorId(Collection<EmpleadosEntity> empleadosByAdministradorId) {
		this.empleadosByAdministradorId = empleadosByAdministradorId;
	}
}
