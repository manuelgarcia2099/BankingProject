package com.gmp.banking.mapper;

import com.gmp.banking.bean.TbCliente;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public interface ClienteMapper {
    int deleteByPrimaryKey(Integer code_cli) throws DataAccessException;

    int insert(TbCliente cliente) throws DataAccessException, DuplicateKeyException;

    int insertSelective(TbCliente cliente) throws DataAccessException, DuplicateKeyException;

    TbCliente selectByPrimaryKey(Integer code_cli) throws DataAccessException;

    int updateByPrimaryKeySelective(TbCliente cliente) throws DataAccessException, DuplicateKeyException;

    int updateByPrimaryKey(TbCliente cliente) throws DataAccessException, DuplicateKeyException;

    List<TbCliente> ObtenerRegistros(TbCliente cliente) throws DataAccessException;

    TbCliente ObtenerUnRegistro(TbCliente cliente) throws DataAccessException;
}