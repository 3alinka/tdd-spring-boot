package ahlev.location.repository;
/*
 * User: ohahlev@gmail.com
 * Project: api
 * Date: 8/9/20
 * Here is some description
 */

import ahlev.location.domain.Country;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface LocationRepository extends CrudRepository<Country, Integer> {

    public List<Country> findAll();
}
