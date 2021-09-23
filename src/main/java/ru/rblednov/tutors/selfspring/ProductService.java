package ru.rblednov.tutors.selfspring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annatation.Autowired;
import org.springframework.beans.factory.stereotype.Service;

@Service
public class ProductService implements InitializingBean {
    @Autowired
    private PromotionService promotionService;

    public PromotionService getPromotionService() {
        return promotionService;
    }

    public void setPromotionService(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("ProductService: afterPropertiesSet()");
    }
}
