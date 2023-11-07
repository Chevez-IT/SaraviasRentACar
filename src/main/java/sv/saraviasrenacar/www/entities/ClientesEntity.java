package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "clientes", schema = "saravias_rentacar", catalog = "")
public class ClientesEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "cliente_id", nullable = false, length = 6)
	private String clienteId;
	@Basic
	@Column(name = "foto_cli", nullable = false, length = -1)
	private String fotoCli;
	@Basic
	@Column(name = "nombres_cli", nullable = false, length = 255)
	private String nombresCli;
	@Basic
	@Column(name = "apellidos_cli", nullable = false, length = 255)
	private String apellidosCli;
	@Basic
	@Column(name = "telefono_cli", nullable = false, length = 10)
	private String telefonoCli;
	@Basic
	@Column(name = "direccion_cli", nullable = false, length = -1)
	private String direccionCli;
	@Basic
	@Column(name = "dui_cli", nullable = false, length = 11)
	private String duiCli;
	@Basic
	@Column(name = "fecha_creacion_cli", nullable = false)
	private Date fechaCreacionCli;
	@Basic
	@Column(name = "estado_cli", nullable = false, length = 25)
	private String estadoCli;
	@OneToMany(mappedBy = "clientesByClienteActual")
	private Collection<ArquileresEntity> arquileresByClienteId;
	@ManyToOne
	@JoinColumn(name = "usuario_cliente", referencedColumnName = "usuario_id", nullable = false)
	private UsuariosEntity usuariosByUsuarioCliente;
	@OneToMany(mappedBy = "clientesByCompradorVenta")
	private Collection<VentasEntity> ventasByClienteId;

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getFotoCli() {
		return fotoCli;
	}

	public void setFotoCli(String fotoCli) {
		this.fotoCli = fotoCli;
	}

	public String getNombresCli() {
		return nombresCli;
	}

	public void setNombresCli(String nombresCli) {
		this.nombresCli = nombresCli;
	}

	public String getApellidosCli() {
		return apellidosCli;
	}

	public void setApellidosCli(String apellidosCli) {
		this.apellidosCli = apellidosCli;
	}

	public String getTelefonoCli() {
		return telefonoCli;
	}

	public void setTelefonoCli(String telefonoCli) {
		this.telefonoCli = telefonoCli;
	}

	public String getDireccionCli() {
		return direccionCli;
	}

	public void setDireccionCli(String direccionCli) {
		this.direccionCli = direccionCli;
	}

	public String getDuiCli() {
		return duiCli;
	}

	public void setDuiCli(String duiCli) {
		this.duiCli = duiCli;
	}

	public Date getFechaCreacionCli() {
		return fechaCreacionCli;
	}

	public void setFechaCreacionCli(Date fechaCreacionCli) {
		this.fechaCreacionCli = fechaCreacionCli;
	}

	public String getEstadoCli() {
		return estadoCli;
	}

	public void setEstadoCli(String estadoCli) {
		this.estadoCli = estadoCli;
	}

	public Collection<ArquileresEntity> getArquileresByClienteId() {
		return arquileresByClienteId;
	}

	public void setArquileresByClienteId(Collection<ArquileresEntity> arquileresByClienteId) {
		this.arquileresByClienteId = arquileresByClienteId;
	}

	public UsuariosEntity getUsuariosByUsuarioCliente() {
		return usuariosByUsuarioCliente;
	}

	public void setUsuariosByUsuarioCliente(UsuariosEntity usuariosByUsuarioCliente) {
		this.usuariosByUsuarioCliente = usuariosByUsuarioCliente;
	}

	public Collection<VentasEntity> getVentasByClienteId() {
		return ventasByClienteId;
	}

	public void setVentasByClienteId(Collection<VentasEntity> ventasByClienteId) {
		this.ventasByClienteId = ventasByClienteId;
	}
}
