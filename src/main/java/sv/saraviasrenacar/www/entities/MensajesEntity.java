package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mensajes", schema = "saravias_rentacar", catalog = "")
public class MensajesEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "mensaje_id", nullable = false, length = 12)
	private String mensajeId;
	@Basic
	@Column(name = "mensaje", nullable = false, length = -1)
	private String mensaje;
	@Basic
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	@Basic
	@Column(name = "estado", nullable = false)
	private String estado;
	@ManyToOne
	@JoinColumn(name = "emisor_mensaje", referencedColumnName = "cliente_id", nullable = false)
	private ClientesEntity clientesByEmisorMensaje;
	@ManyToOne
	@JoinColumn(name = "emisor_mensaje", referencedColumnName = "empleado_id", nullable = false)
	private EmpleadosEntity empleadosByEmisorMensaje;
	@ManyToOne
	@JoinColumn(name = "emisor_mensaje", referencedColumnName = "propietario_id", nullable = false)
	private PropietariosEntity propietariosByEmisorMensaje;
	@ManyToOne
	@JoinColumn(name = "conversacion_id", referencedColumnName = "conversaciones_id", nullable = false)
	private ConversacionesEntity conversacionesByConversacionId;

	public String getMensajeId() {
		return mensajeId;
	}

	public void setMensajeId(String mensajeId) {
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ClientesEntity getClientesByEmisorMensaje() {
		return clientesByEmisorMensaje;
	}

	public void setClientesByEmisorMensaje(ClientesEntity clientesByEmisorMensaje) {
		this.clientesByEmisorMensaje = clientesByEmisorMensaje;
	}

	public EmpleadosEntity getEmpleadosByEmisorMensaje() {
		return empleadosByEmisorMensaje;
	}

	public void setEmpleadosByEmisorMensaje(EmpleadosEntity empleadosByEmisorMensaje) {
		this.empleadosByEmisorMensaje = empleadosByEmisorMensaje;
	}

	public PropietariosEntity getPropietariosByEmisorMensaje() {
		return propietariosByEmisorMensaje;
	}

	public void setPropietariosByEmisorMensaje(PropietariosEntity propietariosByEmisorMensaje) {
		this.propietariosByEmisorMensaje = propietariosByEmisorMensaje;
	}

	public ConversacionesEntity getConversacionesByConversacionId() {
		return conversacionesByConversacionId;
	}

	public void setConversacionesByConversacionId(ConversacionesEntity conversacionesByConversacionId) {
		this.conversacionesByConversacionId = conversacionesByConversacionId;
	}
}
