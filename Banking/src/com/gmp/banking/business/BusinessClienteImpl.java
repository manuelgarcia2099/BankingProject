package com.gmp.banking.business;

import com.gmp.banking.bean.TbCliente;
import com.gmp.banking.business.BusinessCliente;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public class BusinessClienteImpl extends GetServices implements BusinessCliente {
    static final Logger log = Logger.getLogger(BusinessClienteImpl.class);

    @Override
    public List<TbCliente> listarCliente(TbCliente cliente) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business listarCliente");
		if (cliente != null)
			 return getClienteService().ObtenerRegistros(cliente);
		 return null;

    }

    @Override
    public TbCliente obtenerCliente(TbCliente cliente) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business obtenerCliente");
		if (cliente != null)
			 return getClienteService().ObtenerUnRegistro(cliente);
		 return null;

    }

    @Override
    public int insertarCliente(TbCliente cliente) throws DataAccessException, DuplicateKeyException, Exception {
        log.debug("Estoy en el Metodo Business insertarCliente");
		if (cliente != null){
			return getClienteService().insertSelective(cliente);
		 }
		return -1;
    }

    @Override
    public int actualizarCliente(TbCliente cliente) throws DataAccessException, DuplicateKeyException, Exception {
        log.debug("Estoy en el Metodo Business actualizarCliente");
		if (cliente != null){
//			return getClienteService().updateByPrimaryKeySelective(cliente);
			return getClienteService().updateByPrimaryKey(cliente);
		 }
		return -1;
    }

    @Override
    public int eliminarCliente(Integer code_cli) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business eliminarCliente");
		if (code_cli != null){
			return getClienteService().deleteByPrimaryKey(code_cli);
			//return getClienteService().updateByPrimaryKeySelective(cliente);
		 }
		return -1;
    }
}