package es.open4job.aytozgz.opendata.model.vo.presupuesto;

public class GastoCorrienteVO {

	private float obligacionPendientePago;

	private float creditoModificacion;

	private String organo;

	private float obligacionNeta;

	private String idOrgano;

	private String id;

	private String fecha;

	private String concepto;

	private String partida;

	private int idCapitulo;

	private float creditoDefinitivo;

	private String capitulo;

	private float creditoInicial;

	private String idArea;

	private float pagoNeto;

	private float gastoComprometido;

	private float remanenteDeCredito;

	private String area;

	public GastoCorrienteVO(float obligacionPendientePago,
			float creditoModificacion, String organo, float obligacionNeta,
			String idOrgano, String id, String fecha, String concepto,
			String partida, int idCapitulo, float creditoDefinitivo,
			String capitulo, float creditoInicial, String idArea,
			float pagoNeto, float gastoComprometido, float remanenteDeCredito,
			String area) {

		this.obligacionPendientePago = obligacionPendientePago;
		this.creditoModificacion = creditoModificacion;
		this.organo = organo;
		this.obligacionNeta = obligacionNeta;
		this.idOrgano = idOrgano;
		this.id = id;
		this.fecha = fecha;
		this.concepto = concepto;
		this.partida = partida;
		this.idCapitulo = idCapitulo;
		this.creditoDefinitivo = creditoDefinitivo;
		this.capitulo = capitulo;
		this.creditoInicial = creditoInicial;
		this.idArea = idArea;
		this.pagoNeto = pagoNeto;
		this.gastoComprometido = gastoComprometido;
		this.remanenteDeCredito = remanenteDeCredito;
		this.area = area;

	}

	public float getObligacionPendientePago() {
		return obligacionPendientePago;
	}

	public void setObligacionPendientePago(float obligacionPendientePago) {
		this.obligacionPendientePago = obligacionPendientePago;
	}

	public float getCreditoModificacion() {
		return creditoModificacion;
	}

	public void setCreditoModificacion(float creditoModificacion) {
		this.creditoModificacion = creditoModificacion;
	}

	public String getOrgano() {
		return organo;
	}

	public void setOrgano(String organo) {
		this.organo = organo;
	}

	public float getObligacionNeta() {
		return obligacionNeta;
	}

	public void setObligacionNeta(float obligacionNeta) {
		this.obligacionNeta = obligacionNeta;
	}

	public String getIdOrgano() {
		return idOrgano;
	}

	public void setIdOrgano(String idOrgano) {
		this.idOrgano = idOrgano;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public int getIdCapitulo() {
		return idCapitulo;
	}

	public void setIdCapitulo(int idCapitulo) {
		this.idCapitulo = idCapitulo;
	}

	public float getCreditoDefinitivo() {
		return creditoDefinitivo;
	}

	public void setCreditoDefinitivo(float creditoDefinitivo) {
		this.creditoDefinitivo = creditoDefinitivo;
	}

	public String getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(String capitulo) {
		this.capitulo = capitulo;
	}

	public float getCreditoInicial() {
		return creditoInicial;
	}

	public void setCreditoInicial(float creditoInicial) {
		this.creditoInicial = creditoInicial;
	}

	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public float getPagoNeto() {
		return pagoNeto;
	}

	public void setPagoNeto(float pagoNeto) {
		this.pagoNeto = pagoNeto;
	}

	public float getGastoComprometido() {
		return gastoComprometido;
	}

	public void setGastoComprometido(float gastoComprometido) {
		this.gastoComprometido = gastoComprometido;
	}

	public float getRemanenteDeCredito() {
		return remanenteDeCredito;
	}

	public void setRemanenteDeCredito(float remanenteDeCredito) {
		this.remanenteDeCredito = remanenteDeCredito;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String toString() {

		return ("GastoCorrienteVO  = [" + "obligacionPendientePago = "
				+ obligacionPendientePago + ", " + "creditoModificacion = "
				+ creditoModificacion + ", " + ", organo = " + organo + ", "
				+ ", obligacionNeta = " + obligacionNeta + ", "
				+ ", idOrgano = " + idOrgano + ", " + ", id = " + id + ", "
				+ ", fecha = " + fecha + ", " + ", concepto = " + concepto
				+ ", " + ", partida = " + concepto + ", " + ", idCapitulo = "
				+ idCapitulo + ", " + ", creditoDefinitivo = "
				+ creditoDefinitivo + ", " + ", capitulo = " + capitulo + ", "
				+ ", creditoInicial = " + creditoInicial + ", " + ", idArea = "
				+ idArea + ", " + ", pagoNeto = " + pagoNeto + ", "
				+ ", gastoComprometido = " + gastoComprometido + ", "
				+ ", remanenteDeCredito = " + remanenteDeCredito + ", "
				+ ", area = " + area + " ]");

	}

}
