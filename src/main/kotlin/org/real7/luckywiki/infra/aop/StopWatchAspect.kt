package org.real7.luckywiki.infra.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Aspect
@Component
class StopWatchAspect {
    private val logger = LoggerFactory.getLogger("Execution Time Logger")
    
    @Around("execution(* org.real7.luckywiki.domain..*(..))") // 도메인 내 전체 메서드에 적용
    fun run(joinPoint: ProceedingJoinPoint): Any? {
        val stopWatch = StopWatch()

        stopWatch.start()
        val result = joinPoint.proceed()
        stopWatch.stop()

        // 호출된 메서드에 대한 정보
        val className =
            joinPoint.signature.declaringTypeName // package + class name
        val methodName = joinPoint.signature.name // method name
        val methodArguments = joinPoint.args // method arguments

        // 수행 시간
        val timeElapsedMs = stopWatch.totalTimeMillis // elapsed time

        logger.info(
            "{} - {} | Arguments: {} | Execution Time: {}ms",
            className,
            methodName,
            methodArguments.joinToString(", "),
            timeElapsedMs
        )

        return result
    }
}