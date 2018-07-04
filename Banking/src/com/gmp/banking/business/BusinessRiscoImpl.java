package com.gmp.banking.business;

import com.gmp.banking.bean.TbRisco;
import com.gmp.banking.business.BusinessRisco;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public class BusinessRiscoImpl extends GetServices implements BusinessRisco {
    static final Logger log = Logger.getLogger(BusinessRiscoImpl.class);

    @Override
    public List<TbRisco> listarRisco(TbRisco risco) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business listarBRisco");
		if (risco != null)
			 return getRiscoService().ObtenerRegistros(risco);
		 return null;

    }

    @Override
    public TbRisco obtenerRisco(TbRisco risco) throws DataAccessException, Exception {
        log.debug("Estoy en el Metodo Business obtenerBRisco");
		if (risco != null)
			 return getRiscoService().ObtenerUnRegistro(risco);
		 return null;

    }

}