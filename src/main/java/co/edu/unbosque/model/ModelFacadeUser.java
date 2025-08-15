package co.edu.unbosque.model;



import co.edu.unbosque.model.persistence.UsuarioDAO;

public class ModelFacadeUser {

	private UsuarioDAO usuariodao;

	public ModelFacadeUser() {
		
		 this.usuariodao = new UsuarioDAO();
	

	}

	

	public UsuarioDAO getUsuariodao() {
		return usuariodao;
	}

	public void setUsuariodao(UsuarioDAO usuariodao) {
		this.usuariodao = usuariodao;
	}

	@Override
	public String toString() {
		return "ModelFacadeUser [ usuariodao=" + usuariodao + "]";
	}

}
