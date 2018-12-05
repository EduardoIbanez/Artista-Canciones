package dci.ufro.cl.artistascanciones.model.data;

import dci.ufro.cl.artistascanciones.model.Estilo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EstiloDAO extends CrudRepository<Estilo, Integer> {

//    public estilo findByNombre (nom);
}
