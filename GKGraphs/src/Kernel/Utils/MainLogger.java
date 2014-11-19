package Kernel.Utils;

import java.text.MessageFormat;

import org.apache.log4j.Logger;

//import sun.reflect.Reflection;

/**
 * Класс-логгер с единственным экземпляром логера.
 * 
 * @author v.kolpakova
 *
 */
public final class MainLogger {
	
	// TODO попробовать применить рефлексию для добавления наименования вызвавшего класса в лог
	// Пока писать наименования класса в формируемом сообщении (вручную)
	
	private static final Logger LOG = Logger.getLogger("MainLogger");
	
	public static void info(String message) {
		LOG.info(message);
	}
	
	public static void infof(String message, Object... args) {
		LOG.info(MessageFormat.format(message, args));
	}
	
}