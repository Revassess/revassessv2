package com.revature.tier6.answers;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
    Answer1Tests.class,
    Answer2Tests.class,
    Answer3Tests.class,
})
public class Tier6Test {

}