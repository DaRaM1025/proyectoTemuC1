package co.edu.unbosque.model;

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

	private static final CalzadoDAO calzadoDAO = new CalzadoDAO();
	private static final CamisetaDAO camisetaDAO = new CamisetaDAO();
	private static final PantalonDAO pantalonDAO = new PantalonDAO();
	private static final PelucheDAO pelucheDAO = new PelucheDAO();
	private static final PistolaAguaDAO pistolaDAO = new PistolaAguaDAO();
	private static final LegoDAO legoDAO = new LegoDAO();
	private static final CelularDAO celularDAO = new CelularDAO();
	private static final TelevisorDAO televisorDAO = new TelevisorDAO();
	private static final ComputadorDAO computadorDAO = new ComputadorDAO();
	private static final InstrumentoVientoDAO vientoDAO = new InstrumentoVientoDAO();
	private static final InstrumentoPercusionDAO percusionDAO = new InstrumentoPercusionDAO();
	private static final InstrumentoCuerdaDAO cuerdaDAO = new InstrumentoCuerdaDAO();
	private static final SombraDAO sombraDAO = new SombraDAO();
	private static final LabialDAO labialDAO = new LabialDAO();
	private static final CorrectorDAO correctorDAO = new CorrectorDAO();
	private static final CuadernoDAO cuadernoDAO = new CuadernoDAO();
	private static final MarcadorDAO marcadorDAO = new MarcadorDAO();
	private static final CintaAdhesivaDAO cintaDAO = new CintaAdhesivaDAO();

	public static CalzadoDAO getCalzadoDAO() {
		return calzadoDAO;
	}

	public static CamisetaDAO getCamisetaDAO() {
		return camisetaDAO;
	}

	public static PantalonDAO getPantalonDAO() {
		return pantalonDAO;
	}

	public static PelucheDAO getPelucheDAO() {
		return pelucheDAO;
	}

	public static PistolaAguaDAO getPistolaDAO() {
		return pistolaDAO;
	}

	public static LegoDAO getLegoDAO() {
		return legoDAO;
	}

	public static CelularDAO getCelularDAO() {
		return celularDAO;
	}

	public static TelevisorDAO getTelevisorDAO() {
		return televisorDAO;
	}

	public static ComputadorDAO getComputadorDAO() {
		return computadorDAO;
	}

	public static InstrumentoVientoDAO getVientoDAO() {
		return vientoDAO;
	}

	public static InstrumentoPercusionDAO getPercusionDAO() {
		return percusionDAO;
	}

	public static InstrumentoCuerdaDAO getCuerdaDAO() {
		return cuerdaDAO;
	}

	public static SombraDAO getSombraDAO() {
		return sombraDAO;
	}

	public static LabialDAO getLabialDAO() {
		return labialDAO;
	}

	public static CorrectorDAO getCorrectorDAO() {
		return correctorDAO;
	}

	public static CuadernoDAO getCuadernoDAO() {
		return cuadernoDAO;
	}

	public static MarcadorDAO getMarcadorDAO() {
		return marcadorDAO;
	}

	public static CintaAdhesivaDAO getCintaDAO() {
		return cintaDAO;
	}
}