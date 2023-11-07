package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "conversaciones", schema = "saravias_rentacar", catalog = "")
public class ConversacionesEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "conversaciones_id", nullable = false, length = 10)
	private String conversacionesId;
	@Basic
	@Column(name = "fecha_creacion_conv", nullable = false)
	private Date fechaCreacionConv;
	@Basic
	@Column(name = "estado_conv", nullable = false)
	private String estadoConv;
	@ManyToOne
	@JoinColumn(name = "publicacion_conv", referencedColumnName = "arquiler_id", nullable = false)
	private ArquileresEntity arquileresByPublicacionConv;
	@ManyToOne
	@JoinColumn(name = "publicacion_conv", referencedColumnName = "venta_id", nullable = false)
	private VentasEntity ventasByPublicacionConv;
	@ManyToOne
	@JoinColumn(name = "empleado_conv", referencedColumnName = "empleado_id", nullable = false)
	private EmpleadosEntity empleadosByEmpleadoConv;
	@ManyToOne
	@JoinColumn(name = "usuario_conv", referencedColumnName = "cliente_id", nullable = false)
	private ClientesEntity clientesByUsuarioConv;
	@ManyToOne
	@JoinColumn(name = "usuario_conv", referencedColumnName = "propietario_id", nullable = false)
	private PropietariosEntity propietariosByUsuarioConv;
	@OneToMany(mappedBy = "conversacionesByConversacionId")
	private Collection<MensajesEntity> mensajesByConversacionesId;

	public String getConversacionesId() {
		return conversacionesId;
	}

	public void setConversacionesId(String conversacionesId) {
		this.conversacionesId = conversacionesId;
	}

	public Date getFechaCreacionConv() {
		return fechaCreacionConv;
	}

	public void setFechaCreacionConv(Date fechaCreacionConv) {
		this.fechaCreacionConv = fechaCreacionConv;
	}

	public String getEstadoConv() {
		return estadoConv;
	}

	public void setEstadoConv(String estadoConv) {
		this.estadoConv = estadoConv;
	}

	public ArquileresEntity getArquileresByPublicacionConv() {
		return arquileresByPublicacionConv;
	}

	public void setArquileresByPublicacionConv(ArquileresEntity arquileresByPublicacionConv) {
		this.arquileresByPublicacionConv = arquileresByPublicacionConv;
	}

	public VentasEntity getVentasByPublicacionConv() {
		return ventasByPublicacionConv;
	}

	public void setVentasByPublicacionConv(VentasEntity ventasByPublicacionConv) {
		this.ventasByPublicacionConv = ventasByPublicacionConv;
	}

	public EmpleadosEntity getEmpleadosByEmpleadoConv() {
		return empleadosByEmpleadoConv;
	}

	public void setEmpleadosByEmpleadoConv(EmpleadosEntity empleadosByEmpleadoConv) {
		this.empleadosByEmpleadoConv = empleadosByEmpleadoConv;
	}

	public ClientesEntity getClientesByUsuarioConv() {
		return clientesByUsuarioConv;
	}

	public void setClientesByUsuarioConv(ClientesEntity clientesByUsuarioConv) {
		this.clientesByUsuarioConv = clientesByUsuarioConv;
	}

	public PropietariosEntity getPropietariosByUsuarioConv() {
		return propietariosByUsuarioConv;
	}

	public void setPropietariosByUsuarioConv(PropietariosEntity propietariosByUsuarioConv) {
		this.propietariosByUsuarioConv = propietariosByUsuarioConv;
	}

	public Collection<MensajesEntity> getMensajesByConversacionesId() {
		return mensajesByConversacionesId;
	}

	public void setMensajesByConversacionesId(Collection<MensajesEntity> mensajesByConversacionesId) {
		this.mensajesByConversacionesId = mensajesByConversacionesId;
	}
}
