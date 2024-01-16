package Objetos;

public class Usuario {
	private String nombreUsuario;
	private String contrasenyaUsuario;

	public Usuario() {
		this.nombreUsuario="";
		this.contrasenyaUsuario="";
	}
	public Usuario(String nombre, String contrasenya) {
		this.nombreUsuario=nombre;
		this.contrasenyaUsuario = contrasenya;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasenyaUsuario() {
		return contrasenyaUsuario;
	}
	public void setContrasenyaUsuario(String contrasenyaUsuario) {
		this.contrasenyaUsuario = contrasenyaUsuario;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Usuario) {
			Usuario nuevo = (Usuario) obj;
			if(nuevo.getNombreUsuario().equals(this.getNombreUsuario())) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.nombreUsuario.hashCode();
	}

}
