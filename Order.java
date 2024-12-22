package employee;

import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import employee.*;
import enums.*;
import student.*;
import system.*;
import interfaces.*;
import researcher.*;


/**
* @generated
*/
public class Order {
    private int orderId;
    private String idOfSender;
    private String description;
    private OrderStatus status;

    public Order(int orderId, String description,String idOfSender) {
        this.orderId = orderId;
        this.description = description;
        this.status = OrderStatus.NEW;
        this.idOfSender=idOfSender;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDescription() {
        return description;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

	public String getIdOfSender() {
		return idOfSender;
	}

	public void setIdOfSender(String idOfSender) {
		this.idOfSender = idOfSender;
	}
}
