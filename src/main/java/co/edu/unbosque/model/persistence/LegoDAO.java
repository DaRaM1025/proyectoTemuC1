package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Lego;
import co.edu.unbosque.model.LegoDTO;

public class LegoDAO implements OperacionDAO<LegoDTO, Lego> {

	@Override
	public boolean crear(LegoDTO nuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(LegoDTO eliminado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Lego find(Lego toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(LegoDTO previo, LegoDTO nuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return null;
	}

}
