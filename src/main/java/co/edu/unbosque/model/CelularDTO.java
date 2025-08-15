package co.edu.unbosque.model;

public class CelularDTO extends DispositivoElectronicoDTO {
	private String almacenamiento;
	private String ram;
	private int cantidadCamaras;
	private boolean dualSim;

	public CelularDTO() {
		// TODO Auto-generated constructor stub
	}

	public CelularDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String almacenamiento, String ram, int cantidadCamaras,
			boolean dualSim) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.cantidadCamaras = cantidadCamaras;
		this.dualSim = dualSim;
	}

	public CelularDTO(double pulgadas, String resolucion, String sistemaOperativo, String almacenamiento, String ram,
			int cantidadCamaras, boolean dualSim) {
		super(pulgadas, resolucion, sistemaOperativo);
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.cantidadCamaras = cantidadCamaras;
		this.dualSim = dualSim;
	}

	public CelularDTO(String almacenamiento, String ram, int cantidadCamaras, boolean dualSim) {
		super();
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.cantidadCamaras = cantidadCamaras;
		this.dualSim = dualSim;
	}

	public CelularDTO(double pulgadas, String resolucion, String sistemaOperativo) {
		super(pulgadas, resolucion, sistemaOperativo);
		// TODO Auto-generated constructor stub
	}

	public CelularDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
				sistemaOperativo);
		// TODO Auto-generated constructor stub
	}

	public CelularDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public CelularDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo,
			String almacenamiento, String ram, int cantidadCamaras, boolean dualSim) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
				sistemaOperativo);
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.cantidadCamaras = cantidadCamaras;
		this.dualSim = dualSim;
	}

	public String getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public int getCantidadCamaras() {
		return cantidadCamaras;
	}

	public void setCantidadCamaras(int cantidadCamaras) {
		this.cantidadCamaras = cantidadCamaras;
	}

	public boolean isDualSim() {
		return dualSim;
	}

	public void setDualSim(boolean dualSim) {
		this.dualSim = dualSim;
	}

}
