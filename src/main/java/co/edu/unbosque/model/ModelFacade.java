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

/**
 * La clase {@code ModelFacade} actúa como una fachada que centraliza y
 * proporciona acceso a las diferentes instancias de los DAO (Data Access Object)
 * utilizados en el sistema. Esta clase ofrece métodos estáticos para obtener
 * instancias únicas de cada DAO, garantizando un único punto de acceso a los
 * mismos.
 *
 * <p>Los DAOs gestionan la persistencia y operaciones CRUD para diferentes
 * tipos de productos, incluyendo ropa, tecnología, instrumentos musicales,
 * juguetes, maquillaje y artículos de papelería.</p>
 *
 * <p>Este patrón facilita la modularidad y separación de responsabilidades
 * dentro de la arquitectura, evitando que otras capas dependan directamente
 * de múltiples DAOs.</p>
 * 
 * @author TuNombre
 * @version 1.0
 */
public class ModelFacade {

    /** Instancia única del DAO para calzado. */
    private static final CalzadoDAO calzadoDAO = new CalzadoDAO();

    /** Instancia única del DAO para camisetas. */
    private static final CamisetaDAO camisetaDAO = new CamisetaDAO();

    /** Instancia única del DAO para pantalones. */
    private static final PantalonDAO pantalonDAO = new PantalonDAO();

    /** Instancia única del DAO para peluches. */
    private static final PelucheDAO pelucheDAO = new PelucheDAO();

    /** Instancia única del DAO para pistolas de agua. */
    private static final PistolaAguaDAO pistolaDAO = new PistolaAguaDAO();

    /** Instancia única del DAO para productos Lego. */
    private static final LegoDAO legoDAO = new LegoDAO();

    /** Instancia única del DAO para celulares. */
    private static final CelularDAO celularDAO = new CelularDAO();

    /** Instancia única del DAO para televisores. */
    private static final TelevisorDAO televisorDAO = new TelevisorDAO();

    /** Instancia única del DAO para computadores. */
    private static final ComputadorDAO computadorDAO = new ComputadorDAO();

    /** Instancia única del DAO para instrumentos de viento. */
    private static final InstrumentoVientoDAO vientoDAO = new InstrumentoVientoDAO();

    /** Instancia única del DAO para instrumentos de percusión. */
    private static final InstrumentoPercusionDAO percusionDAO = new InstrumentoPercusionDAO();

    /** Instancia única del DAO para instrumentos de cuerda. */
    private static final InstrumentoCuerdaDAO cuerdaDAO = new InstrumentoCuerdaDAO();

    /** Instancia única del DAO para sombras de maquillaje. */
    private static final SombraDAO sombraDAO = new SombraDAO();

    /** Instancia única del DAO para labiales. */
    private static final LabialDAO labialDAO = new LabialDAO();

    /** Instancia única del DAO para correctores. */
    private static final CorrectorDAO correctorDAO = new CorrectorDAO();

    /** Instancia única del DAO para cuadernos. */
    private static final CuadernoDAO cuadernoDAO = new CuadernoDAO();

    /** Instancia única del DAO para marcadores. */
    private static final MarcadorDAO marcadorDAO = new MarcadorDAO();

    /** Instancia única del DAO para cintas adhesivas. */
    private static final CintaAdhesivaDAO cintaDAO = new CintaAdhesivaDAO();

    /**
     * Obtiene la instancia única de {@link CalzadoDAO}.
     *
     * @return instancia de CalzadoDAO
     */
    public static CalzadoDAO getCalzadoDAO() {
        return calzadoDAO;
    }

    /**
     * Obtiene la instancia única de {@link CamisetaDAO}.
     *
     * @return instancia de CamisetaDAO
     */
    public static CamisetaDAO getCamisetaDAO() {
        return camisetaDAO;
    }

    /**
     * Obtiene la instancia única de {@link PantalonDAO}.
     *
     * @return instancia de PantalonDAO
     */
    public static PantalonDAO getPantalonDAO() {
        return pantalonDAO;
    }

    /**
     * Obtiene la instancia única de {@link PelucheDAO}.
     *
     * @return instancia de PelucheDAO
     */
    public static PelucheDAO getPelucheDAO() {
        return pelucheDAO;
    }

    /**
     * Obtiene la instancia única de {@link PistolaAguaDAO}.
     *
     * @return instancia de PistolaAguaDAO
     */
    public static PistolaAguaDAO getPistolaDAO() {
        return pistolaDAO;
    }

    /**
     * Obtiene la instancia única de {@link LegoDAO}.
     *
     * @return instancia de LegoDAO
     */
    public static LegoDAO getLegoDAO() {
        return legoDAO;
    }

    /**
     * Obtiene la instancia única de {@link CelularDAO}.
     *
     * @return instancia de CelularDAO
     */
    public static CelularDAO getCelularDAO() {
        return celularDAO;
    }

    /**
     * Obtiene la instancia única de {@link TelevisorDAO}.
     *
     * @return instancia de TelevisorDAO
     */
    public static TelevisorDAO getTelevisorDAO() {
        return televisorDAO;
    }

    /**
     * Obtiene la instancia única de {@link ComputadorDAO}.
     *
     * @return instancia de ComputadorDAO
     */
    public static ComputadorDAO getComputadorDAO() {
        return computadorDAO;
    }

    /**
     * Obtiene la instancia única de {@link InstrumentoVientoDAO}.
     *
     * @return instancia de InstrumentoVientoDAO
     */
    public static InstrumentoVientoDAO getVientoDAO() {
        return vientoDAO;
    }

    /**
     * Obtiene la instancia única de {@link InstrumentoPercusionDAO}.
     *
     * @return instancia de InstrumentoPercusionDAO
     */
    public static InstrumentoPercusionDAO getPercusionDAO() {
        return percusionDAO;
    }

    /**
     * Obtiene la instancia única de {@link InstrumentoCuerdaDAO}.
     *
     * @return instancia de InstrumentoCuerdaDAO
     */
    public static InstrumentoCuerdaDAO getCuerdaDAO() {
        return cuerdaDAO;
    }

    /**
     * Obtiene la instancia única de {@link SombraDAO}.
     *
     * @return instancia de SombraDAO
     */
    public static SombraDAO getSombraDAO() {
        return sombraDAO;
    }

    /**
     * Obtiene la instancia única de {@link LabialDAO}.
     *
     * @return instancia de LabialDAO
     */
    public static LabialDAO getLabialDAO() {
        return labialDAO;
    }

    /**
     * Obtiene la instancia única de {@link CorrectorDAO}.
     *
     * @return instancia de CorrectorDAO
     */
    public static CorrectorDAO getCorrectorDAO() {
        return correctorDAO;
    }

    /**
     * Obtiene la instancia única de {@link CuadernoDAO}.
     *
     * @return instancia de CuadernoDAO
     */
    public static CuadernoDAO getCuadernoDAO() {
        return cuadernoDAO;
    }

    /**
     * Obtiene la instancia única de {@link MarcadorDAO}.
     *
     * @return instancia de MarcadorDAO
     */
    public static MarcadorDAO getMarcadorDAO() {
        return marcadorDAO;
    }

    /**
     * Obtiene la instancia única de {@link CintaAdhesivaDAO}.
     *
     * @return instancia de CintaAdhesivaDAO
     */
    public static CintaAdhesivaDAO getCintaDAO() {
        return cintaDAO;
    }
}
