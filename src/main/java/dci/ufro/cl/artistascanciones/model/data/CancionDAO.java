package dci.ufro.cl.artistascanciones.model.data;

import dci.ufro.cl.artistascanciones.model.Cancion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CancionDAO extends CrudRepository<Cancion, Integer> {
}
