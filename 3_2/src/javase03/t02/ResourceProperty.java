package javase03.t02;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import static java.lang.System.out;
/**
 * Created by akulakov on 28.10.2015.
 */
public class ResourceProperty {

    private ResourceBundle bundle;

    public ResourceProperty(String filename, Locale locale) {

        bundle = ResourceBundle.getBundle(filename, locale);

    }

        public Set<String> getKeys() {
            return bundle.keySet();
        }

        public String getValue(String key) {

         //   try {
                return bundle.getString(key);
        //    }catch (MissingResourceException e) {
         //       e.printStackTrace();
       //     }
        }
}
