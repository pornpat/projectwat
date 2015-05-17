package camt.se331.watduangdee.controller;

import camt.se331.watduangdee.entity.Gallery;
import camt.se331.watduangdee.entity.Image;
import camt.se331.watduangdee.entity.Product;
import camt.se331.watduangdee.service.GalleryService;
import camt.se331.watduangdee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Iterator;

@Controller
@RequestMapping("/galleryImage")
public class GalleryImageController {
    @Autowired
    GalleryService galleryService;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Gallery addImage(HttpServletRequest request,
                            HttpServletResponse response,@RequestParam("galleryid")Long galleryId){
        MultipartHttpServletRequest mRequest;
        Gallery gallery = galleryService.getGallery(galleryId);
        try{
            mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> itr= mRequest.getFileNames();
            while(itr.hasNext()){
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Image image = new Image();
                image.setFileName(multipartFile.getName());
                image.setContentType(multipartFile.getContentType());
                image.setContent(multipartFile.getBytes());;
                image.setCreated(Calendar.getInstance().getTime());
                galleryService.addImage(gallery,image);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return gallery;
    }
}