package Validate;

import java.util.Scanner;

public class ValidateProduct {
    static Scanner input = new Scanner(System.in);

    public static int checkId() {
        String regex = "^\\d{3}$";
        String inputStringId;
        do {
            inputStringId = input.nextLine();
            if (inputStringId.matches(regex)) {
                break;
            } else {
                System.out.println("ID tối thiểu 3 kí tự");
            }
        } while (true);
        return Integer.parseInt(inputStringId);
    }

    public static String checkName() {
        String regex = "^.{6,8}$";
        String inputName;
        do {
            inputName = input.nextLine();
            if (inputName.matches(regex)) {
                break;
            } else {
                System.out.println("Tên phải có từ 6-8 kí tự");
            }
        } while (true);
        return inputName;
    }

    public static int checkPrice() {
        int inputPrice;
        do {
            try {
                inputPrice = input.nextInt();
                if (inputPrice < 10000000) {
                    break;
                } else {
                    System.out.println("giá phải nhỏ hơn 10.000.000VND");
                }
            } catch (NumberFormatException e) {
                System.out.println("không phải số");
            }

        } while (true);
        return inputPrice;
    }

    public static int checkQuantity() {
        int inputPrice;
        do {
            try {
                inputPrice = input.nextInt();
                if (inputPrice < 1000) {
                    break;
                } else {
                    System.out.println("số lượng nhỏ hơn 1000");
                }
            } catch (NumberFormatException e) {
                System.out.println("không phải số");
            }
        } while (true);
        return inputPrice;
    }
}
