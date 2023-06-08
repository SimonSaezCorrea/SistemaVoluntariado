package Grupo4TBD.VoluntariosTBD.Services;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.UsuarioRepository;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsuarioRepository usuarioRepository;
  @Autowired
  private VoluntarioRepository voluntarioRepository;

  @Override
  public UserDetailsImp loadUserByUsername(String email) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepository.findByEmail(email);
    if (usuario == null) {
      throw new UsernameNotFoundException("El usuario con email " + email + "no existe");
    }
    Voluntario voluntario = voluntarioRepository.findByUsuario(usuario.getId());
    if (voluntario == null) {
      throw new UsernameNotFoundException("El usuario con email " + email + "no existe");
    }
    return new UserDetailsImp(usuario, voluntario.getNombre());
  }

}
