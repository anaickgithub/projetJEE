package hei.projetjee.service;

import hei.projetjee.entity.URLPerso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nicol on 10/02/2017.
 */
public interface URLPersoService {

    List<URLPerso> findAll();

    URLPerso findOneByUrl(String url);

    void save(URLPerso urlPerso);

    void delete(long id);

    URLPerso getLastURLPerso();

}
