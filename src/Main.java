import java.util.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Info> infoArrayList = new ArrayList<>();
        InfoManager infoManager = new InfoManager();
        String choose;
        do {
            showMenu();
            choose = scanner.nextLine();
            switch (choose) {
                case "1": {
                    infoManager.showInfoList(infoArrayList);
                }
                break;
                case "2": {
                    Info newInfo = new Info();
                    newInfo.inputInfo();
                    boolean isAdd = infoManager.addNewInfo(newInfo, infoArrayList);
                    if (isAdd) {
                        System.out.println(newInfo);
                    } else {
                        System.out.println("thêm mới không thành công");
                    }
                }
                break;
                case "3":
                {
                    System.out.println("nhập số điện thoại");
                    String phoneInput = scanner.nextLine();
                    if(phoneInput.equals("")){
                        break;
                    }
                    Info isPhone = infoManager.checkPhoneNumber(phoneInput,infoArrayList);
                    if(isPhone!=null){
                        isPhone.editInfo();
                    }else {
                        System.out.println("không tìm thấy số điện thoại: "+phoneInput);
                    }
                }
                    break;
                case "4":{
                    System.out.println("nhập số điện thoại");
                    String phoneInput = scanner.nextLine();
                    if(phoneInput.equals("")){
                        break;
                    }
                    Info isPhone = infoManager.checkPhoneNumber(phoneInput,infoArrayList);
                    if(isPhone!=null){
                        System.out.println("Nhập Y để xóa ");
                        String isYes = scanner.nextLine();
                        if(isYes.equalsIgnoreCase("Y")){
                            infoArrayList.remove(isPhone);
                            System.out.println("xóa thành công");
                        }

                    }else {
                        System.out.println("không tìm thấy số điện thoại: "+phoneInput);
                    }
                }
                    break;
                case "5":{
                    System.out.println("1. tìm theo số điện thoại");
                    System.out.println("2. tìm theo tên");
                    System.out.println("Nhập lựa chọn");
                }
                    break;
                case "6":
                    infoArrayList = infoManager.getDatafromFile();
                    break;
                case "7":
                    infoManager.saveDataToFile(infoArrayList);
                    break;
                case "8":
                    break;
                default:
                    System.out.println("lựa chọn không hợp lệ");

            }
        } while (!choose.equals("8"));
    }

    private static void showMenu() {
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ--");
        System.out.println("Chọn chức năng theo số để tiếp tục");
        System.out.println("1. xem danh sách");
        System.out.println("2. thêm mới");
        System.out.println("3. cập nhập");
        System.out.println("4. xóa");
        System.out.println("5. tìm kiếm ");
        System.out.println("6. đọc từ file");
        System.out.println("7. ghi vào file");
        System.out.println("8. thoát");
        System.out.println("Chọn chức năng");
    }
}
