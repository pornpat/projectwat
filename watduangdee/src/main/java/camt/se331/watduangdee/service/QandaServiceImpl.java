package camt.se331.watduangdee.service;

import camt.se331.watduangdee.dao.QandaDao;
import camt.se331.watduangdee.entity.Qanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TEN10 on 5/17/2015.
 */
@Service
public class QandaServiceImpl implements  QandaService {
    @Autowired
    QandaDao qandaDao;
    @Override
    public List<Qanda> getQandas() {
        return qandaDao.getQandas();
    }

    @Override
    public Qanda getQanda(Long id) {
        return qandaDao.getQanda(id);
    }

    @Override
    public Qanda addQanda(Qanda qanda) {
        return qandaDao.addQanda(qanda);
    }

    @Override
    public Qanda updateQanda(Qanda qanda) {
        return qandaDao.updateQanda(qanda);
    }
}
