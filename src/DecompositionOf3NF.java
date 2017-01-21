import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kgfan on 2016/12/21.
 */
public class DecompositionOf3NF {
    private List<Character> U;//属性全集
    private List<FunctionalDependency> F;//函数依赖
    private List<FunctionalDependency> mf;//最小函数依赖集

    public DecompositionOf3NF(List<Character> u, List<FunctionalDependency> f) {
        U = u;
        F = f;
        mf = new MiniFunctionDependencySet(u, f).getMiniFunctionDependencySet();
    }

    //求满足3NF并且函数依赖的分解
    public List<String> keepFunctionDependency(){
        List<String> result = new ArrayList<>();
        //检查有无不在F中出现的属性
        String str = new String();
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
            if(bl==false&&br==false){
                str+=String.valueOf(c);
            }
        }
        if(!str.equals("")){
            result.add(str);
        }

        //按左部相同的原则进行分类
        while(mf.size()!=0){
            String s = new String();
            char[] x = mf.get(0).getX();
            char[] y = mf.get(0).getY();
            s+=String.valueOf(x)+String.valueOf(y);
            mf.remove(0);
            for(int i=0;i<mf.size();i++){
                Arrays.sort(x);
                char[] xx = mf.get(i).getX();
                Arrays.sort(xx);
                if(Arrays.equals(x,xx)){
                    s+=String.valueOf(mf.get(i).getY());
                    mf.remove(i);
                    i--;
                }
            }
            result.add(s);
        }

        return result;
    }

}
