package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mensajes", schema = "saravias_rentacar")
public class MensajesEntity implements Serializable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "mensaje_id", nullable = false, length = 12)
	private int mensajeId;
	@Basic
	@Column(name = "mensaje", nullable = false, length = -1)
	private String mensaje;
	@Basic
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	@Basic
	@Column(name = "estado_mensaje", nullable = false, length = 25)
	private String estadoMensaje;
	@ManyToOne
	@JoinColumn(name = "emisor_mensaje", referencedColumnName = "usuario_id", nullable = false)
	private UsuariosEntity usuariosByEmisorMensaje;
	@ManyToOne
	@JoinColumn(name = "receptor_mensaje", referencedColumnName = "usuario_id", nullable = false)
	private UsuariosEntity usuariosByReceptorMensaje;

	public int getMensajeId() {
		return mensajeId;
	}

	public void setMensajeId(int mensajeId) {
		this.mensajeId = mensajeId;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstadoMensaje() {
		return estadoMensaje;
	}

	public void setEstadoMensaje(String estadoMensaje) {
		this.estadoMensaje = estadoMensaje;
	}

	public UsuariosEntity getUsuariosByEmisorMensaje() {
		return usuariosByEmisorMensaje;
	}

	public void setUsuariosByEmisorMensaje(UsuariosEntity usuariosByEmisorMensaje) {
		this.usuariosByEmisorMensaje = usuariosByEmisorMensaje;
	}

	public UsuariosEntity getUsuariosByReceptorMensaje() {
		return usuariosByReceptorMensaje;
	}

	public void setUsuariosByReceptorMensaje(UsuariosEntity usuariosByReceptorMensaje) {
		this.usuariosByReceptorMensaje = usuariosByReceptorMensaje;
	}
}
