package crayon13.study.springbatch.work.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategorysServiceImpl implements CategorysService {

    @Override
    @Transactional(readOnly = true, value = "storeTransactionManager")
    public Object selectCategorysForInsert() {
        return null;
    }

    @Override
    @Transactional(readOnly = true, value = "storeTransactionManager")
    public Object selectCategorysForUpdate(String updateDate) {
        return null;
    }
}
