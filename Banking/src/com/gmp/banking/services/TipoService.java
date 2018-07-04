package com.gmp.banking.services;

import com.gmp.banking.bean.TbTipo;
import com.gmp.banking.mapper.TipoMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
@Service("tipoService")
public class TipoService {

	@Autowired
    private TipoMapper mapper;

	public TbTipo ObtenerUnRegistro(TbTipo record) throws DataAccessException {
        TbTipo objeto= mapper.ObtenerUnRegistro(record);
        return objeto;
    }

    public List<TbTipo> ObtenerRegistros(TbTipo record) throws DataAccessException {
        List<TbTipo> lista= mapper.ObtenerRegistros(record);
        return lista;
    }

}