package ru.practicum.item;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private Long itemId = 0L;
    private final Map<Long, List<Item>> itemMap = new HashMap<>();

    @Override
    public List<Item> findByUserId(long userId) {
        return itemMap.get(userId);
    }

    @Override
    public Item save(Item item) {
        item.setId(itemId);
        idUpdate();
        checkUserList(item.getUserId(), item);
        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        findByUserId(userId).remove(itemId);
    }

    private void idUpdate() {
        itemId++;
    }

    private void checkUserList(Long userId, Item item) {
        itemMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(item);
    }
}
