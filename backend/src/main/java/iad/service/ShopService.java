package iad.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ShopService {

    long makePurchase(long resourceId, long quantity,
                      long sellerId , String username);

    long putResourceOnSale(long resourceId, long quantity, long price, String sellerUsername);
}
