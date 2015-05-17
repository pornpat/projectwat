package camt.se331.watduangdee.service;

import camt.se331.watduangdee.entity.Product;
import camt.se331.watduangdee.entity.Qanda;

import java.util.List;

/**
 * Created by TEN10 on 5/17/2015.
 */
public interface QandaService {

    List<Qanda> getQandas();
    Qanda getQanda (Long id);
    Qanda addQanda(Qanda qanda);
    Qanda updateQanda(Qanda qanda);
    Qanda deleteQanda(Long id);
}
