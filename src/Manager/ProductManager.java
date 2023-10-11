package Manager;

import Model.Product;
import ReadAndWrite.ReadAndWriteProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements IProductManager<Product> {
    List<Product> productList;
    ReadAndWriteProduct readAndWriteProduct;

    public ProductManager() {
        readAndWriteProduct = new ReadAndWriteProduct();
        if (readAndWriteProduct.ReadFile() != null) {
            productList = readAndWriteProduct.ReadFile();
        } else {
            productList = new ArrayList<>();
        }
    }

    @Override
    public void add(Product product) {
        productList.add(product);
        readAndWriteProduct.writeFile(productList);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void edit(int id, Product product) {
        int index = findIndexById(id);
        productList.set(index, product);
        readAndWriteProduct.writeFile(productList);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        productList.remove(index);
        readAndWriteProduct.writeFile(productList);
    }

    @Override
    public List<Product> showAll() {
        readAndWriteProduct.ReadFile();
        return this.productList;
    }

    public boolean checkIdInList(int id) {
        for (Product product : productList
        ) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void sortIncreaseProduct() {
        for (int i = 1; i < productList.size(); i++) {
            for (int j = 0; j < productList.size() - i; j++) {
                if (productList.get(j).getPrice() > productList.get(j + 1).getPrice()) {
                    Product temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }
        for (Product product : productList
        ) {
            System.out.println(product);
        }
    }

    public void sortDecreaseProduct() {
        for (int i = 1; i < productList.size(); i++) {
            for (int j = 0; j < productList.size() - i; j++) {
                if (productList.get(j).getPrice() < productList.get(j + 1).getPrice()) {
                    Product temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }
        for (Product product : productList
        ) {
            System.out.println(product);
        }
    }

    public void searchProductMaxPrice() {
        int maxPrice = productList.get(0).getPrice();
        Product product = productList.get(searchProductWithPrice(maxPrice));
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() > maxPrice) {
                product = productList.get(searchProductWithPrice(productList.get(i).getPrice()));
            }
        }
        System.out.println(product);
    }

    public int searchProductWithPrice(int price) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() == price) {
                return i;
            }
        }
        return -1;
    }
}
