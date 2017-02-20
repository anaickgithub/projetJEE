package hei.projetJEE.service.impl;

import hei.projetJEE.dao.URLPersoDao;
import hei.projetJEE.entity.URLPerso;
import hei.projetJEE.service.URLPersoService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by nicol on 10/02/2017.
 */

@Named
@Transactional
public class URLPersoServiceImpl implements URLPersoService{

    @Inject
    private URLPersoDao urlPersoDao;

    public List<URLPerso> findAll() {
        return urlPersoDao.findAll();
    }

    public URLPerso findOneByUrl(String url) {
        return urlPersoDao.findOneByUrl(url);
    }

    public void save(URLPerso urlPerso) {
        urlPersoDao.save(urlPerso);
    }

    public int deleteById(int id) {
        return urlPersoDao.deleteById(id);
    }

    public String getLastURLPerso() {
        return urlPersoDao.getLastURLPerso();
    }
}
