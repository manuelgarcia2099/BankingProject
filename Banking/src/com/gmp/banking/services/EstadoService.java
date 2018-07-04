package com.gmp.banking.services;

import com.gmp.banking.bean.TbEstado;
import com.gmp.banking.mapper.EstadoMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
@Service("estadoService")
public class EstadoService {

	@Autowired
    private EstadoMapper mapper;
	
    public TbEstado ObtenerUnRegistro(TbEstado record) throws DataAccessException {
        TbEstado objeto= mapper.ObtenerUnRegistro(record);
        return objeto;
    }

    public List<TbEstado> ObtenerRegistros(TbEstado record) throws DataAccessException {
        List<TbEstado> lista= mapper.ObtenerRegistros(record);
        return lista;
    }

}