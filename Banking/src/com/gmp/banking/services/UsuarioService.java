package com.gmp.banking.services;

import com.gmp.banking.bean.TbUsuario;
import com.gmp.banking.mapper.UsuarioMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
@Service("usuarioService")
public class UsuarioService {
	
	static final Logger log = Logger.getLogger(UsuarioService.class);


	@Autowired
    private UsuarioMapper mapper;

    public TbUsuario ObtenerUnRegistro(TbUsuario record) throws DataAccessException {
        TbUsuario objeto= mapper.ObtenerUnRegistro(record);
        return objeto;
    }

    public List<TbUsuario> ObtenerRegistros(TbUsuario record) throws DataAccessException {
        List<TbUsuario> lista= mapper.ObtenerRegistros(record);
        return lista;
    }

    @Transactional
    public int insert(TbUsuario record) throws DataAccessException, DuplicateKeyException {
         return mapper.insert(record);
    }

    @Transactional
    public int insertSelective(TbUsuario record) throws DataAccessException, DuplicateKeyException {
         return mapper.insertSelective(record);
    }

    public TbUsuario selectByPrimaryKey(Integer code_use) throws DataAccessException {
        TbUsuario objeto= mapper.selectByPrimaryKey(code_use);
        return objeto;
    }

    @Transactional
    public int updateByPrimaryKey(TbUsuario record) throws DataAccessException, DuplicateKeyException {
         return mapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int updateByPrimaryKeySelective(TbUsuario record) throws DataAccessException, DuplicateKeyException {
         return mapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    public int deleteByPrimaryKey(Integer code_use) throws DataAccessException {
        return mapper.deleteByPrimaryKey(code_use);
    }
    
    // Login 
    public TbUsuario login(TbUsuario usuario){
    	log.debug("Usuario mapper: " + mapper);
    	log.debug("info usuario: " + usuario.getEmai_use() + " " + usuario.getPass_use());


    	TbUsuario usuario_login = mapper.ObtenerUnRegistro(usuario);

    	if (usuario_login!=null){
    		log.debug("Nome Usuario: " + usuario_login.getName_use() +" - Sobrenome Usuario: " + usuario_login.getSobr_use());
    	}

    	return usuario_login;
    }
    
    
    
}