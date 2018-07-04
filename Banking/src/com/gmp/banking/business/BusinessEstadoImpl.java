package com.gmp.banking.business;

import com.gmp.banking.bean.TbEstado;
import com.gmp.banking.business.BusinessEstado;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public class BusinessEstadoImpl extends GetServices implements BusinessEstado {
    static final Logger log = Logger.getLogger(BusinessEstadoImpl.class);

    @Override
    public List<TbEstado> listarEstado(TbEstado estado) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business listarBEstado");
		if (estado != null)
			 return getEstadoService().ObtenerRegistros(estado);
		 return null;

    }
    @Override
    public TbEstado obtenerEstado(TbEstado estado) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business obtenerBEstado");
		if (estado != null)
			 return getEstadoService().ObtenerUnRegistro(estado);
		 return null;

    }
}