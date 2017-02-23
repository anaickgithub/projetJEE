package hei.projetJEE.dao;

import hei.projetJEE.entity.URLPerso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by nicol on 10/02/2017.
 */
public interface URLPersoDao extends JpaRepository<URLPerso, Long> {

    @Query(value="SELECT * FROM URLPerso where perso=false ORDER BY id DESC Limit 0,1" , nativeQuery=true)
    URLPerso getLastURLPerso();

    URLPerso findOneByUrl(String url);

    int deleteById(int id);

}
