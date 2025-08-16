package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Calzado;
import co.edu.unbosque.model.CalzadoDTO;
import co.edu.unbosque.model.Camiseta;
import co.edu.unbosque.model.CamisetaDTO;
import co.edu.unbosque.model.Celular;
import co.edu.unbosque.model.CelularDTO;
import co.edu.unbosque.model.CintaAdhesiva;
import co.edu.unbosque.model.CintaAdhesivaDTO;
import co.edu.unbosque.model.Computador;
import co.edu.unbosque.model.ComputadorDTO;
import co.edu.unbosque.model.Corrector;
import co.edu.unbosque.model.CorrectorDTO;
import co.edu.unbosque.model.Cuaderno;
import co.edu.unbosque.model.CuadernoDTO;
import co.edu.unbosque.model.DispositivoElectronico;
import co.edu.unbosque.model.DispositivoElectronicoDTO;
import co.edu.unbosque.model.InstrumentoCuerda;
import co.edu.unbosque.model.InstrumentoCuerdaDTO;
import co.edu.unbosque.model.InstrumentoMusical;
import co.edu.unbosque.model.InstrumentoMusicalDTO;
import co.edu.unbosque.model.InstrumentoPercusion;
import co.edu.unbosque.model.InstrumentoPercusionDTO;
import co.edu.unbosque.model.InstrumentoViento;
import co.edu.unbosque.model.InstrumentoVientoDTO;
import co.edu.unbosque.model.Juguete;
import co.edu.unbosque.model.JugueteDTO;
import co.edu.unbosque.model.Labial;
import co.edu.unbosque.model.LabialDTO;
import co.edu.unbosque.model.Lego;
import co.edu.unbosque.model.LegoDTO;
import co.edu.unbosque.model.Maquillaje;
import co.edu.unbosque.model.MaquillajeDTO;
import co.edu.unbosque.model.Marcador;
import co.edu.unbosque.model.MarcadorDTO;
import co.edu.unbosque.model.Pantalon;
import co.edu.unbosque.model.PantalonDTO;
import co.edu.unbosque.model.Papeleria;
import co.edu.unbosque.model.PapeleriaDTO;
import co.edu.unbosque.model.Peluche;
import co.edu.unbosque.model.PelucheDTO;
import co.edu.unbosque.model.PistolaAgua;
import co.edu.unbosque.model.PistolaAguaDTO;
import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.ProductoDTO;
import co.edu.unbosque.model.Ropa;
import co.edu.unbosque.model.RopaDTO;
import co.edu.unbosque.model.Sombra;
import co.edu.unbosque.model.SombraDTO;
import co.edu.unbosque.model.Televisor;
import co.edu.unbosque.model.TelevisorDTO;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * Clase que se encarga de la conversión entre entidades y sus respectivos DTOs.
 * Facilita la transferencia de datos entre la capa de presentación y la capa de
 * persistencia.
 *
 * @author Nataly Rengifo
 */

public class DataMapper {

	/**
	 * Convierte un UsuarioDTO a un Usuario.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad Usuario correspondiente, o null si el DTO es null.
	 */
	public static Usuario usuarioDTOToUsuario(UsuarioDTO dto) {
		return new Usuario(dto.getNombre(), dto.getTelefono(), dto.getEmail(), dto.getUsername(), dto.getPassword(),
				dto.getFechaNacimiento());
	}

	public static UsuarioDTO usuarioToUsuarioDTO(Usuario entity) {
		return new UsuarioDTO(entity.getNombre(), entity.getTelefono(), entity.getEmail(), entity.getUsername(),
				entity.getPassword(), entity.getFechaNacimiento());
	}

	public static ArrayList<UsuarioDTO> listaUsuarioToListaUsuarioDTO(ArrayList<Usuario> entityList) {
		ArrayList<UsuarioDTO> dtoList = new ArrayList<>();
		for (Usuario u : entityList) {
			dtoList.add(new UsuarioDTO(u.getNombre(), u.getTelefono(), u.getEmail(), u.getUsername(), u.getPassword(),
					u.getFechaNacimiento()));
		}
		return dtoList;
	}

	public static ArrayList<UsuarioDTO> listaUsuarioDTOToListaUsuario(ArrayList<UsuarioDTO> dtoList) {
		ArrayList<UsuarioDTO> entityList = new ArrayList<>();
		for (UsuarioDTO d : dtoList) {
			entityList.add(new UsuarioDTO(d.getNombre(), d.getTelefono(), d.getEmail(), d.getUsername(),
					d.getPassword(), d.getFechaNacimiento()));
		}
		return entityList;
	}

	/**
	 * Convierte un CamisetaDTO a un Camiseta.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Camiseta dtoToCamiseta(CamisetaDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Camiseta(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getTalla(), dto.getGenero(),
				dto.getMaterial(), dto.getTipoManga(), dto.getCuello(), dto.isEstampado());
	}

	/**
	 * Convierte un Camiseta a un CamisetaDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static CamisetaDTO entityToCamisetaDTO(Camiseta ent) {
		if (ent == null) {
			return null;
		}
		return new CamisetaDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getTalla(), ent.getGenero(),
				ent.getMaterial(), ent.getTipoManga(), ent.getCuello(), ent.isEstampado());
	}

	/**
	 * Convierte una lista de Camiseta a una lista de CamisetaDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<CamisetaDTO> listaCamisetaToListaCamisetaDTO(ArrayList<Camiseta> listaEntidad) {
		ArrayList<CamisetaDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Camiseta cam : listaEntidad) {
			listaDTO.add(entityToCamisetaDTO(cam));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de CamisetaDTO a una lista de Camiseta.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Camiseta> listaCamisetaDTOToListaCamiseta(ArrayList<CamisetaDTO> listaDTO) {
		ArrayList<Camiseta> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (CamisetaDTO camDto : listaDTO) {
			listaEntidad.add(dtoToCamiseta(camDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un CalzadoDTO a un Calzado.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Calzado dtoToCalzado(CalzadoDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Calzado(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getTalla(), dto.getGenero(),
				dto.getMaterial(), dto.getTipoCalzado(), dto.getOcasion(), dto.getMaterialSuela(),
				dto.getAlturaSuela());
	}

	/**
	 * Convierte un Calzado a un CalzadoDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static CalzadoDTO entityToCalzadoDTO(Calzado ent) {
		if (ent == null) {
			return null;
		}
		return new CalzadoDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getTalla(), ent.getGenero(),
				ent.getMaterial(), ent.getTipoCalzado(), ent.getOcasion(), ent.getMaterialSuela(),
				ent.getAlturaSuela());
	}

	/**
	 * Convierte una lista de Calzado a una lista de CalzadoDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<CalzadoDTO> listaCalzadoToListaCalzadoDTO(ArrayList<Calzado> listaEntidad) {
		ArrayList<CalzadoDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Calzado cal : listaEntidad) {
			listaDTO.add(entityToCalzadoDTO(cal));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de CalzadoDTO a una lista de Calzado.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Calzado> listaCalzadoDTOToListaCalzado(ArrayList<CalzadoDTO> listaDTO) {
		ArrayList<Calzado> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (CalzadoDTO calDto : listaDTO) {
			listaEntidad.add(dtoToCalzado(calDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un CelularDTO a un Celular.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Celular dtoToCelular(CelularDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Celular(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getPulgadas(),
				dto.getResolucion(), dto.getSistemaOperativo(), dto.getAlmacenamiento(), dto.getRam(),
				dto.getCantidadCamaras(), dto.isDualSim());
	}

	/**
	 * Convierte un Celular a un CelularDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static CelularDTO entityToCelularDTO(Celular ent) {
		if (ent == null) {
			return null;
		}
		return new CelularDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getPulgadas(),
				ent.getResolucion(), ent.getSistemaOperativo(), ent.getAlmacenamiento(), ent.getRam(),
				ent.getCantidadCamaras(), ent.isDualSim());
	}

	/**
	 * Convierte una lista de Celular a una lista de CelularDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<CelularDTO> listaCelularToListaCelularDTO(ArrayList<Celular> listaEntidad) {
		ArrayList<CelularDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Celular cel : listaEntidad) {
			listaDTO.add(entityToCelularDTO(cel));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de CelularDTO a una lista de Celular.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Celular> listaCelularDTOToListaCelular(ArrayList<CelularDTO> listaDTO) {
		ArrayList<Celular> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (CelularDTO celDto : listaDTO) {
			listaEntidad.add(dtoToCelular(celDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un CintaAdhesivaDTO a un CintaAdhesiva.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static CintaAdhesiva dtoToCintaAdhesiva(CintaAdhesivaDTO dto) {
		if (dto == null) {
			return null;
		}
		return new CintaAdhesiva(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getTipoPresentacion(),
				dto.isEsAdhesivoReposicionable(), dto.getAncho(), dto.getTipoCinta());
	}

	/**
	 * Convierte un CintaAdhesiva a un CintaAdhesivaDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static CintaAdhesivaDTO entityToCintaAdhesivaDTO(CintaAdhesiva ent) {
		if (ent == null) {
			return null;
		}
		return new CintaAdhesivaDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getTipoPresentacion(),
				ent.isEsAdhesivoReposicionable(), ent.getAncho(), ent.getTipoCinta());
	}

	/**
	 * Convierte una lista de CintaAdhesiva a una lista de CintaAdhesivaDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<CintaAdhesivaDTO> listaCintaAdhesivaToListaCintaAdhesivaDTO(
			ArrayList<CintaAdhesiva> listaEntidad) {
		ArrayList<CintaAdhesivaDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (CintaAdhesiva cint : listaEntidad) {
			listaDTO.add(entityToCintaAdhesivaDTO(cint));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de CintaAdhesivaDTO a una lista de CintaAdhesiva.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<CintaAdhesiva> listaCintaAdhesivaDTOToListaCintaAdhesiva(
			ArrayList<CintaAdhesivaDTO> listaDTO) {
		ArrayList<CintaAdhesiva> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (CintaAdhesivaDTO cintDto : listaDTO) {
			listaEntidad.add(dtoToCintaAdhesiva(cintDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un ComputadorDTO a un Computador.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Computador dtoToComputador(ComputadorDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Computador(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getPulgadas(),
				dto.getResolucion(), dto.getSistemaOperativo(), dto.getAlmacenamiento(), dto.getRam(),
				dto.getProcesador(), dto.getTarjetaGrafica());
	}

	/**
	 * Convierte un Computador a un ComputadorDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static ComputadorDTO entityToComputadorDTO(Computador ent) {
		if (ent == null) {
			return null;
		}
		return new ComputadorDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getPulgadas(),
				ent.getResolucion(), ent.getSistemaOperativo(), ent.getAlmacenamiento(), ent.getRam(),
				ent.getProcesador(), ent.getTarjetaGrafica());
	}

	/**
	 * Convierte una lista de Computador a una lista de ComputadorDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<ComputadorDTO> listaComputadorToListaComputadorDTO(ArrayList<Computador> listaEntidad) {
		ArrayList<ComputadorDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Computador comp : listaEntidad) {
			listaDTO.add(entityToComputadorDTO(comp));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de ComputadorDTO a una lista de Computador.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Computador> listaComputadorDTOToListaComputador(ArrayList<ComputadorDTO> listaDTO) {
		ArrayList<Computador> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (ComputadorDTO compDto : listaDTO) {
			listaEntidad.add(dtoToComputador(compDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un CorrectorDTO a un Corrector.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Corrector dtoToCorrector(CorrectorDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Corrector(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getTipoPiel(),
				dto.isEsApruebaDeAgua(), dto.getFechaVencimiento(), dto.getCobertura(), dto.getFormato());
	}

	/**
	 * Convierte un Corrector a un CorrectorDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static CorrectorDTO entityToCorrectorDTO(Corrector ent) {
		if (ent == null) {
			return null;
		}
		return new CorrectorDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getTipoPiel(),
				ent.isEsApruebaDeAgua(), ent.getFechaVencimiento(), ent.getCobertura(), ent.getFormato());
	}

	/**
	 * Convierte una lista de Corrector a una lista de CorrectorDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<CorrectorDTO> listaCorrectorToListaCorrectorDTO(ArrayList<Corrector> listaEntidad) {
		ArrayList<CorrectorDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Corrector corr : listaEntidad) {
			listaDTO.add(entityToCorrectorDTO(corr));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de CorrectorDTO a una lista de Corrector.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Corrector> listaCorrectorDTOToListaCorrector(ArrayList<CorrectorDTO> listaDTO) {
		ArrayList<Corrector> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (CorrectorDTO corrDto : listaDTO) {
			listaEntidad.add(dtoToCorrector(corrDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un CuadernoDTO a un Cuaderno.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Cuaderno dtoToCuaderno(CuadernoDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Cuaderno(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getTipoPresentacion(),
				dto.getTipoHojas(), dto.getCantidadHojas(), dto.isPastaDura());
	}

	/**
	 * Convierte un Cuaderno a un CuadernoDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static CuadernoDTO entityToCuadernoDTO(Cuaderno ent) {
		if (ent == null) {
			return null;
		}
		return new CuadernoDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getTipoPresentacion(),
				ent.getTipoHojas(), ent.getCantidadHojas(), ent.isPastaDura());
	}

	/**
	 * Convierte una lista de Cuaderno a una lista de CuadernoDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<CuadernoDTO> listaCuadernoToListaCuadernoDTO(ArrayList<Cuaderno> listaEntidad) {
		ArrayList<CuadernoDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Cuaderno cua : listaEntidad) {
			listaDTO.add(entityToCuadernoDTO(cua));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de CuadernoDTO a una lista de Cuaderno.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Cuaderno> listaCuadernoDTOToListaCuaderno(ArrayList<CuadernoDTO> listaDTO) {
		ArrayList<Cuaderno> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (CuadernoDTO cuaDto : listaDTO) {
			listaEntidad.add(dtoToCuaderno(cuaDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un InstrumentoCuerdaDTO a un InstrumentoCuerda.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static InstrumentoCuerda dtoToInstrumentoCuerda(InstrumentoCuerdaDTO dto) {
		if (dto == null) {
			return null;
		}
		return new InstrumentoCuerda(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.isIncluyeEstuche(),
				dto.getTipoInstrumentoCuerda(), dto.getNumeroCuerdas(), dto.getTipoCuerda(),
				dto.isTieneCajaResonancia());
	}

	/**
	 * Convierte un InstrumentoCuerda a un InstrumentoCuerdaDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static InstrumentoCuerdaDTO entityToInstrumentoCuerdaDTO(InstrumentoCuerda ent) {
		if (ent == null) {
			return null;
		}
		return new InstrumentoCuerdaDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.isIncluyeEstuche(),
				ent.getTipoInstrumentoCuerda(), ent.getNumeroCuerdas(), ent.getTipoCuerda(),
				ent.isTieneCajaResonancia());
	}

	/**
	 * Convierte una lista de InstrumentoCuerda a una lista de InstrumentoCuerdaDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<InstrumentoCuerdaDTO> listaInstrumentoCuerdaToListaInstrumentoCuerdaDTO(
			ArrayList<InstrumentoCuerda> listaEntidad) {
		ArrayList<InstrumentoCuerdaDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (InstrumentoCuerda cua : listaEntidad) {
			listaDTO.add(entityToInstrumentoCuerdaDTO(cua));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de InstrumentoCuerdaDTO a una lista de InstrumentoCuerda.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<InstrumentoCuerda> listaInstrumentoCuerdaDTOToListaInstrumentoCuerda(
			ArrayList<InstrumentoCuerdaDTO> listaDTO) {
		ArrayList<InstrumentoCuerda> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (InstrumentoCuerdaDTO cuaDto : listaDTO) {
			listaEntidad.add(dtoToInstrumentoCuerda(cuaDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un InstrumentoVientoDTO a un InstrumentoViento.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static InstrumentoViento dtoToInstrumentoViento(InstrumentoVientoDTO dto) {
		if (dto == null) {
			return null;
		}
		return new InstrumentoViento(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.isIncluyeEstuche(),
				dto.getTipoInstrumentoViento(), dto.getAfinacion(), dto.getNumeroValvulas(), dto.isRequiereBoquilla());
	}

	/**
	 * Convierte un InstrumentoViento a un InstrumentoVientoDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static InstrumentoVientoDTO entityToInstrumentoVientoDTO(InstrumentoViento ent) {
		if (ent == null) {
			return null;
		}
		return new InstrumentoVientoDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.isIncluyeEstuche(),
				ent.getTipoInstrumentoViento(), ent.getAfinacion(), ent.getNumeroValvulas(), ent.isRequiereBoquilla());
	}

	/**
	 * Convierte una lista de InstrumentoViento a una lista de InstrumentoVientoDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<InstrumentoVientoDTO> listaInstrumentoVientoToListaInstrumentoVientoDTO(
			ArrayList<InstrumentoViento> listaEntidad) {
		ArrayList<InstrumentoVientoDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (InstrumentoViento cua : listaEntidad) {
			listaDTO.add(entityToInstrumentoVientoDTO(cua));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de InstrumentoVientoDTO a una lista de InstrumentoViento.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<InstrumentoViento> listaInstrumentoVientoDTOToListaInstrumentoViento(
			ArrayList<InstrumentoVientoDTO> listaDTO) {
		ArrayList<InstrumentoViento> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (InstrumentoVientoDTO cuaDto : listaDTO) {
			listaEntidad.add(dtoToInstrumentoViento(cuaDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un InstrumentoPercusionDTO a un InstrumentoPercusion.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static InstrumentoPercusion dtoToInstrumentoPercusion(InstrumentoPercusionDTO dto) {
		if (dto == null) {
			return null;
		}
		return new InstrumentoPercusion(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.isIncluyeEstuche(),
				dto.getTipoInstrumentoPercusion(), dto.isUsoBaquetas(), dto.getTipoPercusion(),
				dto.getCantSuperficiesSonoras());
	}

	/**
	 * Convierte un InstrumentoPercusion a un InstrumentoPercusionDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static InstrumentoPercusionDTO entityToInstrumentoPercusionDTO(InstrumentoPercusion ent) {
		if (ent == null) {
			return null;
		}
		return new InstrumentoPercusionDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.isIncluyeEstuche(),
				ent.getTipoInstrumentoPercusion(), ent.isUsoBaquetas(), ent.getTipoPercusion(),
				ent.getCantSuperficiesSonoras());
	}

	/**
	 * Convierte una lista de InstrumentoPercusion a una lista de
	 * InstrumentoPercusionDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<InstrumentoPercusionDTO> listaInstrumentoPercusionToListaInstrumentoPercusionDTO(
			ArrayList<InstrumentoPercusion> listaEntidad) {
		ArrayList<InstrumentoPercusionDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (InstrumentoPercusion cua : listaEntidad) {
			listaDTO.add(entityToInstrumentoPercusionDTO(cua));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de InstrumentoPercusionDTO a una lista de
	 * InstrumentoPercusion.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<InstrumentoPercusion> listaInstrumentoPercusionDTOToListaInstrumentoPercusion(
			ArrayList<InstrumentoPercusionDTO> listaDTO) {
		ArrayList<InstrumentoPercusion> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (InstrumentoPercusionDTO cuaDto : listaDTO) {
			listaEntidad.add(dtoToInstrumentoPercusion(cuaDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un LabialDTO a un Labial.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Labial dtoToLabial(LabialDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Labial(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getTipoPiel(),
				dto.isEsApruebaDeAgua(), dto.getFechaVencimiento(), dto.getDuracion(), dto.isEsHidratante());
	}

	/**
	 * Convierte un Labial a un LabialDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static LabialDTO entityToLabialDTO(Labial ent) {
		if (ent == null) {
			return null;
		}
		return new LabialDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getTipoPiel(),
				ent.isEsApruebaDeAgua(), ent.getFechaVencimiento(), ent.getDuracion(), ent.isEsHidratante());
	}

	/**
	 * Convierte una lista de Labial a una lista de LabialDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<LabialDTO> listaLabialToListaLabialDTO(ArrayList<Labial> listaEntidad) {
		ArrayList<LabialDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Labial lab : listaEntidad) {
			listaDTO.add(entityToLabialDTO(lab));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de LabialDTO a una lista de Labial.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Labial> listaLabialDTOToListaLabial(ArrayList<LabialDTO> listaDTO) {
		ArrayList<Labial> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (LabialDTO labDto : listaDTO) {
			listaEntidad.add(dtoToLabial(labDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un LegoDTO a un Lego.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Lego dtoToLego(LegoDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Lego(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getEdadRecomendada(),
				dto.getTema(), dto.getNumeroPiezas(), dto.isTieneMinifiguras());
	}

	/**
	 * Convierte un Lego a un LegoDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static LegoDTO entityToLegoDTO(Lego ent) {
		if (ent == null) {
			return null;
		}
		return new LegoDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getEdadRecomendada(),
				ent.getTema(), ent.getNumeroPiezas(), ent.isTieneMinifiguras());
	}

	/**
	 * Convierte una lista de Lego a una lista de LegoDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<LegoDTO> listaLegoToListaLegoDTO(ArrayList<Lego> listaEntidad) {
		ArrayList<LegoDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Lego leg : listaEntidad) {
			listaDTO.add(entityToLegoDTO(leg));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de LegoDTO a una lista de Lego.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Lego> listaLegoDTOToListaLego(ArrayList<LegoDTO> listaDTO) {
		ArrayList<Lego> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (LegoDTO legoDto : listaDTO) {
			listaEntidad.add(dtoToLego(legoDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un MarcadorDTO a un Marcador.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Marcador dtoToMarcador(MarcadorDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Marcador(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getTipoPresentacion(),
				dto.getTipoPunta(), dto.isPermanente(), dto.getTipoMarcador());
	}

	/**
	 * Convierte un Marcador a un MarcadorDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static MarcadorDTO entityToMarcadorDTO(Marcador ent) {
		if (ent == null) {
			return null;
		}
		return new MarcadorDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getTipoPresentacion(),
				ent.getTipoPunta(), ent.isPermanente(), ent.getTipoMarcador());
	}

	/**
	 * Convierte una lista de Marcador a una lista de MarcadorDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<MarcadorDTO> listaMarcadorToListaMarcadorDTO(ArrayList<Marcador> listaEntidad) {
		ArrayList<MarcadorDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Marcador mar : listaEntidad) {
			listaDTO.add(entityToMarcadorDTO(mar));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de MarcadorDTO a una lista de Marcador.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Marcador> listaMarcadorDTOToListaMarcador(ArrayList<MarcadorDTO> listaDTO) {
		ArrayList<Marcador> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (MarcadorDTO marDto : listaDTO) {
			listaEntidad.add(dtoToMarcador(marDto));
		}
		return listaEntidad;
	}

	/**
	 * Convierte un PantalonDTO a un Pantalon.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Pantalon dtoToPantalon(PantalonDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Pantalon(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getTalla(),
				dto.getGenero(), dto.getMaterial(), dto.getTipoPantalon(), dto.getCorte(), dto.getLargo());
	}

	/**
	 * Convierte un Pantalon a un PantalonDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static PantalonDTO entityToPantalonDTO(Pantalon ent) {
		if (ent == null) {
			return null;
		}
		return new PantalonDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getTalla(),
				ent.getGenero(), ent.getMaterial(), ent.getTipoPantalon(), ent.getCorte(), ent.getLargo());
	}

	/**
	 * Convierte una lista de Pantalon a una lista de PantalonDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<PantalonDTO> listaPantalonToListaPantalonDTO(ArrayList<Pantalon> listaEntidad) {
		ArrayList<PantalonDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Pantalon pan : listaEntidad) {
			listaDTO.add(entityToPantalonDTO(pan));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de PantalonDTO a una lista de Pantalon.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Pantalon> listaPantalonDTOToListaPantalon(ArrayList<PantalonDTO> listaDTO) {
		ArrayList<Pantalon> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (PantalonDTO panDto : listaDTO) {
			listaEntidad.add(dtoToPantalon(panDto));
		}
		return listaEntidad;
	}
	
	/**
	 * Convierte un PelucheDTO a un Peluche.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Peluche dtoToPeluche(PelucheDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Peluche(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getEdadRecomendada(),
				dto.isTieneSonido(),dto.getTipoRelleno(), dto.isLavadoMaquina());
	}

	/**
	 * Convierte un Peluche a un PelucheDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static PelucheDTO entityToPelucheDTO(Peluche ent) {
		if (ent == null) {
			return null;
		}
		return new PelucheDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(),  ent.getEdadRecomendada(),
				ent.isTieneSonido(),ent.getTipoRelleno(), ent.isLavadoMaquina());
	}

	/**
	 * Convierte una lista de Peluche a una lista de PelucheDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<PelucheDTO> listaPelucheToListaPelucheDTO(ArrayList<Peluche> listaEntidad) {
		ArrayList<PelucheDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Peluche pel : listaEntidad) {
			listaDTO.add(entityToPelucheDTO(pel));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de PelucheDTO a una lista de Peluche.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Peluche> listaPelucheDTOToListaPeluche(ArrayList<PelucheDTO> listaDTO) {
		ArrayList<Peluche> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (PelucheDTO pelDto : listaDTO) {
			listaEntidad.add(dtoToPeluche(pelDto));
		}
		return listaEntidad;
	}
	
	/**
	 * Convierte un PistolaAguaDTO a un PistolaAgua.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static PistolaAgua dtoToPistolaAgua(PistolaAguaDTO dto) {
		if (dto == null) {
			return null;
		}
		return new PistolaAgua(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getEdadRecomendada(),
				dto.getCapacidadAgua(),dto.getCantidadChorros(), dto.getAlcanceMaximo());
	}

	/**
	 * Convierte un PistolaAgua a un PistolaAguaDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static PistolaAguaDTO entityToPistolaAguaDTO(PistolaAgua ent) {
		if (ent == null) {
			return null;
		}
		return new PistolaAguaDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(),  ent.getEdadRecomendada(),
				ent.getCapacidadAgua(),ent.getCantidadChorros(), ent.getAlcanceMaximo());
	}

	/**
	 * Convierte una lista de PistolaAgua a una lista de PistolaAguaDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<PistolaAguaDTO> listaPistolaAguaToListaPistolaAguaDTO(ArrayList<PistolaAgua> listaEntidad) {
		ArrayList<PistolaAguaDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (PistolaAgua pis : listaEntidad) {
			listaDTO.add(entityToPistolaAguaDTO(pis));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de PistolaAguaDTO a una lista de PistolaAgua.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<PistolaAgua> listaPistolaAguaDTOToListaPistolaAgua(ArrayList<PistolaAguaDTO> listaDTO) {
		ArrayList<PistolaAgua> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (PistolaAguaDTO pisDto : listaDTO) {
			listaEntidad.add(dtoToPistolaAgua(pisDto));
		}
		return listaEntidad;
	}
	
	/**
	 * Convierte un TelevisorDTO a un Televisor.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Televisor dtoToTelevisor(TelevisorDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Televisor(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getPulgadas(),
				dto.getResolucion(),dto.getSistemaOperativo(), dto.getCantPuertosHDMI(), dto.getFrecuenciaHz(), dto.getAsistenteVirtual());
	}
	
	/**
	 * Convierte un Televisor a un TelevisorDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static TelevisorDTO entityToTelevisorDTO(Televisor ent) {
		if (ent == null) {
			return null;
		}
		return new TelevisorDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getPulgadas(),
				ent.getResolucion(),ent.getSistemaOperativo(), ent.getCantPuertosHDMI(), ent.getFrecuenciaHz(), ent.getAsistenteVirtual());
	}

	/**
	 * Convierte una lista de Televisor a una lista de TelevisorDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<TelevisorDTO> listaToListaTelevisorDTO(ArrayList<Televisor> listaEntidad) {
		ArrayList<TelevisorDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Televisor tel : listaEntidad) {
			listaDTO.add(entityToTelevisorDTO(tel));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de TelevisorDTO a una lista de Televisor.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Televisor> listaTelevisorDTOToListaTelevisor(ArrayList<TelevisorDTO> listaDTO) {
		ArrayList<Televisor> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (TelevisorDTO telDto : listaDTO) {
			listaEntidad.add(dtoToTelevisor(telDto));
		}
		return listaEntidad;
	}
	
	/**
	 * Convierte un SombraDTO a un Sombra.
	 *
	 * @param dto El DTO a convertir.
	 * @return La entidad UsuarioAdministrador correspondiente, o null si el DTO es
	 *         null.
	 */
	public static Sombra dtoToSombra(SombraDTO dto) {
		if (dto == null) {
			return null;
		}
		return new Sombra(dto.getNombre(), dto.getMarca(), dto.getTipoProducto(), dto.getDescripcion(),
				dto.getUrlImagen(), dto.getPrecio(), dto.getCantidad(), dto.getId(), dto.getTipoPiel(), dto.isEsApruebaDeAgua(),
				dto.getFechaVencimiento(),dto.getCantidadColores(), dto.getAcabado());
	}
	
	/**
	 * Convierte un Sombra a un SombraDTO.
	 *
	 * @param entidad La entidad a convertir.
	 * @return El DTO correspondiente, o null si la entidad es null.
	 */
	public static SombraDTO entityToSombraDTO(Sombra ent) {
		if (ent == null) {
			return null;
		}
		return new SombraDTO(ent.getNombre(), ent.getMarca(), ent.getTipoProducto(), ent.getDescripcion(),
				ent.getUrlImagen(), ent.getPrecio(), ent.getCantidad(), ent.getId(), ent.getTipoPiel(), ent.isEsApruebaDeAgua(),
				ent.getFechaVencimiento(),ent.getCantidadColores(), ent.getAcabado());
	}

	/**
	 * Convierte una lista de Sombra a una lista de SombraDTO.
	 *
	 * @param listaEntidad La lista de entidades a convertir.
	 * @return La lista de DTOs correspondiente, o una lista vacía si la entrada es
	 *         null.
	 */
	public static ArrayList<SombraDTO> listaSombraToListaSombraDTO(ArrayList<Sombra> listaEntidad) {
		ArrayList<SombraDTO> listaDTO = new ArrayList<>();
		if (listaEntidad == null) {
			return listaDTO;
		}
		for (Sombra som : listaEntidad) {
			listaDTO.add(entityToSombraDTO(som));
		}
		return listaDTO;
	}

	/**
	 * Convierte una lista de SombraDTO a una lista de Sombra.
	 *
	 * @param listaDTO La lista de DTOs a convertir.
	 * @return La lista de entidades correspondiente, o una lista vacía si la
	 *         entrada es null.
	 */
	public static ArrayList<Sombra> listaSombraDTOToListaTelevisor(ArrayList<SombraDTO> listaDTO) {
		ArrayList<Sombra> listaEntidad = new ArrayList<>();
		if (listaDTO == null) {
			return listaEntidad;
		}
		for (SombraDTO somDto : listaDTO) {
			listaEntidad.add(dtoToSombra(somDto));
		}
		return listaEntidad;
	}
	
	// metodos realizados por David, no modificar nada
	
	//Este metodo convierte todos los subproductos en forma de DTO en productos Entidad
	public static Producto productoDTOToEntity(ProductoDTO dto) {
			return switch (dto) {
			case RopaDTO ropaDto -> dtoToRopa((RopaDTO) dto);
			case JugueteDTO jugueteDto -> dtoToJuguete((JugueteDTO)dto);
			case MaquillajeDTO maquillajeDto -> dtoToMaquillaje((MaquillajeDTO) dto);
			case PapeleriaDTO papeleriaDto -> dtoToPapeleria((PapeleriaDTO) dto);
			case InstrumentoMusicalDTO insMusicalDto -> dtoToInstrumentoMusical((InstrumentoMusicalDTO)dto);
			case DispositivoElectronicoDTO dispElectronicoDto -> dtoToDispositivoElectronico((DispositivoElectronicoDTO) dto);
			default ->
			throw new IllegalArgumentException("Unexpected value: " + dto.getClass().getName());
			};
	}
	
	public static Ropa dtoToRopa(RopaDTO dto) {
		 return switch (dto) {
		case CalzadoDTO calzDto -> { 
			Ropa ropa = (dtoToCalzado((CalzadoDTO) dto));
			yield ropa;
		}
		case CamisetaDTO camistaDto -> { 
			Ropa ropa = dtoToCamiseta((CamisetaDTO) dto);
			yield ropa;
		}
		case PantalonDTO pantsDto -> { 
			Ropa ropa = (dtoToPantalon((PantalonDTO) dto));
			yield ropa;
		}
		default ->
		throw new IllegalArgumentException("Unexpected value: " + dto.getClass().getName());
		};
	}
	public static Juguete dtoToJuguete(JugueteDTO dto) {
		return switch (dto) {
		case PelucheDTO pelucheDto -> { 
			Juguete juguete = (dtoToPeluche((PelucheDTO) dto));
			yield juguete;
		}
		case LegoDTO legoDto -> { 
			Juguete juguete = (dtoToLego((LegoDTO) dto));
			yield juguete;
		}
		case PistolaAguaDTO pAguaDto -> { 
			Juguete juguete = (dtoToPistolaAgua((PistolaAguaDTO) dto));
			yield juguete;
		}
		default ->
		throw new IllegalArgumentException("Unexpected value: " + dto.getClass().getName());
		};
	}
	
	public static Maquillaje dtoToMaquillaje(MaquillajeDTO dto) {
		return switch (dto) {
		case SombraDTO sombraDto -> { 
			Maquillaje maquillaje = (dtoToSombra((SombraDTO) dto));
			yield maquillaje;
		}
		case LabialDTO labialDto -> { 
			Maquillaje maquillaje = (dtoToLabial((LabialDTO) dto));
			yield maquillaje;
		}
		case CorrectorDTO correctorDto -> { 
			Maquillaje maquillaje = (dtoToCorrector((CorrectorDTO) dto));
			yield maquillaje;
		}
		default ->
		throw new IllegalArgumentException("Unexpected value: " + dto.getClass().getName());
		};
	}
	public static Papeleria dtoToPapeleria(PapeleriaDTO dto) {
		return switch (dto) {
		case MarcadorDTO marcadorDto -> { 
			Papeleria papeleria = (dtoToMarcador((MarcadorDTO) dto));
			yield papeleria;
		}
		case CintaAdhesivaDTO cintaDto -> { 
			Papeleria papeleria = (dtoToCintaAdhesiva((CintaAdhesivaDTO) dto));
			yield papeleria;
		}
		case CuadernoDTO cuadernoDto -> { 
			Papeleria papeleria = (dtoToCuaderno((CuadernoDTO) dto));
			yield papeleria;
		}
		default ->
		throw new IllegalArgumentException("Unexpected value: " + dto.getClass().getName());
		};
	}
	public static InstrumentoMusical dtoToInstrumentoMusical(InstrumentoMusicalDTO dto) {
		return switch (dto) {
		case InstrumentoCuerdaDTO instMusicalDto -> { 
			InstrumentoMusical instrumento = (dtoToInstrumentoCuerda((InstrumentoCuerdaDTO) dto));
			yield instrumento;
		}
		case InstrumentoPercusionDTO insPerscusionDto -> { 
			InstrumentoMusical instrumento = (dtoToInstrumentoPercusion((InstrumentoPercusionDTO) dto));
			yield instrumento;
		}
		case InstrumentoVientoDTO cuadernoDto -> { 
			InstrumentoMusical instrumento = (dtoToInstrumentoViento((InstrumentoVientoDTO) dto));
			yield instrumento;
		}
		default ->
		throw new IllegalArgumentException("Unexpected value: " + dto.getClass().getName());
		};
	}
	public static DispositivoElectronico dtoToDispositivoElectronico(DispositivoElectronicoDTO dto) {
		return switch (dto) {
		case CelularDTO celularDto -> { 
			DispositivoElectronico dispElectronico = (dtoToCelular((CelularDTO) dto));
			yield dispElectronico;
		}
		case ComputadorDTO computadorDto -> { 
			DispositivoElectronico dispElectronico = (dtoToComputador((ComputadorDTO)dto));
			yield dispElectronico;
		}
		case TelevisorDTO televisorDto -> { 
			DispositivoElectronico dispElectronico = (dtoToTelevisor((TelevisorDTO)dto));
			yield dispElectronico;
		}
		default ->
		throw new IllegalArgumentException("Unexpected value: " + dto.getClass().getName());
		};
	}
	
	//conversion de entidad a dtos
	public static ProductoDTO productoEntityToDTO(Producto entity) {
	    return switch (entity) {
	        case Ropa ropa -> ropaToDTO(ropa);
	        case Juguete juguete -> jugueteToDTO(juguete);
	        case Maquillaje maquillaje -> maquillajeToDTO(maquillaje);
	        case Papeleria papeleria -> papeleriaToDTO(papeleria);
	        case InstrumentoMusical instrumento -> instrumentoMusicalToDTO(instrumento);
	        case DispositivoElectronico dispElectronico -> dispositivoElectronicoToDTO(dispElectronico);
	        default ->
	            throw new IllegalArgumentException("Unexpected value: " + entity.getClass().getName());
	    };
	}

	// ================== ROPA ==================
	public static RopaDTO ropaToDTO(Ropa entity) {
	    return switch (entity) {
	        case Calzado calzado -> entityToCalzadoDTO(calzado);
	        case Camiseta camiseta -> entityToCamisetaDTO(camiseta);
	        case Pantalon pantalon -> entityToPantalonDTO(pantalon);
	        default ->
	            throw new IllegalArgumentException("Unexpected value: " + entity.getClass().getName());
	    };
	}

	// ================== JUGUETE ==================
	public static JugueteDTO jugueteToDTO(Juguete entity) {
	    return switch (entity) {
	        case Peluche peluche -> entityToPelucheDTO(peluche);
	        case Lego lego -> entityToLegoDTO(lego);
	        case PistolaAgua pistolaAgua -> entityToPistolaAguaDTO(pistolaAgua);
	        default ->
	            throw new IllegalArgumentException("Unexpected value: " + entity.getClass().getName());
	    };
	}

	// ================== MAQUILLAJE ==================
	public static MaquillajeDTO maquillajeToDTO(Maquillaje entity) {
	    return switch (entity) {
	        case Sombra sombra -> entityToSombraDTO(sombra);
	        case Labial labial -> entityToLabialDTO(labial);
	        case Corrector corrector -> entityToCorrectorDTO(corrector);
	        default ->
	            throw new IllegalArgumentException("Unexpected value: " + entity.getClass().getName());
	    };
	}

	// ================== PAPELERIA ==================
	public static PapeleriaDTO papeleriaToDTO(Papeleria entity) {
	    return switch (entity) {
	        case Marcador marcador -> entityToMarcadorDTO(marcador);
	        case CintaAdhesiva cinta -> entityToCintaAdhesivaDTO(cinta);
	        case Cuaderno cuaderno -> entityToCuadernoDTO(cuaderno);
	        default ->
	            throw new IllegalArgumentException("Unexpected value: " + entity.getClass().getName());
	    };
	}

	// ================== INSTRUMENTO MUSICAL ==================
	public static InstrumentoMusicalDTO instrumentoMusicalToDTO(InstrumentoMusical entity) {
	    return switch (entity) {
	        case InstrumentoCuerda instCuerda -> entityToInstrumentoCuerdaDTO(instCuerda);
	        case InstrumentoPercusion instPercusion -> entityToInstrumentoPercusionDTO(instPercusion);
	        case InstrumentoViento instViento -> entityToInstrumentoVientoDTO(instViento);
	        default ->
	            throw new IllegalArgumentException("Unexpected value: " + entity.getClass().getName());
	    };
	}

	// ================== DISPOSITIVO ELECTRONICO ==================
	public static DispositivoElectronicoDTO dispositivoElectronicoToDTO(DispositivoElectronico entity) {
	    return switch (entity) {
	        case Celular celular -> entityToCelularDTO(celular);
	        case Computador computador -> entityToComputadorDTO(computador);
	        case Televisor televisor -> entityToTelevisorDTO(televisor);
	        default ->
	            throw new IllegalArgumentException("Unexpected value: " + entity.getClass().getName());
	    };
	}
}
