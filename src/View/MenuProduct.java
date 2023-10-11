package View;

import Manager.ProductManager;
import Model.Product;
import Validate.ValidateProduct;
import javafx.scene.Camera;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuProduct {
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    ProductManager productManager = new ProductManager();

    public void MainMenu() {
        int choice;
        do {
            System.out.println("|_______________Menu Admin___________________|\n|1.Xem danh sách.\n|2.Thêm mới.\n|3.Cập nhật.\n|4.Xóa.\n|5.Sắp xếp.\n|6.tìm kiếm sản phẩm có giá đắt nhất.\n|9.thoát.\n|____________________________________________|");
            System.out.println("Nhập lựa chọn của bạn:");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showAllProduct();
                    break;
                case 2:
                    showMenuAddProduct();
                    break;
                case 3:
                    showMenuEditProduct();
                    break;
                case 4:
                    showMenuDeleteProduct();
                    break;
                case 5:
                    sortProductByPrice();
                    break;
                case 6:
                    findProductMaxPrice();
                    break;
            }

        } while (choice != 9);
    }

    private void showMenuAddProduct() {
        System.out.println("|_______Menu Add_______|");
        int id;
        do {
            System.out.println("Nhập id");
            id = ValidateProduct.checkId();
            if (productManager.checkIdInList(id)) {
                System.out.println("Id đã tồn tại vui lòng nhập id khác");
            } else {
                break;
            }
        } while (true);
        System.out.println("Nhập tên:");
        String name = ValidateProduct.checkName();
        System.out.println("Nhập số lượng sản phẩm:");
        int quantity = ValidateProduct.checkQuantity();
        System.out.println("Nhập giá sản phẩm:");
        int price = ValidateProduct.checkPrice();
        System.out.println("Nhập mô tả sản phẩm:");
        String description = inputString.nextLine();
        Product product = new Product(id, name, quantity, price, description);
        productManager.add(product);
        System.out.println("===> thêm thành công");
    }

    private void showMenuEditProduct() {
        System.out.println("|_______Menu Edit_______|");
        int id;
        do {
            System.out.println("Nhập id");
            id = inputInt.nextInt();
            if (productManager.checkIdInList(id)) {
                break;
            } else {
                System.out.println("Id không tồn tại, vui lòng nhập lại");
            }
        } while (true);
        System.out.println("Nhập tên:");
        String name = ValidateProduct.checkName();
        System.out.println("Nhập số lượng sản phẩm:");
        int quantity = ValidateProduct.checkQuantity();
        System.out.println("Nhập giá sản phẩm:");
        int price = ValidateProduct.checkPrice();
        System.out.println("Nhập mô tả sản phẩm:");
        String description = inputString.nextLine();
        Product product = new Product(id, name, quantity, price, description);
        productManager.edit(id, product);
        System.out.println("===> sửa thành công");
    }

    private void showMenuDeleteProduct() {
        System.out.println("|_______Menu Delete_______|");
        int idDelete;
        do {
            System.out.println("Nhập id của sản phẩm muốn xóa:");
            idDelete = inputInt.nextInt();
            if (productManager.checkIdInList(idDelete)) {
                break;
            } else {
                System.out.println("Id không tồn tại, vui lòng nhập lại");
            }
        } while (true);
        productManager.delete(idDelete);
        System.out.println("===> xóa thành công");
    }

    private void showAllProduct() {
        List<Product> showList = productManager.showAll();
        for (Product product : showList
        ) {
            System.out.println(product);
        }
    }

    private void sortProductByPrice() {
        int choice;
        do {
            System.out.println("Menu Sort");
            System.out.println("1.Tăng dần\n2.Giảm dần\n3.Thoát");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Sắp xếp tăng dần");
                    productManager.sortIncreaseProduct();
                    break;
                case 2:
                    System.out.println("Sắp xếp giảm dần");
                    productManager.sortDecreaseProduct();
                    break;
            }
        } while (choice != 3);
    }

    private void findProductMaxPrice() {
        System.out.println("Sản phẩm giá cao nhất");
        productManager.searchProductMaxPrice();
    }
}
