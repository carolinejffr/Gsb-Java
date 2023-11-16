package gsb.tests;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

import static org.junit.Assert.*;

import org.junit.Test;

public class VisiteDaoTests {
    @Test
    public void testRechercherValide() {
        Visite uneVisite = VisiteDao.rechercher("v001");
        assertEquals("v0001", uneVisite.getReference());
    }
    public static void main(String[] args) {
        
    }
}
