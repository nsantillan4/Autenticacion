package confirmacion.servicios;

import java.util.HashMap;
import java.util.Map.Entry;


public class Servicios {

	private HashMap<String, String> usuarios;
	
	public  Servicios()
	{
		
	}
	
	
	public HashMap<String, String> inicializar()
	{
		this.usuarios =  new HashMap<String, String>();
		
		this.usuarios.put("privilegio", "0123");
		this.usuarios.put("privilegio2", "01234");
		this.usuarios.put("NO privilegio", "123");
		this.usuarios.put("NO privilegio2", "1234");

	    
		return this.usuarios;
	}
	
	
	public boolean autenticar(String clave)
	{
		boolean ret = false;
		
		if(clave != null && !clave.isEmpty())
		{
	

			for(String usuClave : usuarios.values())
			{
				
				if(clave.equals(usuClave))
				{
					ret = true;
				}
			}
		}
		return ret;
	}
	
	public Usuario getDetalle(String clave)
	{
		Usuario usuario = null;
		for(Entry<String, String> usuarios : usuarios.entrySet())
		{
			String usuClave = usuarios.getValue();
	
			if(clave.equals(usuClave))
			{
				String usuNombre = usuarios.getKey();
				
				usuario = new Usuario(usuNombre, clave);
			}
		}
		
		return usuario;
	}
}
