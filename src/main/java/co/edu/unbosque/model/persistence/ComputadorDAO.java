package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Computador;
import co.edu.unbosque.model.ComputadorDTO;

public class ComputadorDAO implements OperacionDAO<ComputadorDTO, Computador>{

	@Override
	public boolean crear(ComputadorDTO nuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(ComputadorDTO eliminado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Computador find(Computador toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ComputadorDTO previo, ComputadorDTO nuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return null;
	}

}
