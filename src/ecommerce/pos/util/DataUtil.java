
package ecommerce.pos.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DataUtil {
 
    // METODO ESTATICO QUE FORMATA A DATA PARA EXIBICAO NO FORM
    public static String formatar(Calendar data){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
        return df.format(data.getTime());
    }
}
