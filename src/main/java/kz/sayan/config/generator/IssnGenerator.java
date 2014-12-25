package kz.sayan.config.generator;

import kz.sayan.config.annotation.EightDigits;
import kz.sayan.config.annotation.NumberOfDigits;

/**
 * User: Sayan.Zhumashev
 * Date: 7/16/14
 * Time: 5:36 PM
 */
//@EightDigits
@NumberOfDigits(value = NumberOfDigits.Digits.EIGHT, odd = false)
public class IssnGenerator implements NumberGenerator {

    @Override
    public String generateNumber(){
        return String.valueOf(Math.round(9999999+Math.random()*10000000));
    }

}
