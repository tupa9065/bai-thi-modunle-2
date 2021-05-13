import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InfoManager {
    Scanner scanner = new Scanner(System.in);

    public void showInfoList(List<Info> list) {
        int count = 0;
        for (Info info : list
        ) {

            System.out.println(info);
            count++;
            if (count % 5 == 0) {
                System.out.println("Enter to next 5 info");
                String next = scanner.nextLine();
            }

        }
    }

    public boolean addNewInfo(Info newInfo, ArrayList<Info> infoArrayList) {
        try {
            infoArrayList.add(newInfo);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public Info checkPhoneNumber(String phoneInput, ArrayList<Info> infoArrayList) {
        for (Info info : infoArrayList
        ) {
            if (info.getPhoneNumber().equals(phoneInput)) {
                return info;
            }
        }
        return null;
    }

    public ArrayList<Info> getDatafromFile() {
        ArrayList<Info> newInfos = new ArrayList<>();
        try {
            File f = new File("data\\contacts.csv");
            if (!f.isFile() || f.length()==0){
                System.out.println(" file trống");
                return newInfos;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String str = "";
            String line;
            while ((line = bufferedReader.readLine()) != null){
                str = str.concat(line);
                str = str.concat("\n");
                System.out.println(str);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newInfos;
    }

    public void saveDataToFile(ArrayList<Info> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data\\contacts.csv"))) {
            bw.write("Số điện thoại");
            bw.write(",");
            bw.write("Nhóm");
            bw.write(",");
            bw.write("Họ tên");
            bw.write(",");
            bw.write("Giới tính");
            bw.write(",");
            bw.write("Địa chỉ");
            bw.write(",");
            bw.write("Ngày sinh");
            bw.write(",");
            bw.write("Email");
            bw.newLine();
            for (Info data : list) {
                bw.write(String.valueOf(list));
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
