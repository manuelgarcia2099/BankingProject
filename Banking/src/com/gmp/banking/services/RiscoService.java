package com.gmp.banking.services;

import com.gmp.banking.bean.TbRisco;
import com.gmp.banking.mapper.RiscoMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
@Service("riscoService")
public class RiscoService {

	@Autowired
    private RiscoMapper mapper;
	
    public TbRisco ObtenerUnRegistro(TbRisco record) throws DataAccessException {
        TbRisco objeto= mapper.ObtenerUnRegistro(record);
        return objeto;
    }
    
    public List<TbRisco> ObtenerRegistros(TbRisco record) throws DataAccessException {
        List<TbRisco> lista= mapper.ObtenerRegistros(record);
        return lista;
    }

}