package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.CalzadoDAO;
import co.edu.unbosque.model.persistence.CamisetaDAO;
import co.edu.unbosque.model.persistence.CelularDAO;
import co.edu.unbosque.model.persistence.CintaAdhesivaDAO;
import co.edu.unbosque.model.persistence.ComputadorDAO;
import co.edu.unbosque.model.persistence.CorrectorDAO;
import co.edu.unbosque.model.persistence.CuadernoDAO;
import co.edu.unbosque.model.persistence.InstrumentoCuerdaDAO;
import co.edu.unbosque.model.persistence.InstrumentoPercusionDAO;
import co.edu.unbosque.model.persistence.InstrumentoVientoDAO;
import co.edu.unbosque.model.persistence.LabialDAO;
import co.edu.unbosque.model.persistence.LegoDAO;
import co.edu.unbosque.model.persistence.MarcadorDAO;
import co.edu.unbosque.model.persistence.PantalonDAO;
import co.edu.unbosque.model.persistence.PelucheDAO;
import co.edu.unbosque.model.persistence.PistolaAguaDAO;
import co.edu.unbosque.model.persistence.SombraDAO;
import co.edu.unbosque.model.persistence.TelevisorDAO;

public class ModelFacade {
	private CalzadoDAO calzadoDAO;
	private CamisetaDAO camisetaDAO;
	private PantalonDAO pantalonDAO;
	private PelucheDAO pelucuheDAO;
	private PistolaAguaDAO pistolaDAO;
	private LegoDAO legoDAO;
	private CelularDAO celularDAO;
	private TelevisorDAO televisorDAO;
	private ComputadorDAO computadorDAO;
	private InstrumentoVientoDAO vientoDAO;
	private InstrumentoPercusionDAO percusionDAO;
	private InstrumentoCuerdaDAO cuerdaDAO;
	private SombraDAO sombraDAO;
	private LabialDAO labialDAO;
	private CorrectorDAO correctorDAO;
	private CuadernoDAO cuadernoDAO;
	private MarcadorDAO marcadorDAO;
	private CintaAdhesivaDAO cintaDAO;
	ArrayList<Ropa>listaRopa;
	ArrayList<Juguete>listaJuguete;
	ArrayList<DispositivoElectronico>listaElectronicos;
	ArrayList<InstrumentoMusical>listaMusical;
	ArrayList<Maquillaje>listaMaquillaje;
	ArrayList<Papeleria>listaPapeleria;
	ArrayList<Producto>listaProductos;
	public ModelFacade() {
		calzadoDAO= new CalzadoDAO();
		listaRopa= new ArrayList<>();
		listaJuguete= new ArrayList<>();
		listaElectronicos= new ArrayList<>();
		listaPapeleria= new ArrayList<>();
		listaMaquillaje= new ArrayList<>();
		listaMusical= new ArrayList<>();
		listaProductos= new ArrayList<>();
	}
	public CalzadoDAO getCalzadoDAO() {
		return calzadoDAO;
	}
	public void setCalzadoDAO(CalzadoDAO calzadoDAO) {
		this.calzadoDAO = calzadoDAO;
	}
	public CamisetaDAO getCamisetaDAO() {
		return camisetaDAO;
	}
	public void setCamisetaDAO(CamisetaDAO camisetaDAO) {
		this.camisetaDAO = camisetaDAO;
	}
	public PantalonDAO getPantalonDAO() {
		return pantalonDAO;
	}
	public void setPantalonDAO(PantalonDAO pantalonDAO) {
		this.pantalonDAO = pantalonDAO;
	}
	public PelucheDAO getPelucuheDAO() {
		return pelucuheDAO;
	}
	public void setPelucuheDAO(PelucheDAO pelucuheDAO) {
		this.pelucuheDAO = pelucuheDAO;
	}
	public PistolaAguaDAO getPistolaDAO() {
		return pistolaDAO;
	}
	public void setPistolaDAO(PistolaAguaDAO pistolaDAO) {
		this.pistolaDAO = pistolaDAO;
	}
	public LegoDAO getLegoDAO() {
		return legoDAO;
	}
	public void setLegoDAO(LegoDAO legoDAO) {
		this.legoDAO = legoDAO;
	}
	public CelularDAO getCelularDAO() {
		return celularDAO;
	}
	public void setCelularDAO(CelularDAO celularDAO) {
		this.celularDAO = celularDAO;
	}
	public TelevisorDAO getTelevisorDAO() {
		return televisorDAO;
	}
	public void setTelevisorDAO(TelevisorDAO televisorDAO) {
		this.televisorDAO = televisorDAO;
	}
	public ComputadorDAO getComputadorDAO() {
		return computadorDAO;
	}
	public void setComputadorDAO(ComputadorDAO computadorDAO) {
		this.computadorDAO = computadorDAO;
	}
	public InstrumentoVientoDAO getVientoDAO() {
		return vientoDAO;
	}
	public void setVientoDAO(InstrumentoVientoDAO vientoDAO) {
		this.vientoDAO = vientoDAO;
	}
	public InstrumentoPercusionDAO getPercusionDAO() {
		return percusionDAO;
	}
	public void setPercusionDAO(InstrumentoPercusionDAO percusionDAO) {
		this.percusionDAO = percusionDAO;
	}
	public InstrumentoCuerdaDAO getCuerdaDAO() {
		return cuerdaDAO;
	}
	public void setCuerdaDAO(InstrumentoCuerdaDAO cuerdaDAO) {
		this.cuerdaDAO = cuerdaDAO;
	}
	public SombraDAO getSombraDAO() {
		return sombraDAO;
	}
	public void setSombraDAO(SombraDAO sombraDAO) {
		this.sombraDAO = sombraDAO;
	}
	public LabialDAO getLabialDAO() {
		return labialDAO;
	}
	public void setLabialDAO(LabialDAO labialDAO) {
		this.labialDAO = labialDAO;
	}
	public CorrectorDAO getCorrectorDAO() {
		return correctorDAO;
	}
	public void setCorrectorDAO(CorrectorDAO correctorDAO) {
		this.correctorDAO = correctorDAO;
	}
	public CuadernoDAO getCuadernoDAO() {
		return cuadernoDAO;
	}
	public void setCuadernoDAO(CuadernoDAO cuadernoDAO) {
		this.cuadernoDAO = cuadernoDAO;
	}
	public MarcadorDAO getMarcadorDAO() {
		return marcadorDAO;
	}
	public void setMarcadorDAO(MarcadorDAO marcadorDAO) {
		this.marcadorDAO = marcadorDAO;
	}
	public CintaAdhesivaDAO getCintaDAO() {
		return cintaDAO;
	}
	public void setCintaDAO(CintaAdhesivaDAO cintaDAO) {
		this.cintaDAO = cintaDAO;
	}
	public ArrayList<Ropa> getListaRopa() {
		return listaRopa;
	}
	public void setListaRopa(ArrayList<Ropa> listaRopa) {
		this.listaRopa = listaRopa;
	}
	public ArrayList<Juguete> getListaJuguete() {
		return listaJuguete;
	}
	public void setListaJuguete(ArrayList<Juguete> listaJuguete) {
		this.listaJuguete = listaJuguete;
	}
	public ArrayList<DispositivoElectronico> getListaElectronicos() {
		return listaElectronicos;
	}
	public void setListaElectronicos(ArrayList<DispositivoElectronico> listaElectronicos) {
		this.listaElectronicos = listaElectronicos;
	}
	public ArrayList<InstrumentoMusical> getListaMusical() {
		return listaMusical;
	}
	public void setListaMusical(ArrayList<InstrumentoMusical> listaMusical) {
		this.listaMusical = listaMusical;
	}
	public ArrayList<Maquillaje> getListaMaquillaje() {
		return listaMaquillaje;
	}
	public void setListaMaquillaje(ArrayList<Maquillaje> listaMaquillaje) {
		this.listaMaquillaje = listaMaquillaje;
	}
	public ArrayList<Papeleria> getListaPapeleria() {
		return listaPapeleria;
	}
	public void setListaPapeleria(ArrayList<Papeleria> listaPapeleria) {
		this.listaPapeleria = listaPapeleria;
	}
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

}
