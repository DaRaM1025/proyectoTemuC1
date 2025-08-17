package co.edu.unbosque.model;

public class CorrectorDTO extends MaquillajeDTO {
    private String cobertura;
    private String formato;

    public CorrectorDTO() {
		// TODO Auto-generated constructor stub
	}

	public CorrectorDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento, String cobertura,
			String formato) {
		super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
		this.cobertura = cobertura;
		this.formato = formato;
	}

	public CorrectorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String cobertura, String formato) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.cobertura = cobertura;
		this.formato = formato;
	}

	public CorrectorDTO(String cobertura, String formato) {
		super();
		this.cobertura = cobertura;
		this.formato = formato;
	}

	public CorrectorDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
		super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
		// TODO Auto-generated constructor stub
	}

	public CorrectorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
				fechaVencimiento);
		// TODO Auto-generated constructor stub
	}

	public CorrectorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public CorrectorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento,
			String cobertura, String formato) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
				fechaVencimiento);
		this.cobertura = cobertura;
		this.formato = formato;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	@Override
	public CorrectorDTO clone() {
		return new CorrectorDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
				getCantidad(), getId(), getTipoPiel(), isEsApruebaDeAgua(), getFechaVencimiento(), getCobertura(), getFormato());
	}

}
