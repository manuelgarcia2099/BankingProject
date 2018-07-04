package com.gmp.banking.services;

import com.gmp.banking.bean.TbCliente;
import com.gmp.banking.mapper.ClienteMapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
@Service("clienteService")
public class ClienteService {

	@Autowired
    private ClienteMapper mapper;

    public TbCliente ObtenerUnRegistro(TbCliente record) throws DataAccessException {
        TbCliente objeto= mapper.ObtenerUnRegistro(record);
        return objeto;
    }

    public List<TbCliente> ObtenerRegistros(TbCliente record) throws DataAccessException {
        List<TbCliente> lista= mapper.ObtenerRegistros(record);
        return lista;
    }

    @Transactional
    public int insert(TbCliente record) throws DataAccessException, DuplicateKeyException {
         return mapper.insert(record);
    }

    @Transactional
    public int insertSelective(TbCliente record) throws DataAccessException, DuplicateKeyException {
         return mapper.insertSelective(record);
    }

    public TbCliente selectByPrimaryKey(Integer code_cli) throws DataAccessException {
        TbCliente objeto= mapper.selectByPrimaryKey(code_cli);
        return objeto;
    }

    @Transactional
    public int updateByPrimaryKey(TbCliente record) throws DataAccessException, DuplicateKeyException {
         return mapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(TbCliente record) throws DataAccessException, DuplicateKeyException {
         return mapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    public int deleteByPrimaryKey(Integer code_cli) throws DataAccessException {
        return mapper.deleteByPrimaryKey(code_cli);
    }
}