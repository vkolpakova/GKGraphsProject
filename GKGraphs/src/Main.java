import Kernel.Graph.PrimeNumberGraph;
import Kernel.GraphConstructor.LieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.LieTypeGroupGraphConstructorResolver;
import Kernel.Utils.LieTypeGroupTypeResolver;

public class Main {
	
	public static void main(String args[]) {
		System.out.println("Hello");
		LieTypeGroup gr = LieTypeGroupTypeResolver.resolve("A_3(8)");
		LieTypeGroupGraphConstructor constr = LieTypeGroupGraphConstructorResolver.resolve(gr);
		PrimeNumberGraph graph = constr.constructGKGraph();
		graph.printConsole();
	}
	
}