package com.gmp.banking.business;

import com.gmp.banking.bean.TbTipo;
import java.util.List;
import org.springframework.dao.DataAccessException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public interface BusinessTipo {

	List<TbTipo> listarTipo(TbTipo tipo) throws DataAccessException, Exception;

	TbTipo obtenerTipo(TbTipo tipo) throws DataAccessException, Exception;

}