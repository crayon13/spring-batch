package crayon13.study.springbatch.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategorysBulkStep {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private CategorysBulkReader categorysReader;
    @Autowired
    private CategorysProcess categorysProcess;
    @Autowired
    private CategorysWriter categorysWriter;

    public TaskletStep run(String stepName, int batchSize) {
        log.info("+++++ CategorysBulkStep > run");

        return stepBuilderFactory.get(stepName)
            .<Object, Object>chunk(batchSize)
            .reader(categorysReader)
            .processor(categorysProcess)
            .writer(categorysWriter)
            .build();
    }
}