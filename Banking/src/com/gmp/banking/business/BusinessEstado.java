package com.gmp.banking.business;

import com.gmp.banking.bean.TbEstado;
import java.util.List;
import org.springframework.dao.DataAccessException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public interface BusinessEstado {

	List<TbEstado> listarEstado(TbEstado estado) throws DataAccessException, Exception;

    TbEstado obtenerEstado(TbEstado estado) throws DataAccessException, Exception;

}