package camt.se331.watduangdee.dao;

import camt.se331.watduangdee.entity.Qanda;
import camt.se331.watduangdee.repository.ProductRepository;
import camt.se331.watduangdee.repository.QandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TEN10 on 5/17/2015.
 */
@Repository
public class DbQandaDao implements  QandaDao {
    @Autowired
    QandaRepository qandaRepository;

    @Override
    public List<Qanda> getQandas() {
        return qandaRepository.findAll();
    }

    @Override
    public Qanda getQanda(Long id) {
        return qandaRepository.findOne(id);
    }

    @Override
    public Qanda addQanda(Qanda qanda) {
        return qandaRepository.save(qanda);
    }

    @Override
    public Qanda updateQanda(Qanda qanda) {
        return qandaRepository.save(qanda);
    }
}
