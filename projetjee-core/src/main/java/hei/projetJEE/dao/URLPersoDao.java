package hei.projetJEE.dao;

import hei.projetJEE.entity.URLPerso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by nicol on 20/02/2017.
 */
public interface URLPersoDao extends JpaRepository<URLPerso, String> {

    List<URLPerso> findAll();

    URLPerso findOneByUrl(String url);

    void save();

    int deleteById(int id);

    @Query("SELECT u.urlCourt FROM URLPerso u where u.perso=false ORDER BY u.id DESC LIMIT 0,1")
    String getLastURLPerso();

}