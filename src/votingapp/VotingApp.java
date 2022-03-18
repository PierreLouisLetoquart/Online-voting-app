package votingapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import votingapp.view.EntryView;

/**
 *
 * @author pll
 */

public class VotingApp {

    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) throws NoSuchAlgorithmException {
        /**/
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EntryView().setVisible(true);
            }
        });
        /**/
        
    }
    
    public static String sha(String password) throws NoSuchAlgorithmException {
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<byteData.length;i++) {
            String hex=Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        
        return hexString.toString();
    }
    
    
}
