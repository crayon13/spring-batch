package crayon13.study.springbatch.work;

import crayon13.study.springbatch.work.search.Bulk;
import crayon13.study.springbatch.work.search.Index;
import crayon13.study.springbatch.work.service.CategorysIndexService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategorysWriter implements ItemWriter<Object> {
    private Index index = Index.CATEGORYS;
    private Bulk bulk = Bulk.INDEX;

    @Autowired
    private CategorysIndexService categorysIndexService;

    @Override
    public void write(List<? extends Object> categorysResponseVOList) throws Exception {
        categorysIndexService.insertBulk("");
    }

    private StringBuilder getJsonStringBuilder(List<? extends Object> categorysResponseVOList) {
        StringBuilder stringBuilder = new StringBuilder(4000);
        return stringBuilder;
    }
}
