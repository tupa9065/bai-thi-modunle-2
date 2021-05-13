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
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] infos = line.split(",");
                Info newInfo = new Info();
                newInfo.setPhoneNumber(infos[0]);
                newInfo.setGroupInfo(infos[1]);
                newInfo.setName(infos[2]);
                newInfo.setGender(infos[2]);
                newInfo.setAddress(infos[4]);
                newInfo.setDob(infos[5]);
                newInfo.setEmail(infos[6]);
                newInfos.add(newInfo);

            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newInfos;
    }

    public void saveDataToFile(ArrayList<Info> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data\\contacts.csv"))) {
//            bw.write("Số điện thoại");
//            bw.write(",");
//            bw.write("Nhóm");
//            bw.write(",");
//            bw.write("Họ tên");
//            bw.write(",");
//            bw.write("Giới tính");
//            bw.write(",");
//            bw.write("Địa chỉ");
//            bw.write(",");
//            bw.write("Ngày sinh");
//            bw.write(",");
//            bw.write("Email");
//            bw.newLine();

            for (Info data : list) {
                bw.write(data.phoneNumber);
                bw.write(",");
                bw.write(data.groupInfo);
                bw.write(",");
                bw.write(data.name);
                bw.write(",");
                bw.write(data.gender);
                bw.write(",");
                bw.write(data.address);
                bw.write(",");
                bw.write(data.dob);
                bw.write(",");
                bw.write(data.email);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
