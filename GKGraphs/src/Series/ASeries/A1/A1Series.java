package Series.ASeries.A1;

import java.util.List;

import Kernel.Group.LieTypeGroup.GroupType;
import Series.ASeries.ASeries;

/**
 * Реализация серии групп лиева типа вида A_1(q).
 * FIXME удалить класс, т.к. скорее всего, он не будет использоваться
 * @author v.kolpakova
 *
 */
public class A1Series extends ASeries {

	public A1Series(String name, List<Component> components, int n) {
		super(name, components, n);
		this.grType = GroupType.A;
	}
	
}