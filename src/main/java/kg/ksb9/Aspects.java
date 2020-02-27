package kg.ksb9;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspects {
    private long startTime;

    @Before("@annotation(kg.ksb9.aspects.TimeAspect)")
    private void beforeInitDb() {
         startTime = System.nanoTime();
    }

    @After("@annotation(kg.ksb9.aspects.TimeAspect)")
    private void afterInitDb() {
        double endTime = ((System.nanoTime() - startTime)/1_000_000_000.0);
        System.out.println(endTime);
    }




}
