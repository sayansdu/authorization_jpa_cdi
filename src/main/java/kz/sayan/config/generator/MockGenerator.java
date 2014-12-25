package kz.sayan.config.generator;

import javax.enterprise.inject.Alternative;

/**
 * User: Sayan.Zhumashev
 * Date: 7/16/14
 * Time: 5:36 PM
 */
@Alternative
public class MockGenerator implements NumberGenerator {

    @Override
    public String generateNumber() {
        return "mock-" + String.valueOf(Math.round(9999999+Math.random()*10000000));
    }
}
