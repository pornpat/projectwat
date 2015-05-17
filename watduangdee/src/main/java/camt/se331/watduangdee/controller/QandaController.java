package camt.se331.watduangdee.controller;

import camt.se331.watduangdee.entity.Qanda;
import camt.se331.watduangdee.service.QandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by TEN10 on 5/17/2015.
 */
@RestController
@RequestMapping("/")
public class QandaController {

    @Autowired
    QandaService qandaService;

    @RequestMapping(value = "qanda", method = RequestMethod.GET)
    public List<Qanda> list() {
        return qandaService.getQandas();
    }


    @RequestMapping(value = "qanda", method = RequestMethod.POST)
    public
    @ResponseBody
    Qanda add(@RequestBody Qanda qanda, BindingResult bindingResult) {
        return qandaService.addQanda(qanda);
    }

    @RequestMapping(value = "qanda/{id}", method = RequestMethod.GET)
    public Qanda getQanda(@PathVariable("id") Long id) {
        return qandaService.getQanda(id);


    }
        @RequestMapping(value = "qanda/{id}",method = RequestMethod.PUT)
        public  Qanda edit(@PathVariable("id") Long id,@RequestBody Qanda qanda, BindingResult bindingResult){
            return qandaService.updateQanda(qanda);
        }

    @RequestMapping(value = "qanda/{id}",method = RequestMethod.DELETE)
    public  Qanda edit(@PathVariable("id") Long id){
        return qandaService.deleteQanda(id);
    }
}



