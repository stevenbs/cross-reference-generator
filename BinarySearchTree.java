class BinarySearchTree{
  private class Node{
    private String key;
    private Node left;
    private Node right;
    private Term next;
    private Node(String key,Term next){
      this.key=key;
      this.next=next;
      left=null;
      right=null;
    }
  }
  private class Term{
    private int value;
    private Term next;
    public Term(int value,Term next){
      this.value = value;
      this.next = next;
    }
  }
  private Node root;
  public BinarySearchTree(){
    root =null;
  } 
  public void printNumbers(Term temp){
    if(temp ==null){
      return;
    }else{
      printNumbers(temp.next);
      System.out.format("%05d", temp.value);
      System.out.print(" ");
    }
  }
  public void printInOrder(Node temp){
      if(temp.left!=null){
        printInOrder(temp.left);
      }
      System.out.printf("%-30s",temp.key);
      printNumbers(temp.next);
      System.out.println();
      if(temp.right!=null){
        printInOrder(temp.right);
      }
  }
  
  public void put(int value,String  key){
    if(root==null){
      root = new Node(key,null);
      Term T = new Term(value,null);
      root.next= T; 
    }else{
      Node temp = root;
      while(true){
        if(key.compareTo(temp.key)<0){
          if(temp.left == null){
            temp.left = new Node(key,null);
            Term T = new Term(value,null);
            temp.left.next = T;
            return;
          }else{
            temp =temp.left;
          }
        }else if(key.compareTo(temp.key)>0) {
          if(temp.right==null){
            temp.right = new Node(key,null);
            Term T = new Term(value,null);
            temp.right.next = T;
            return;
          }else{
            temp=temp.right;
          }
        }else{
          //temp.value=value;
          if(temp.next.value!=value){
            Term a = new Term(value,temp.next);
            temp.next =a;
          }
          return;
        }
      }
    }
  }
  public static void main(String args[]){
  BinarySearchTree tree = new BinarySearchTree(); 
  Nomenclator nomenclator = new Nomenclator("Factorials.java", true); 
  while(nomenclator.hasNext()){
    tree.put(nomenclator.nextNumber(), nomenclator.nextName()); 
  } 
  
  tree.printInOrder(tree.root);
  
  }
  // answer:
//00001  //  FACTORIALS. Print some factorials. 
//00002 
//00003 class Factorials 
//00004 { 
//00005   
//00006   //  FACTORIAL. Return the factorial of N. 
//00007   
//00008   private static int factorial(int n) 
//00009   { 
//00010     if (n == 0) 
//00011     { 
//00012       return 1; 
//00013     } 
//00014     else 
//00015     { 
//00016       return n * factorial(n - 1); 
//00017     } 
//00018   } 
//00019   
//00020   //  MAIN. Write the factorials of 0 through 10. 
//00021   
//00022   public static void main(String [] args) 
//00023   { 
//00024     for (int k = 0; k <= 10; k += 1) 
//00025     { 
//00026       System.out.println(k + "! = " + factorial(k)); 
//00027     } 
//00028   } 
//00029 }
//Factorials  00003 
//String      00022 
//System      00026 
//args        00022 
//class       00003 
//else        00014 
//factorial   00008 00016 00026 
//for         00024 
//if          00010 
//int         00008 00024 
//k           00024 00026 
//main        00022 
//n           00008 00010 00016 
//out         00026 
//println     00026 
//private     00008 
//public      00022 
//return      00012 00016 
//static      00008 00022 
//void        00022 
 
}

