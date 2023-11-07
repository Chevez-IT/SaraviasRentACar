package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ventas", schema = "saravias_rentacar", catalog = "")
public class VentasEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "venta_id", nullable = false, length = 10)
	private String ventaId;
	@Basic
	@Column(name = "titulo_venta", nullable = false, length = 100)
	private String tituloVenta;
	@Basic
	@Column(name = "descripcion_venta", nullable = false, length = 100)
	private String descripcionVenta;
	@Basic
	@Column(name = "precio_venta", nullable = false, length = 255)
	private String precioVenta;
	@Basic
	@Column(name = "fecha_compra_venta", nullable = false)
	private Date fechaCompraVenta;
	@Basic
	@Column(name = "estado_venta", nullable = false, length = 25)
	private String estadoVenta;
	@Basic
	@Column(name = "fecha_creacion_venta", nullable = false)
	private Date fechaCreacionVenta;
	@ManyToOne
	@JoinColumn(name = "vehiculo_id", referencedColumnName = "vehiculo_id", nullable = false)
	private VehiculosEntity vehiculosByVehiculoId;
	@ManyToOne
	@JoinColumn(name = "comprador_venta", referencedColumnName = "cliente_id", nullable = false)
	private ClientesEntity clientesByCompradorVenta;
	@ManyToOne
	@JoinColumn(name = "gestor_id", referencedColumnName = "empleado_id", nullable = false)
	private EmpleadosEntity empleadosByGestorId;

	public String getVentaId() {
		return ventaId;
	}

	public void setVentaId(String ventaId) {
		this.ventaId = ventaId;
	}

	public String getTituloVenta() {
		return tituloVenta;
	}

	public void setTituloVenta(String tituloVenta) {
		this.tituloVenta = tituloVenta;
	}

	public String getDescripcionVenta() {
		return descripcionVenta;
	}

	public void setDescripcionVenta(String descripcionVenta) {
		this.descripcionVenta = descripcionVenta;
	}

	public String getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Date getFechaCompraVenta() {
		return fechaCompraVenta;
	}

	public void setFechaCompraVenta(Date fechaCompraVenta) {
		this.fechaCompraVenta = fechaCompraVenta;
	}

	public String getEstadoVenta() {
		return estadoVenta;
	}

	public void setEstadoVenta(String estadoVenta) {
		this.estadoVenta = estadoVenta;
	}

	public Date getFechaCreacionVenta() {
		return fechaCreacionVenta;
	}

	public void setFechaCreacionVenta(Date fechaCreacionVenta) {
		this.fechaCreacionVenta = fechaCreacionVenta;
	}

	public VehiculosEntity getVehiculosByVehiculoId() {
		return vehiculosByVehiculoId;
	}

	public void setVehiculosByVehiculoId(VehiculosEntity vehiculosByVehiculoId) {
		this.vehiculosByVehiculoId = vehiculosByVehiculoId;
	}

	public ClientesEntity getClientesByCompradorVenta() {
		return clientesByCompradorVenta;
	}

	public void setClientesByCompradorVenta(ClientesEntity clientesByCompradorVenta) {
		this.clientesByCompradorVenta = clientesByCompradorVenta;
	}

	public EmpleadosEntity getEmpleadosByGestorId() {
		return empleadosByGestorId;
	}

	public void setEmpleadosByGestorId(EmpleadosEntity empleadosByGestorId) {
		this.empleadosByGestorId = empleadosByGestorId;
	}
}
