import java.util.ArrayList;
import java.util.List;

/**
 * Created by kgfan on 2016/12/21.
 */
public class MiniFunctionDependencySet {
    private List<Character> U;//属性全集
    private List<FunctionalDependency> F;//函数依赖

    public MiniFunctionDependencySet(List<Character> u, List<FunctionalDependency> f) {
        U = u;
        F = f;
    }

    public List<FunctionalDependency> getMiniFunctionDependencySet() {
        List<FunctionalDependency> result = new ArrayList<FunctionalDependency>();
        List<FunctionalDependency> temp = new ArrayList<FunctionalDependency>(F);
        //先分解右部不是单个属性的函数依赖
        for (FunctionalDependency f : temp) {
            char[] y = f.getY();
            if (y.length > 1) {
                for (char c : y) {
                    result.add(new FunctionalDependency(String.valueOf(f.getX()), String.valueOf(c)));
                }
            } else {
                result.add(f);
            }
        }
        //去掉多余的函数依赖
        for (int i = 0; i < result.size(); i++) {
            List list1 = U;
            List list2 = new ArrayList<Character>();
            for (int j = 0; j < result.get(i).getX().length; j++) {
                list2.add(result.get(i).getX()[j]);
            }
            List list3 = new ArrayList<FunctionalDependency>();
            for (int j = 0; j < result.size(); j++) {
                if (j != i) {
                    list3.add(result.get(j));
                }
            }
            PropertySetClosure p = new PropertySetClosure(list1, list2, list3);
            if (p.getPropertySetClosure().contains(result.get(i).getY()[0])) {
                result.remove(i);
                i--;
            }
        }
        //检查左边非单个属性的依赖
        for (int i = 0; i < result.size(); i++) {
            char[] x = result.get(i).getX();
            if (x.length > 1) {
                List list1 = U;
                List list3 = new ArrayList<FunctionalDependency>();
                for (int j = 0; j < result.size(); j++) {
                    if (j != i) {
                        list3.add(result.get(j));
                    }
                }
                for (int j = 0; j < x.length; j++) {
                    List<Character> list2 = new ArrayList<Character>();
                    for (int k = 0; k < x.length; k++) {
                        if (j != k)
                            list2.add(x[k]);
                    }
                    PropertySetClosure p = new PropertySetClosure(list1, list2, list3);
                    if (p.getPropertySetClosure().contains(result.get(i).getY()[0])) {
                        char[] c = new char[list2.size()];
                        for (int n = 0; n < c.length; n++) {
                            c[n] = list2.get(n);
                        }
                        result.get(i).setX(c);
                    }
                }
            }
        }
        return result;
    }
}
