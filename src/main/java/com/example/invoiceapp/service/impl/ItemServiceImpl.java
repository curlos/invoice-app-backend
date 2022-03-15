package com.example.invoiceapp.service.impl;

import com.example.invoiceapp.model.Invoice;
import com.example.invoiceapp.model.Item;
import com.example.invoiceapp.repository.InvoiceRepository;
import com.example.invoiceapp.repository.ItemRepository;
import com.example.invoiceapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        super();
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems(Long invoiceId) {
        return itemRepository.findAll();
    }

    @Override
    public Item saveItem(Item item) {
        System.out.println(item);
        return itemRepository.save(item);
    }
}
