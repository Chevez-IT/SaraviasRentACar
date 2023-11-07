package sv.saraviasrenacar.www.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "arquileres", schema = "saravias_rentacar", catalog = "")
public class ArquileresEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private Integer precioArquiler;
	@Basic
	@Column(name = "estado_arquiler", nullable = false)
	private String estadoArquiler;
	@ManyToOne
	@JoinColumn(name = "vehiculo_id", referencedColumnName = "vehiculo_id", nullable = false)
	private VehiculosEntity vehiculosByVehiculoId;
	@ManyToOne
	@JoinColumn(name = "gestor_id", referencedColumnName = "empleado_id", nullable = false)
	private EmpleadosEntity empleadosByGestorId;
	@OneToMany(mappedBy = "arquileresByPublicacionConv")
	private Collection<ConversacionesEntity> conversacionesByArquilerId;

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

	public Integer getPrecioArquiler() {
		return precioArquiler;
	}

	public void setPrecioArquiler(Integer precioArquiler) {
		this.precioArquiler = precioArquiler;
	}

	public String getEstadoArquiler() {
		return estadoArquiler;
	}

	public void setEstadoArquiler(String estadoArquiler) {
		this.estadoArquiler = estadoArquiler;
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

	public Collection<ConversacionesEntity> getConversacionesByArquilerId() {
		return conversacionesByArquilerId;
	}

	public void setConversacionesByArquilerId(Collection<ConversacionesEntity> conversacionesByArquilerId) {
		this.conversacionesByArquilerId = conversacionesByArquilerId;
	}
}
