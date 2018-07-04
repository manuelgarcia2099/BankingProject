package com.gmp.banking.business;

import com.gmp.banking.bean.TbTipo;
import com.gmp.banking.business.BusinessTipo;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public class BusinessTipoImpl extends GetServices implements BusinessTipo {
    static final Logger log = Logger.getLogger(BusinessTipoImpl.class);

    @Override
    public List<TbTipo> listarTipo(TbTipo tipo) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business listarBTipo");
		if (tipo != null)
			 return getTipoService().ObtenerRegistros(tipo);
		 return null;

    }

    @Override
    public TbTipo obtenerTipo(TbTipo tipo) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business obtenerBTipo");
		if (tipo != null)
			 return getTipoService().ObtenerUnRegistro(tipo);
		 return null;

    }

}