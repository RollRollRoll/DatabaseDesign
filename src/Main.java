/**
 * Created by kgfan on 2016/12/21.
 */
public class Main {

    public static void main(String[] args) {
        //List<Character> list = new ArrayList<Character>();
        //list.add('A');
        //list.add('B');
        //list.add('C');
        //list.add('D');
        //list.add('E');
        //List<FunctionalDependency> list1 = new ArrayList<FunctionalDependency>();
        //list1.add(new FunctionalDependency("AB", "C"));
        //list1.add(new FunctionalDependency("B", "D"));
        //list1.add(new FunctionalDependency("C", "E"));
        //list1.add(new FunctionalDependency("EC", "B"));
        //list1.add(new FunctionalDependency("AC", "B"));
        //List<Character> list3 = new ArrayList<Character>();
        //list3.add('A');
        //list3.add('B');
        //list3.add('C');
        //list3.remove(1);

        //PropertySetClosure p = new PropertySetClosure(list, list3, list1);
        //Set s = p.getPropertySetClosure();
        //Iterator i = s.iterator();
        //while (i.hasNext()) {
        //    System.out.println(i.next());
        //}


        /*-------------------------------------------------------------------------------*/

        //List<Character> list = new ArrayList<Character>();
        //list.add('A');
        //list.add('B');
        //list.add('C');
        //list.add('D');
        //list.add('E');
        //list.add('G');
        //List<FunctionalDependency> list1 = new ArrayList<FunctionalDependency>();
        //list1.add(new FunctionalDependency("B", "D"));
        //list1.add(new FunctionalDependency("DG", "C"));
        //list1.add(new FunctionalDependency("BD", "E"));
        //list1.add(new FunctionalDependency("AG", "B"));
        //list1.add(new FunctionalDependency("ADG", "BC"));
        //MiniFunctionDependencySet m = new MiniFunctionDependencySet(list,list1);
        //List<FunctionalDependency> l = m.getMiniFunctionDependencySet();
        //for(FunctionalDependency f:l){
        //    char[] x = f.getX();
        //    char[] y = f.getY();
        //    for(char c:x)
        //        System.out.print(c);
        //    System.out.print("  ");
        //    for(char c:y)
        //        System.out.print(c);
        //    System.out.println();
        //}


        //List<Character> list = new ArrayList<Character>();
        //list.add('A');
        //list.add('B');
        //list.add('C');
        //List<FunctionalDependency> list1 = new ArrayList<FunctionalDependency>();
        //list1.add(new FunctionalDependency("A", "BC"));
        //list1.add(new FunctionalDependency("B", "C"));
        //list1.add(new FunctionalDependency("A", "B"));
        //list1.add(new FunctionalDependency("AB", "C"));
        //MiniFunctionDependencySet m = new MiniFunctionDependencySet(list,list1);
        //List<FunctionalDependency> l = m.getMiniFunctionDependencySet();
        //for(FunctionalDependency f:l){
        //    char[] x = f.getX();
        //    char[] y = f.getY();
        //    for(char c:x)
        //        System.out.print(c);
        //    System.out.print("  ");
        //    for(char c:y)
        //        System.out.print(c);
        //    System.out.println();
        //}


        /*-------------------------------------------------------------------------------*/

        //List<Character> list = new ArrayList<Character>();
        //list.add('A');
        //list.add('B');
        //list.add('C');
        //list.add('D');
        //list.add('E');
        //List<FunctionalDependency> list1 = new ArrayList<FunctionalDependency>();
        //list1.add(new FunctionalDependency("D", "B"));
        //list1.add(new FunctionalDependency("B", "D"));
        //list1.add(new FunctionalDependency("AD", "B"));
        //list1.add(new FunctionalDependency("AC", "D"));
        //CandidateCode c = new CandidateCode(list,list1);
        //List<Character> l = c.getCandidateCode();
        //for(Character cc:l){
        //    System.out.println(cc);
        //}

        /*-------------------------------------------------------------------------------*/

        //List<Character> list = new ArrayList<Character>();
        //list.add('C');
        //list.add('T');
        //list.add('H');
        //list.add('I');
        //list.add('S');
        //list.add('G');
        //List<FunctionalDependency> list1 = new ArrayList<FunctionalDependency>();
        //list1.add(new FunctionalDependency("CS", "G"));
        //list1.add(new FunctionalDependency("C", "T"));
        //list1.add(new FunctionalDependency("TH", "I"));
        //list1.add(new FunctionalDependency("HI", "C"));
        //list1.add(new FunctionalDependency("HS", "I"));
        //DecompositionOf3NF c = new DecompositionOf3NF(list,list1);
        //List<String> l = c.keepFunctionDependency();
        //for(String cc:l){
        //    System.out.println(cc);
        //}

        /*-------------------------------------------------------------------------------*/
       // List<Character> list = new ArrayList<Character>();
       // list.add('A');
       // list.add('B');
       // list.add('C');
       // list.add('D');
       // List<FunctionalDependency> list1 = new ArrayList<FunctionalDependency>();
       // list1.add(new FunctionalDependency("B", "A"));
       // list1.add(new FunctionalDependency("C", "D"));
       // List<String> r = new ArrayList<String>();
       // r.add(new String("AB"));
       // r.add(new String("BC"));
       // r.add(new String("CD"));
       // LosslessConnectivity c = new LosslessConnectivity(list,list1,r);
       //System.out.println(c.testLosslessConnectivity());

    }
}
