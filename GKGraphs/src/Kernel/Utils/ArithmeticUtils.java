package Kernel.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс утилитарных арифметических методов.
 * 
 * @author v.kolpakova
 *
 */
public class ArithmeticUtils {
	
	private static int MAX_E_CICLE_ITERRATOR = 100;
	private static int MAX_NPART_CICLE_ITERRATOR = 20;
	
	/**
	 * Проверка, является ли заданное целое число простым
	 * @param number
	 * @return
	 */
	public static boolean isPrimeNumber(int number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
	
	/**
	 * Метод возвращает коллекцию простых делителей заданного числа
	 * @param number
	 * @return
	 */
	public static List<Integer> getAllPrimeDevisors(int number) {
		List<Integer> result = new ArrayList<Integer>();
        for (int i = 2; i <= number; i ++) {
            if (isPrimeNumber(i) && number % i == 0) {
            	MainLogger.info("*ArithmeticUtils* Number=" + ((Integer)number).toString() + ", prime divisor=" + ((Integer)i).toString() + ", ");
            	// optimization part
            	while ((number % i) == 0) {
            		number = number / i;
            	}
                result.add(i);
            }
        }
		return result;
	}
	
	/**
	 * Возвращает произведение всех простых делителей числа
	 * @param number
	 * @return
	 */
	public static int primeDivMultiplication(int number) {
		int result = 1;
		List<Integer> intList = getAllPrimeDevisors(number);
		for (int div : intList) {
			result *= div;
		}
		return result;
	}
	
	/**
	 * Метод вычисляет n-часть числа q
	 * @param q
	 * @param n
	 * @return наибольшая степень числа n, которая делит q
	 */
	public static int nPart(int q, int n) {
		if ((q % n) != 0) {
			return 1; 
		} else {
			int nPow = 1;
			int i = 1;
			while (i < MAX_NPART_CICLE_ITERRATOR && (q % nPow) == 0) {
				nPow *= n;
			}
			return nPow/n;
		}
	}
	
	/**
	 * Метод вычисляет НОД двух чисел a и b
	 * @param a
	 * @param b
	 * @return НОД(a, b)
	 */
	public static int NOD(int a, int b) {
		while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
	}
	
	/**
	 * Метод вычисляет значение функции e
	 * @param p
	 * @param q
	 * @return
	 */
	public static int e(int p, int q) {
		for (int i=1; i < MAX_E_CICLE_ITERRATOR; i++) {
			if ((Math.pow(q, i) - 1) % p == 0) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * Метод вычисляет значение функции эта
	 * @param m
	 * @return m/2, если m четно; m, если m нечетно
	 */
	public static int eta(int m) {
		return (m % 2 == 0) ? (m/2) : m; 
	}
	
	/**
	 * Метод вычисляет значение функции ню
	 * @param m
	 * @return
	 */
	public static int nu(int m) {
		int modulo = m % 4;
		if (modulo == 0) {
			return m;
		} else if (modulo == 2) {
			return m / 2;
		} else {
			return 2 * m;
		}
	}
	
}