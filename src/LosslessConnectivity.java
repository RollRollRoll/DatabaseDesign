import java.util.List;

/**
 * Created by kgfan on 2016/12/21.
 */
public class LosslessConnectivity {
    private List<Character> U;//属性全集
    private List<FunctionalDependency> F;//函数依赖
    private List<String> R;//子关系模式

    public LosslessConnectivity(List<Character> u, List<FunctionalDependency> f, List<String> r) {
        U = u;
        F = f;
        R = r;
    }

    public boolean testLosslessConnectivity(){
        //初始化表格
        String[][] table = new String[R.size()][U.size()];
        for(int i=0;i<U.size();i++){
            for(int j=0;j<R.size();j++){
                if(R.get(j).indexOf(U.get(i))>=0){
                    table[j][i]=new String("a"+(i+i));
                }else{
                    table[j][i]=new String("b"+(i+1)+(j+1));
                }
            }
        }

        //修改表
        for(FunctionalDependency f:F){
            char[] x = f.getX();
            char[] y = f.getY();
            int[] xIndex = new int[x.length];
            int[] yIndex = new int[y.length];
            for(int i=0;i<x.length;i++){
                xIndex[i]=U.indexOf(x[i]);
            }
            for(int i=0;i<y.length;i++){
                yIndex[i]=U.indexOf(y[i]);
            }
            for(int index=0;index<xIndex.length;index++){
                for(int row=0;row<R.size()-1;row++){
                    if(table[row][xIndex[index]].equals(table[row+1][xIndex[index]])){
                        if(table[row][yIndex[index]].indexOf('a')>=0){
                            table[row+1][yIndex[index]]=table[row][yIndex[index]];
                        }else if(table[row+1][yIndex[index]].indexOf('a')>=0){
                            table[row][yIndex[index]]=table[row+1][yIndex[index]];
                        }else{
                            table[row+1][yIndex[index]]=table[row][yIndex[index]];
                        }

                    }
                }
            }
        }
        for(int row=0;row<R.size();row++){
            boolean flag=true;
            for(int j=0;j<U.size();j++){
                if(!(table[row][j].indexOf('a')>=0)){
                    flag=false;
                }
            }
            if(flag==true){
                return true;
            }
        }
        return false;
    }
}
