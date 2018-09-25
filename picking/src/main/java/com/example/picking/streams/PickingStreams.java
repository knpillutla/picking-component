package com.example.picking.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PickingStreams {
    public String ORDERS_OUTPUT = "orders-out";
    public String INVENTORY_OUTPUT="inventory-out";
    public String PICK_OUTPUT="pick-out";
    
    @Input(INVENTORY_OUTPUT)
    public SubscribableChannel outboundInventory();

    @Output(ORDERS_OUTPUT)
    public SubscribableChannel outboundOrders();
    
    @Output(PICK_OUTPUT)
    public MessageChannel outboundPick();
}