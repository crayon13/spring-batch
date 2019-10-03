package crayon13.study.springbatch.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategorysProcess implements ItemProcessor<Object, Object> {

    @Override
    public Object process(Object categorysResponseVO) {
        log.info("+++ CategorysProcess > process");
        return categorysResponseVO;
    }
}
