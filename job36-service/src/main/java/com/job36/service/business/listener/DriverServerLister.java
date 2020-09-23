package com.job36.service.business.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@WebListener
public class DriverServerLister implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		Driver driver = null;
		while (drivers.hasMoreElements()) {
			driver = drivers.nextElement();
			try {
				DriverManager.deregisterDriver(driver);
				//LogUtil.logInfo(String.format("deregistering jdbc driver: %s", driver));
			} catch (SQLException e) {
				e.printStackTrace();
				//LogUtil.logError(String.format("deregistering jdbc driver: %s", driver));
			}
		}

	}

}
