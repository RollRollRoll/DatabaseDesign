import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by kgfan on 2016/12/21.
 */
public class PropertySetClosure {
    private List<Character> U;//属性全集
    private List<Character> X;//属性集
    private List<FunctionalDependency> F;//函数依赖

    public PropertySetClosure(List<Character> u, List<Character> x,
                              List<FunctionalDependency> f) {
        U = u;
        X = x;
        F = f;
    }

    Set<Character> getPropertySetClosure() {
        Set<Character> result = new HashSet<Character>(X);//初始化
        Set<Character> old = new HashSet<Character>(result);//old用于保存上一次循环的结果
        boolean flag = true;//用于终止计算循环过程
        do {
            Set<Character> temp = new HashSet<Character>();
            for (FunctionalDependency f : F) {
                boolean b = true;//标志函数依赖左部是否包含已经包含的属性
                for (char c : f.getX()) {
                    if (!result.contains(c)) {
                        b = false;
                        break;
                    }
                }
                //将符合的函数依赖右部添加进TEMP
                if (b == true) {
                    for (char c : f.getY()) {
                        temp.add(c);
                    }
                }
            }
            result.addAll(temp);
            //如果新的结果和旧的结果没有区别的话就结束循环
            if (isSetEqual(result, old)) {
                flag = false;
            } else {
                old = new HashSet<>(result);
            }
        } while (flag);
        return result;
    }

    public static boolean isSetEqual(Set set1, Set set2) {
        if (set1 == null && set2 == null) {
            return true; //Both are null
        }
        if (set1 == null || set2 == null || set1.size() != set2.size() || set1.size() == 0 || set2.size() == 0) {
            return false;
        }
        Iterator ite1 = set1.iterator();
        Iterator ite2 = set2.iterator();
        boolean isFullEqual = true;
        while (ite2.hasNext()) {
            if (!set1.contains(ite2.next())) {
                isFullEqual = false;
            }
        }
        return isFullEqual;
    }
}
