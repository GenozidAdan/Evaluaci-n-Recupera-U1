package mx.edu.utez.Integradora.service.impl;

import mx.edu.utez.Integradora.model.dao.UsuarioDao;
import mx.edu.utez.Integradora.model.dto.UsuarioDto;
import mx.edu.utez.Integradora.model.entidad.UsuarioBean;
import mx.edu.utez.Integradora.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioImpl implements IUsuario {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UsuarioBean save(UsuarioDto usuarioDto) {
        UsuarioBean usuario = UsuarioBean.builder()
                .idusuario(usuarioDto.getIdusuario())
                .username(usuarioDto.getUsername())
                .estado(usuarioDto.isEstado())
                .password(usuarioDto.getPassword())
                .build();
        return usuarioDao.save(usuario);
    }

    @Override
    public UsuarioBean findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public List<UsuarioBean> findAll() {
        return (List<UsuarioBean>) usuarioDao.findAll();
    }

    @Override
    public void delete(UsuarioBean usuario) {
        usuarioDao.delete(usuario);
    }
}
