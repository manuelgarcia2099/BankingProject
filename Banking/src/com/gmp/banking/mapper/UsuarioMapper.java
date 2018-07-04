package com.gmp.banking.mapper;

import com.gmp.banking.bean.TbUsuario;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public interface UsuarioMapper {
    int deleteByPrimaryKey(Integer code_use) throws DataAccessException;

    int insert(TbUsuario usuario) throws DataAccessException, DuplicateKeyException;

    int insertSelective(TbUsuario usuario) throws DataAccessException, DuplicateKeyException;

    TbUsuario selectByPrimaryKey(Integer code_use) throws DataAccessException;

    int updateByPrimaryKeySelective(TbUsuario usuario) throws DataAccessException, DuplicateKeyException;

    int updateByPrimaryKey(TbUsuario usuario) throws DataAccessException, DuplicateKeyException;

    List<TbUsuario> ObtenerRegistros(TbUsuario usuario) throws DataAccessException;

    TbUsuario ObtenerUnRegistro(TbUsuario usuario) throws DataAccessException;
}