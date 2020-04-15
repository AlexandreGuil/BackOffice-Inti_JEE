package ecommerce;

import com.inti.fromation.projetspring.ecommerce.entities.Categorie;
import com.inti.fromation.projetspring.ecommerce.entities.Produit;
import com.inti.fromation.projetspring.ecommerce.servicies.IAdminCategorieServicy;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestAppEshop {

    ClassPathXmlApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});

    }

    @Test
    public void AddCategorie() {
        try {

            IAdminCategorieServicy metier = (IAdminCategorieServicy) context.getBean("metier");
            List<Categorie> CAT1 = metier.findAllCategories();
            metier.saveCategorie(new Categorie(1L,
                    "laptop",
                    null,
                    "laptop de toute marque et de tout systeme d'exploitation"));
            metier.saveCategorie(new Categorie(2L,
                    "smart-phone",
                    null,
                    "Smart phone for speak with all your friends"));
            List<Categorie> CAT2 = metier.findAllCategories();
            context.close();
            if(CAT1.size() + 2 == CAT2.size())
                assertTrue(true);
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }

    }

    @Test
    public void AddProduit() {
        try {

            IAdminCategorieServicy metier = (IAdminCategorieServicy) context.getBean("metier");
            List<Produit> PROD1 = metier.findAllproduits();
            metier.saveProduit(new Produit(1L,"Macbook Pro (2017)",
                    "The ultimate pro notebook. MacBook Pro features faster processors ;upgraded memory;the Apple T2 chip;and a Retina display with True Tone technology.",
                    1299,3,true,
                    "src/img/image1.jpg"),
                    1L);
            metier.saveProduit(new Produit(2L,"Iphone X",
                    "The iPhone X display is so immersive the device itself disappears into the experience.",
                    799,5,false,
                    "src/img/image2.jpg"),
                    2L);
            List<Produit> PROD2 = metier.findAllproduits();
            context.close();
            if(PROD1.size() + 2 == PROD2.size())
                assertTrue(true);
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
    }
}
