package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;

public class BalanceOperation implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public BalanceOperation(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public boolean doOperation(Fruit fruit, int quantity) {
        if (fruit == null) {
            throw new RuntimeException("Fruit can't be null");
        }
        if (quantity < MIN_FRUIT_QUANTITY) {
            throw new RuntimeException("Quantity " + quantity + " can't be negative");
        }
        return fruitStorageDao.setBalance(fruit, quantity);
    }
}
