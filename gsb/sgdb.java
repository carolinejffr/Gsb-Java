package gsb;

import java.sql.*;

public class sgdb 
{

    public static void utiliserSgdb(String laRequete, boolean doitAfficherResultat) 
    {
        String url = "jdbc:mysql://localhost:3306/gsbV2";
        String user = "root";
        String password = "password";
        Connection con = null;
        Statement requete = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url,user,password);

            requete = con.createStatement();

            if (doitAfficherResultat == true)
            {
                ResultSet resultat = requete.executeQuery(laRequete);
                while (resultat.next()) 
                {
                    System.out.println(resultat.getString(1)+" "+resultat.getString(2));
                };// fin while
            }
            else
            {
                requete.executeUpdate(laRequete);
            }
            

        }
        catch(Exception e) 
        {

        System.out.println("Echec SGDB");

        e.printStackTrace();

        }
        finally
        {
            try
            {
                con.close();
                requete.close();
            }
            catch(Exception e) 
            {
                e.printStackTrace();
            }
        }
    }
}