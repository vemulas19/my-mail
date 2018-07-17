package com.facebook.controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.facebook.pojo.Item;
import com.facebook.pojo.ItemsTypes;

@Controller
public class OrderControllers {

	@RequestMapping(value="/takeOrder")
	public String getItemTypes(Model model) {
		
		Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		Query query = session.createQuery("from ItemsTypes");

		List<ItemsTypes> itemTypes = query.list();
		
		
		model.addAttribute("itemTypeList", itemTypes);
		return "Order";
	}
	
	@RequestMapping(value="/getItems")
	public String getItems(@RequestParam("itemType") int itemType, Model model) {
		
		System.out.println("Item type is : " + itemType);
		Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		Query query = session.createQuery("from Item where itemTypeId =: iType");
		query.setParameter("iType", itemType);

		List<Item> items = query.list();
		
		
		model.addAttribute("items", items);
		return "Order";
	}
}
