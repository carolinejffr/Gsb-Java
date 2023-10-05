package gsb.modele;

public class Localite 
{
    public Localite(String codePostal, String ville) 
    {
        this.codePostal = codePostal;
        this.ville = ville;
    }

    protected String codePostal;
    protected String ville;
    public String getCodePostal() 
    {
        return codePostal;
    }
    public void setCodePostal(String codePostal) 
    {
        this.codePostal = codePostal;
    }
    public String getVille() 
    {
        return ville;
    }
    public void setVille(String ville) 
    {
        this.ville = ville;
    }
}
