package hei.projetjee.service.impl;

import hei.projetjee.dao.URLPersoDao;
import hei.projetjee.entity.URLPerso;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by nicol on 10/02/2017.
 */

@Named
@Transactional
public class URLPersoServiceImpl implements hei.projetjee.service.URLPersoService {

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

    public void delete(long id) {
        urlPersoDao.delete(id);
    }

    public URLPerso getLastURLPerso() { return urlPersoDao.getLastURLPerso(); }
}
