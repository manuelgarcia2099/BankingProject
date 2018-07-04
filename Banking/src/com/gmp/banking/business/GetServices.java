package com.gmp.banking.business;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.gmp.banking.services.ClienteService;
import com.gmp.banking.services.EstadoService;
import com.gmp.banking.services.RiscoService;
import com.gmp.banking.services.TipoService;
import com.gmp.banking.services.UsuarioService;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public class GetServices {	
	private ApplicationContext cntx = ContextLoader.getCurrentWebApplicationContext();
	
	public GetServices(){		
	}
	
	private ClienteService clienteService = (ClienteService)cntx.getBean("clienteService");
	private EstadoService estadoService = (EstadoService)cntx.getBean("estadoService");
	private RiscoService riscoService = (RiscoService)cntx.getBean("riscoService");
	private TipoService tipoService = (TipoService)cntx.getBean("tipoService");
	private UsuarioService usuarioService = (UsuarioService)cntx.getBean("usuarioService");

	public ClienteService getClienteService() {
		return clienteService;
	}

	public EstadoService getEstadoService() {
		return estadoService;
	}

	public RiscoService getRiscoService() {
		return riscoService;
	}

	public TipoService getTipoService() {
		return tipoService;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	
}
