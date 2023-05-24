package Grupo4TBD.VoluntariosTBD.Services;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import Grupo4TBD.VoluntariosTBD.RepositoriesImplement.UsuarioRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsuarioRepositoryImp usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepository.findByEmail(email);
    if (usuario == null) {
      throw new UsernameNotFoundException("El usuario con email " + email + "no existe");
    }
    return new UserDetailsImp(usuario);
  }

}
