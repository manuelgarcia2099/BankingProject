package com.gmp.banking.mapper;

import com.gmp.banking.bean.TbEstado;
import java.util.List;
import org.springframework.dao.DataAccessException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public interface EstadoMapper {

	List<TbEstado> ObtenerRegistros(TbEstado estado) throws DataAccessException;

	TbEstado ObtenerUnRegistro(TbEstado estado) throws DataAccessException;
	
}