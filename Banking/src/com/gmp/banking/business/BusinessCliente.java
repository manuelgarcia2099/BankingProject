package com.gmp.banking.business;

import com.gmp.banking.bean.TbCliente;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public interface BusinessCliente {
    List<TbCliente> listarCliente(TbCliente cliente) throws DataAccessException, Exception;

    TbCliente obtenerCliente(TbCliente cliente) throws DataAccessException, Exception;

    int insertarCliente(TbCliente cliente) throws DataAccessException, DuplicateKeyException, Exception;

    int actualizarCliente(TbCliente cliente) throws DataAccessException, DuplicateKeyException, Exception;

    int eliminarCliente(Integer code_cli) throws DataAccessException, Exception;
}