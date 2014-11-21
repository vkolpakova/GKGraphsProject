package Kernel.Resolvers;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Kernel.Group.LieTypeGroup;
import Kernel.Group.LieTypeGroup.GroupType;
import Kernel.Utils.LieTypeGroupNameParser;
import Kernel.Utils.MainLogger;

/**
 * Класс вычисляет, конкструктор какого класса вызвать на основе обозначения конкретной группы Лиева типа.
 * 
 * @author v.kolpakova
 *
 */
public class LieTypeGroupTypeResolver {
	
	public static LieTypeGroup resolve(String name) {
		LieTypeGroup group = null;
		try {
			GroupType type = LieTypeGroupNameParser.computeGroupType(name);
			MainLogger.info("*LieTypeGroupTypeResolver* Group type: " + type.name());
			int n = LieTypeGroupNameParser.computeN(name);
			MainLogger.info("*LieTypeGroupTypeResolver* Group range = " + Integer.toString(n));
			int q = LieTypeGroupNameParser.computeQ(name);
			MainLogger.info("*LieTypeGroupTypeResolver* Field order = " + Integer.toString(q));
			int p = LieTypeGroupNameParser.computeP(name);
			MainLogger.info("*LieTypeGroupTypeResolver* Field characteristic = " + Integer.toString(p));
			if (type == GroupType.A) {
				group = new ALieTypeGroup(name, n, p, q);
			} else if (type == GroupType.B) {
				group = new BLieTypeGroup(name, n, p, q);
			}
			// TODO с появлением конкретных типов реализовать соотв. логику
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return group;
	}
	
}