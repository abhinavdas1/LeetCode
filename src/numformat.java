/**
 * Created by abhinavdas on 1/22/17.
 */
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.text.*;
import java.util.Locale;
import java.math.*;
public class numformat {
    public static void numfor()
    {
        float a=7;
        DecimalFormat df=new DecimalFormat("0.00");
//        a=Float.parseFloat(df.format(a));
        System.out.println(df.format(a));
    }
}
