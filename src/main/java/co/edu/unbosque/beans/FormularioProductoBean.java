package co.edu.unbosque.beans;


import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;

@Named("productoFormularioBean")
@ViewScoped
public class FormularioProductoBean implements Serializable {

    // ----- DATOS BÁSICOS -----
    private String nombre;
    private String marca;
    private String descripcion;
    private String imagen; 
    private double precio;
    private int cantidad;
    private String tipoProducto; 

    // ----- ROPA -----
    private String talla;
    private String genero;
    private String material;
    private String subRopa;

    // Subcategoría: Pantalón
    private String tipoPantalon;
    private String cortePantalon;
    private String largoPantalon;

    // Subcategoría: Camiseta
    private String mangaCamiseta;
    private String cuelloCamiseta;
    private boolean estampada;

    // Subcategoría: Calzado
    private String tipoCalzado;
    private String ocasionCalzado;
    private String suelaCalzado;
    private String alturaSuela;

    // ----- ELECTRÓNICOS -----
    private String pulgadas;
    private String resolucion;
    private String sistemaOperativo;
    private String subElectronico;

    // Subcategoría: Celular
    private String almacenamientoCel;
    private String ramCel;
    private int camaras;
    private boolean dualSim;

    // Subcategoría: Computador
    private String almacenamientoPc;
    private String ramPc;
    private String procesadorPc;
    private String graficaPc;

    // Subcategoría: Televisor
    private int puertosHdmi;
    private int frecuenciaHz;
    private String asistenteVirtual;

    // ----- JUGUETES -----
    private int edadRecomendada;
    private String subJuguete;

    // Lego
    private String temaLego;
    private int piezasLego;
    private boolean minifiguras;

    // Peluche
    private boolean sonidoPeluche;
    private String rellenoPeluche;
    private boolean lavable;

    // Pistola de agua
    private int capacidadAgua;
    private int cantidadChorros;
    private double alcanceChorro;

    // ----- PAPELERÍA -----
    private String presentacion;
    private String subPapeleria;

    // Cuaderno
    private String tipoHoja;
    private int cantidadHojas;
    private boolean pastaDura;

    // Marcador
    private String tipoPunta;
    private boolean permanente;
    private String tipoMarcador;

    // Cinta adhesiva
    private boolean reposicionable;
    private double anchoCinta;
    private String tipoCinta;

    // ----- MAQUILLAJE -----
    private String tipoPiel;
    private boolean pruebaAgua;
    private LocalDate fechaVencimiento;
    private String subMaquillaje;

    // Sombras
    private int cantidadColores;
    private String acabadoSombras;

    // Corrector
    private String coberturaCorrector;
    private String formatoCorrector;

    // Labial
    private String duracionLabial;
    private boolean hidratante;

    // ----- INSTRUMENTOS -----
    private boolean incluyeEstuche;
    private String subInstrumento;

    // Viento
    private String tipoInstrumentoViento;
    private String afinacion;
    private int numValvulas;
    private boolean boquillas;

    // Cuerda
    private String tipoInstrumentoCuerda;
    private int numeroCuerdas;
    private String tipoCuerda;
    private boolean cajaResonancia;

    // Percusión
    private String tipoInstrumentoPercusion;
    private boolean usoBaquetas;
    private String tipoPercusion;
    private int cantSuperficiesSonoras;

    // ----- MÉTODOS DE ACCIÓN -----
    //Gurda la informaciòn en la lista correspondiente del producto y su categoria
    public String guardar() {
       
        System.out.println("Producto guardado: " + nombre + " - " + tipoProducto);
        return null; 
    }
//Metodo que limpie los campos del form sin guardar nada
    public String cancelar() {

        return null;
    }
    // ----- GETTERS Y SETTERS -----

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSubRopa() {
		return subRopa;
	}

	public void setSubRopa(String subRopa) {
		this.subRopa = subRopa;
	}

	public String getTipoPantalon() {
		return tipoPantalon;
	}

	public void setTipoPantalon(String tipoPantalon) {
		this.tipoPantalon = tipoPantalon;
	}

	public String getCortePantalon() {
		return cortePantalon;
	}

	public void setCortePantalon(String cortePantalon) {
		this.cortePantalon = cortePantalon;
	}

	public String getLargoPantalon() {
		return largoPantalon;
	}

	public void setLargoPantalon(String largoPantalon) {
		this.largoPantalon = largoPantalon;
	}

	public String getMangaCamiseta() {
		return mangaCamiseta;
	}

	public void setMangaCamiseta(String mangaCamiseta) {
		this.mangaCamiseta = mangaCamiseta;
	}

	public String getCuelloCamiseta() {
		return cuelloCamiseta;
	}

	public void setCuelloCamiseta(String cuelloCamiseta) {
		this.cuelloCamiseta = cuelloCamiseta;
	}

	public boolean isEstampada() {
		return estampada;
	}

	public void setEstampada(boolean estampada) {
		this.estampada = estampada;
	}

	public String getTipoCalzado() {
		return tipoCalzado;
	}

	public void setTipoCalzado(String tipoCalzado) {
		this.tipoCalzado = tipoCalzado;
	}

	public String getOcasionCalzado() {
		return ocasionCalzado;
	}

	public void setOcasionCalzado(String ocasionCalzado) {
		this.ocasionCalzado = ocasionCalzado;
	}

	public String getSuelaCalzado() {
		return suelaCalzado;
	}

	public void setSuelaCalzado(String suelaCalzado) {
		this.suelaCalzado = suelaCalzado;
	}

	public String getAlturaSuela() {
		return alturaSuela;
	}

	public void setAlturaSuela(String alturaSuela) {
		this.alturaSuela = alturaSuela;
	}

	public String getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(String pulgadas) {
		this.pulgadas = pulgadas;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public String getSubElectronico() {
		return subElectronico;
	}

	public void setSubElectronico(String subElectronico) {
		this.subElectronico = subElectronico;
	}

	public String getAlmacenamientoCel() {
		return almacenamientoCel;
	}

	public void setAlmacenamientoCel(String almacenamientoCel) {
		this.almacenamientoCel = almacenamientoCel;
	}

	public String getRamCel() {
		return ramCel;
	}

	public void setRamCel(String ramCel) {
		this.ramCel = ramCel;
	}

	public int getCamaras() {
		return camaras;
	}

	public void setCamaras(int camaras) {
		this.camaras = camaras;
	}

	public boolean isDualSim() {
		return dualSim;
	}

	public void setDualSim(boolean dualSim) {
		this.dualSim = dualSim;
	}

	public String getAlmacenamientoPc() {
		return almacenamientoPc;
	}

	public void setAlmacenamientoPc(String almacenamientoPc) {
		this.almacenamientoPc = almacenamientoPc;
	}

	public String getRamPc() {
		return ramPc;
	}

	public void setRamPc(String ramPc) {
		this.ramPc = ramPc;
	}

	public String getProcesadorPc() {
		return procesadorPc;
	}

	public void setProcesadorPc(String procesadorPc) {
		this.procesadorPc = procesadorPc;
	}

	public String getGraficaPc() {
		return graficaPc;
	}

	public void setGraficaPc(String graficaPc) {
		this.graficaPc = graficaPc;
	}

	public int getPuertosHdmi() {
		return puertosHdmi;
	}

	public void setPuertosHdmi(int puertosHdmi) {
		this.puertosHdmi = puertosHdmi;
	}

	public int getFrecuenciaHz() {
		return frecuenciaHz;
	}

	public void setFrecuenciaHz(int frecuenciaHz) {
		this.frecuenciaHz = frecuenciaHz;
	}

	public String getAsistenteVirtual() {
		return asistenteVirtual;
	}

	public void setAsistenteVirtual(String asistenteVirtual) {
		this.asistenteVirtual = asistenteVirtual;
	}

	public int getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	public String getSubJuguete() {
		return subJuguete;
	}

	public void setSubJuguete(String subJuguete) {
		this.subJuguete = subJuguete;
	}

	public String getTemaLego() {
		return temaLego;
	}

	public void setTemaLego(String temaLego) {
		this.temaLego = temaLego;
	}

	public int getPiezasLego() {
		return piezasLego;
	}

	public void setPiezasLego(int piezasLego) {
		this.piezasLego = piezasLego;
	}

	public boolean isMinifiguras() {
		return minifiguras;
	}

	public void setMinifiguras(boolean minifiguras) {
		this.minifiguras = minifiguras;
	}

	public boolean isSonidoPeluche() {
		return sonidoPeluche;
	}

	public void setSonidoPeluche(boolean sonidoPeluche) {
		this.sonidoPeluche = sonidoPeluche;
	}

	public String getRellenoPeluche() {
		return rellenoPeluche;
	}

	public void setRellenoPeluche(String rellenoPeluche) {
		this.rellenoPeluche = rellenoPeluche;
	}

	public boolean isLavable() {
		return lavable;
	}

	public void setLavable(boolean lavable) {
		this.lavable = lavable;
	}

	public int getCapacidadAgua() {
		return capacidadAgua;
	}

	public void setCapacidadAgua(int capacidadAgua) {
		this.capacidadAgua = capacidadAgua;
	}

	public int getCantidadChorros() {
		return cantidadChorros;
	}

	public void setCantidadChorros(int cantidadChorros) {
		this.cantidadChorros = cantidadChorros;
	}

	public double getAlcanceChorro() {
		return alcanceChorro;
	}

	public void setAlcanceChorro(double alcanceChorro) {
		this.alcanceChorro = alcanceChorro;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getSubPapeleria() {
		return subPapeleria;
	}

	public void setSubPapeleria(String subPapeleria) {
		this.subPapeleria = subPapeleria;
	}

	public String getTipoHoja() {
		return tipoHoja;
	}

	public void setTipoHoja(String tipoHoja) {
		this.tipoHoja = tipoHoja;
	}

	public int getCantidadHojas() {
		return cantidadHojas;
	}

	public void setCantidadHojas(int cantidadHojas) {
		this.cantidadHojas = cantidadHojas;
	}

	public boolean isPastaDura() {
		return pastaDura;
	}

	public void setPastaDura(boolean pastaDura) {
		this.pastaDura = pastaDura;
	}

	public String getTipoPunta() {
		return tipoPunta;
	}

	public void setTipoPunta(String tipoPunta) {
		this.tipoPunta = tipoPunta;
	}

	public boolean isPermanente() {
		return permanente;
	}

	public void setPermanente(boolean permanente) {
		this.permanente = permanente;
	}

	public String getTipoMarcador() {
		return tipoMarcador;
	}

	public void setTipoMarcador(String tipoMarcador) {
		this.tipoMarcador = tipoMarcador;
	}

	public boolean isReposicionable() {
		return reposicionable;
	}

	public void setReposicionable(boolean reposicionable) {
		this.reposicionable = reposicionable;
	}

	public double getAnchoCinta() {
		return anchoCinta;
	}

	public void setAnchoCinta(double anchoCinta) {
		this.anchoCinta = anchoCinta;
	}

	public String getTipoCinta() {
		return tipoCinta;
	}

	public void setTipoCinta(String tipoCinta) {
		this.tipoCinta = tipoCinta;
	}

	public String getTipoPiel() {
		return tipoPiel;
	}

	public void setTipoPiel(String tipoPiel) {
		this.tipoPiel = tipoPiel;
	}

	public boolean isPruebaAgua() {
		return pruebaAgua;
	}

	public void setPruebaAgua(boolean pruebaAgua) {
		this.pruebaAgua = pruebaAgua;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getSubMaquillaje() {
		return subMaquillaje;
	}

	public void setSubMaquillaje(String subMaquillaje) {
		this.subMaquillaje = subMaquillaje;
	}

	public int getCantidadColores() {
		return cantidadColores;
	}

	public void setCantidadColores(int cantidadColores) {
		this.cantidadColores = cantidadColores;
	}

	public String getAcabadoSombras() {
		return acabadoSombras;
	}

	public void setAcabadoSombras(String acabadoSombras) {
		this.acabadoSombras = acabadoSombras;
	}

	public String getCoberturaCorrector() {
		return coberturaCorrector;
	}

	public void setCoberturaCorrector(String coberturaCorrector) {
		this.coberturaCorrector = coberturaCorrector;
	}

	public String getFormatoCorrector() {
		return formatoCorrector;
	}

	public void setFormatoCorrector(String formatoCorrector) {
		this.formatoCorrector = formatoCorrector;
	}

	public String getDuracionLabial() {
		return duracionLabial;
	}

	public void setDuracionLabial(String duracionLabial) {
		this.duracionLabial = duracionLabial;
	}

	public boolean isHidratante() {
		return hidratante;
	}

	public void setHidratante(boolean hidratante) {
		this.hidratante = hidratante;
	}

	public boolean isIncluyeEstuche() {
		return incluyeEstuche;
	}

	public void setIncluyeEstuche(boolean incluyeEstuche) {
		this.incluyeEstuche = incluyeEstuche;
	}

	public String getSubInstrumento() {
		return subInstrumento;
	}

	public void setSubInstrumento(String subInstrumento) {
		this.subInstrumento = subInstrumento;
	}

	public String getTipoInstrumentoViento() {
		return tipoInstrumentoViento;
	}

	public void setTipoInstrumentoViento(String tipoInstrumentoViento) {
		this.tipoInstrumentoViento = tipoInstrumentoViento;
	}

	public String getAfinacion() {
		return afinacion;
	}

	public void setAfinacion(String afinacion) {
		this.afinacion = afinacion;
	}

	public int getNumValvulas() {
		return numValvulas;
	}

	public void setNumValvulas(int numValvulas) {
		this.numValvulas = numValvulas;
	}

	public boolean isBoquillas() {
		return boquillas;
	}

	public void setBoquillas(boolean boquillas) {
		this.boquillas = boquillas;
	}

	public String getTipoInstrumentoCuerda() {
		return tipoInstrumentoCuerda;
	}

	public void setTipoInstrumentoCuerda(String tipoInstrumentoCuerda) {
		this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
	}

	public int getNumeroCuerdas() {
		return numeroCuerdas;
	}

	public void setNumeroCuerdas(int numeroCuerdas) {
		this.numeroCuerdas = numeroCuerdas;
	}

	public String getTipoCuerda() {
		return tipoCuerda;
	}

	public void setTipoCuerda(String tipoCuerda) {
		this.tipoCuerda = tipoCuerda;
	}

	public boolean isCajaResonancia() {
		return cajaResonancia;
	}

	public void setCajaResonancia(boolean cajaResonancia) {
		this.cajaResonancia = cajaResonancia;
	}

	public String getTipoInstrumentoPercusion() {
		return tipoInstrumentoPercusion;
	}

	public void setTipoInstrumentoPercusion(String tipoInstrumentoPercusion) {
		this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
	}

	public boolean isUsoBaquetas() {
		return usoBaquetas;
	}

	public void setUsoBaquetas(boolean usoBaquetas) {
		this.usoBaquetas = usoBaquetas;
	}

	public String getTipoPercusion() {
		return tipoPercusion;
	}

	public void setTipoPercusion(String tipoPercusion) {
		this.tipoPercusion = tipoPercusion;
	}

	public int getCantSuperficiesSonoras() {
		return cantSuperficiesSonoras;
	}

	public void setCantSuperficiesSonoras(int cantSuperficiesSonoras) {
		this.cantSuperficiesSonoras = cantSuperficiesSonoras;
	}

   
}

