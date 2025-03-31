package MachineCoding;

import java.util.*;

class Main {
    
    public static void main(String[] args) {
       
       Seller seller=new Seller(1,"sai@123","sai");
       seller.details();
       
       Product product=new Product(123, "Biscuit", 250, 2, seller.getSellerId());
       
       product.getProductDetails();
       
       ArrayList<Product> products= new ArrayList<>();
       products.add(product);

       User user = new User(420,"kiran@123","kiran");
       user.getUserDetails();
       
       Cart userCart= new Cart(1111,420);
       userCart.addToCart(123,4);
       userCart.removeFromCart(123,2);
       
       System.out.println(userCart.calculateAmount(products));
    }
}

class Seller{
     
     private int id;
     private String email;
     private String name;
     
     Seller(int id, String email, String name){
         this.id=id;
         this.name=name;
         this.email=email;
     }
     
      public void setName(String name){
        this.name=name;
      }
      
    public String getName(){
        return this.name;
    }
    
     public void setSellerId(int id){
        this.id=id;
    }
    
    public int getSellerId(){
        return this.id;
    }
    
     public void setEmail(String email){
        this.email=email;
    }
    
    public String getEmail(){
        return this.email;
    }
    
     public void details(){
        System.out.print("Name :"+name+"\nemail : "+email+"\nid : "+id);
    }
     
        
}

class Product {
     //product->Id,cost,qunt,sellerId;
     private int id;
     private String name;
     private int cost;
     private int quantity;
     private int sellerId;
     

    Product(int id, String name, int cost, int quantity, int sellerId) {
        this.id=id;
        this.name=name;
        this.cost=cost;
        this.quantity=quantity;
        this.sellerId=sellerId;
    }
    
      public void setId(int id){
        this.id=id;
      }
    
      public int getId(){
        return this.id;
      }
    
      public void setCost(int cost){
        this.cost=cost;
     }
    
     public String getName(){
        return this.name;
     }
     
      public void setName(String name){
        this.name=name;
     }
    
     public int getCost(){
        return this.cost;
     }
    
     public void setQuantity(int id){
        this.quantity=quantity;
     }
     
    public int getQuantity(){
        return this.quantity;
    }
    
    public void setSellerId(int sellerId){
        this.sellerId=sellerId;
    }
    
    public int getSellerId(){
        return this.sellerId;
    }
    
    public void getProductDetails(){
         System.out.println("Name :"+this.name);
    }
    
}

class User{
     
     private int id;
     private String email;
     private String name;
     
     User(int userId, String email, String name){
         this.id=userId;
         this.name=name;
         this.email=email;
     }
     
      public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return this.name;
    }
    
     public void setUserId(int id){
        this.id=id;
    }
    
    public int getUserId(){
        return this.id;
    }
    
     public void setEmail(String email){
        this.email=email;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void getUserDetails(){
        System.out.println("Name :"+name+"email : "+email+"\n id : "+id);
    }
}

class Cart{
      
      private int id;
      private int userId;
      
      //   cart-> products,cost,quant;
      private HashMap<Integer,Integer> userCart = new HashMap<>();
      
      Cart(int id, int userId){
      this.id=id;
      this.userId=userId;
      }
      
     public void addToCart(int productId, int quantity){
          if(userCart.containsKey(productId)){
              int prevCount = userCart.get(productId);
              userCart.put(productId, prevCount+quantity);
          }else{
           userCart.put(productId, quantity);
          }
          
      }
      
      public void removeFromCart(int productId, int quantity){
          
           if(userCart.containsKey(productId)){
              int prevCount = userCart.get(productId);
              userCart.put(productId, prevCount-quantity);
          }else{
           System.out.println("Product Doesn't exist in cart");
          }
          
      }
      
      public int calculateAmount(ArrayList<Product> products){
          HashMap<Integer, Integer> userCart = this.userCart;
          int totalAmount = 0;
          
          for( Map.Entry<Integer, Integer> cartItem: userCart.entrySet()){
              
              int productId = cartItem.getKey();
              int quantity = cartItem.getValue();
              
              int productCost= findProductCost(productId, products);
              
              totalAmount = totalAmount +productCost*quantity;
          }
          return totalAmount;
      }
      
      public int findProductCost(int productId, ArrayList<Product> products){
          
          for(Product product: products){
              if(product.getId()==productId){
                  return product.getCost();
              }
              
          }
          throw new Error("Product doesn't exist");
          
      }
}