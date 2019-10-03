package crayon13.study.springbatch.work;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j // log 사용을 위한 lombok 어노테이션
@RequiredArgsConstructor // 생성자 DI를 위한 lombok 어노테이션
@Configuration
public class SimpleJobConfiguration2 {
    private final String jobName = "SimpleJobConfiguration2";
    private final JobBuilderFactory jobBuilderFactory; // 생성자 DI 받음
    private final StepBuilderFactory stepBuilderFactory; // 생성자 DI 받음

    @Bean
    public Job simpleJob2() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>> {} start!!!!!!!!", jobName);

        return jobBuilderFactory.get(jobName)
            .start(simpleStep12())
            .build();
    }

    @Bean
    public Step simpleStep12() {
        return stepBuilderFactory.get("simpleStep12")
            .tasklet((contribution, chunkContext) -> {
                log.info(">>>>> This is Step12");
                return RepeatStatus.FINISHED;
            })
            .build();
    }
}