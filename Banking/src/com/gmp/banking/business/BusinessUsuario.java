package com.gmp.banking.business;

import com.gmp.banking.bean.TbUsuario;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public interface BusinessUsuario {
    List<TbUsuario> listarUsuario(TbUsuario usuario) throws DataAccessException, Exception;

    TbUsuario obtenerUsuario(TbUsuario usuario) throws DataAccessException, Exception;

    int insertarUsuario(TbUsuario usuario) throws DataAccessException, DuplicateKeyException, Exception;

    int actualizarUsuario(TbUsuario usuario) throws DataAccessException, DuplicateKeyException, Exception;

    int eliminarUsuario(TbUsuario usuario) throws DataAccessException, Exception;
    
 // Login
    public TbUsuario login(TbUsuario usuario) throws DataAccessException, Exception;

}