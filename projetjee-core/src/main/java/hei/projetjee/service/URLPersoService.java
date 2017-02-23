package hei.projetjee.service;

import hei.projetjee.entity.URLPerso;

import java.util.List;

/**
 * Created by nicol on 10/02/2017.
 */
public interface URLPersoService {

    List<URLPerso> findAll();

    URLPerso findOneByUrl(String url);

    void save(URLPerso urlPerso);

    int deleteById(int id);

    URLPerso getLastURLPerso();

}
