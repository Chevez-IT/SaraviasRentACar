package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.util.Collection;

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
	@Column(name = "estado_venta", nullable = false)
	private String estadoVenta;
	@OneToMany(mappedBy = "ventasByPublicacionConv")
	private Collection<ConversacionesEntity> conversacionesByVentaId;
	@ManyToOne
	@JoinColumn(name = "vehiculo_id", referencedColumnName = "vehiculo_id", nullable = false)
	private VehiculosEntity vehiculosByVehiculoId;
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

	public String getEstadoVenta() {
		return estadoVenta;
	}

	public void setEstadoVenta(String estadoVenta) {
		this.estadoVenta = estadoVenta;
	}

	public Collection<ConversacionesEntity> getConversacionesByVentaId() {
		return conversacionesByVentaId;
	}

	public void setConversacionesByVentaId(Collection<ConversacionesEntity> conversacionesByVentaId) {
		this.conversacionesByVentaId = conversacionesByVentaId;
	}

	public VehiculosEntity getVehiculosByVehiculoId() {
		return vehiculosByVehiculoId;
	}

	public void setVehiculosByVehiculoId(VehiculosEntity vehiculosByVehiculoId) {
		this.vehiculosByVehiculoId = vehiculosByVehiculoId;
	}

	public EmpleadosEntity getEmpleadosByGestorId() {
		return empleadosByGestorId;
	}

	public void setEmpleadosByGestorId(EmpleadosEntity empleadosByGestorId) {
		this.empleadosByGestorId = empleadosByGestorId;
	}
}
