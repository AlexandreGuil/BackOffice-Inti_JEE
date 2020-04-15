package com.inti.fromation.projetspring.ecommerce.controlers;

import com.inti.fromation.projetspring.ecommerce.entities.Produit;
import com.inti.fromation.projetspring.ecommerce.servicies.IAdminProduitServicy;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = "/apiAdminProduit")
//@Validated
public class AdminProduitController {

    @Autowired
    @Qualifier("EshopServicyImpl")
    IAdminProduitServicy serv;

    public BufferedImage resize(BufferedImage image, int width, int height) throws IOException {
        return Thumbnails.of(image).forceSize(width, height).asBufferedImage();
    }

    @ResponseBody
    @RequestMapping(value = "/ProdPhoto", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] photoProd(@RequestParam Long idProduit) throws IOException {
        Produit produit = serv.findByIdProduit(idProduit);
        File file = new File(System.getProperty("java.io.tmpdir") + "_" + "PROD_" + idProduit + "_" + produit.getPhoto());
        return IOUtils.toByteArray(new FileInputStream(file));
    }

    @PostMapping(value = "/saveProduit/{idCategorie}")
    public void saveProduit(@RequestBody Produit produit, @PathVariable Long idCategorie) {
        serv.saveProduit(produit, idCategorie);
    }

    @DeleteMapping(value = "/deleteProduit/{idproduit}")
    public void deleteProduit(@PathVariable Long idproduit) {
        serv.deleteProduit(idproduit);
    }

    @PutMapping(value = "/updateProduit")
    public void updateProduit(@RequestBody Produit produit) {
        serv.updateProduit(produit);
    }
}
