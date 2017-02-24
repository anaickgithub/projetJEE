package hei.projetjee.dao;

import hei.projetjee.entity.URLPerso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by nicol on 10/02/2017.
 */
public interface URLPersoDao extends JpaRepository<URLPerso, Long> {

    @Query(value="SELECT * FROM URLPerso where perso=false ORDER BY id DESC Limit 0,1" , nativeQuery=true)
    URLPerso getLastURLPerso();

    URLPerso findOneByUrl(String url);

    URLPerso findOneByUrlCourt (String urlCourt);

}
