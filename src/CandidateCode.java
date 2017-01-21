import java.util.ArrayList;
import java.util.List;

/**
 * Created by kgfan on 2016/12/21.
 */
public class CandidateCode {
    private List<Character> U;//属性全集
    private List<FunctionalDependency> F;//函数依赖
    private List<FunctionalDependency> mf;//最小函数依赖集

    public CandidateCode(List<Character> u, List<FunctionalDependency> f) {
        U = u;
        F = f;
        mf = new MiniFunctionDependencySet(u, f).getMiniFunctionDependencySet();
    }

    public List<Character> getCandidateCode() {
        //分类
        List<Character> l = new ArrayList<>();
        List<Character> r = new ArrayList<>();
        List<Character> n = new ArrayList<>();
        List<Character> lr = new ArrayList<>();
        for (char c : U) {
            boolean bl = false;
            boolean br = false;
            for (FunctionalDependency f : mf) {
                char[] x = f.getX();
                char[] y = f.getY();
                for (char cc : x) {
                    if (cc == c) {
                        bl = true;
                    }
                }
                for (char cc : y) {
                    if (cc == c) {
                        br = true;
                    }
                }
            }
            if (bl == true && br == true) {
                lr.add(c);
            } else if (bl == true && br == false) {
                l.add(c);
            } else if (bl == false && br == true) {
                r.add(c);
            } else {
                n.add(c);
            }
        }

        //结果
        List<Character> resutlt = new ArrayList<Character>(l);
        resutlt.addAll(n);
        PropertySetClosure p = new PropertySetClosure(U, resutlt, F);
        do {
            if (p.getPropertySetClosure().containsAll(U)) {
                return resutlt;
            } else {
                resutlt.add(lr.get(0));
                lr.remove(0);
            }
        } while (true);
    }
}
