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
		listaRopa= new ArrayList<>();
		listaJuguete= new ArrayList<>();
		listaElectronicos= new ArrayList<>();
		listaPapeleria= new ArrayList<>();
		listaMaquillaje= new ArrayList<>();
		listaMusical= new ArrayList<>();
		listaProductos= new ArrayList<>();
	}

}
