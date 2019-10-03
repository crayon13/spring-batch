package crayon13.study.springbatch.work;

import crayon13.study.springbatch.work.service.CategorysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategorysBulkReader implements ItemReader {
    @Autowired
    private CategorysService categorysService;

    @Override
    public ItemReader read() {
        return searchCategorys(1000);
    }

    private ItemReader searchCategorys(int batchSize) {
        log.info("CategorysBulkReader > searchCategorys");

        return null;
    }
}
