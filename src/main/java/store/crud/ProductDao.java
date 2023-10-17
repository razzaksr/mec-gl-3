package store.crud;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDao {

    private String file="mydb.doc";
    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private List<Product> products=new ArrayList<>();

    public ProductDao(){

    }

    public void fetch(){
        try{
            fis=new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            products=(List<Product>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (EOFException eof){
            products=new ArrayList<>();
        }
        catch (IOException | ClassNotFoundException io){

        }
    }

    public void affect(){
        try{
            fos=new FileOutputStream(file);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();fos.close();
        }
        catch (IOException io){

        }
    }

    public void create(Product product) {
        fetch();
        products.add(product);
        affect();
        System.out.println(product.getProName()+"has added to stock");
    }

    public List<Product> readAll() {
        fetch();
        return products;
    }

    public void update(Product product) {
        fetch();
        //Product temp= (Product) products.stream().filter(v->v.getProId() == product.getProId()).collect(Collectors.toList()).get(0);
        for(int index=0;index<products.size();index++){
            if(products.get(index).getProId()== product.getProId()){
                System.out.println("existing"+products.get(index));
                products.set(index,product);
                affect();
                System.out.println(product.getProId()+" has updated");
                return;
            }
        }
        System.out.println(product.getProId()+" hasn't updated");
    }

    public void delete(int productId) {
        fetch();
        products = products.stream().filter(v->v.getProId() != productId).collect(Collectors.toList());
//        products.forEach(v->System.out.println(v));
        affect();
    }
}
