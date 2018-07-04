package com.gmp.banking.managedBean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import com.gmp.banking.bean.TbUsuario;
import com.gmp.banking.business.BusinessUsuario;
import com.gmp.banking.business.BusinessUsuarioImpl;
import com.gmp.banking.utils.Constantes;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 3865315765817497135L;
	private static Logger log = Logger.getLogger(LoginBean.class);

	private TbUsuario usuarioLogin = new TbUsuario();
	private transient BusinessUsuario businessUsuario = new BusinessUsuarioImpl();	

	public boolean logeado = false;

	RequestContext context = RequestContext.getCurrentInstance();
	FacesContext jsfCtx= FacesContext.getCurrentInstance();
	ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msg");

	FacesMessage msg = null;

	public LoginBean() {
		if(usuarioLogin != null) {
			log.debug(usuarioLogin.toString());
		}
	}

	public String login() {

		RequestContext context = RequestContext.getCurrentInstance();		
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) ctx.getSession(false);

		try {
			TbUsuario usuarioLogeado = new TbUsuario();

			usuarioLogeado.setEmai_use(usuarioLogin.getEmai_use());
			usuarioLogeado.setPass_use(usuarioLogin.getPass_use());

			usuarioLogin = businessUsuario.login(usuarioLogeado);

			if (usuarioLogin == null) {

				usuarioLogin = new TbUsuario();
				logeado = false;
				session.invalidate();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("msg.error"), bundle.getString("msg.loginbean.credencialesinvalidas")));

			} else {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("msg.loginbean.bienvenido"), usuarioLogin.getName_use());

				session.setAttribute(Constantes.VC_ATRIBUTO_SESION, usuarioLogin);
				logeado = true;
			}
		} catch (Exception e) {
			msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, bundle.getString("msg.errorinterno"),"");
			logeado = false;
		}

		if (logeado) {
			context.addCallbackParam("estaLogeado", logeado);			
			return "/"+Constantes.VC_RUTA_CLIENTE+"?faces-redirect=true";	
		}

		return "";
	}

	public String logout() {

		logeado = false;
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

		try {
			((HttpSession) ctx.getSession(true)).removeAttribute(Constantes.VC_ATRIBUTO_SESION);
			((HttpSession) ctx.getSession(false)).invalidate();

			ctx.redirect(ctxPath.toString());

		} catch (IOException ex) {
			log.debug("IOException: " + ex,ex);
		}
		return null;
	}

	public TbUsuario getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(TbUsuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public boolean isLogeado() {
		return logeado;
	}

	public void setLogeado(boolean logeado) {
		this.logeado = logeado;
	}

}
