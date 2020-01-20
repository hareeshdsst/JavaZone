package com.sg.fooring;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sg.flooring.constants.FlooringModeEnum;
import com.sg.flooring.controller.Controller;
import com.sg.flooring.dao.DataPersistenceException;
import com.sg.flooring.service.InvalidOrderNumberException;
import com.sg.flooring.service.StateValidationException;

public class App {
	public static void main(String[] args)
			throws DataPersistenceException, StateValidationException, IOException, InvalidOrderNumberException {

		System.out.println("Please select mode 1.Training, 2.Production");

		Scanner scanner = new Scanner(System.in);
		String selection = scanner.nextLine();
		int intmodeselection = Integer.parseInt(selection);
		FlooringModeEnum.setModeSelection(intmodeselection);
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Controller controller = ctx.getBean("controller", Controller.class);
		controller.execute();
	}
}
