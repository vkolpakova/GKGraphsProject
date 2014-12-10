package Kernel.Resolvers.Concrete;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.D.DLieTypeGroup;
import Implementations.LieTypeGroups.F.FLieTypeGroup;
import Implementations.LieTypeGroups.G.GLieTypeGroup;
import Implementations.LieTypeGroups.Ri.RiLieTypeGroup;
import Implementations.LieTypeGroups.Sz.SzLieTypeGroup;
import Implementations.LieTypeGroups._A._ALieTypeGroup;
import Implementations.LieTypeGroups._D._DLieTypeGroup;
import Implementations.LieTypeGroups.__D.__DLieTypeGroup;
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
			} else if (type == GroupType._A) {
				group = new _ALieTypeGroup(name, n, p, q);
			} else if (type == GroupType.B || type == GroupType.C) {
				// поскольку критерии для групп типа B и C совпадают, отождествляем оба типа с типом B
				group = new BLieTypeGroup(name, n, p, q);
			} else if (type == GroupType.D) {
				group = new DLieTypeGroup(name, n, p, q);
			} else if (type == GroupType._D) {
				group = new _DLieTypeGroup(name, n, p, q);
			} else if (type == GroupType.__D) {
				group = new __DLieTypeGroup(name, n, p, q);
			} else if (type == GroupType.G) {
				group = new GLieTypeGroup(name, n, p, q);
			} else if (type == GroupType.F) {
				group = new FLieTypeGroup(name, n, p, q);
			} else if (type == GroupType.Sz) {
				group = new SzLieTypeGroup(name, n, p, q);
			} else if (type == GroupType.Ri) {
				group = new RiLieTypeGroup(name, n, p, q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return group;
	}
	
}