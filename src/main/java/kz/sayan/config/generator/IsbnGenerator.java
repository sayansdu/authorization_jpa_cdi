package kz.sayan.config.generator;

import kz.sayan.config.annotation.NumberOfDigits;
import kz.sayan.config.annotation.ThirteenDigits;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

/**
 * User: Sayan.Zhumashev
 * Date: 7/16/14
 * Time: 5:36 PM
 */

//@ThirteenDigits
//@ApplicationScoped
@NumberOfDigits(value = NumberOfDigits.Digits.THIRTEEN, odd = false)
public class IsbnGenerator implements NumberGenerator {

    @Override
    public String generateNumber(){
        return "12345-" + String.valueOf(Math.round(9999999+Math.random()*10000000));
    }

}
