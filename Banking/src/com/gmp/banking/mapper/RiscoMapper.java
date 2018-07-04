package com.gmp.banking.mapper;

import com.gmp.banking.bean.TbRisco;
import java.util.List;
import org.springframework.dao.DataAccessException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public interface RiscoMapper {
	
    List<TbRisco> ObtenerRegistros(TbRisco risco) throws DataAccessException;
    
    TbRisco ObtenerUnRegistro(TbRisco risco) throws DataAccessException;
}