package Logic.Test.Implementations.FieldAutGraphConstructor;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Resolvers.Concrete.FieldAutLieTypeGroupGraphConstructorResolver;
import Logic.Kernel.Resolvers.Concrete.LieTypeGroupTypeResolver;
import Logic.Kernel.Utils.MainLogger;
import Logic.Test.Implementations.GroupGraphConstructor.AbstractLieTypeGroup_Test;
import Logic.Test.Implementations.Helper.GraphAndFieldAutLieTypeGroupTestHelper;

public class AbstractFieldAutLieTypeGroup_Test extends AbstractLieTypeGroup_Test {
		
	protected Map<Integer, List<PrimeNumberGraph>> graphsMap = Maps.newHashMap();
	
	@Override
	protected void determineGroupWithGraph(String name) {
		this.group = LieTypeGroupTypeResolver.resolve(name);
		FieldAutConcreteLieTypeGroupGraphConstructor<?> constructor = FieldAutLieTypeGroupGraphConstructorResolver.resolve(group);
		this.graphsMap = constructor.constructGraphs();
		for (List<PrimeNumberGraph> grList : this.graphsMap.values()) {
			for (PrimeNumberGraph gr : grList) {
				gr.printConsole();
			}
		}
		if (graphsMap.size() == 1 && graphsMap.containsKey(1) && graphsMap.get(1).get(0).equals(group.getGraph())) {
			MainLogger.info("Полевые автоморфизмы отсутствуют.");
		}
	}
	
	/**
	 * Метод проверяет равенство графов простых чисел расширений конкретных групп полевыми автоморфизмами
	 * @param groupName		--- наименование группы
	 * @param verticesStr	--- список вершин ГПЧ
	 * @param edgesStrs		--- строки "порядок полевого авт. + список ребер ГПЧ"
	 * @return true, если совпадают, false иначе
	 */
	protected boolean checkEqualities(String groupName, String verticesStr, String ... edgesStrs) {
		determineGroupWithGraph(groupName);
		return GraphAndFieldAutLieTypeGroupTestHelper.checkEqualities(this.group, this.graphsMap, verticesStr, edgesStrs);
	}
	
	@Override
	protected List<String> parseEdgesList(String input) {
		return GraphAndFieldAutLieTypeGroupTestHelper.parseEdgesList(input);
	}
		
}