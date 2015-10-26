package javase02.t07;

import java.lang.annotation.*;
import java.util.Date;

/**
 * Created by akulakov on 26.10.2015.
 */

@Documented
public @interface AnnotationSubmarine {
    int version();
    String author();
}
