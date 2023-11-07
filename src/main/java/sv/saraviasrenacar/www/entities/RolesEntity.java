package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles", schema = "saravias_rentacar", catalog = "")
public class RolesEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "rol_id", nullable = false, length = 5)
	private String rolId;
	@Basic
	@Column(name = "rol", nullable = false, length = 20)
	private String rol;
	@OneToMany(mappedBy = "rolesByRolId")
	private Collection<UsuariosEntity> usuariosByRolId;

	public String getRolId() {
		return rolId;
	}

	public void setRolId(String rolId) {
		this.rolId = rolId;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Collection<UsuariosEntity> getUsuariosByRolId() {
		return usuariosByRolId;
	}

	public void setUsuariosByRolId(Collection<UsuariosEntity> usuariosByRolId) {
		this.usuariosByRolId = usuariosByRolId;
	}
}
