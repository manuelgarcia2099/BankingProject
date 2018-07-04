package com.gmp.banking.business;

import com.gmp.banking.bean.TbRisco;
import java.util.List;
import org.springframework.dao.DataAccessException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public interface BusinessRisco {
	
    List<TbRisco> listarRisco(TbRisco risco) throws DataAccessException, Exception;
    
    TbRisco obtenerRisco(TbRisco risco) throws DataAccessException, Exception;

}