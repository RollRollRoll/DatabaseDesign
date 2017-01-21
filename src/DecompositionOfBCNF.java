import java.util.List;

/**
 * Created by kgfan on 2016/12/21.
 */
public class DecompositionOfBCNF {
    private List<Character> U;//属性全集
    private List<FunctionalDependency> F;//函数依赖
    private List<String> R;//分解的子模式

    private boolean testBCNF(FunctionalDependency f,List<Character> candidateCode){
        char[] x = f.getX();
        char[] y = f.getY();
        int count = 0;
        for(int i=0;i<y.length;i++){
            for(int j=0;j<x.length;j++){
                if(x[j]==y[i]){
                    count++;
                    break;
                }
            }
        }
        if(count==y.length){
            return true;
        }
        count=0;
        for(int i=0;i<candidateCode.size();i++){
            for(int j=0;j<x.length;j++){
                if(x[j]==candidateCode.get(i)){
                    count++;
                    break;
                }
            }
        }
        if(count==candidateCode.size()){
            return true;
        }else{
            return false;
        }
    }


}
