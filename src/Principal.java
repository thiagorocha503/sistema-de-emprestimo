
import java.io.File;
import view.JanelaListagem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thiago
 */
public class Principal {
    
    public static void verificacao(){
        String path = new File("").getAbsolutePath()+"\\data";
        File data = new File(path);
        if(!data.exists()){
            data.mkdirs();
        } 
    }
    
    
    public static void main(String[] arg){
            verificacao();
            System.err.println("jdbc:sqlite" + System.getProperty("user.dir")+"src/data/dataBase.sqlite");
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        JanelaListagem janelaListagem = new JanelaListagem();
        janelaListagem.setVisible(true);
    }
}
