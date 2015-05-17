package camt.se331.watduangdee.dao;

import camt.se331.watduangdee.entity.Qanda;

import java.util.List;

/**
 * Created by TEN10 on 5/17/2015.
 */
public interface QandaDao {
    List<Qanda> getQandas();
    Qanda getQanda (Long id);
    Qanda addQanda(Qanda qanda);
    Qanda updateQanda(Qanda qanda);

}
