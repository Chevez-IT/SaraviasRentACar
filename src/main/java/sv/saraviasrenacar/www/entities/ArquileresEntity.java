package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "arquileres", schema = "saravias_rentacar")
public class ArquileresEntity implements Serializable {
	@Id
	@Column(name = "arquiler_id", nullable = false, length = 10)
	private String arquilerId;
	@Basic
	@Column(name = "titulo_arquiler", nullable = false, length = 100)
	private String tituloArquiler;
	@Basic
	@Column(name = "descripcion_arquiler", nullable = false, length = -1)
	private String descripcionArquiler;
	@Basic
	@Column(name = "precio_arquiler", nullable = false, precision = 2)
	private BigDecimal precioArquiler;
	@Basic
	@Column(name = "fecha_inicio", nullable = true)
	private Date fechaInicio;
	@Basic
	@Column(name = "fecha_finalizacion", nullable = true)
	private Date fechaFinalizacion;
	@Basic
	@Column(name = "estado_arquiler", nullable = false, length = 25)
	private String estadoArquiler;
	@Basic
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	@ManyToOne
	@JoinColumn(name = "vehiculo_id", referencedColumnName = "vehiculo_id", nullable = false)
	private VehiculosEntity vehiculosByVehiculoId;
	@ManyToOne
	@JoinColumn(name = "cliente_actual", referencedColumnName = "cliente_id", nullable = true)
	private ClientesEntity clientesByClienteActual;
	@ManyToOne
	@JoinColumn(name = "gestor_id", referencedColumnName = "empleado_id", nullable = true)
	private EmpleadosEntity empleadosByGestorId;

	public String getArquilerId() {
		return arquilerId;
	}

	public void setArquilerId(String arquilerId) {
		this.arquilerId = arquilerId;
	}

	public String getTituloArquiler() {
		return tituloArquiler;
	}

	public void setTituloArquiler(String tituloArquiler) {
		this.tituloArquiler = tituloArquiler;
	}

	public String getDescripcionArquiler() {
		return descripcionArquiler;
	}

	public void setDescripcionArquiler(String descripcionArquiler) {
		this.descripcionArquiler = descripcionArquiler;
	}

	public BigDecimal getPrecioArquiler() {
		return precioArquiler;
	}

	public void setPrecioArquiler(BigDecimal precioArquiler) {
		this.precioArquiler = precioArquiler;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getEstadoArquiler() {
		return estadoArquiler;
	}

	public void setEstadoArquiler(String estadoArquiler) {
		this.estadoArquiler = estadoArquiler;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public VehiculosEntity getVehiculosByVehiculoId() {
		return vehiculosByVehiculoId;
	}

	public void setVehiculosByVehiculoId(VehiculosEntity vehiculosByVehiculoId) {
		this.vehiculosByVehiculoId = vehiculosByVehiculoId;
	}

	public ClientesEntity getClientesByClienteActual() {
		return clientesByClienteActual;
	}

	public void setClientesByClienteActual(ClientesEntity clientesByClienteActual) {
		this.clientesByClienteActual = clientesByClienteActual;
	}

	public EmpleadosEntity getEmpleadosByGestorId() {
		return empleadosByGestorId;
	}

	public void setEmpleadosByGestorId(EmpleadosEntity empleadosByGestorId) {
		this.empleadosByGestorId = empleadosByGestorId;
	}
}
