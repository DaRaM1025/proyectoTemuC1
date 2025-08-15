package co.edu.unbosque.model.persistence;

public interface OperacionDAO<D, E> {
	public boolean crear(D nuevo);

	public boolean eliminar(D eliminado);

	public E find(E toFind);

	public boolean update(D previo, D nuevo);

	public String mostrar();
}
