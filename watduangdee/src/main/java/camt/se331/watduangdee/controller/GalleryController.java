package camt.se331.watduangdee.controller;

import camt.se331.watduangdee.entity.Gallery;
import camt.se331.watduangdee.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Asus N46V on 18/5/2558.
 */
@RestController
@RequestMapping("/")
public class GalleryController {
    @Autowired
    GalleryService galleryService;

    @RequestMapping(value = "gallery",method = RequestMethod.GET)
    public  List<Gallery> list(){
        return galleryService.getGallerys();
    }


    @RequestMapping(value = "getGallery",method = RequestMethod.GET)
    public List<Gallery> getListByName(@RequestParam("name")String name){
        return galleryService.getGallerysByName(name);
    }
    @RequestMapping(value = "gallery",method = RequestMethod.POST)
    public @ResponseBody Gallery add(@RequestBody Gallery gallery, BindingResult bindingResult){
        return galleryService.addGallery(gallery);
    }

    @RequestMapping(value = "gallery/{id}",method = RequestMethod.GET)
    public  Gallery getProduct(@PathVariable("id") Long id){
        return galleryService.getGallery(id);
    }

    @RequestMapping(value = "gallery/{id}",method = RequestMethod.PUT)
    public  Gallery edit(@PathVariable("id") Long id,@RequestBody Gallery gallery, BindingResult bindingResult){
        return galleryService.updateGallery(gallery);
    }

    @RequestMapping(value = "gallery/{id}",method = RequestMethod.DELETE)
    public  Gallery edit(@PathVariable("id") Long id){
        return galleryService.deleteGallery(id);
    }
}

