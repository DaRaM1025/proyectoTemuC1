package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Celular;
import co.edu.unbosque.model.CelularDTO;

public class CelularDAO implements OperacionDAO<CelularDTO, Celular> {

	@Override
	public boolean crear(CelularDTO nuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(CelularDTO eliminado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Celular find(Celular toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(CelularDTO previo, CelularDTO nuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return null;
	}

}
