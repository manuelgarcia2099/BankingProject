package com.gmp.banking.business;

import com.gmp.banking.bean.TbUsuario;
import com.gmp.banking.business.BusinessUsuario;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public class BusinessUsuarioImpl extends GetServices implements BusinessUsuario {
    static final Logger log = Logger.getLogger(BusinessUsuarioImpl.class);

    @Override
    public List<TbUsuario> listarUsuario(TbUsuario usuario) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business listarUsuario");
		if (usuario != null)
			 return getUsuarioService().ObtenerRegistros(usuario);
		 return null;

    }

    @Override
    public TbUsuario obtenerUsuario(TbUsuario usuario) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business obtenerUsuario");
		if (usuario != null)
			 return getUsuarioService().ObtenerUnRegistro(usuario);
		 return null;

    }

    @Override
    public int insertarUsuario(TbUsuario usuario) throws DataAccessException, DuplicateKeyException, Exception {
        log.debug("Estoy en el Metodo Business insertarUsuario");
		if (usuario != null){
			return getUsuarioService().insertSelective(usuario);
		 }
		return -1;
    }

    @Override
    public int actualizarUsuario(TbUsuario usuario) throws DataAccessException, DuplicateKeyException, Exception {
        log.debug("Estoy en el Metodo Business actualizarUsuario");
		if (usuario != null){
			return getUsuarioService().updateByPrimaryKeySelective(usuario);
		 }
		return -1;
    }

    @Override
    public int eliminarUsuario(TbUsuario usuario) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business eliminarUsuario");
		if (usuario != null){
			return getUsuarioService().updateByPrimaryKeySelective(usuario);
		 }
		return -1;
    }
    
    @Override
    public TbUsuario login(TbUsuario usuario) throws DataAccessException, Exception {
        log.debug(" Business login Usuario");

        if (usuario != null){
  			return getUsuarioService().login(usuario);
  		}
  		return null;
    }
}