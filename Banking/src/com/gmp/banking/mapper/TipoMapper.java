package com.gmp.banking.mapper;

import com.gmp.banking.bean.TbTipo;
import java.util.List;
import org.springframework.dao.DataAccessException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public interface TipoMapper {

	List<TbTipo> ObtenerRegistros(TbTipo tipo) throws DataAccessException;

	TbTipo ObtenerUnRegistro(TbTipo tipo) throws DataAccessException;
}