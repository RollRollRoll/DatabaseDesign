/**
 * Created by kgfan on 2016/12/21.
 */
public class FunctionalDependency {
    private char[] X;
    private char[] Y;

    public FunctionalDependency(String X, String Y) {
        this.X = X.toCharArray();
        this.Y = Y.toCharArray();
    }

    public char[] getX() {
        return X;
    }

    public char[] getY() {
        return Y;
    }

    public void setX(char[] x) {
        X = x;
    }

    public void setY(char[] y) {
        Y = y;
    }
}
