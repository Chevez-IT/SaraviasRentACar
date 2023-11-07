package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "usuarios", schema = "saravias_rentacar", catalog = "")
public class UsuariosEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "usuario_id", nullable = false, length = 5)
	private String usuarioId;
	@Basic
	@Column(name = "username", nullable = false, length = 100)
	private String username;
	@Basic
	@Column(name = "correo_user", nullable = false, length = 255)
	private String correoUser;
	@Basic
	@Column(name = "contrasena_user", nullable = false, length = 255)
	private String contrasenaUser;
	@Basic
	@Column(name = "estado_user", nullable = false)
	private String estadoUser;
	@OneToMany(mappedBy = "usuariosByUsuarioAdmin")
	private Collection<AdministradoresEntity> administradoresByUsuarioId;
	@OneToMany(mappedBy = "usuariosByUsuarioCliente")
	private Collection<ClientesEntity> clientesByUsuarioId;
	@OneToMany(mappedBy = "usuariosByUsuarioEmpleado")
	private Collection<EmpleadosEntity> empleadosByUsuarioId;
	@OneToMany(mappedBy = "usuariosByUsuarioPropietario")
	private Collection<PropietariosEntity> propietariosByUsuarioId;
	@ManyToOne
	@JoinColumn(name = "rol_id", referencedColumnName = "rol_id", nullable = false)
	private RolesEntity rolesByRolId;

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCorreoUser() {
		return correoUser;
	}

	public void setCorreoUser(String correoUser) {
		this.correoUser = correoUser;
	}

	public String getContrasenaUser() {
		return contrasenaUser;
	}

	public void setContrasenaUser(String contrasenaUser) {
		this.contrasenaUser = contrasenaUser;
	}

	public String getEstadoUser() {
		return estadoUser;
	}

	public void setEstadoUser(String estadoUser) {
		this.estadoUser = estadoUser;
	}

	public Collection<AdministradoresEntity> getAdministradoresByUsuarioId() {
		return administradoresByUsuarioId;
	}

	public void setAdministradoresByUsuarioId(Collection<AdministradoresEntity> administradoresByUsuarioId) {
		this.administradoresByUsuarioId = administradoresByUsuarioId;
	}

	public Collection<ClientesEntity> getClientesByUsuarioId() {
		return clientesByUsuarioId;
	}

	public void setClientesByUsuarioId(Collection<ClientesEntity> clientesByUsuarioId) {
		this.clientesByUsuarioId = clientesByUsuarioId;
	}

	public Collection<EmpleadosEntity> getEmpleadosByUsuarioId() {
		return empleadosByUsuarioId;
	}

	public void setEmpleadosByUsuarioId(Collection<EmpleadosEntity> empleadosByUsuarioId) {
		this.empleadosByUsuarioId = empleadosByUsuarioId;
	}

	public Collection<PropietariosEntity> getPropietariosByUsuarioId() {
		return propietariosByUsuarioId;
	}

	public void setPropietariosByUsuarioId(Collection<PropietariosEntity> propietariosByUsuarioId) {
		this.propietariosByUsuarioId = propietariosByUsuarioId;
	}

	public RolesEntity getRolesByRolId() {
		return rolesByRolId;
	}

	public void setRolesByRolId(RolesEntity rolesByRolId) {
		this.rolesByRolId = rolesByRolId;
	}
}
