package com.example.invoiceapp.service;

import com.example.invoiceapp.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems(Long invoiceId);
    Item saveItem(Item item);
}
