package Kernel.Utils;

import java.text.MessageFormat;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

//import sun.reflect.Reflection;

/**
 * Класс-логгер с единственным экземпляром логера.
 * 
 * @author v.kolpakova
 *
 */
public final class MainLogger {
	
	/**
	 * Включить логгер на уровень INFO
	 */
	public static void loggerOn() {
		LOG.setLevel(Level.INFO);
	}
	
	/**
	 * Выключить логгер
	 */
	public static void loggerOff() {
		LOG.setLevel(Level.OFF);
	}
	
	// TODO попробовать применить рефлексию для добавления наименования вызвавшего класса в лог
	// Пока писать наименования класса в формируемом сообщении (вручную)
	
	private static final Logger LOG = Logger.getLogger("MainLogger");
	
	public static void info(String message) {
		if (LOG.isInfoEnabled()) {
			LOG.info(message);
		}
	}
	
	public static void infof(String message, Object... args) {
		if (LOG.isInfoEnabled()) {
			LOG.info(MessageFormat.format(message, args));
		}
	}
	
}