package aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import runner.App;

@Aspect
public class BetCalculationServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Pointcut("execution(* service.BetCalculationService.*(..))")
    public void log() {
    }

    @Before("log()")
    public void printParameters(JoinPoint joinPoint) {
        LOGGER.debug("{} is executing.", joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        LOGGER.debug("Arguments: {}", Arrays.toString(args));
    }

    @AfterReturning(pointcut = "log()", returning = "result")
    public void printReturnValue(JoinPoint joinPoint, Object result) {
        LOGGER.debug("Result: {}", result);
    }

    @Around("log()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        LOGGER.debug("Method execution time: {} milliseconds.", elapsedTime);
        return output;
    }
}
