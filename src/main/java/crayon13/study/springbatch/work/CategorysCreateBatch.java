package crayon13.study.springbatch.work;

import crayon13.study.springbatch.work.service.CategorysIndexService;
import crayon13.study.springbatch.work.util.JobCompletionNotificationListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

//@ConditionalOnProperty(name = "job.name", havingValue = CategorysCreateBatch.JOB_NAME)
@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class CategorysCreateBatch {
    private int batchSize = 10000;
    static final String JOB_NAME = "CategorysCreateBatch";

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final JobCompletionNotificationListener jobCompletionNotificationListener;
    private final CategorysBulkStep categorysBulkStep;

    private final CategorysIndexService categorysIndexService;

    @Bean
    public Job categorysCreateJob() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>> {} start!!!!!!!!", JOB_NAME);

        return jobBuilderFactory.get(JOB_NAME)
            .start(createCategorysStep())
            .next(bulkCategorysForCreateStep())
            .listener(jobCompletionNotificationListener)
            .build();
    }

    @Bean
    public Step createCategorysStep() {
        log.info(" +++++ createCategorysStep");

        return stepBuilderFactory.get("createCategorysStep")
            .tasklet((contribution, chunkContext) -> {
                try {
                    categorysIndexService.createIndex();
                } catch (Exception ex){
                    contribution.setExitStatus(ExitStatus.FAILED);
                }

                return RepeatStatus.FINISHED;
            })
            .build();
    }

    @Bean
    @JobScope
    public Step bulkCategorysForCreateStep() {
        String stepName = "bulkCategorysForCreateStep";
        return categorysBulkStep.run(stepName, batchSize);
    }


}
