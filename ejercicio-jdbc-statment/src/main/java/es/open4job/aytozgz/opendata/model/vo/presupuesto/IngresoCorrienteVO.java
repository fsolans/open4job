package es.open4job.aytozgz.opendata.model.vo.presupuesto;

public class IngresoCorrienteVO {

	private String aplicacion;
	private float derechosCancelados;
	private float excesoDefectoPrevision;
	private float derechosReconocidosNetos;
	private float previsionModificacion;
	private float derechosReconocidos;
	private String id;
	private float recaudacionNeta;
	private String fecha;
	private float previsionInicial;
	private String concepto;
	private int idCapitulo;
	private String capitulo;
	private float derechosAnuladosYDevoluciones;
	private float previsionDefinitivo;
	private float derechosPendientesCobro;

	public IngresoCorrienteVO(String aplicacion, float derechosCancelados,
			float excesoDefectoPrevision, float derechosReconocidosNetos,
			float previsionModificacion, float derechosReconocidos, String id,
			float recaudacionNeta, String fecha, float previsionInicial,
			String concepto, int idCapitulo, String capitulo,
			float derechosAnuladosYDevoluciones, float previsionDefinitivo,
			float derechosPendientesCobro) {

		this.aplicacion = aplicacion;
		this.derechosCancelados = derechosCancelados;
		this.excesoDefectoPrevision = excesoDefectoPrevision;
		this.derechosReconocidosNetos = derechosReconocidosNetos;
		this.previsionModificacion = previsionModificacion;
		this.derechosReconocidos = derechosReconocidos;
		this.id = id;
		this.recaudacionNeta = recaudacionNeta;
		this.fecha = fecha;
		this.previsionInicial = previsionInicial;
		this.concepto = concepto;
		this.idCapitulo = idCapitulo;
		this.capitulo = capitulo;
		this.derechosAnuladosYDevoluciones = derechosAnuladosYDevoluciones;
		this.previsionDefinitivo = previsionDefinitivo;
		this.derechosPendientesCobro = derechosPendientesCobro;
	}

	//
	// Getters and setters
	//

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public float getDerechosCancelados() {
		return derechosCancelados;
	}

	public void setDerechosCancelados(float derechosCancelados) {
		this.derechosCancelados = derechosCancelados;
	}

	public float getExcesoDefectoPrevision() {
		return excesoDefectoPrevision;
	}

	public void setExcesoDefectoPrevision(float excesoDefectoPrevision) {
		this.excesoDefectoPrevision = excesoDefectoPrevision;
	}

	public float getDerechosReconocidosNetos() {
		return derechosReconocidosNetos;
	}

	public void setDerechosReconocidosNetos(float derechosReconocidosNetos) {
		this.derechosReconocidosNetos = derechosReconocidosNetos;
	}

	public float getPrevisionModificacion() {
		return previsionModificacion;
	}

	public void setPrevisionModificacion(float previsionModificacion) {
		this.previsionModificacion = previsionModificacion;
	}

	public float getDerechosReconocidos() {
		return derechosReconocidos;
	}

	public void setDerechosReconocidos(float derechosReconocidos) {
		this.derechosReconocidos = derechosReconocidos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getRecaudacionNeta() {
		return recaudacionNeta;
	}

	public void setRecaudacionNeta(float recaudacionNeta) {
		this.recaudacionNeta = recaudacionNeta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getPrevisionInicial() {
		return previsionInicial;
	}

	public void setPrevisionInicial(float previsionInicial) {
		this.previsionInicial = previsionInicial;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public int getIdCapitulo() {
		return idCapitulo;
	}

	public void setIdCapitulo(int idCapitulo) {
		this.idCapitulo = idCapitulo;
	}

	public String getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(String capitulo) {
		this.capitulo = capitulo;
	}

	public float getDerechosAnuladosYDevoluciones() {
		return derechosAnuladosYDevoluciones;
	}

	public void setDerechosAnuladosYDevoluciones(
			float derechosAnuladosYDevoluciones) {
		this.derechosAnuladosYDevoluciones = derechosAnuladosYDevoluciones;
	}

	public float getPrevisionDefinitivo() {
		return previsionDefinitivo;
	}

	public void setPrevisionDefinitivo(float previsionDefinitivo) {
		this.previsionDefinitivo = previsionDefinitivo;
	}

	public float getDerechosPendientesCobro() {
		return derechosPendientesCobro;
	}

	public void setDerechosPendientesCobro(float derechosPendientesCobro) {
		this.derechosPendientesCobro = derechosPendientesCobro;
	}

	//
	// Vista
	//

	public String toString() {

		return ("IngresoCorrienteVO  = [ " + "aplicacion = " + aplicacion
				+ ", " + ", derechosCancelados = " + derechosCancelados + ", "
				+ ", excesoDefectoPrevision = " + excesoDefectoPrevision + ", "
				+ ", derechosReconocidosNetos = " + derechosReconocidosNetos
				+ ", " + ", previsionModificacion = " + previsionModificacion
				+ ", " + ", derechosReconocidos = " + derechosReconocidos
				+ ", " + ", id = " + id + ", " + ", recaudacionNeta = "
				+ recaudacionNeta + ", " + ", fecha = " + fecha + ", "
				+ ", previsionInicial = " + previsionInicial + ", "
				+ ", concepto = " + concepto + ", " + ", idCapitulo = "
				+ idCapitulo + ", " + ", capitulo = " + capitulo + ", "
				+ ", derechosAnuladosYDevoluciones = "
				+ derechosAnuladosYDevoluciones + ", "
				+ ", previsionDefinitivo = " + previsionDefinitivo + ", "
				+ ", derechosPendientesCobro = " + derechosPendientesCobro + " ]");
	}
}
