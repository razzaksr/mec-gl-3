package store.crud;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
            ProductDao productDao = new ProductDao();
            int choice=0;
            do{
                System.out.println("1.Add Product\n2.View Products\n3.Update Product\n4.Delete Product\n5.Exit");
                choice= scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Submit details of the product id, name, model, price and size ");
                        Product product=new Product();
                        product.setProId(scanner.nextInt());
                        product.setProName(scanner.next());
                        product.setProModel(scanner.next());
                        product.setProPrice(scanner.nextInt());
                        product.setProSize(scanner.nextDouble());
                        productDao.create(product);
                        break;
                    case 2:
                        System.out.println("Following are the available items in the stock");
                        List<Product> items=productDao.readAll();
                        items.forEach(item->System.out.println(item));
                        break;
                    case 3:
                        System.out.println("Submit details of the product id, product name, model, price and size ");
                        Product product1=new Product();
                        product1.setProId(scanner.nextInt());
                        product1.setProName(scanner.next());
                        product1.setProModel(scanner.next());
                        product1.setProPrice(scanner.nextInt());
                        product1.setProSize(scanner.nextDouble());
                        productDao.update(product1);
                        break;
                    case 4:
                        System.out.println("Enter the product id to remove ");
                        int id= scanner.nextInt();
                        productDao.delete(id);
                        break;
                    default:return;
                }
            }while(true);
    }
}
