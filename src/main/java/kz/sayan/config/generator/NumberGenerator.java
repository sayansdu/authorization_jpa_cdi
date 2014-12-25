package kz.sayan.config.generator;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

/**
 * User: Sayan.Zhumashev
 * Date: 7/16/14
 * Time: 5:36 PM
 */

public interface NumberGenerator extends Serializable {

    public String generateNumber();

}
