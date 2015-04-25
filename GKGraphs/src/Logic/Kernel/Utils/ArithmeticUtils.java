package Logic.Kernel.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.math.LongMath;

/**
 * Класс утилитарных арифметических методов.
 * 
 * @author v.kolpakova
 *
 */
public class ArithmeticUtils {
	
	private static final int MAX_E_CICLE_ITERRATOR = 100;
	private static final int MAX_NPART_CICLE_ITERRATOR = 20;
	
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
	public static List<Integer> getAllPrimeDevisors(double number) {
		List<Integer> result = new ArrayList<Integer>();
        for (int i = 2; i <= number; i ++) {
            if (isPrimeNumber(i) && number % i == 0) {
            	MainLogger.info("*ArithmeticUtils* Number=" + ((Double)number).toString() + ", prime divisor=" + ((Integer)i).toString() + ", ");
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
	public static int primeDivMultiplication(double number) {
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
			if ((LongMath.pow(q, i) - 1) % p == 0) {
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
	
	/**
	 * Возвращает степень числа p, которая равна q
	 * TODO test
	 * @param q --- некоторая степень p
	 * @param p
	 * @return
	 */
	public static int getPow(int q, int p) {
		int result = 0;
		while ((q % p) == 0) {
			q /= p;
			result++;
		}
		return result;
	}
	
	/**
	 * Метод вычисляет значение функции m_i(B, n)
	 * TODO test
	 * @param i
	 * @param q
	 * @return
	 */
	public static int m_iB(int x, int q) {
		int twoPow = getPow(q, 2);
		if ((twoPow % 2) == 0) {
			try {
				throw new Exception("Uncorrect q (even pow)!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int n = twoPow / 2;
		if ((((int) (Math.pow(2, twoPow) - 1)) % x) == 0) {
			return 1; // m1
		} else if ((((int) (Math.pow(2, twoPow) - Math.pow(2, n + 1) + 1)) % x) == 0) {
			return 2; // m2
		} else if ((((int) (Math.pow(2, twoPow) - Math.pow(2, n + 1) + 1)) % x) == 0) {
			return 3; // m3
		} else {
			return 0;
		}
	}
	
	/**
	 * Метод вычисляет значение функции m_i(G, n)
	 * TODO test
	 * @param i
	 * @param q
	 * @return
	 */
	public static int m_iG(int x, int q) {
		int threePow = getPow(q, 3);
		if ((threePow % 2) == 0) {
			try {
				throw new Exception("Uncorrect q (even pow)!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int n = threePow / 2;
		if ((((int) (Math.pow(3, threePow) - 1)) % x) == 0) {
			return 1; // m1
		} else if ((((int) (Math.pow(3, threePow) + 1)) % x) == 0) {
			return 2; // m2
		} else if ((((int) (Math.pow(3, threePow) - Math.pow(3, n + 1) + 1)) % x) == 0) {
			return 3; // m3
		} else if ((((int) (Math.pow(3, threePow) + Math.pow(3, n + 1) + 1)) % x) == 0) {
			return 4; // m4
		} else {
			return 0;
		}
	}
	
	/**
	 * Метод получает разложение числа n
	 * @param n
	 * @return коллекцию разложений
	 */
	public static List<List<Integer>> partition(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>(n);
		int l = n;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = 1;
			list.add(1);
		}
		result.add(list);
		do {
			int i = l - 1;
			int sum = 0;
			do {
				sum += arr[i--];
			} while ((i > 0) && arr[i - 1] <= arr[i]);
			arr[i]++;
			l = i + sum;
			for (int j = i + 1; j < l; j++) {
				arr[j] = 1;
			}
			list = new ArrayList<Integer>(l);
			for (int j = 0; j < l; j++) {
				list.add(arr[j]);
			}
			result.add(list);
		} while (l > 1);
		return result;
	}
	
	/**
	 * Рекурсивный метод получения коллекции всех возможных подмножеств некоторого множества. </br>
	 * Элемент коллекции - упорядоченная коллекция из 0 (элемент не содержится в подмножестве) и 1 (элемент содержится в подмножестве)
	 * @param arr --- массив из 0 размерности, равной мощности множества
	 * @param n --- мощность множества
	 * @param curPos --- текущая позиция (при вызове выставлять 0)
	 * @return
	 */
	public static void combination(List<List<Integer>> resList, Integer[] arr, int n, int curPos) {
		if (n == curPos) {
			List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
			resList.add(list);
		} else {
			arr[curPos] = 0;
			combination(resList, arr, n, curPos + 1);
			arr[curPos] = 1;
			combination(resList, arr, n, curPos + 1);
		}
	}
	
	/**
	 * Метод формирует для всех разбиений числа все возможные разбиения его на подножество и его дополнение
	 * всеми возможными вариантами
	 * @param numSet --- множество чисел
	 * @return
	 */
	public static List<Map<Integer, List<Integer>>> getFullPartitionMapForConcreteCombination(List<Integer> numSet) {
		List<Map<Integer, List<Integer>>> result = new ArrayList<Map<Integer, List<Integer>>>();
		Integer[] arr = new Integer[numSet.size()];
		for (int i = 0; i < numSet.size(); i ++) {
			arr[i] = 0;
		}
		List<List<Integer>> allCombinations = new ArrayList<List<Integer>>();
		combination(allCombinations, arr, numSet.size(), 0);
		for (List<Integer> combination : allCombinations) {
			Map<Integer, List<Integer>> resultMap = new HashMap<Integer, List<Integer>>();
			List<Integer> subset = new ArrayList<Integer>();
			List<Integer> complement = new ArrayList<Integer>();
			for (int i = 0; i < numSet.size(); i ++) {
				if (combination.get(i) == 1) {
					subset.add(numSet.get(i));
				} else {
					complement.add(numSet.get(i));
				}
			}
			resultMap.put(1, subset);
			resultMap.put(0, complement);
			result.add(resultMap);
		}
		return result;
	}
	
	/**
	 * Метод возвращает все возможные разложения множества всех возможных разложений числа n на слагаемые 
	 * @param n
	 * @return
	 */
	public static Set<Map<Integer, List<Integer>>> getAllPartitionsForAllCombinations(int n) {
		Set<Map<Integer, List<Integer>>> result = new HashSet<Map<Integer, List<Integer>>>();
		List<List<Integer>> partitions = partition(n);
		for (List<Integer> partition : partitions) {
			List<Map<Integer, List<Integer>>> combinations = getFullPartitionMapForConcreteCombination(partition);
			result.addAll(combinations);
		}
		return result;
	}
	
}